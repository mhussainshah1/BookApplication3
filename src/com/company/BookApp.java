package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a method that returns the pricing for a requested number of books. Five books at $20.00 should return
 * $100, if they are in stock. If they are not in stock, that should be handled appropriately (hint - you decide).
 *
 */

public class BookApp {
    public static void main(String[] args) {
        BookDatabase database = new BookDatabase();
        List<Book> databaseBookList = database.getBooks();

        Scanner keyboard = new Scanner(System.in);
        String bookNameInput, bookName;
        List<Book> customerBookList = new ArrayList<>();

        for(int i=0; i<5; i++){
            System.out.print("Enter book SKU: ");
            Book book = database.getBook(keyboard.nextLine());
            customerBookList.add(book);
        }

        for(Book book:databaseBookList){
            bookNameInput = keyboard.next().toLowerCase();
            bookName = book.getTitle().toLowerCase();
            if(bookName.contains(bookNameInput)){
                customerBookList.add(book);
            }
        }
        BookApp app = new BookApp();
        System.out.println("The total price of five books are "+app.getTotal(customerBookList));
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
