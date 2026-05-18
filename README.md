# 🍽️ Restoran Yönetim Sistemi - Aşama 2

Bu proje, restoran yönetim sisteminin ikinci aşamasıdır. Restoran menüsünün hiyerarşik (kategoriler ve alt ürünler) yapısını yönetmek ve garsonların hızlıca sipariş oluşturmasını sağlamak amacıyla geliştirilmiştir.

## 🚀 Özellik: Menü ve Sipariş Yönetimi (İhtiyaç 2)
* **Kategori Yönetimi:** Menü elemanları dinamik olarak kategorilere ayrılmıştır (Örn: Çorba, Tatlı, Ara Sıcak, Salata).
* **Dinamik Listeleme:** Kullanıcı veya garson bir kategoriye tıkladığında, o kategoriye ait alt ürünler (Örn: Çorba kategorisi altında Ezogelin, Mercimek, Tarhana) listelenir.
* **Garson Sipariş Paneli:** Garsonlar menüden kolayca ürün seçebilir, eklenecek ürün adetlerini belirleyebilir ve hızlıca sipariş oluşturabilir.

---

## 🛠️ Structural (Yapısal) Tasarım Kalıbı: Composite (Bileşik) Pattern

**Tanımı:** Nesneleri ağaç yapısında düzenleyerek "parça-bütün" hiyerarşileri oluşturmamızı sağlayan yapısal bir tasarım kalıbıdır. Bu kalıp, istemcinin (garson/sistem) tekil nesneler (ürünler) ile nesne gruplarına (kategoriler) aynı şekilde muamele etmesine olanak tanır.

### 🔍 Kod Üzerinde Uygulama Analizi

* **A. Component (Bileşen) - `MenuComponent` Sınıfı:**
  Hiyerarşideki tüm nesneler için ortak arayüzdür. Hem tekil ürünlerin hem de kategorilerin sahip olması gereken ortak davranışları (`getName()`, `getPrice()`, `display()`) tanımlayan bir `abstract class` yapısıdır.

* **B. Leaf (Yaprak) - `Product` Sınıfı:**
  Hiyerarşinin en alt birimidir. İçinde başka nesneler barındıramaz. Sadece kendi işlevini (ürün ismi ve fiyatı) yerine getirir ve `MenuComponent` sınıfından miras alır (`extends`).

* **C. Composite (Bileşik) - `Category` Sınıfı:**
  İçinde hem `Product` (yaprak) hem de başka `Category` (alt bileşikler) nesnelerini barındırabilen sınıftır. Kendi içindeki listeyi yönetmek için `add()` metodunu kullanır ve `MenuComponent` sınıfından miras alır.

### ❓ Neden Bu Kalıbı Kullandık?

1. **Hiyerarşik Esneklik:** Bu yapı sayesinde "Tatlılar" kategorisinin altına hem "Sütlaç" (ürün) hem de "Şerbetli Tatlılar" (alt kategori) ekleyebiliyoruz. Derinlik sınırı olmadan menüyü esnekçe genişletebiliyoruz.
2. **Polimorfizm ve Tek Tip Kullanım:** `RestaurantSystem` (Main) sınıfında, ekrana yazdırma işlemi yaparken nesnenin kategori mi yoksa ürün mü olduğunu kontrol etmemize gerek kalmıyor. Hepsine sadece `.display()` dememiz yeterli oluyor.
3. **Özyinelemeli (Recursive) Hesaplama:** `Category` sınıfındaki `getPrice()` metodu, içindeki tüm alt bileşenlerin fiyatlarını otomatik olarak topluyor. Eğer bir kategorinin içinde başka bir kategori varsa, o da kendi içindekileri topluyor. Bu sayede ana menünün toplam fiyatı tek bir çağrı ile hesaplanabiliyor.
