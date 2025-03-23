package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        Scanner scanner = new Scanner(System.in);

//        _01(scanner);
//        _02();
//        _03();
//        _04(scanner);
//        _05(scanner);
//        _06(scanner);
//        _07(scanner);
//        _08(scanner);
//        _09(scanner);
//        _10Dummy();
//        _11(scanner);
//        _10Clever();
//        _12(scanner);
//        _13(scanner);
        _14();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }

    private void _14() {
        int count = authorService.findBookCountForAuthor("Roger", "Porter");
        System.out.println(count);
    }

    private void _13(Scanner scanner) {
        int minCount = Integer.parseInt(scanner.nextLine());

        int deletedBooksCount = bookService.deleteWithCopiesCountLessThan(minCount);
        System.out.println(deletedBooksCount);
    }

    private void _12(Scanner scanner) {
        String date = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        long addedCopies = bookService.updateBookCopiesAfterDate(date, count);
        System.out.println(addedCopies);
    }

    private void _10Clever() {
        List<String> result = authorService.getByTotalBookCopiesCountClever();
        result.forEach(System.out::println);
    }

    private void _11(Scanner scanner) {
        String title = scanner.nextLine();

        BookInfo bookInfo = bookService.findBookInfo(title);
        System.out.println(bookInfo.getTitle() + " " + bookInfo.getEditionType().name() + " " +
                bookInfo.getAgeRestriction().name() + " " + bookInfo.getPrice());
    }

    private void _10Dummy() {
        List<String> result = authorService.getByTotalBookCopiesCount();
        result.forEach(System.out::println);
    }

    private void _09(Scanner scanner) {
        int length = Integer.parseInt(scanner.nextLine());
        int count = bookService.findBooksCountByTitleLength(length);
        System.out.println(count);
    }

    private void _08(Scanner scanner) {
        String lastNameStart = scanner.nextLine();
        List<String> titles = bookService.findByAuthorLastName(lastNameStart);
        titles.forEach(System.out::println);
    }

    private void _07(Scanner scanner) {
        String morpheme = scanner.nextLine();

        List<String> titles = bookService.findTitlesContaining(morpheme);
        titles.forEach(System.out::println);
    }

    private void _06(Scanner scanner) {
        String ending = scanner.nextLine();

        List<String> names = authorService.findFirstNamesEndingWith(ending);
        names.forEach(System.out::println);
    }

    private void _05(Scanner scanner) {
        List<Book> books = bookService.findBooksBefore(scanner.nextLine());
        books.forEach(b -> System.out.println(b.shortInfo()));
    }

    private void _04(Scanner scanner) {
        List<String> titles = bookService.findTitlesNotReleasedIn(Integer.parseInt(scanner.nextLine()));
        titles.forEach(System.out::println);
    }

    private void _03() {
        List<Book> books = bookService.findByPriceOutsideOf(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
        books.forEach(b -> System.out.printf("%s - $%.2f\n", b.getTitle(), b.getPrice()));
    }

    private void _02() {
        List<String> titles = bookService.findGoldenBooksTitles();
        titles.forEach(System.out::println);
    }

    private void _01(Scanner scanner) {
        List<String> titles = bookService.findTitlesByAgeRestriction(scanner.nextLine());
        titles.forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
