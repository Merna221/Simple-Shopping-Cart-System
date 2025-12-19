/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalproject;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
        Catalog catalog = new Catalog();
        ShoppingCart cart = ShoppingCart.getInstance();
        ShopService service = new ShopService();

        // Observers
        service.registerObserver(new InventoryObserver());
        service.registerObserver(new EmailNotificationObserver());

        System.out.println("=== Simple Shopping Cart Demo ===");

        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Catalog:");
                    for (Product p : catalog.list()) {
                        System.out.printf("%s | %s | $%.2f - %s%n",
                                p.getId(), p.getName(), p.getPrice(), p.getDescription());
                    }
                    break;

                case "2":
                    System.out.print("Enter product id: ");
                    String id = scanner.nextLine().trim();
                    Product prod = catalog.findById(id);
                    if (prod == null) {
                        System.out.println("No product with id " + id);
                        break;
                    }
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Gift wrap? (y/n): ");
                    String gw = scanner.nextLine().trim();
                    Product toAdd = prod;
                    if (gw.equalsIgnoreCase("y")) {
                        toAdd = new GiftWrapDecorator(prod);
                    }

                    CartCommand addCmd = new AddCommand(toAdd, qty);
                    addCmd.execute();
                    break;

                case "3":
                    System.out.print("Enter product id to remove: ");
                    String rid = scanner.nextLine().trim();
                    System.out.print("Quantity to remove: ");
                    int rqty = Integer.parseInt(scanner.nextLine().trim());

                    CartCommand remCmd = new RemoveCommand(rid, rqty);
                    remCmd.execute();
                    break;

                case "4":
                    System.out.println("Cart contents:");
                    for (CartItem ci : cart.getItems()) {
                        System.out.printf("%s x%d - $%.2f each ⇒ $%.2f%n",
                                ci.product.getName(), ci.quantity, ci.product.getPrice(),
                                ci.product.getPrice() * ci.quantity);
                    }
                    System.out.printf("Total: $%.2f%n", cart.getTotal());
                    break;

                case "5":
                    if (cart.isEmpty()) {
                        System.out.println("Cart empty.");
                        break;
                    }

                    System.out.println("Payment method: 1) Credit Card 2) PayPal");
                    String pm = scanner.nextLine().trim();

                    if (pm.equals("1")) {
                        System.out.print("Enter card number: ");
                        String card = scanner.nextLine().trim();
                        service.setPaymentStrategy(new CreditCardPayment(card));
                    } else {
                        System.out.print("Enter PayPal email: ");
                        String email = scanner.nextLine().trim();
                        service.setPaymentStrategy(new PayPalPayment(email));
                    }

                    CartCommand checkout = new CheckoutCommand(service);
                    checkout.execute();
                    break;

                case "0":
                    exit = true;
                    break;

                default:
                    System.out.println("Unknown choice.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1) List products");
        System.out.println("2) Add product to cart");
        System.out.println("3) Remove product from cart");
        System.out.println("4) View cart");
        System.out.println("5) Checkout");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }
}