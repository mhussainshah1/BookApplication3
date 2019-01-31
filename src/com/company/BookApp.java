package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a method that returns the pricing for a requested number of books. Five books at $20.00 should return
 * $100, if they are in stock. If they are not in stock, that should be handled appropriately (hint - you decide).
 */

public class BookApp {
    public static void main(String[] args) {
        BookDatabase database = new BookDatabase();

        Scanner keyboard = new Scanner(System.in);
        List<Book> customerBookList = new ArrayList<>();

        Book book;
        String SKU;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter book SKU: ");
            SKU = keyboard.next();
            book = database.getBook(SKU);
            customerBookList.add(book);
        }

//        List<Book> databaseBookList = database.getBooks();
//        String bookNameInput, bookName;
//        for(Book book:databaseBookList){
//        System.out.print("Enter book Name: ");
//            bookName = book.getTitle().toLowerCase();
//            bookNameInput = keyboard.next().toLowerCase();
//            if(bookName.contains(bookNameInput)){
//                customerBookList.add(book);
//            }
//        }
        BookApp app = new BookApp();
        System.out.println("The total price is " + app.getTotal(customerBookList));
    }

    public double getTotal(List<Book> books) {
        double sum = 0.0;
        for (Book book : books) {
            if (book.isInStock()) {
                sum += book.getPrice();
            } else {
                System.out.println(book.getTitle() + " is out of stock");
            }
        }
        return sum;
    }
}