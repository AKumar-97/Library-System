package com.example.LibrarySystem;

//this is my Model class. This will contain the objects/model to my application

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//we do this to implement concept of JPA and make this as an entity and pass it as a table to the DB

public class Books {
    @Id
    private String bookName;
    private String  bookID;
    private String authorName;

    public Books(String bookName, String bookID, String authorName) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.authorName = authorName;
    }

    public Books() { }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", bookID=" + bookID +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
