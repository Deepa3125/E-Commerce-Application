package ecommerce;


import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceMain {

    static ArrayList<Product> productList = new ArrayList<>();
    static ArrayList<CartItem> cart = new ArrayList<>();
    static int productIdCounter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Console E-commerce App!");

        while (running) {
            System.out.println("\n1.Add Product (Admin)\n2.View Products\n3.Add to Cart\n4.View Cart\n5.Checkout\n6.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    addToCart(sc);
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    System.out.println("Thank you for shopping with us!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    static void addProduct(Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.next();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stock = sc.nextInt();

        Product product = new Product(productIdCounter++, name, price, stock);
        productList.add(product);
        System.out.println("Product added successfully!");
    }

    static void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Available Products:");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    static void addToCart(Scanner sc) {
        viewProducts();
        if (productList.isEmpty()) return;

        System.out.print("Enter product ID to add to cart: ");
        int id = sc.nextInt();

        Product selected = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                selected = p;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (qty > selected.getStock()) {
            System.out.println("Insufficient stock! Available: " + selected.getStock());
            return;
        }

        cart.add(new CartItem(selected, qty));
        selected.setStock(selected.getStock() - qty);
        System.out.println("Added to cart successfully!");
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        double total = 0;
        for (CartItem item : cart) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " = Rs." + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Cart Total: Rs." + total);
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
            return;
        }

        System.out.println("Checkout Summary:");
        double total = 0;
        for (CartItem item : cart) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " = Rs." + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Amount: Rs." + total);
        System.out.println("Order placed successfully! Thank you for shopping.");

        cart.clear();
    }
}