package com.devopslam.graphql.persistance.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.devopslam.graphql.exceptions.BookNotFoundException;
import com.devopslam.graphql.persistance.model.Author;
import com.devopslam.graphql.persistance.model.Book;
import com.devopslam.graphql.persistance.repository.AuthorRepository;
import com.devopslam.graphql.persistance.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Author newAuthor(final String firstName, final String lastName) {
        Author author = new Author(firstName, lastName);
        return authorRepository.save(author);
    }

    public Book newBook(final String title, final String isbn, Integer pageCount, Long authorId) {
        pageCount = pageCount != null ? pageCount : 0;
        Author author = new Author(authorId);
        Book book = new Book(title, isbn, pageCount, author);
        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);

        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found id", id);
        }
        book.setPageCount(pageCount);
        return bookRepository.save(book);
    }
}
