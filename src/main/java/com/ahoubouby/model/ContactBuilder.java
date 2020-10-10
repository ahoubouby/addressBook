package com.ahoubouby.model;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.google.common.base.Optional;

public final class ContactBuilder {
    private Contact contact;

    private ContactBuilder() {
        contact = new Contact();
    }

    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    public ContactBuilder withName(String name) {
        contact.setName(name);
        return this;
    }

    public ContactBuilder withSurname(String surname) {
        contact.setSurname(surname);
        return this;
    }

    public ContactBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        contact.setPhoneNumber(phoneNumber);
        return this;
    }

    public ContactBuilder withEmail(Email email) {
        contact.setEmail(email);
        return this;
    }

    public ContactBuilder withAge(int age) {
        contact.setAge(age);
        return this;
    }

    public ContactBuilder withHairColor(Optional<String> hairColor) {
        contact.setHairColor(hairColor);
        return this;
    }

    public ContactBuilder withCategory(Category category) {
        contact.setCategory(category);
        return this;
    }

    public Contact build() {
        return contact;
    }
}
