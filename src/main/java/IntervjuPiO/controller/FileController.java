package IntervjuPiO.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import IntervjuPiO.model.FileDto;
import IntervjuPiO.model.FileDocument;
import IntervjuPiO.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")  // Enable CORS for specific origin
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/files")
    public ResponseEntity<List<FileDto>> listFiles() {
        try {
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
        } catch (Exception e) {
            logger.error("Error fetching files: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/file/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) {
        try {
            // Retrieve the file document by ID
            FileDocument fileDocument = fileRepository.findById(id).orElse(null);

            if (fileDocument != null) {
                // Return file content as byte array
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(fileDocument.getFiletype()))
                        .header("Content-Disposition", "attachment; filename=\"" + fileDocument.getFilename() + "\"")
                        .body(fileDocument.getContent().getData());
            } else {
                logger.warn("File not found with ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            logger.error("Error downloading file with ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
