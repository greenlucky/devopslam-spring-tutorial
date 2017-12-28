package com.devopslam.graphql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQlTest {

    @LocalServerPort
    private int randomPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAllAuthors() {

        String url = "http://localhost:" + randomPort + "/graphql";
        Object data = "{\"query\":\"query{\\n\\tfindAllAuthors{id firstName lastName}\\n}\"}";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, data, Object.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testFindAllBooks() {
        String url = "http://localhost:" + randomPort + "/graphql";
        Object data  = "{\"query\": \"query{findAllBooks{id title}}\"}";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, data, Object.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testAddNewAuthor() {
        String url = "http://localhost:" + randomPort + "/graphql";
        Object data = "{\"query\":\"mutation{newAuthor(firstName: \\\"Lam\\\", lastName: \\\"Nguyen\\\"){id lastName}}\"}";

        ResponseEntity<Object> response = restTemplate.postForEntity(url, data, Object.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testDeleteBook() {
        String url = "http://localhost:" + randomPort + "/graphql";
        Object data = "{\"query\": \"mutation{deleteBook(id: \\\"1\\\")}\"}";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, data, Object.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testUpdateBookExceptionIdNotFound() {
        String url = "http://localhost:" + randomPort + "/graphql";
        Object data = "{\"query\": \"mutation{updateBookPageCount(pageCount: 250, id: 2){id pageCount}}\"}";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, data, Object.class);
        System.out.println(response.getBody());
    }
}
