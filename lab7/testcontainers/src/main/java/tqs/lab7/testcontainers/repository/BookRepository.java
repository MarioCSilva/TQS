package tqs.lab7.testcontainers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tqs.lab7.testcontainers.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

