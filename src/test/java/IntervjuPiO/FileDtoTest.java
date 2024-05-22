package IntervjuPiO;

import IntervjuPiO.model.FileDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDtoTest {

    @Test
    public void testFileDtoGettersAndSetters() {
        // Create test data
        String id = "1";
        String filename = "test.txt";
        String filetype = "text/plain";
        String base64Content = "VGhpcyBpcyBhIHRlc3QgY29udGVudA=="; // Base64 encoded "This is a test content"

        // Create a FileDto object
        FileDto fileDto = new FileDto();
        fileDto.setId(id);
        fileDto.setFilename(filename);
        fileDto.setFiletype(filetype);
        fileDto.setBase64Content(base64Content);

        // Check if the getters return the correct values
        assertEquals(id, fileDto.getId());
        assertEquals(filename, fileDto.getFilename());
        assertEquals(filetype, fileDto.getFiletype());
        assertEquals(base64Content, fileDto.getBase64Content());
    }
}

