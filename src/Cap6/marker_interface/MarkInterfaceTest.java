package Cap6.marker_interface;

public class MarkInterfaceTest {
    public static void main(String[] args) {
        Book physicalBook = new Book("Effective Java", "Joshua Bloch");
        EBook digitalBook = new EBook("Clean Code", "Robert C. Martin");

        // This will work
        double shippingCost = ShippingCalculator.calculateShipping(physicalBook);
        System.out.println("Shipping cost for physical book: " + shippingCost);

        // This will not compile
        //double digitalShippingCost = ShippingCalculator.calculateShipping(digitalBook);
    }
}
