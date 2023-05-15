package com.example.service;

import com.example.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> findProductByName(Pageable pageable, String name);
    void addProduct(ProductDTO productDTO);
    void delete (Integer id);
    ProductDTO findById(Integer id);
    void update(ProductDTO productDTO);
}
