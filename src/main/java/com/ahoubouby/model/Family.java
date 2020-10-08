package com.ahoubouby.model;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import java.io.Serializable;

public class Family extends Category implements Serializable {
    private static final long serialVersionUID = 1537291373623897545L;
    private Relationship relationship;

    public Family(Relationship relationship) {
        super("family");
        this.relationship = relationship;

    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "Family{" +
                "relationship=" + relationship +
                '}';
    }
}
