package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.model.Address;
import com.example.model.Course;
import com.example.model.Item;
import com.example.model.Review;
import com.example.model.Student;
import com.example.model.User;
import com.example.repository.CourseRepository;
import com.example.repository.ItemRepository;
import com.example.repository.ReviewRepository;
import com.example.repository.StudentRepository;
import com.example.repository.UserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class PostgresApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;
	
//	@Bean
//	public AuditorAware<String> auditorAware(){
//		return new AuditorAwareImpl();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDB();
	}
	
	public void initDB() {
		
		User user = new User("first-name", "last-name", "email@email.com");
		List<Item> items = Arrays.asList(new Item("item-name", 3, 310.19), new Item("item-name2", 2, 555.55));
		user.setItems(items);
		user.setAddress(new Address("123, abc soc., surat, gujarat" , "123456"));
		userRepository.save(user);

		user = new User("black", "adam", "blacka@email.com");
		items = Arrays.asList(new Item("itemName", 2, 366), new Item("itemName2", 5, 350.88));
		user.setItems(items);
		user.setAddress(new Address("234, xyz soc., ahmedabad, gujarat" , "111222"));
		userRepository.save(user);

		user = new User("abc", "xyz", "abcd@email.com");
		items = Arrays.asList(new Item("i1", 6, 606.45), new Item("i2", 2, 88));
		user.setItems(items);
		user.setAddress(new Address("111, pqr soc., indore, madhyapradesh" , "222333"));
		userRepository.save(user);

		user = new User("bruce", "wyne", "bruce@email.com");
		items = Arrays.asList(new Item("i10", 1, 5556), new Item("i20", 1, 6665));
		user.setItems(items);
		user.setAddress(new Address("222, bjp soc., mumbai, maharashtra" , "345678"));
		userRepository.save(user);

		Item i = itemRepository.save(new Item("i-pad", 1, 55500));
		
		Review review1 = new Review(5d, "Good");
		review1.setItem(i);
		reviewRepository.save(review1);

		Review review2 = new Review(4.5, "Better");
		review2.setItem(i);
		reviewRepository.save(review2);
		
		//------------------------------------------------------------------------------
		
		// create three courses
		Course course1 = Course.builder().title("AI").credit(12).build();
		Course course2 = Course.builder().title("ML").credit(12).build();
		Course course3 = Course.builder().title("Java").credit(12).build();
		
		// save courses
		courseRepository.saveAll(Arrays.asList(course1, course2, course3));

		// create a student
        Student student = Student.builder().name("Jhon dank").build();
        Student student2 = Student.builder().name("Amit Chavda").build();
        Student student3 = Student.builder().name("Parth Chavda").build();

        // add courses to the student
        student.getCourses().addAll(Arrays.asList(course1, course2, course3));
        student2.getCourses().addAll(Arrays.asList(course1, course2, course3));
        student3.getCourses().addAll(Arrays.asList(course1, course2, course3));

        // update the student
        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);
	}
}
