package com.devopslam.graphql;

import com.devopslam.graphql.persistance.model.Author;
import com.devopslam.graphql.persistance.model.Book;
import com.devopslam.graphql.persistance.repository.AuthorRepository;
import com.devopslam.graphql.persistance.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);
            bookRepository.save(
                    new Book(
                            "Java: A Beginner's Guide, Sixth Edition",
                            "0071809252",
                            728,
                            author));
        };
    }

}
