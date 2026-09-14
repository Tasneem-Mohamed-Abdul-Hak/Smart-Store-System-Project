package smart_story;

public class Electronics extends Product {

    private int warrantyPeriod;
    private String brand;
    private String model;

//    constructor
    public Electronics(int id, String name, double price, int quantity, String description, boolean isActive , int warrantyPeriod, String brand, String model) {
        super(id, name, price, quantity, description, isActive);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
        this.model = model;
    }

//    getters  && setters
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
       if(warrantyPeriod >= 0){
            this.warrantyPeriod = warrantyPeriod;
       }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getProductType() {
        return "Electronics";
    }

   @Override
    public String getDetailsList() {
        return "ID: " + getId() + 
               "  Name: " + getName() + 
               "  Brand: " + brand + 
               "  Model: " + model + 
               "  Price: " + getformattedPrice() + 
               "  Warranty: " + warrantyPeriod + " Months" + 
               "  Available Qty: " + getQuantity();
    }

}
