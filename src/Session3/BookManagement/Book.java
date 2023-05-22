package Session3.BookManagement;

public class Book {
    int id;
    String name;
    float price;
    int pages;
    int publishDate;
    Author author;

    public Book(int id, String name, float price, int pages, int publishDate, Author author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pages = pages;
        this.publishDate = publishDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", publishDate=" + publishDate +
                ", author=" + author +
                '}';
    }
}
