//package IntervjuPiO;
//
//import IntervjuPiO.controller.FileController;
//import IntervjuPiO.model.FileDocument;
//import IntervjuPiO.repository.FileRepository;
//import org.bson.types.Binary;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(FileController.class)
//public class FileControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private FileRepository fileRepository;
//
//    @Test
//    public void testListFiles() throws Exception {
//        // Mock the list of FileDocuments
//        List<FileDocument> fileDocuments = new ArrayList<>();
//        fileDocuments.add(new FileDocument("1", "file1.txt", "text/plain", new Binary("file1 content".getBytes())));
//        fileDocuments.add(new FileDocument("2", "file2.txt", "text/plain", new Binary("file2 content".getBytes())));
//
//        // Stub the repository method to return the list of FileDocuments
//        when(fileRepository.findAll()).thenReturn(fileDocuments);
//
//        // Perform the GET request and verify the response
//        mockMvc.perform(get("/files"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id").value("1"))
//                .andExpect(jsonPath("$[0].filename").value("file1.txt"))
//                .andExpect(jsonPath("$[0].filetype").value("text/plain"))
//                .andExpect(jsonPath("$[0].base64Content").value(Base64.getEncoder().encodeToString("file1 content".getBytes())))
//                .andExpect(jsonPath("$[1].id").value("2"))
//                .andExpect(jsonPath("$[1].filename").value("file2.txt"))
//                .andExpect(jsonPath("$[1].filetype").value("text/plain"))
//                .andExpect(jsonPath("$[1].base64Content").value(Base64.getEncoder().encodeToString("file2 content".getBytes())));
//    }
//
//    @Test
//    public void testDownloadFile() throws Exception {
//        // Mock a FileDocument
//        FileDocument fileDocument = new FileDocument("1", "file1.txt", "text/plain", new Binary("file1 content".getBytes()));
//
//        // Stub the repository method to return the FileDocument
//        when(fileRepository.findById("1")).thenReturn(Optional.of(fileDocument));
//
//        // Perform the GET request and verify the response
//        mockMvc.perform(get("/file/download/1"))
//                .andExpect(status().isOk())
//                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, "text/plain"))
//                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file1.txt\""))
//                .andExpect(content().bytes("file1 content".getBytes()));
//    }
//
//    @Test
//    public void testDownloadFileNotFound() throws Exception {
//        // Stub the repository method to return null
//        when(fileRepository.findById("1")).thenReturn(Optional.empty());
//
//        // Perform the GET request and verify the response
//        mockMvc.perform(get("/file/download/1"))
//                .andExpect(status().isNotFound());
//    }
//}
