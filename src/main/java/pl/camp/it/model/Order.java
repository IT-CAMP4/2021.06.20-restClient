package pl.camp.it.model;

import java.util.Date;
import java.util.Set;

public class Order {
    private int id;
    private User user;
    private Set<OrderPosition> positions;
    private double price;
    private Date date;

    public Order(User user, Set<OrderPosition> positions) {
        this.user = user;
        this.positions = positions;

        this.price = 0;
        for(OrderPosition basketPosition : this.positions) {
            this.price = this.price + (basketPosition.getBook().getPrice() * basketPosition.getPieces());
        }

        this.date = new Date();
    }

    public Order() {
    }

    public Set<OrderPosition> getPositions() {
        return positions;
    }

    public void setPositions(Set<OrderPosition> positions) {
        this.positions = positions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", positions=" + positions +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
