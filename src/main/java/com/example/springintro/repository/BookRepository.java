package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.model.entity.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction restriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType type, Integer copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate start, LocalDate end);

    List<Book> findByReleaseDateBefore(LocalDate date);

    List<Book> findByTitleContainingIgnoreCase(String morpheme);

    List<Book> findByAuthorLastNameStartingWith(String lastNameStart);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE CHAR_LENGTH(b.title) > :length")
    int countByTitleLengthGreaterThan(int length);

    BookInfo findByTitle(String title);

    @Query("UPDATE Book AS b SET b.copies = b.copies + :count WHERE b.releaseDate > :parsed")
    @Transactional
    @Modifying
    int updateBookCopiesReleasedAfter(LocalDate parsed, int count);

    @Transactional
    int deleteByCopiesLessThan(int count);
}
