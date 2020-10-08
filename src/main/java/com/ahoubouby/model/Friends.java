package com.ahoubouby.model;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import java.io.Serializable;

import static com.ahoubouby.utils.ObjectValidator.*;

public class Friends extends Category implements Serializable {
    private static final long serialVersionUID = -3539929371746109694L;
    private int numFriendshipYears;
    
    public Friends( int numFriendshipYears) {
        super("friends");
        checkArgument(numFriendshipYears > 0 , MESSAGE_MUST_BE_POSITIVE);
    }
}
