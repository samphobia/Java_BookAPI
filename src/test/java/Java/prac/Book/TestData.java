package Java.prac.Book;

import Java.prac.Book.domain.Book;
import Java.prac.Book.domain.BookEntity;

public final class TestData {
  private TestData() {

  }

  public static Book testBook() {
    return Book.builder()
        .isbn("02345678")
        .author("Obafemi Samuel")
        .title("The waves")
        .build();
  }
  
  public static BookEntity testBookEntity() {
    return  BookEntity.builder()
    .isbn("02345678")
    .author("Obafemi Samuel")
    .title("The waves")
        .build();
  }
}
