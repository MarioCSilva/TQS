package feature.booksearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.cucumber.java.ParameterType;
import tqs.lab5.booksearch.Library;
import tqs.lab5.booksearch.Book;

public class BookSearchApplicationTest {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @Given("(/.*/)book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author, final LocalDateTime published) {
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books with the title {string}")
    public void booksByTitle(String title) {
        result = library.findBooksByTitle(title);
    }

    @When("the customer searches for books written by the author {string}")
    public void booksByAuthor(String author) {
        result = library.findBooksByAuthor(author);
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
        result = library.findBooks(from, to);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        assertThat(result.size(), equalTo(booksFound));
    }

    @Then("Book {int} should have the title {string}")
    public void verifyBookAtPositionTitle(final int position, final String title) {
        assertThat(result.get(position - 1).getTitle(), equalTo(title));
    }

    @Then("Book {int} should have the author {string}")
    public void verifyBookAtPositionAuthor(final int position, final String author) {
        assertThat(result.get(position - 1).getAuthor(), equalTo(author));
    }

    @Then("Book {int} should have the date {iso8601Date}")
    public void verifyBookAtPositionDate(final int position, final LocalDateTime title) {
        assertThat(result.get(position - 1).getPublished(), equalTo(title));
    }
}
