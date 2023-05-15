package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name like concat('%', :name, '%') ", nativeQuery = true)
    Page<Product> findProductByName(Pageable pageable, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "insert into product (code, date, name, quantity, product_type_id) " +
            "values (:code, :date, :name, :quantity, :product_type_id)", nativeQuery = true)
    void addProduct(@Param("code") String code,
                    @Param("date") String date,
                    @Param("name") String name,
                    @Param("quantity") Integer quantity,
                    @Param("product_type_id") Integer productType);

    @Modifying
    @Transactional
    @Query(value = "delete from product where id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Integer id);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findProductById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update product set code = :code, name = :name, date = :date, " +
            "quantity = :quantity, product_type_id = :product_type_id where id = :id", nativeQuery = true)
    void updateProduct(@Param("code") String code,
                       @Param("date") String date,
                       @Param("name") String name,
                       @Param("quantity") Integer quantity,
                       @Param("product_type_id") Integer productType,
                       @Param("id") Integer id);
}
