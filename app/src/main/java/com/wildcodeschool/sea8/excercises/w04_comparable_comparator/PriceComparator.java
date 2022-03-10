package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.util.Comparator;

public class PriceComparator implements Comparator<CatalogItem>{
    static Comparator<CatalogItem> priceComparator = new Comparator<CatalogItem>() {
        @Override
        public int compare(CatalogItem o1, CatalogItem o2) {
            return(o1.getPrice().compareTo(o2.getPrice()));
        }
    };

    @Override
    public int compare(CatalogItem o1, CatalogItem o2) {
        return(o1.getPrice().compareTo(o2.getPrice()));
    }

    
}
