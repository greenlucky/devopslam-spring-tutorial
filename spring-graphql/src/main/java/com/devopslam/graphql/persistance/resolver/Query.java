package com.devopslam.graphql.persistance.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.devopslam.graphql.persistance.model.Author;
import com.devopslam.graphql.persistance.model.Book;
import com.devopslam.graphql.persistance.repository.AuthorRepository;
import com.devopslam.graphql.persistance.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

}
