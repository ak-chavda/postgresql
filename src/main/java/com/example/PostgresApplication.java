package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.model.AuditorAwareImpl;
import com.example.model.Item;
import com.example.model.User;
import com.example.repository.UserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class PostgresApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDB();
	}
	
	public void initDB() {
		User user1 = new User("first-name", "last-name", "email@email.com");
		Item item1 = new Item("item-name", 3, 310.19);
		Item item2 = new Item("item-name2", 2, 555.55);
		List<Item> itemsList = Arrays.asList(item1, item2);
		user1.setItems(itemsList);
		userRepository.save(user1);
		
		User user2 = new User("first-name1", "last-name1", "email1@email1.com");
		Item item3 = new Item("item-name3", 4, 350);
		Item item4 = new Item("item-name4", 5, 705);
		List<Item> itemsList2 = Arrays.asList(item3, item4);
		user2.setItems(itemsList2);
		userRepository.save(user2);
	}
}
