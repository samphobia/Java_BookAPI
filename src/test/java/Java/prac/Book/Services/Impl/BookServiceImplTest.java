package Java.prac.Book.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.Mockito.when;
import static Java.prac.Book.TestData.testBook;
import static Java.prac.Book.TestData.testBookEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Java.prac.Book.domain.Book;
import Java.prac.Book.domain.BookEntity;
import Java.prac.Book.repositories.BookRepository;
import Java.prac.Book.services.impl.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {
  @Mock
  private BookRepository bookRepository;
  
  @InjectMocks
  private BookServiceImpl underTest;

  @Test
  public void testThatBookIsSaved() {
    final Book book = testBook();

    final BookEntity bookEntity = testBookEntity();

    when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

    final Book result = underTest.save(book);
    assertEquals(book, result);

  }
  
  @Test
  public void testThatFindByIdReturnsEmptyWhenNoBook() {
    final String isbn = "123123123";
    when(bookRepository.findById(eq(isbn))).thenReturn(Optional.empty());

    final Optional<Book> result = underTest.findById(isbn);
    assertEquals(Optional.empty(), result);
  }

  @Test
  public void testThatFindByIdReturnsBookWhenExists() {
    final Book book = testBook();
    final BookEntity bookEntity = testBookEntity();

    when(bookRepository.findById(eq(book.getIsbn()))).thenReturn(Optional.of(bookEntity));

    final Optional<Book> result = underTest.findById(book.getIsbn());
    assertEquals(Optional.of(book), result);
  }

  @Test
  public void testListBooksReturnsEmptyListWhenNoBooksExist() {
    when(bookRepository.findAll()).thenReturn(new ArrayList<BookEntity>());
    final List<Book> result = underTest.listBooks();
    assertEquals(0, result.size());
  }

  @Test
  public void testListBooksReturnsBooksWhenExist() {
    final BookEntity bookEntity = testBookEntity();
    when(bookRepository.findAll()).thenReturn(List.of(bookEntity));
    final List<Book> result = underTest.listBooks();
    assertEquals(1, result.size());
  }

  @Test
  public void testIsBookExistsReturnsFalseWhenBookDoesntExist() {
    when(bookRepository.existsById(any())).thenReturn(false);
    final boolean result = underTest.isBookExist(testBook());
    assertEquals(false, result);
  }

  @Test
  public void testIsBookExistsReturnstrueWhenBookDoesntExist() {
    when(bookRepository.existsById(any())).thenReturn(true);
    final boolean result = underTest.isBookExist(testBook());
    assertEquals(true, result);
  }

}
