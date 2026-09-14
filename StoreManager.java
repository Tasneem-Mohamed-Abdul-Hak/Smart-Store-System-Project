
package smart_store;

import java.util.ArrayList;

public class StoreManager {

    private ArrayList<Product> products;
    private Cart cart;

  
    public StoreManager(Cart cart) {
        this.products = new ArrayList<>();
        this.cart = cart;
    }

    
    public void addProduct(Product product) {

        if (product != null) {
            products.add(product);
            System.out.println("Product added successfully.");
        }
    }

    
    public boolean removeProduct(int id) {

        Product product = findProductById(id);

        if (product != null) {
            products.remove(product);
            System.out.println("Product removed successfully.");
            return true;
        }

        System.out.println("Product not found.");
        return false;
    }

    
    public Product findProductById(int id) {

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    
    public Product findProductByName(String name) {

        for (Product product : products) {

            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }

    
    public void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n===== Store Products =====");

        for (Product product : products) {
            System.out.println(product.getDetailsList());
        }
    }

    
    public void displayProduct(int id) {

        Product product = findProductById(id);

        if (product != null) {
            System.out.println(product.getDetailsList());
        } else {
            System.out.println("Product not found.");
        }
    }

    
    public boolean buyProduct(int id, int quantity) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return false;
        }

        if (!product.isAvailable()) {
            System.out.println("Product is not available.");
            return false;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Not enough quantity available.");
            return false;
        }

        product.decreaseQuantity(quantity);

        cart.addProduct(product);

        System.out.println("Product added to cart.");
        return true;
    }

    
    public boolean restockProduct(int id, int quantity) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return false;
        }

        product.increaseQuantity(quantity);

        System.out.println("Stock updated successfully.");
        return true;
    }

    
    public boolean applyDiscount(int id, double percentage) {

        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        if (product.applyDiscount(percentage)) {
            System.out.println("Discount applied successfully.");
            return true;
        }

        System.out.println("Invalid discount percentage.");
        return false;
    }
