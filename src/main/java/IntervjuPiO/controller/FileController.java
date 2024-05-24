package IntervjuPiO.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import IntervjuPiO.model.FileDto;
import IntervjuPiO.model.FileDocument;
import IntervjuPiO.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);


    @GetMapping("/files")
    public ResponseEntity<List<FileDto>> listFiles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "18") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FileDocument> filePage = fileRepository.findAll(pageable);
        List<FileDto> fileDtos = filePage.getContent().stream().map(file -> {
            FileDto fileDto = new FileDto();
            fileDto.setId(file.getId());
            fileDto.setFilename(file.getFilename());
            fileDto.setFiletype(file.getFiletype());
            String base64Content = Base64.getEncoder().encodeToString(file.getContent().getData());
            fileDto.setBase64Content(base64Content);
            return fileDto;
        }).collect(Collectors.toList());
        logger.info("Page: {}, Size: {}, Total Elements: {}", page, size, filePage.getTotalElements());


        return ResponseEntity.ok(fileDtos);
    }

    @GetMapping("/file/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) {
        FileDocument fileDocument = fileRepository.findById(id).orElse(null);

        if (fileDocument != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(fileDocument.getFiletype()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDocument.getFilename() + "\"")
                    .body(fileDocument.getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
