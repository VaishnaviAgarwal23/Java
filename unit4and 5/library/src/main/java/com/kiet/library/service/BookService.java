package com.kiet.library.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kiet.library.model.Book;

@Service 
public class BookService {
    List<Book> books = new ArrayList<>();
    public List<Book> getAll(){
        return books;
    }

    public Book getBookById(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                return b;
            }
        }
        return null;
    }

    public String addBook(Book book) {
        books.add(book);
        return "Book added successfully";
    }

    public String updateBook(int bookId, Book updatedBook){
        for (Book b : books) {
            if (b.getId() == bookId) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setCategory(updatedBook.getCategory());
                b.setPublishedYear(updatedBook.getPublishedYear());
                return "Book updated successfully";
            }
        }
        return "Book not found";
    }

    public String deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bookId) {
                books.remove(i);
                return "Book deleted successfully";
            }
        }
        return "Book not found";
    }

    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getCategory().equals(category)) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getPublishedYear() >= fromYear) {
                result.add(b);
            }
        }
        return result;
    }

}
