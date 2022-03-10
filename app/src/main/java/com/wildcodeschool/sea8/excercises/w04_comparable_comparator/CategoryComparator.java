package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class CategoryComparator implements Comparator<CatalogItem>{
    static Comparator<CatalogItem> categoryComparator = new Comparator<CatalogItem>() {
        @Override
        public int compare(CatalogItem o1, CatalogItem o2) {
            return(o1.getCategory().compareTo(o2.getCategory()));
        }
    };

    @Override
    public int compare(CatalogItem o1, CatalogItem o2) {
        return(o1.getCategory().compareTo(o2.getCategory()));
    }

    
}
