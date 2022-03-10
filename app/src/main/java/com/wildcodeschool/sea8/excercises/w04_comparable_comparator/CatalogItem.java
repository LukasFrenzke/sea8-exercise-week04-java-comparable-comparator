package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.math.BigDecimal;

public class CatalogItem implements Comparable<CatalogItem> {

    @Override
    public int compareTo(CatalogItem item) {
        if (this.getID() > item.getID()) return 1;
        if (this.getID() < item.getID()) return -1;
        else return 0;
    }

    private int id;
    private String name;
    private BigDecimal price;
    private String category;

    public CatalogItem(int id, String name, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return String.format("CatalogItem(Name: \"%s\", Price: %s, Category: %s, ID: %d)", getName(), getPrice().toString(), getCategory(), getID());
    }
}