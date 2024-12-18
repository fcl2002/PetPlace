// package com.petplace.buying;

// import java.util.ArrayList;
// import java.util.List;

// import com.petplace.buying.cart.Cart;
// import com.petplace.buying.order.Order;
// import com.petplace.catalog.domain.security.UserRole;
// import com.petplace.catalog.domain.user.ContactDetails;
// import com.petplace.catalog.domain.user.Password;
// import com.petplace.catalog.domain.user.User;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.DiscriminatorValue;
// import jakarta.persistence.Entity;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;

// @Entity
// @DiscriminatorValue("CLIENT")

// public class Customer extends User {

//     private String cpf;

//     public Customer(Password password, ContactDetails contactDetails, UserRole role) {
//         super(password, contactDetails, UserRole.CUSTOMER);
//     }

//     @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//     private Cart cart;

//     @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//     private Cart wishList;

//     @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<Order> orders = new ArrayList<>();
// }
