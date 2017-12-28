----------------------------------
**Demo Spring and GraphQL**
----------------------------------

Run project mvn spring-boot:run

View Schema: <a href="http://localhost:8080/graphql/schema.json">http://localhost:8080/graphql/schema.json</a>

To query data from server using GraphQL, we should use <a href="https://insomnia.rest">Insomnia app</a> or using plugin GraphiQL innner server, paste the query below to tool:

1. FindAllAuthors:

     query {
        findAllAuthors{id firstName lastName}
     }
 
2. FindAllBooks:

    query {
        findAllBooks{
            id 
            title
            isbn
            author{
                firstName
                lastName
            }
        }
    }

3. CountBooks:

    query {
        countBooks
    }

4. CountAuthors:

    query {
        countAuthors
    }

5. Add new Author:

    mutation {
        newAuthor(firstName: "firstName", lastName: "lastName"){id firstName lastName}
    }

6. Add new Book:

    mutation {
        newBook(
            title : "Title book", isbn : "23124324", pageCount : 123, author: 1
        ){id title}
    }

7. Update PageSize of Book:

    mutation{
        updateBookPageCount(pageCount: 250, id: 2)
        {id pageCount}
    }

8. Delete Book:
    mutation{
        deleteBook(id: 1)
    }

