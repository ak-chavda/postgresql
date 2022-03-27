package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Item;
import com.example.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
