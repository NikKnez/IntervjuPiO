package IntervjuPiO.repository;

import IntervjuPiO.model.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends MongoRepository<FileDocument, String>, PagingAndSortingRepository<FileDocument, String> {
    // Define query methods if needed
}
