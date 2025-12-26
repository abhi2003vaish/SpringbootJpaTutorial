package com.cosingshuttle.jpaTutorial.jpaTuts.repositories;

import com.cosingshuttle.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(Integer quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(Integer quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    Optional<ProductEntity>  findByTitleAndPrice(String title, BigDecimal price);

//    @Query("SELECT e FROM ProductEntity e WHERE e.title =:title AND e.price =:price")
    @Query("SELECT e FROM ProductEntity e WHERE e.title = ?1 AND e.price = ?2")
    Optional<ProductEntity> fetchByTitleAndPrice(String title, BigDecimal price);


    //for Sorting in method names
    List<ProductEntity> findBytitleOrderByPrice(String title);

    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title,Pageable pageable);























}
