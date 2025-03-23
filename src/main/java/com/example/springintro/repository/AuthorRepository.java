package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.AuthorCopies;
import com.example.springintro.model.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY SIZE(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findByFirstNameEndingWith(String ending);

    @Query("SELECT CONCAT(a.firstName, ' ', a.lastName) AS fullName, SUM(b.copies) AS totalCopies" +
            " FROM Author AS a JOIN a.books AS b" +
            " GROUP BY a.id " +
            " ORDER BY totalCopies DESC")
    List<AuthorCopies> findAuthorsByBookCopiesCount();

//    @Query("SELECT new com.example.springintro.model.entity.Example(a.firstName, a.lastName, SUM(b.copies))" +
//            " FROM Author AS a JOIN a.books AS b" +
//            " GROUP BY a.id " +
//            " ORDER BY SUM(b.copies) DESC")
//    List<Example> findAuthorsByBookCopiesCountClassBased();
    @Procedure(procedureName = "COUNT_AUTHOR_BOOKS", outputParameterName = "result")
    int findBookCount(String firstName, String lastName);
}
