package IntervjuPiO.model;

import lombok.Data;

@Data
public class FileDto {
    private String id;
    private String filename;
    private String filetype;
    private String base64Content;

}

