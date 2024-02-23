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
    productsInst.add(product1);
    productsInst.addAll(products);
    productsInst.addAll(products);

    System.out.println("total items: " + productsInst.getAddCount());


  }

}
