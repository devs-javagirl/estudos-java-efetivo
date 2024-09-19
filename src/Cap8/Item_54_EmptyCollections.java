package Cap8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item_54_EmptyCollections {

    enum CheeseType {
        STILTON,
        PARMESAO,
        PRATO,
        MUSSARELA
    }
    private record Cheese (CheeseType type){

    }

    private static List<Cheese> cheesesInStock = new ArrayList<>();


    private static List<Cheese> getCheeses() {
        return cheesesInStock.isEmpty() ? Collections.emptyList() : cheesesInStock;
    }

    public static void main(String[] args) {
        cheesesInStock.add(new Cheese(CheeseType.PARMESAO));
        cheesesInStock.add(new Cheese(CheeseType.MUSSARELA));
        cheesesInStock.add(new Cheese(CheeseType.PRATO));

        for( Cheese cheese: getCheeses()) {
            System.out.println(cheese);
        }

        Cheese parmesao = new Cheese(CheeseType.PARMESAO);
        System.out.println("Temos queijo Parmesao ? " + cheesesInStock.contains(parmesao));

        System.out.println("Limpando a lista");

        cheesesInStock.clear();

        System.out.println("Tamanho da lista " + cheesesInStock.size());

        System.out.println("Temos queijo Parmesao ? " + cheesesInStock.contains(parmesao));

        for( Cheese cheese: getCheeses()) {
            System.out.println(cheese);
        }
    }
}
