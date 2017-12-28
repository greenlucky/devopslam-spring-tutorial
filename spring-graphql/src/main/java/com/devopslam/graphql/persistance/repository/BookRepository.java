package com.devopslam.graphql.persistance.repository;

import com.devopslam.graphql.persistance.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
