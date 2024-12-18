package com.petplace.catalog.domain.user;

import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "users")

public abstract class User {
    @EmbeddedId
    private UserID id;

    @Embedded
    private Password password;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "contact_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "contact_last_name")),
            @AttributeOverride(name = "email", column = @Column(name = "contact_email")),
            @AttributeOverride(name = "phone", column = @Column(name = "contact_phone"))
    })
    private ContactDetails contactDetails;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(Password password, ContactDetails contactDetails, UserRole role) {
        this.id = new UserID();
        this.contactDetails = contactDetails;
        this.password = password;
        this.role = role;
    }

    public Password getPassword() {
        return password;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
