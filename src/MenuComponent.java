import java.util.*;

// component-ortak arayuz
abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {

    }
    public abstract String getName();
    public abstract double getPrice();
    public abstract void display();
}

// leaf-tekil urunler
class Product extends MenuComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display() {
        System.out.println("  - " + getName() + ": " + getPrice() + " TL");
    }
}

// composite-kategoriler
class Category extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public String getName() { return name; }

    @Override
    public void display() {
        System.out.println("\n--- " + getName().toUpperCase() + " ---");
        for (MenuComponent component : menuComponents) {
            component.display();
        }
    }

    @Override
    public double getPrice() {
        double total = 0;

            for(MenuComponent component : menuComponents) {
                total += component.getPrice();
            }

            return total;
        }


    // alt ogeleri getirmek icin
    public List<MenuComponent> getComponents() {
        return menuComponents;
    }
}