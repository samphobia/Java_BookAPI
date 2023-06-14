package Java.prac.Book.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

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
    final Book book = Book.builder()
      .isbn("02345678")
      .author("Obafemi Samuel")
      .title("The waves")
        .build();

        final BookEntity bookEntity = BookEntity.builder()
        .isbn("02345678")
        .author("Obafemi Samuel")
        .title("The waves")
            .build();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);
          
        final Book result = underTest.create(book);
          assertEquals(book, result);
      
  }

}
