public class RestaurantSystem {
    public static void main(String[] args) {
        MenuComponent anaMenu = new Category("Tüm Menü");

        MenuComponent corbalar = new Category("Çorba");
        corbalar.add(new Product("Ezogelin", 145.0));
        corbalar.add(new Product("Mercimek", 140.0));

        MenuComponent tatlilar = new Category("Tatlı");
        tatlilar.add(new Product("Sütlaç", 160.0));
        tatlilar.add(new Product("Künefe", 265.0));

        MenuComponent anaYemek = new Category("Ana Yemek");
        anaYemek.add(new Product("Adana kebap", 390.0));
        anaYemek.add(new Product("Tavuk sis", 370.0));

        anaMenu.add(corbalar);
        anaMenu.add(tatlilar);
        anaMenu.add(anaYemek);

        // garson
        System.out.println("--- Restoran Sipariş Sistemi ---");
        anaMenu.display(); // tum yapiyi tek seferde basar

        System.out.println("\n--- Sipariş Oluşturuluyor ---");

        MenuComponent secilenUrun = new Product("Ezogelin", 145.0);
        int adet = 10;

        // siparis nesnesi olusur
        Order yeniSiparis = new Order(secilenUrun, adet);
        yeniSiparis.displayOrderSummary(); // ozeti yazar



    }
}