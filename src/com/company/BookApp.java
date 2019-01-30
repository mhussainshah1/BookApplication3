package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;
import java.util.Scanner;

/**
 * Assignment
 * ----------
 * Create a method that returns the pricing for a requested number of books. Five books at $20.00 should return
 * $100, if they are in stock. If they are not in stock, that should be handled appropriately (hint - you decide).
 *
 */

public class BookApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter books ");
        int numberOfBooks = keyboard.nextInt();

        BookDatabase database = new BookDatabase();
        List<Book> books = database.getBooks();

        BookApp app = new BookApp();
        System.out.println("The total price of five books are "+app.getTotal(books));
    }

    public double getTotal(List<Book> books){
        int sum = 0;
        for(Book book : books){
            if(book.isInStock()){
                sum += book.getPrice() ;
            } else {
                //If they are not in stock, that should be handled appropriately
                System.out.println(book.getTitle() +" is out of stock");
            }
        }
        return sum;
    }
}
