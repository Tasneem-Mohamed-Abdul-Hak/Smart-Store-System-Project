package smart_store;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        StoreManager storeManager = new StoreManager(cart);

        boolean running = true;

        while (running) {

            showMenu();

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addProduct(scanner, storeManager);
                    break;

                case 2:
                    storeManager.displayProducts();
                    break;

                case 3:
                    searchProduct(scanner, storeManager);
                    break;

                case 4:
                    buyProduct(scanner, storeManager);
                    break;

                case 5:
                    restockProduct(scanner, storeManager);
                    break;

                case 6:
                    applyDiscount(scanner, storeManager);
                    break;

                case 7:
                    displayProduct(scanner, storeManager);
                    break;

                case 8:
                    System.out.println("Total stock value: "
                            + storeManager.calculateStockValue());
                    break;

                case 9:
                    System.out.println("Number of products: "
                            + storeManager.getProductCount());
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using Smart Store.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

   
    public static void showMenu() {

        System.out.println("\n==============================");
        System.out.println("        SMART STORE");
        System.out.println("==============================");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Search Product");
        System.out.println("4. Buy Product");
        System.out.println("5. Restock Product");
        System.out.println("6. Apply Discount");
        System.out.println("7. View Product Details");
        System.out.println("8. Calculate Stock Value");
        System.out.println("9. Product Count");
        System.out.println("0. Exit");
        System.out.println("==============================");
    }

    
    public static void addProduct(
            Scanner scanner,
            StoreManager storeManager) {

        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Is product active? (true/false): ");
        boolean active = scanner.nextBoolean();

        System.out.print("Enter warranty period in months: ");
        int warrantyPeriod = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        Product product = new Electronics(
                id,
                name,
                price,
                quantity,
                description,
                active,
                warrantyPeriod,
                brand,
                model
        );
        storeManager.addProduct(product);
    }

    
    public static void searchProduct(
            Scanner scanner,
            StoreManager storeManager) {

        scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        Product product = storeManager.findProductByName(name);

        if (product != null) {
            System.out.println(product.getDetailsList());
        } else {
            System.out.println("Product not found.");
        }
    }

    
    public static void buyProduct(
            Scanner scanner,
            StoreManager storeManager) {

        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        storeManager.buyProduct(id, quantity);
    }

    
    public static void restockProduct(
            Scanner scanner,
            StoreManager storeManager) {

        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();

        storeManager.restockProduct(id, quantity);
    }

    
    public static void applyDiscount(
            Scanner scanner,
            StoreManager storeManager) {

        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter discount percentage: ");
        double percentage = scanner.nextDouble();

        storeManager.applyDiscount(id, percentage);
    }

    
    public static void displayProduct(
            Scanner scanner,
            StoreManager storeManager) {

        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();

        storeManager.displayProduct(id);
    }
}
 
