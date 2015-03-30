package zy.testing.servlet.domains;

import java.util.Arrays;
import java.util.List;

public class Items {

    public List<Item> items() {

        return Arrays.asList(new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"), new Feature("Awesome!"))),
            new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."), new Feature("Ugly."))));
    }

    public static class Item {

        Item(String name, String price, List<Feature> features) {

            this.name = name;
            this.price = price;
            this.features = features;
        }

        public String getName() {

            return name;
        }

        public String getPrice() {

            return price;
        }

        public List<Feature> getFeatures() {

            return features;
        }

        String name, price;
        List<Feature> features;
    }

    public static class Feature {

        public Feature(String description) {

            this.description = description;
        }

        public String getDescription() {

            return description;
        }

        String description;
    }
}