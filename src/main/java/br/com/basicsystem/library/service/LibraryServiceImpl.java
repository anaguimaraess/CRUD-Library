package br.com.basicsystem.library.service;


import br.com.basicsystem.library.model.Book;
import br.com.basicsystem.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Book> getAllBooks() {
        return this.libraryRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return this.libraryRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Livro não existente no banco de dados!"));
    }

    @Override
    public Book registerBook(Book book) {
        return this.libraryRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        this.libraryRepository.deleteById(id);
        return;
    }


    @Override
    public String changeData(String id, Book book) {
        Optional<Book> bookData = this.libraryRepository.findById(id);
        Book books = bookData.get();
        books.setNameBook(book.getNameBook());
        books.setAuthor(book.getAuthor());
        books.setNumberPages(book.getNumberPages());
        books.setPrice(book.getPrice());
        libraryRepository.save(books);
        return "Dados alterados com sucesso!";
    }


}
