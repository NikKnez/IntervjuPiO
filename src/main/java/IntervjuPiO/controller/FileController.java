package IntervjuPiO.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import IntervjuPiO.model.FileDto;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import IntervjuPiO.model.FileDocument;
import IntervjuPiO.repository.FileRepository;

@CrossOrigin(origins = "https://intervjupio.netlify.app")
@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @CrossOrigin(origins = "https://intervjupio.netlify.app")
    @GetMapping("/files")
    public ResponseEntity<List<FileDto>> listFiles() {
        // Retrieve all files from the repository
        List<FileDocument> files = fileRepository.findAll();

        // Convert binary content to Base64 and construct DTO objects
        List<FileDto> fileDtos = files.stream().map(file -> {
            FileDto fileDto = new FileDto();
            fileDto.setId(file.getId());
            fileDto.setFilename(file.getFilename());
            fileDto.setFiletype(file.getFiletype());

            // Convert binary data to Base64
            String base64Content = Base64.getEncoder().encodeToString(file.getContent().getData());
            fileDto.setBase64Content(base64Content);

            return fileDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(fileDtos);

    }

    @GetMapping("/file/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) {
        // Retrieve the file document by ID
        FileDocument fileDocument = fileRepository.findById(id).orElse(null);

        if (fileDocument != null) {
            // Return file content as byte array
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(fileDocument.getFiletype()))
                    .header("Content-Disposition", "attachment; filename=\"" + fileDocument.getFilename() + "\"")
                    .body(fileDocument.getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}