package com.ahoubouby.model;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */


import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public abstract class Category implements Serializable {
    private static final long serialVersionUID = 3111321735924917378L;

    private String name;
    

    public Category(String name) {
        requireNonNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

}
