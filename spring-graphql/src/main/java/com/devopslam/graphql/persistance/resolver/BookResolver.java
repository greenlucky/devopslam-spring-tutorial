package com.devopslam.graphql.persistance.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.devopslam.graphql.persistance.model.Author;
import com.devopslam.graphql.persistance.model.Book;
import com.devopslam.graphql.persistance.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book>{


    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }



}
