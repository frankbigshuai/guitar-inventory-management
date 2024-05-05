package iu.edu.frank.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "guitar", name="customers")
public final class Customer {
    @Id
    @Column(name = "customer_userName")
    private  String username;

    @Column(name = "customer_password")
    private  String password;

    @Column(name = "customer_email")
    private  String email;

    public Customer(String username,
                    String password,
                    String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}