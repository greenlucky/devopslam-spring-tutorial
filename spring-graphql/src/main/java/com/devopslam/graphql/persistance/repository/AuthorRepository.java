package com.devopslam.graphql.persistance.repository;

import com.devopslam.graphql.persistance.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
}
