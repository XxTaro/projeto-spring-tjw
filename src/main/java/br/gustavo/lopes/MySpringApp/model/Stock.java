package br.gustavo.lopes.MySpringApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private int price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Stock(long id, String name, String description, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", description: " + description +
                ", price: " + price +
                ", quantity: " + quantity;
    }
}
