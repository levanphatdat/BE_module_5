package com.example.service;

import com.example.dto.ProductDTO;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class    ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<ProductDTO> findProductByName(Pageable pageable, String name) {
        Page<Product> productPage = productRepository.findProductByName(pageable, name);
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productPage) {
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return new PageImpl<>(productDTOList, pageable, productPage.getTotalElements());
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productRepository.addProduct(product.getCode(),
                product.getDate(),
                product.getName(),
                product.getQuantity(),
                product.getProductType().getId());
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public ProductDTO findById(Integer id) {
        Product product = productRepository.findProductById(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productRepository.updateProduct(product.getCode(),
                product.getDate(),
                product.getName(),
                product.getQuantity(),
                product.getProductType().getId(),
                product.getId());
    }
}
