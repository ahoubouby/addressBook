package com.ahoubouby.model;

public enum Relationship {

    PARENT("PARENT"),
    GRANDPARENT("GRANDPARENT"),
    SON("SON"),
    DAUGHTER("DAUGHTER"),
    AUNT("AUNT"),
    UNCLE("UNCLE");

    public final String label;

    private Relationship(String label) {
        this.label = label;
    }
}
