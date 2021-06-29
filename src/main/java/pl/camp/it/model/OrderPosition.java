package pl.camp.it.model;

public class OrderPosition {
    private int id;
    private Book book;
    private int pieces;

    public OrderPosition() {
    }

    public OrderPosition(int id, Book book, int pieces) {
        this.id = id;
        this.book = book;
        this.pieces = pieces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id=" + id +
                ", book=" + book +
                ", pieces=" + pieces +
                '}';
    }
}