package tqs.lab5.booksearch;

import java.time.ZoneId;
import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {
        Calendar end = Calendar.getInstance();
        Date fromDate = convertToDateViaInstant(from);
        end.setTime(convertToDateViaInstant(to));

        return store.stream()
                .filter(book -> fromDate.before(convertToDateViaInstant(book.getPublished()))
                    && end.getTime().after(convertToDateViaInstant(book.getPublished())))
                .sorted(Comparator.comparing(Book::getPublished).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(final String author) {
        return store.stream().filter(book -> book.getAuthor().equals(author))
                .sorted(Comparator.comparing(Book::getPublished).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByTitle(final String title) {
        return store.stream()
                .filter(book -> book.getTitle().equals(title))
                .sorted(Comparator.comparing(Book::getPublished).reversed())
                .collect(Collectors.toList());
    }

    public Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}
