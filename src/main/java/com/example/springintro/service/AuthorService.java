package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> findFirstNamesEndingWith(String ending);

    List<String> getByTotalBookCopiesCount();

    List<String> getByTotalBookCopiesCountClever();

    int findBookCountForAuthor(String firstName, String lastName);
}
