package com.ahoubouby.dao;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.model.Contact;

import java.util.List;
import java.util.Optional;

public class AddressBookDAO  implements   BaseDao<Contact, String> {
    @Override
    public Contact save(Contact entity) {
        return null;
    }

    @Override
    public int delete(Contact entity) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public Optional<Contact> findById(String id) {
        return Optional.empty();
    }

    @Override
    public int update(String entity) {
        return 0;
    }
}
