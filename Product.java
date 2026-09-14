package smart_story;

public abstract class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private boolean isActive;

//    constructor
    public Product(int id, String name, double price, int quantity, String description, boolean isActive) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.isActive = isActive;
    }

//    getters  && setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

//     methods 
    // methods to check if the product is available for sale or not
    public boolean isAvailable() {

        return this.isActive && this.quantity > 0;
    }

    // methods to increase stock quantity
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;

        }
    }

    // methods to decrease quantity when selling
    public void decreaseQuantity(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount;
        }
    }

    // Activate the product
    public void activate() {
        this.isActive = true;
    }

    // Deactivate the product
    public void deactivate() {
        this.isActive = false;
    }

    // Calculating the total value of the product in stock
    public double calculateStockValue() {
        return this.price * this.quantity;
    }

    // A ready-made function to print the price formatted in Egyptian pounds
    public String getformattedPrice() {
        return String.format("%.2f EGP", this.price);
    }

    // Ready-made function to apply a discount on the product price
    public boolean applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            double discountAmount = price * percentage / 100;
            price -= discountAmount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description=" + description + ", isActive=" + isActive + '}';
    }

    // To force each subclass to return its exact details
    public abstract String getDetailsList();

    // (abstract Methods)Subclasses need to implement it to specify the product type
    public abstract String getProductType();

}
