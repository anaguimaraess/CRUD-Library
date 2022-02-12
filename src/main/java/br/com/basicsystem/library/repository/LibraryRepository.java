package br.com.basicsystem.library.repository;

import br.com.basicsystem.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Book, String> {
}
