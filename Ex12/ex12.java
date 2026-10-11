import java.util.*;

class Book {
    private int bookId;
    private String title, author, category;
    private boolean available;

    Book(int id, String t, String a, String c, boolean av) {
        bookId = id;
        title = t;
        author = a;
        category = c;
        available = av;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Availability: " +
                (available ? "Available" : "Not Available"));
        System.out.println("-------------------------");
    }
}

public class LibraryBookSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(101, "Java Programming",
                "James Gosling", "Programming", true));
        books.add(new Book(102, "Wings of Fire",
                "APJ Abdul Kalam", "Biography", true));
        books.add(new Book(103, "Python Basics",
                "Guido van Rossum", "Programming", false));

        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter title or author: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if ((choice == 1 &&
                    b.getTitle().toLowerCase()
                    .contains(search.toLowerCase())) ||
                (choice == 2 &&
                    b.getAuthor().toLowerCase()
                    .contains(search.toLowerCase()))) {
                b.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("Book not found.");

        sc.close();
    }
}