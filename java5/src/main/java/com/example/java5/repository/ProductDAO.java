package com.example.java5.repository;

import com.example.java5.model.Product2;
import com.example.java5.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product2, Integer> {
    @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product2> findByPrice(double minPrice, double maxPrice);

    List<Product2> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product2> findByKeywords(String keywords, Pageable pageable);

    Page<Product2> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT new Report(o.category, sum(o.price), count(o)) "

            + " FROM Product2 o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}
