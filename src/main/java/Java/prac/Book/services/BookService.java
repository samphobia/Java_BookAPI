package Java.prac.Book.services;

import java.util.Optional;

import Java.prac.Book.domain.Book;

public interface BookService {
  Book save(Book book);

  Optional<Book> findById(String isbn);
}
