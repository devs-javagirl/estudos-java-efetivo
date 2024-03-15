package Cap4.composition;

import java.util.HashSet;
import java.util.Set;

public class InstrumentedSetTest {

  public record Product(String name, double price) {}
  public static void main(String[] args) {

    Product product1 = new Product("Pencil", 2.45);
    Product product2 = new Product("Pen", 3.45);

    Set<Product> products = new HashSet<>();
    products.add(product1);
    products.add(product2);

    InstrumentedSet<Product> productsInst = new InstrumentedSet<>(products);
    productsInst.add(product1);
    productsInst.add(product2);

    Set<Product> productsCol = new HashSet<>();
    productsCol.add(new Product("rule", 5));
    productsCol.add(new Product("eraser", 2.45));

    productsInst.addAll(productsCol);

    System.out.println("total items: " + productsInst.getAddCount());

    productsInst.add(new Product("eraser", 3.25));
    System.out.println("total items: " + productsInst.getAddCount());

  }

}
