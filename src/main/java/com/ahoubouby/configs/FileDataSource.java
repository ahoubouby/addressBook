package com.ahoubouby.configs;
/*
 * ahoubouby created on 10/10/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.model.Contact;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class FileDataSource implements Closeable{
    ObjectOutputStream oos;
    ObjectInputStream ois;
    private static FileDataSource instance = null;

    private FileDataSource(ObjectOutputStream oos, ObjectInputStream ois) {
        this.ois = ois;
        this.oos = oos;
    }

    public static FileDataSource getInstance(File file) throws IOException {
        if (null == instance) {
            return new FileDataSource(new ObjectOutputStream(new FileOutputStream(file)),
                    new ObjectInputStream(new FileInputStream(file)));
        } else
            return instance;
    }
    
    public void  addObject (Object obejct)  throws IOException{
        oos.writeObject(obejct);
        oos.flush();
    }

    public void  read (Contact contact)  throws IOException, ClassNotFoundException{
        ArrayList<Contact> contactList =   (ArrayList<Contact> )ois.readObject();
    }

    @Override
    public void close() throws IOException {
        oos.close();
        ois.close();
    }
}
