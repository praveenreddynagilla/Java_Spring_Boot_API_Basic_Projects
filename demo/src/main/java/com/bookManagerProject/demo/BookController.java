package com.bookManagerProject.demo;
import java.util.HashMap;

import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController  //It is must on the top of the Controller class then only it will recognise here are the APIs.
public class BookController {

    //we are not working with any database so
    //we are creating a temporary database by using HashMaps
    //Here regarding the book , id is the primary key so and we are adding books to the database so

    Map <Integer,Book> bookData=new HashMap<>();

    // the user will not come and add book details by code right so
    //user need one api to connect frontend to backend so

    //whenever user wants to add book then

    //Here we need to use @PostMapping for when user call  that url then it will call that method

    @PostMapping("/add-new-book")   //this is the url attached with below method
    public String addBook(@RequestBody Book book){ //for Api we need to pass @RequestBody surely for pass all parameters
        bookData.put(book.getId(),book);
        return "book is created with id: "+book.getId();
    }

    @GetMapping("/get-book")
    public Book getBook(@RequestParam Integer id){   //@RequestParam is only for one parameter input
        return bookData.get(id);
    }
}
