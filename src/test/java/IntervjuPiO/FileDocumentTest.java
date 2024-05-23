//package IntervjuPiO;
//
//import IntervjuPiO.model.FileDocument;
//import org.bson.types.Binary;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class FileDocumentTest {
//
//    @Test
//    public void testFileDocumentConstructor() {
//        // Create test data
//        String id = "1";
//        String filename = "test.txt";
//        String filetype = "text/plain";
//        byte[] contentData = "Test content".getBytes();
//        Binary content = new Binary(contentData);
//
//        // Create a FileDocument object
//        FileDocument fileDocument = new FileDocument(id, filename, filetype, content);
//
//        // Check if the object is created correctly
//        assertEquals(id, fileDocument.getId());
//        assertEquals(filename, fileDocument.getFilename());
//        assertEquals(filetype, fileDocument.getFiletype());
//        assertEquals(content, fileDocument.getContent());
//    }
//}
//
