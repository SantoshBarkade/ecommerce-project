package com.santosh.ecom_proj.controller;

import com.santosh.ecom_proj.model.Product;
import com.santosh.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getallProduct(){
        return new ResponseEntity<>(service.getallProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product=service.getProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProduct(product, imageFile);
            return  new ResponseEntity<>(product1,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product= service.getProduct(productId);
        byte[] imageFile=product.getImageDate();
         return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);


    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String>updateProduct(@PathVariable int id,@RequestPart Product product, @RequestPart MultipartFile imageFile)  {
        Product product1=null;
        try {
          product1=service.updateProduct(id,product,imageFile);

        } catch (IOException e) {
            return new  ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
        if (product1!=null){
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }
     else{
            return new  ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);


        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String>deleteById(@PathVariable int id){
        Product product=service.getProduct(id);
        if (product!=null){
            service.deleteById(id);
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }else{
            return new  ResponseEntity<>("Failed to delete",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/search")
    public  ResponseEntity<List<Product>>searchProduct(@RequestParam String keyword){
        List<Product>products=service.searchProduct(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
