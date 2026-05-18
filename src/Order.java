class Order {
    private MenuComponent product;
    private int quantity;

    public Order(MenuComponent product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void displayOrderSummary() {
        double total = product.getPrice() * quantity;
        System.out.println("\n===== YENİ SİPARİŞ FİŞİ =====");
        System.out.println("Ürün: " + product.getName());
        System.out.println("Adet: " + quantity);
        System.out.println("Birim Fiyat: " + product.getPrice() + " TL");
        System.out.println("TOPLAM TUTAR: " + total + " TL");
        System.out.println("=============================");
    }
}