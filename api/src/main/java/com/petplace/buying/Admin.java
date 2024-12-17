package com.petplace.buying;

import com.petplace.catalog.domain.security.UserRole;
import com.petplace.catalog.domain.user.ContactDetails;
import com.petplace.catalog.domain.user.Password;
import com.petplace.catalog.domain.user.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("ADMIN")

public class Admin extends User {
    public Admin(Password password, ContactDetails contactDetails, UserRole role) {
        super(password, contactDetails, UserRole.ADMIN);
    }
}
