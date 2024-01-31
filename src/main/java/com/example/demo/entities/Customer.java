package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;


    // Part G: nullable = false validates the value provided by the user is not null
    //   before allowing the customer to be saved to the database (empty is OK, null is not OK)
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    // Part G: nullable = false validates the value provided by the user is not null
    //   before allowing the customer to be saved to the database (empty is OK, null is not OK)
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    // Part G: nullable = false validates the value provided by the user is not null
    //   before allowing the customer to be saved to the database (empty is OK, null is not OK)
    @Column(name = "address", nullable = false)
    private String address;

    // Part G: nullable = false validates the value provided by the user is not null
    //   before allowing the customer to be saved to the database (empty is OK, null is not OK)
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    // Part G: nullable = false validates the value provided by the user is not null
    //   before allowing the customer to be saved to the database (empty is OK, null is not OK)
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    public Customer() {

    }

    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Division division_id, Set<Cart> carts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = division_id;
        this.carts = carts;
    }

    public void add(Cart cart) {

        if (cart != null) {

            if (carts == null) {
                carts = new HashSet<>();
            }

            carts.add(cart);
            cart.setCustomer(this);
        }
    }

}
