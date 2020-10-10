package com.ahoubouby.model;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.google.common.base.Optional;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    private static final long serialVersionUID = 5196217427868307382L;
    private String name;
    private String surname;
    private PhoneNumber phoneNumber;
    private Email email;
    private int age;
    private Optional<String >  hairColor;
    private Category category;

    public Contact() {
    }

    public Contact(String name, String surname, PhoneNumber phoneNumber, Email email, Category category,   Optional<String > hairColor) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.category = category;
      this.hairColor = hairColor;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<String> getHairColor() {
        return hairColor;
    }

    public void setHairColor(Optional<String> hairColor) {
        this.hairColor = hairColor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", age=" + age +
                ", hairColor='" + hairColor + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return surname.equals(contact.surname) &&
                phoneNumber.equals(contact.phoneNumber) &&
                email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, phoneNumber, email);
    }
}
