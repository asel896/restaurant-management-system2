import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantMenuTest {

    private MenuComponent anaMenu;
    private MenuComponent corbalar;
    private MenuComponent mercimek;
    private MenuComponent ezogelin;

    @BeforeEach
    void setUp() {
        anaMenu = new Category("Ana Menü");
        corbalar = new Category("Çorbalar");

        mercimek = new Product("Mercimek", 140.0);
        ezogelin = new Product("Ezogelin", 145.0);

        corbalar.add(mercimek);
        corbalar.add(ezogelin);
        anaMenu.add(corbalar);
    }

    @Test
    void testProductDetails() {
        assertEquals("Mercimek", mercimek.getName());
        assertEquals(140.0, mercimek.getPrice());
    }

    @Test
    void testCategoryTotalPrice() {
        assertEquals(285.0, corbalar.getPrice(), "Kategori toplam fiyatı hatalı!");
    }

    @Test
    void testEmptyCategoryPrice() {
        Category bosKategori = new Category("Boş");
        assertEquals(0.0, bosKategori.getPrice());
    }

    @Test
    void testAddProductToProduct() {
        assertDoesNotThrow(() -> {
            mercimek.add(new Product("Limon", 0.0));
        }, "Ürüne ekleme yapmak hata fırlatmamalı.");
    }

    @Test
    void testNestedCategoryPrice() {
        MenuComponent tatlilar = new Category("Tatlılar");
        tatlilar.add(new Product("Sütlaç", 160.0));
        anaMenu.add(tatlilar);

        assertEquals(445.0, anaMenu.getPrice());
    }
}