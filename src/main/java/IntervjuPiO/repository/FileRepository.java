package IntervjuPiO.repository;

import IntervjuPiO.model.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileDocument, String> {
    // Define additional query methods if needed
}
