package com.santosh.ecom_proj.service;

import com.santosh.ecom_proj.model.Product;
import com.santosh.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getallProduct(){
        return repo.findAll();
    }

    public Product getProduct(int id){
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
       return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageDate(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());

        return repo.save(product);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
    public List<Product> searchProduct(String keyword){
        return repo.searchProduct(keyword);
    }
}
