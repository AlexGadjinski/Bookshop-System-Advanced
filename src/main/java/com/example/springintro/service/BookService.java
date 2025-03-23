package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findTitlesByAgeRestriction(String ageRestriction);

    List<String> findGoldenBooksTitles();

    List<Book> findByPriceOutsideOf(BigDecimal lowerBound, BigDecimal upperBound);

    List<String> findTitlesNotReleasedIn(int year);

    List<Book> findBooksBefore(String input);

    List<String> findTitlesContaining(String morpheme);

    List<String> findByAuthorLastName(String lastNameStart);

    int findBooksCountByTitleLength(int length);

    BookInfo findBookInfo(String title);

    long updateBookCopiesAfterDate(String date, int count);

    int deleteWithCopiesCountLessThan(int minCount);
}
