package com.ahoubouby.configs;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class FileDataSource implements Closeable {
    ObjectOutputStream oos;
    ObjectInputStream ois;
    private static FileDataSource instance = null;
    private File file;
    private List<Contact> contacts;


    private FileDataSource(File file) {
        this.file = file;
        try {

            if (file.length() > 0) {
                this.ois = new ObjectInputStream(new FileInputStream(this.file));
                readFromFile();
            } else
                contacts = new Vector<>();
        } catch (Exception ex) {
             
        }

    }

    public static FileDataSource getInstance(File file) throws IOException {
        if (null == instance) {
            return new FileDataSource(file);
        } else
            return instance;
    }

    public void addObject(Contact object) {
        contacts.add(object);
    }

    public Stream<Contact> read() {
        return contacts.stream();
    }


    private void writeContact(Contact contact) {
        try {
            oos.writeObject(contact);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void readFromFile() throws Exception {
        contacts  = new ArrayList<>();
        while (true) {
            Contact contact = (Contact) ois.readObject();
            contacts.add(contact);
        }

    }

    @Override
    public void close() throws IOException {
        this.oos = new ObjectOutputStream(new FileOutputStream(this.file));
        contacts.forEach(this::writeContact);
        oos.close();
        if (null != ois) ois.close();
    }
}
