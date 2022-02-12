package br.com.basicsystem.library.controller;

import br.com.basicsystem.library.model.Book;
import br.com.basicsystem.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return this.libraryService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable String id){
        return this.libraryService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<String> registerBook(@RequestBody Book book){
        this.libraryService.registerBook(book);
        return new ResponseEntity<>("Livro salvo com sucesso!", HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id){
        this.libraryService.deleteBook(id);
        return new ResponseEntity<>("O livro de número de ID " + id + " foi deletado com sucesso.", HttpStatus.OK);
    }

    @PutMapping("/changeData/{id}")
    public ResponseEntity<String> changeData(@PathVariable String id,@RequestBody Book book){
        this.libraryService.changeData(id, book);
        return new ResponseEntity<>("Dados alterados com sucesso!", HttpStatus.ACCEPTED);
        }
}
