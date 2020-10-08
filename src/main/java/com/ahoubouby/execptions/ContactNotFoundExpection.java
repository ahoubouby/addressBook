package com.ahoubouby.execptions;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

public class ContactNotFoundExpection extends Exception {
    private static final long serialVersionUID = 288153856991964756L;
    
    public  ContactNotFoundExpection(String message) {
        super(message);
    }
}
