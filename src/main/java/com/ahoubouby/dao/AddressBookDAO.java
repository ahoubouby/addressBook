package com.ahoubouby.dao;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.AddressBook;
import com.ahoubouby.configs.FileDataSource;
import com.ahoubouby.model.Contact;
import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AddressBookDAO implements BaseDao<Contact, String> {
    FileDataSource fileDataSource;
    static AddressBookDAO addressBookDAO;

    public static AddressBookDAO getInstance(FileDataSource fileDataSource) {
        if (null == addressBookDAO)
            return new AddressBookDAO(fileDataSource);
        return addressBookDAO;
    }

    private AddressBookDAO(FileDataSource fileDataSource) {
        this.fileDataSource = fileDataSource;
    }


    @Override
    public Contact save(Contact entity) {
        fileDataSource.addObject(entity);
        return entity;

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
        return fileDataSource
                .read()
                .filter(c -> c.getSurname().equals(id))
                .findFirst();
    }

    @Override
    public int update(String entity) {
        return 0;
    }
}
