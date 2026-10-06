package com.budiluhur.catalog;

import com.budiluhur.catalog.model.Product;
import com.budiluhur.catalog.repository.ProductRepository;
import com.budiluhur.catalog.exception.ProductNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.addProduct(new Product("PRD-01", "Keyboard Mechanical", 450000.0));
        repo.addProduct(new Product("PRD-02", "Mouse Wireless", 175000.0));

        System.out.println("=== DAFTAR SELURUH PRODUK ===");
        repo.findAll().forEach(System.out::println);

        System.out.println("\n=== PENCARIAN PRODUK ===");
        try {
            Product p = repo.findById("PRD-99");
            System.out.println("Ditemukan: " + p);
        } catch (ProductNotFoundException e) {
            System.err.println("Error Terjadi: " + e.getMessage());
        }

        System.out.println("\n=== HAPUS PRODUK ===");
        try {
            repo.deleteById("PRD-02");
            System.out.println("PRD-02 berhasil dihapus.");
            repo.deleteById("PRD-99");
        } catch (ProductNotFoundException e) {
            System.err.println("Error Terjadi: " + e.getMessage());
        }

        System.out.println("\n=== SISA PRODUK ===");
        repo.findAll().forEach(System.out::println);

        // Latihan Map (HashMap)
        System.out.println("\n=== LATIHAN MAP ===");
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("PRD-01", 450000.0);
        priceMap.put("PRD-02", 175000.0);
        System.out.println("Harga PRD-01: Rp" + priceMap.get("PRD-01"));
    }
}