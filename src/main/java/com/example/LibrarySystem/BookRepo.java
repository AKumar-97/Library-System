package com.example.LibrarySystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends /*CrudRepository*/JpaRepository<Books, String> {
    List<Books> findBybookID(String bookID);

    List<Books> findBybookName(String bookName);
    List<Books> findByauthorName(String authorName);

}
