import java.util.ArrayList;
import java.util.List;

// 1. كلاس المنتج (Product)
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// 2. كلاس عربة التسوق (Cart)
class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
        System.out.println("تم إضافة المنتج: " + product.getName() + " بسعر: " + product.getPrice());
    }

    public void removeProduct(int id) {
        items.removeIf(product -> product.getId() == id);
        System.out.println("تم حذف المنتج صاحب الرقم التعريفى (ID): " + id);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return items;
    }
}

// 3. واجهة تطبيق الخصومات - مبدأ OCP (DiscountStrategy)
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// تطبيق خيار عدم وجود خصم
class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}

// تطبيق خصم بنسبة مئوية
class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * (percentage / 100));
    }
}

// 4. كلاس الفاتورة (Invoice)
class Invoice {
    private Cart cart;
    private DiscountStrategy discountStrategy;

    public Invoice(Cart cart, DiscountStrategy discountStrategy) {
        this.cart = cart;
        this.discountStrategy = discountStrategy;
    }

    public double getTotal() {
        double subtotal = cart.calculateTotal();
        return discountStrategy.applyDiscount(subtotal);
    }
}

// 5. الكلاس الرئيسي لتشغيل البرنامج وتجربة الكود (Main)
public class Main {
    public static void main(String[] args) {
        // إنشاء منتجات تجريبية
        Product product1 = new Product(1, "Laptop", 15000);
        Product product2 = new Product(2, "Mouse", 500);
        Product product3 = new Product(3, "Keyboard", 1000);

        // إضافة المنتجات إلى عربة التسوق
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        System.out.println("إجمالي العربة قبل الحذف: " + cart.calculateTotal() + " ج.م");
        System.out.println("----------------------------------------");

        // حذف منتج من العربة
        cart.removeProduct(2);
        System.out.println("إجمالي العربة بعد الحذف: " + cart.calculateTotal() + " ج.م");
        System.out.println("----------------------------------------");

        // فاتورة بدون خصم
        Invoice invoice1 = new Invoice(cart, new NoDiscount());
        System.out.println("المبلغ النهائي (بدون خصم): " + invoice1.getTotal() + " ج.م");

        // فاتورة بتطبيق خصم 10%
        Invoice invoice2 = new Invoice(cart, new PercentageDiscount(10));
        System.out.println("المبلغ النهائي (بعد خصم 10%): " + invoice2.getTotal() + " ج.م");
    }
}
