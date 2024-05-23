package IntervjuPiO.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "files")
public class FileDocument {
    private String id;
    private String filename;
    private String filetype;
    private Binary content;

}
