package Java.prac.Book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Java.prac.Book.domain.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String>{
  
}
