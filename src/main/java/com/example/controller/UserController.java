package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Item;
import com.example.model.User;
import com.example.repository.ItemRepository;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok().body(userRepository.findAll());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));

//		user.add(linkTo(methodOn(UserController.class).getUserById(userId)).withSelfRel());

		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/users/{userid}/items/{itemid}")
	public ResponseEntity<?> getUserItemById(@PathVariable(value = "userid") Long userId, @PathVariable(value = "itemid") Long itemId) throws ResourceNotFoundException {
		Item item = itemRepository.findItemByItemIdAndUserId(userId, itemId).orElseThrow(() -> new ResourceNotFoundException("Item: " + itemId + " not found for user: " + userId));

		return ResponseEntity.ok().body(item);
	}

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@Validated @RequestBody User User) {
		return ResponseEntity.ok().body(userRepository.save(User));
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long userId, @Validated @RequestBody User userData) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));

		user.setEmailId(userData.getEmailId());
		user.setLastName(userData.getLastName());
		user.setFirstName(userData.getFirstName());
		user.setItems(userData.getItems());

		return ResponseEntity.ok().body(userRepository.save(user));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok().body(response);
	}
}
