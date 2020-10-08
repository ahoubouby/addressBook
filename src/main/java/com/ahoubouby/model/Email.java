package com.ahoubouby.model;

import java.io.Serializable;
import java.util.Objects;

import static com.ahoubouby.utils.ObjectValidator.*;
import static java.util.Objects.requireNonNull;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */


public class Email implements Serializable {
    private static final long serialVersionUID = 1654798686737229110L;
    private String value;

    public Email(String email) {
        requireNonNull(email);
        checkArgument(isValidEmail(email), MESSAGE_EMAIL_CONSTRAINTS);
        this.value = email;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }
}
