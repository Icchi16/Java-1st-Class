package Session3.BookManagement;

import java.util.Scanner;

public class BookManagement {
static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static Author author1 = new Author(1, "Trần Thị ku");
    static Author author2 = new Author(2, "Nguyễn Văn Somebody");
    static Author[] authorList = {author1,author2};


    static Book book1 = new Book(1, "Làm thế nào để giỏi JavaScipt", 45000, 200, 2024, author1);
    static Book book2 = new Book(2, "Java tuổi gì?", 30000, 340, 2005, author2);
    static Book book3 = new Book(3, "JavaScrit hơn Java vì sao?", 120000, 140, 1988, author2);

    static Book[] bookList = {book1,book2,book3};

    public static void menu() {
        while (true) {
            System.out.println("---------------------- Student Management ----------------------");
            System.out.println("1. Show Book List");
            System.out.println("2. Create Author");
            System.out.println("3. Create Book");
            System.out.println("4. Update Book");
            System.out.println("5. Exit");
            System.out.println("---------------------- Student Management ----------------------");
            System.out.println("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showBookList();
                    break;
                case 2:
                    createAuthor();
                    showAuthorList();
                    break;
                case 3:
                    createBook();
                    break;
                case 4:
                    updateBook();
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("****** Please input correct option ******");
            }
        }
    }


    public static void showBookList() {
        for (Book book: bookList
             ) {
            System.out.println(book.toString());
        }
    }
    public static void showAuthorList() {
        for (Author author: authorList
        ) {
            System.out.println(author.toString());
        }
    }

    public static void createAuthor() {
        int newID = getnewID(1);
        System.out.println("---------------------- New Author Info ----------------------");
        System.out.println("--------------------- Input Book Name ---------------------");
        String newName = scanner.nextLine();
        Author[] newAuthorList = new Author[authorList.length + 1];

        while (newName.equals("")){
            System.out.println("--------------------- Input Author Name ---------------------");
            newName = scanner.nextLine();
        }

        for (int i = 0; i < newAuthorList.length; i++) {
            if( i > authorList.length - 1){
                newAuthorList[i] = new Author(newID, newName);
            } else {
                newAuthorList[i] = authorList[i];
            }
        }
        authorList = newAuthorList;
    }

    public static void createBook() {
        System.out.println("---------------------- How many books you want to create ? ----------------------");
        int newBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < newBooks; i++) {
            Book[] newBookList = new Book[bookList.length + 1];
            int newBookID = getnewID(2);
            System.out.println("---------------------- New Book "+ (i + 1) +" Info ----------------------");
            System.out.println("--------------------- Input Book Name ---------------------");
            String newBookName = scanner.nextLine();
            while (newBookName.equals("")) {
                System.out.println("****** Please input correct name ******");
                newBookName = scanner.nextLine();
            }
            System.out.println("--------------------- Input Book Price ---------------------");
            float newBookPrice = Float.parseFloat(scanner.nextLine());
            System.out.println("--------------------- Input Book Pages ---------------------");
            int newBookPage = Integer.parseInt(scanner.nextLine());
            System.out.println("--------------------- Input Book Publish Date ---------------------");
            int newPublishDate = Integer.parseInt(scanner.nextLine());
            System.out.println("--------------------- Choose Author (input ID) ---------------------");
            showAuthorList();
            int newAuthorId = Integer.parseInt(scanner.nextLine());
            Author newAuthor = findAuthorById(newAuthorId);

            for (int j = 0; j < newBookList.length; j++) {
                if( j > bookList.length - 1){
                    newBookList[j] = new Book(newBookID, newBookName, newBookPrice, newBookPage, newPublishDate, newAuthor);
                } else {
                    newBookList[j] = bookList[j];
                }
            }
            bookList = newBookList;
        }
    }

    public static void updateBook() {
        showBookList();
        System.out.println("---------------------- Choose Book ID to update ----------------------");
        int bookChoiceID = Integer.parseInt(scanner.nextLine());
        Book chosenBook = findBookById(bookChoiceID);
        System.out.println("---------------------- Update Book "+ chosenBook.getId() +" Info ----------------------");
        System.out.println("--------------------- Input New Book Name ---------------------");
        String updateBookName = scanner.nextLine();
        if(updateBookName.equals("")){
            updateBookName = chosenBook.getName();
        }
        System.out.println("--------------------- Input Book Price ---------------------");
        String updateBookPrice = scanner.nextLine();
        if(updateBookPrice.equals("")){
            updateBookPrice = Float.toString(chosenBook.getPrice());
        }
        System.out.println("--------------------- Input Book Pages ---------------------");
        String updateBookPage = scanner.nextLine();
        if(updateBookPage.equals("")){
            updateBookPage = Integer.toString(chosenBook.getPages());
        }
        System.out.println("--------------------- Input Book Publish Date ---------------------");
        String updatePublishDate = scanner.nextLine();
        if(updatePublishDate.equals("")){
            updatePublishDate = Integer.toString(chosenBook.getPublishDate());
        }
        System.out.println("--------------------- Choose Author (input ID) ---------------------");
        showAuthorList();
        int newAuthorId = Integer.parseInt(scanner.nextLine());
        Author updateAuthor = findAuthorById(newAuthorId);



        chosenBook.setName(updateBookName);
        chosenBook.setPrice(Float.parseFloat(updateBookPrice));
        chosenBook.setPages(Integer.parseInt(updateBookPage));
        chosenBook.setPublishDate(Integer.parseInt(updatePublishDate));
        chosenBook.setAuthor(updateAuthor);
    }


  public static int getnewID (int option){
        int maxId = 0;
        switch (option){
            case 1:
                for (Author author: authorList
                     ) {
                    if(maxId < author.getId()){
                        maxId = author.getId();
                    }
                }
                break;
            case 2:
                for (Book book: bookList){
                    if(maxId < book.getId()){
                        maxId = book.getId();
                    }
                }
        }
        maxId++;
        return maxId;
  }

  public static Author findAuthorById(int id) {
        Author result = null;
      for (Author author : authorList) {
          if (author.getId() == id) {
              result = author;
              break;
          }
      }
        return result;
  }

    public static Book findBookById(int id) {
        Book result = null;
        for (Book book : bookList) {
            if (book.getId() == id) {
                result = book;
                break;
            }
        }
        return result;
    }
}
