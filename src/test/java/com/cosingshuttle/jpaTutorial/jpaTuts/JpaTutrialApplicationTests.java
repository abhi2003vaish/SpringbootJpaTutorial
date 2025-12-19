package com.cosingshuttle.jpaTutorial.jpaTuts;

import com.cosingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.cosingshuttle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutrialApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity=ProductEntity.builder()
                .sku("nesle234")
                .title("nesle chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();
        ProductEntity savedProductEntity=productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }


    @Test
    void getRepository(){
        List<ProductEntity> entities=productRepository.findAll();
        System.out.println(entities);
    }


    @Test
    void getRepositoryByTitle(){
        List<ProductEntity> entities=productRepository.findByTitle("pepsi");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByCreatedAtAfter(){
        List<ProductEntity> entities=productRepository.findByCreatedAtAfter(
                LocalDateTime.of(2024,1,1,0,0,0)
        );
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityAndPrice(){
        List<ProductEntity> entities=productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(12.4));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityGreaterThanAndPriceLessThan(){
        List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(2,BigDecimal.valueOf(15.0));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByQuantityGreaterThanOrPriceLessThan(){
        List<ProductEntity> entities=productRepository.findByQuantityGreaterThanOrPriceLessThan(2,BigDecimal.valueOf(15.0));
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleLike(){
        List<ProductEntity> entities=productRepository.findByTitleLike("%Ep%");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleContaining(){
        List<ProductEntity> entities=productRepository.findByTitleContaining("E");
        System.out.println(entities);
    }

    @Test
    void getRepositoryByTitleContainingIgnoreCase(){
        List<ProductEntity> entities=productRepository.findByTitleContainingIgnoreCase("E");
        System.out.println(entities);
    }

    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity=productRepository.findByTitleAndPrice("pepsi",BigDecimal.valueOf(14.4));
        productEntity.ifPresent(System.out::println);
    }

    @Test
    void getSingleFromRepositoryByQueryAnnotation(){
        Optional<ProductEntity> productEntity=productRepository.fetchByTitleAndPrice("pepsi",BigDecimal.valueOf(14.4));
        productEntity.ifPresent(System.out::println);
    }


}
