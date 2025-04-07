# 🧩 Selenium Test Otomasyon Projesi

Bu proje, **Selenium WebDriver** kullanılarak geliştirilmiş bir test otomasyon projesidir.  
SauceDemo e-ticaret sitesi üzerinde login işlemi ve sepet kontrolü gibi temel işlevleri test etmek amacıyla hazırlanmıştır.

## 🛠️ Kullanılan Teknolojiler

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Allure Report (isteğe bağlı eklenebilir)**

## 📂 Proje Yapısı

```
src
├── main
│   └── java
│       └── com.automation.pages
│           ├── BasePage.java
│           ├── HomePage.java
│           └── LoginPage.java
├── test
│   └── java
│       └── com.automation.tests
│           └── LoginTest.java
├── pom.xml
└── testng.xml
```

## 🚀 Kurulum & Çalıştırma

1. Projeyi klonlayın:
   ```bash
   git clone <repo-link>
   ```

2. Proje dizinine geçin:
   ```bash
   cd sauce-automation
   ```

3. Maven bağımlılıklarını indirin:
   ```bash
   mvn clean install
   ```

4. Testleri çalıştırın:
   ```bash
   mvn test
   ```

## 📝 Test Kapsamı

- ✅ Başarılı login testi
- ✅ Sepet ikonunun görünürlük kontrolü
- ✅ Sayfa başlıkları ve URL doğrulama

## 🔍 İlerleyen Dönem İçin Geliştirmeler

- [ ] Allure Report ile detaylı raporlama
- [ ] Daha fazla senaryo ekleme (ürün ekleme, checkout vb.)
- [ ] CI/CD entegrasyonu (GitHub Actions, Jenkins)

## 👨‍💻 Katkıda Bulunmak

Pull request'ler her zaman memnuniyetle karşılanır!  
Yeni özellikler eklemek veya hataları düzeltmek için katkıda bulunabilirsiniz.

## 📃 Lisans

Bu proje açık kaynaklıdır. Dilediğiniz gibi kullanabilirsiniz.
