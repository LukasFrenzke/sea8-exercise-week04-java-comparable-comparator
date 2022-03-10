package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<CatalogItem>{
    static Comparator<CatalogItem> nameComparator = new Comparator<CatalogItem>() {
        @Override
        public int compare(CatalogItem o1, CatalogItem o2) {
            return(o1.getName().compareTo(o2.getName()));
        }
    };

    @Override
    public int compare(CatalogItem o1, CatalogItem o2) {
        return(o1.getName().compareTo(o2.getName()));
    }


    
}