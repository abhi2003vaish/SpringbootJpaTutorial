package com.cosingshuttle.jpaTutorial.jpaTuts.controllers;


import com.cosingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.cosingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping
//    public List<ProductEntity> getAllproducts(){
//        return productRepository.findBytitleOrderByPrice("Mazza");
//    }

//    @GetMapping
//    public List<ProductEntity> getAllproducts(){
//        return productRepository.findByOrderByPrice();
//    }

//    @GetMapping       //default value of sorting we set it on basis of id if request param is not provided by user
//    public List<ProductEntity> getAllproducts(@RequestParam(defaultValue= "id") String sortBy){
////        Sort.by(Direction,properties,....)
//        return productRepository.findBy(Sort.by(Sort.Direction.ASC,sortBy,"quantity","price"));
//    }

//            Sort.by(Order,Order,....)
    //        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy),Sort.Order.desc("quantity")));


     private final Integer PAGE_SIZE=5;

//    @GetMapping
//    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue= "id") String sortBy,
//                                              @RequestParam(defaultValue = "0") Integer pageNumber){
//        Pageable pageable=PageRequest.of(pageNumber,PAGE_SIZE);
//        return productRepository.findAll(pageable);
//    }


    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue= "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable=PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
        return productRepository.findAll(pageable).getContent();
    }


    @GetMapping(path="/byTitle")
    public List<ProductEntity> getProductsByTitle(
            @RequestParam(defaultValue="0") Integer pageNumber,
            @RequestParam(defaultValue="") String title,
            @RequestParam(defaultValue = "id") String sortBy){
        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
        );
    }













}
