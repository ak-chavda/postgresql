package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Item;
import com.example.model.User;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
