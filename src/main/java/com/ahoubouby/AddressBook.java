package com.ahoubouby;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */


import com.ahoubouby.model.*;
import com.google.common.base.Optional;

import java.io.*;

public class AddressBook {

    public static void main(String[] args)  {
        try {
            Contact contact = new Contact(
                    "abdelwahed",
                    "ahoubouby",
                    new PhoneNumber("093939399"),
                    new Email("ahououby@gmail.com"),
                    new Family(Relationship.PARENT),
                    Optional.absent()
            ) ;

            ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream("contact.txt"));
            Contact contact1 = (Contact) outputStream.readObject();
            System.out.println(contact1);
            outputStream.close();
        }catch (Throwable ex) {
            ex.printStackTrace();
        }
       
    }
}
