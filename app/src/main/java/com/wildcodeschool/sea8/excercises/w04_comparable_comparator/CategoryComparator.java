package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class CategoryComparator implements Comparator<CatalogItem>{
    static Comparator<CatalogItem> categoryComparator = new Comparator<CatalogItem>() {
        @Override
        public int compare(CatalogItem o1, CatalogItem o2) {
            if (o1.getCategory().length() > o2.getCategory().length()) return 1;
            if (o1.getCategory().length() < o2.getCategory().length()) return -1;
            else return 0;
        }
    };

    @Override
    public int compare(CatalogItem o1, CatalogItem o2) {
        if (o1.getCategory().length() > o2.getCategory().length()) return 1;
        if (o1.getCategory().length() < o2.getCategory().length()) return -1;
        else return 0;
    }

    
}
