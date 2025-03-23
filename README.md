# Bookshop-System-Advanced

This project provides a comprehensive suite of operations for managing and querying a bookshop database. It offers a variety of functionality to filter, update, and delete books based on several criteria, such as age restrictions, price range, release dates, and more. The program integrates with a relational database, allowing seamless interactions with data for efficient management and reporting.

## Features

1. **Books Titles by Age Restriction**  
   Retrieve book titles based on the given age restrictions (`minor`, `teen`, `adult`), ignoring case sensitivity.

2. **Golden Books**  
   Display the titles of books marked as "golden edition" that have fewer than 5000 copies in stock.

3. **Books by Price**  
   Show book titles and prices for books that are either cheaper than $5 or more expensive than $40.

4. **Not Released Books**  
   List book titles that were not released in a specific year.

5. **Books Released Before Date**  
   Retrieve book titles, edition types, and prices for books released before a specific date in the format `dd-MM-yyyy`.

6. **Authors Search**  
   Search for authors whose first name ends with a given string.

7. **Books Search**  
   Find books whose titles contain a given substring, case insensitive.

8. **Book Titles Search by Author's Last Name**  
   Retrieve book titles written by authors whose last name starts with a specific string.

9. **Count Books by Title Length**  
   Count and display how many books have titles longer than a specified length.

10. **Total Book Copies by Author**  
    List authors and the total number of book copies they have written, ordered by the number of copies in descending order.

11. **Reduced Book Information**  
    Retrieve minimal information (title, edition type, age restriction, price) for a specific book by its title.

12. **Increase Book Copies**  
    Increase the number of copies for all books released after a given date by a specified number. The total number of copies added is printed.

13. **Remove Books with Low Copies**  
    Delete books from the database that have fewer than a given number of copies, and print the number of books deleted.

14. **Stored Procedure**  
    A stored procedure is created in the database to query the total number of books an author has written based on their first and last name.
