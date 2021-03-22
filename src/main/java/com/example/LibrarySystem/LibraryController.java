package com.example.LibrarySystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
public class LibraryController {

    @Autowired
    BookRepo repo;


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    //adding books at this path or sending data to the server
    /*@RequestMapping("/addBooks")
    public String addBooks(Books book){
        repo.save(book);//saving the entity object
        return "home";
    }*/

    //adding the books at this path or sending data to the server
    //using POST mapping
    @PostMapping("/books")
    public Books addBooks(@RequestBody Books book){
        if(book.getBookName() == null) {                        //bookName is null
            if (book.getBookID() == null) {                     //bookName is null and bookID is also null
                if (book.getAuthorName() == null) {             //bookName is null and bookID is null and book
                    /*book.setBookName("nullbookName");
                    book.setBookID("nullID");
                    book.setAuthorName("nullauthorName");*/
                    //will result in server error
                } else {                                        //bookName is null and bookID is null but authorName is not null
                    book.setBookName("null");
                    book.setBookID("null");
                }
            } else {                                            //bookName is null but bookID is not null
                if (book.getAuthorName() == null) {             //bookName is null and authorName is null but bookID is not null
                    book.setBookName("null");
                    book.setAuthorName("null");
                } else {                                        //bookName is null but authorName is not null and bookID is not null
                    book.setBookName("null");
                }
            }
        }
        else {
            if (book.getBookID() == null) {                   //bookName is not null but bookID is null
                if (book.getAuthorName() == null) {           //bookName is not null but bookID is null and bookauthorName is null
                    book.setBookID("null");
                    book.setAuthorName("null");
                } else {                                      //bookName is not null and bookauthorName is not null but bookID is null
                    book.setBookID("null");
                }
            }
            else{                                             // bookName is not null and bookID is not null
                if (book.getAuthorName() == null) {          //bookName is not null and bookID is not null but bookauthorName is null
                    book.setAuthorName("null");
                }
            }
        }
        repo.save(book); //saving the entity object
        return (book) ;
    }

    //getting the books at this path or getting them from the server
    //using GET mapping
    @GetMapping("/books")
    public List<Books> getBooks()
    {
        return repo.findAll();
        //extended JPA repository instead of CRUD repository
        //to print data in JSON format
    }

    //deleting the books at this path from the server
    //using Delete mapping
    //deleting books using bookID
    @DeleteMapping("/books/{bookID}")
    public List<Books> deleteBooks(@PathVariable String bookID){
        /*ModelAndView mv = new ModelAndView("home");
        List<Books> book = repo.findBybookID(bookID);
        repo.deleteAll(book);//deleting the entity object
        return "home";*/
        List<Books> book = repo.findBybookID(bookID);
        repo.deleteAll(book);
        return book;
    }

    //creating another method for updating
    @PutMapping("/books")
    public Books updateBooks(@RequestBody Books book){
        repo.save(book); //saving the entity object
        return (book) ;
    }

    //finding books using each of the different attributes
    @GetMapping(value = "/books/{bookName}")
    public List<Books> getBookByName(@PathVariable String bookName)//finding books using bookName
    {

       /* ModelAndView mv1 = new ModelAndView("showByName");
        List<Books> book= repo.findBybookName(bookName);
        mv1.addObject("obj",book);
        return mv1;*/
        List<Books> book= repo.findBybookName(bookName);
        return (book);
    }

    @PutMapping(value = "/books/{bookName}")
    public Books updatesingleBooks(@PathVariable String bookName, @RequestBody Books temp){
        List<Books> book = repo.findBybookName(bookName);
        Books bookTemp;
        bookTemp= book.get(0);

        if(temp.getBookName() != null){
            bookTemp.setBookName(temp.getBookName());
        }
        if(temp.getBookID() != null){
            bookTemp.setBookID(temp.getBookID());
        }
        if(temp.getAuthorName() != null){
            bookTemp.setAuthorName(temp.getAuthorName());
        }

        book.add(0,bookTemp);
        repo.save(bookTemp);
        return(bookTemp);

    }

    @RequestMapping(value = "/getBookByID/{bookID}", method = {RequestMethod.GET,RequestMethod.POST})
    public  List<Books> getBookByID(@PathVariable String bookID)//finding books by bookID
    {
        /*ModelAndView mv2 = new ModelAndView("showByID");
        List<Books> book = repo.findBybookID(bookID);
        //System.out.println(book);
        mv2.addObject("obj2",book);
        return mv2;*/
        List<Books> book = repo.findBybookID(bookID);
        return (book);
    }

    @RequestMapping(value = "/getBookByAuthor", method = {RequestMethod.GET,RequestMethod.POST})
    public List<Books> getBookByAuthor(@RequestParam String authorName){
        /*ModelAndView mv3 = new ModelAndView("showByAuthor");
        List<Books> book= repo.findByauthorName(authorName);
        mv3.addObject("obj3",book);
        return mv3;*/
        List<Books> book = repo.findByauthorName(authorName);
        return (book);
    }



}
