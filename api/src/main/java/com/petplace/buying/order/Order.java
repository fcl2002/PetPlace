// package com.petplace.buying.order;

// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.ArrayList;
// import java.util.List;

// import com.petplace.buying.Customer;
// import com.petplace.catalog.domain.product.Product;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;

// @Entity
// @Table(name = "orders")

// public class Order {
//     @Id
//     @GeneratedValue(strategy = GenerationType.UUID)
//     private String id;

//     @Min(value = 0, message = "The total value must be positive")
//     private Double total;
//     private PaymentStatus paymentStatus;
//     private LocalDate createdAt;
//     private LocalTime time;
//     private Double freight;
//     private OrderStatus orderStatus;

//     @NotNull
//     @ManyToOne
//     @JoinColumn(name = "client_id", nullable = false)
//     private Customer client;

//     @NotNull
//     @ManyToMany
//     @JoinColumn(name = "product_id", nullable = false)
//     private List<Product> products = new ArrayList<>();

//     public Order(Double total, PaymentStatus paymentStatus, LocalDate createdAt, LocalTime time, Double freight, OrderStatus orderStatus, Customer client) {
//         this.total = total;
//         this.paymentStatus = paymentStatus;
//         this.createdAt = createdAt;
//         this.freight = freight;
//         this.orderStatus = orderStatus;
//         this.client = client;
//     }
// }
