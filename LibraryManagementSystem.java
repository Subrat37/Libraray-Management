import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.println("enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Book Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Title: ");
                    String title = sc.nextLine();

                    System.out.println("Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author, false));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.println("enter book id: ");
                    library.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.println("enter book id: ");
                    library.returnBook(sc.nextInt());
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }

    }
}

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    public void displayBooks() {
        for (Book b : books) {
            System.out.println(b.id + " " + b.title + " " + b.author + " " + (b.issued ? "Issued" : "avilable"));
        }
    }

    public void issueBook(int id) {
        Book b = searchBook(id);

        if (b == null) {
            System.out.println("Book not found");
        } else if (b.issued) {
            System.out.println("Book already issued");
        } else {
            b.issued = true;
            System.out.println("Book issued successfully");
        }
    }

    public void returnBook(int id) {
        Book b = searchBook(id);

        if (b == null) {
            System.out.println("Book not found");
        } else if (b.issued = false) {
            System.out.println("Book already Avialble");
        } else {
            b.issued = true;
            System.out.println("Book returned successfully");
        }
    }
}
