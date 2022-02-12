package br.com.basicsystem.library.service;

import br.com.basicsystem.library.model.Book;

import java.util.List;

public interface LibraryService {
    public List<Book> getAllBooks();

    public Book getBookById(String id);

    public Book registerBook(Book book);

    public void deleteBook(String id);

    public String changeData(String id, Book book);
}
