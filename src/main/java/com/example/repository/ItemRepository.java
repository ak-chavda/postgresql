package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

//	@Query(nativeQuery = true, value = "SELECT i.* from user_table u inner join item i on i.user_id = :userId and i.id = :itemId")
	@Query(nativeQuery = true, value = "SELECT * from item i where i.user_id = :userId and i.id = :itemId")
	Optional<Item> findItemByItemIdAndUserId(@Param("userId") Long userId, @Param("itemId") Long itemId);

	@Query(nativeQuery = true, value = "SELECT * from item i where i.user_id = :userId")
	Optional<List<Item>> findItemsByUserId(@Param("userId") Long userId);

}
