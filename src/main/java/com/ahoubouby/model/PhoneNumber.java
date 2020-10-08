package com.ahoubouby.model;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import java.io.Serializable;
import java.util.Objects;

import static com.ahoubouby.utils.ObjectValidator.*;
import static java.util.Objects.requireNonNull;

public class PhoneNumber implements Serializable {
    private static final long serialVersionUID = -659865551126578787L;

    private String value;

    public PhoneNumber(String phone) {
        requireNonNull(phone);
        checkArgument(isValidPhone(phone), MESSAGE_PHONE_CONSTRAINTS);
        this.value = phone;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }
}

