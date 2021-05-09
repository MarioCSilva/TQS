package tqs.lab7.testcontainers;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import tqs.lab7.testcontainers.repository.BookRepository;
import tqs.lab7.testcontainers.entity.Book;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@Testcontainers
@SpringBootTest
class TestcontainersApplicationTests {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres")
            .withUsername("admin")
            .withPassword("password")
            .withDatabaseName("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Order(1)
    public void testSaveBook() {
        Book book = new Book();
        book.setName("Testcontainers");
        bookRepository.save(book);
    }

    @Test
    @Order(2)
    public void testListBooks() {
        List<Book> books = bookRepository.findAll();
        assertThat(books)
                .hasSize(1)
                .extracting(Book::getName)
                .contains("Testcontainers");
    }

    @Test
    @Order(3)
    public void testDeleteBook() {
        bookRepository.deleteAll();
        assertThat(bookRepository.count()).isEqualTo(0);
    }
}