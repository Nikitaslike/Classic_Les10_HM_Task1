package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Війна та мир", "Л. Товстий", 1869, 298);
        Book book2 = new Book("Гаррі Поттер та філософський камінь", "Дж. Роулінг", 1997, 9029);
        User user1 = new User("Дмитро", "вулиця Морозива.");
        User user2 = new User("Віра ", "вулиця Кубічна");
        book1.printInfo();
        book2.printInfo();
        user1.printInfo();
        user2.printInfo();
        System.out.println("Нещодавні зміни в історії:");
        user1.takeBook(book1);
        user1.takeBook(book2);
        user2.takeBook(book2);
        user1.returnBook(book1);
        user2.returnBook(book2);
        book1.printInfo();
        book2.printInfo();
        user1.printInfo();
        user2.printInfo();
    }
}
class Book {
    private String bookName;
    private String bookAutor;
    private int dateOfPublish;
    private boolean status; // Якщо це true, то ця книга- вільна
    int likes;
    public Book(String bookName, String bookAutor, int dateOfPublish, int likes) {
        this.bookName = bookName;
        this.bookAutor = bookAutor;
        this.dateOfPublish = dateOfPublish;
        this.status = true;
        this.likes = likes;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookAutor() {
        return bookAutor;
    }
    public void setBookAutor(String bookAutor) {
        this.bookAutor = bookAutor;
    }
    public int getDateOfPublish() {
        return dateOfPublish;
    }
    public void setDateOfPublish(int dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }
    public boolean isAvailable() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void printInfo() {
        System.out.println("Назва книги: " + bookName);
        System.out.println("Автор книги: " + bookAutor);
        System.out.println("Рік видання: " + dateOfPublish);
        if (status == true) {
            System.out.println("Книга доступна.");
        } else {
            System.out.println("Книга занята :(");
        }
        System.out.println("Книга сподобалася: "+likes+" користувачам.");
    }
}
class User {
    private String name;
    private String address;
    private ArrayList<Book> listOfBooks;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
        this.listOfBooks = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(ArrayList<Book> books) {
        this.listOfBooks = books;
    }

    public void takeBook(Book book) {
        if (book.isAvailable()) {
            listOfBooks.add(book);
            book.setStatus(false);
            System.out.println("Користувач " + name + " отримав книгу " + book.getBookName());
        } else {
            System.out.println("Книга " + book.getBookName() + " вже використовується");
        }
    }

    public void returnBook(Book book) {
        if (listOfBooks.contains(book)) {
            listOfBooks.remove(book);
            book.setStatus(true);
            System.out.println("Користувач " + name + " повернув книгу " + book.getBookName());
        } else {
            System.out.println("Користувач " + name + " не отримував таку книгу " + book.getBookName());
        }
    }

    public void printInfo() {
        System.out.println("Ім'я: " + name);
        System.out.println("Адреса: " + address);
        System.out.println("Кількість прочитаних книжок: " + listOfBooks.size());
        for (Book book : listOfBooks) {
            book.printInfo();
        }
    }
}