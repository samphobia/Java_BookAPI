package Java.prac.Book.services;

import java.util.List;
import java.util.Optional;

import Java.prac.Book.domain.Book;

public interface BookService {

  boolean isBookExist(Book book);

  Book save(Book book);

  Optional<Book> findById(String isbn);

  List<Book> listBooks();

  void deleteBookById(String isbn);
}
