package com.example.service;

import com.example.model.ProductType;
import com.example.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductType() {
        return productTypeRepository.findAllProductType();
    }
}
