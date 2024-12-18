// package com.petplace.buying.cart;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.data.annotation.Id;

// import com.petplace.catalog.domain.product.Product;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;


// @Entity
// @Table(name = "carts")

// public class Cart {
//     @Id
//     @GeneratedValue(strategy = GenerationType.UUID)
//     private String id;

//     @OneToMany
//     private List<Product> products = new ArrayList<>();

//     public Cart(List<Product> products) {
//         this.products = products;
//     }
// }
