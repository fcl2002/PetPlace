package com.petplace.catalog.domain.user;

import org.springframework.util.Assert;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class ContactDetails {

    private String firstName;
    private String lastName;
    
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email"))
    private Email email;
    
    @Embedded
    @AttributeOverride(name = "phone", column = @Column(name = "phone"))
    private Phone phone;
    
    public ContactDetails(String firstName, String lastName, Email email, Phone phone) {
        Assert.notNull(firstName, "firstName must not be null");
        Assert.notNull(lastName, "lastName must not be null");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }
}
