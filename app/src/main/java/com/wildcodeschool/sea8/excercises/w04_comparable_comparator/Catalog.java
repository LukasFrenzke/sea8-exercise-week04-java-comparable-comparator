package com.wildcodeschool.sea8.excercises.w04_comparable_comparator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Catalog {
    // File containing our catalog
    public static final File CATALOG_FILE = new File("src/main/resources/catalog.csv");
    public static void main(String[] args) {
        // First we are reading the CSV file and turn the data inside into a list containing our catalog items.
        List<CatalogItem> catalog = new ArrayList<CatalogItem>();
        try {
            List<String> lines = Files.readAllLines(CATALOG_FILE.toPath());
            lines.remove(0);
            String[] splitLine;
            for (String line : lines) {
                splitLine = line.split(",");
                catalog.add(new CatalogItem(Integer.parseInt(splitLine[0]), splitLine[1], new BigDecimal(splitLine[2]), splitLine[3]));
            }
        } catch (IOException e) {
            System.err.println("File could not be read.");
            e.printStackTrace();
            return;
        } catch (NumberFormatException e) {
            System.err.println("Catalog CSV is corrupted.");
            e.printStackTrace();
            return;
        }
        // After the catalog is loaded, we randomly scramble the ordering of the list.
        // Note that we are seeding the random shuffling so that we always get the same
        // result on consecutive executions with the same data.
        Collections.shuffle(catalog, new Random(20220310));

        // Next we have a look at the data.
        printCatalog(catalog);
        System.out.println("_________________________");
        // TASK AREA START
        // Sort by ID
        Collections.sort(catalog);
        printCatalog(catalog);
        System.out.println("_________________________");
        // Sort by Price
        Collections.sort(catalog , new PriceComparator());
        printCatalog(catalog);
        System.out.println("_________________________");
        // Sort by Name asc
        Collections.sort(catalog , new NameComparator());
        printCatalog(catalog);
        System.out.println("_________________________");
        // Sort by Category length
        Collections.sort(catalog , new CategoryComparator());
        printCatalog(catalog);

        // Unterschied zwischen Comparable und Comparator:
        // Mit Comparable lässt sich relativ simpel eine einheitliche Sortierlogik implementieren. z.B. können dann alle Listen nach ID, Name, Preis etc sortiert werden.
        // Mit Comparator kann man Individuallogiken implementieren. Das ist hilfreich, wenn man z.B. eine Liste nach Namen und die andere Liste nach Preisen sortieren möchte.
        // Hier ist dann keine einheitliche Lösung notwendig, sondern eine Logik für jede Liste. Dank der verschiedenen Comparator die man erstellen kann, kann so die Sort-Methode mit der Liste und der gewünschten Sortierung ausgeführt werden.
        // TASK ARE END
    }

    /**
     * Utility method to print the catalog in a table view.
     * @param catalog The catalog list to display.
     */
    private static void printCatalog(List<CatalogItem> catalog) {
        System.out.println("ID\tName\t\tPrice\tCategory");
        catalog.forEach((item) -> System.out.println(item.getID() + "\t" + item.getName() + ((item.getName().length() > 8) ? "\t" : "\t\t") + item.getPrice().toString() + "\t" + item.getCategory()));
    }
}
