package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean  
    ApplicationRunner init(TodoRepository repository) {  
        return args -> {  
            Stream.of("Buy milk", "Eat pizza", "Write tutorial", "Learn Azure", "Go kayaking").forEach(name -> {  
                    Todo todo = new Todo();  
                    todo.setDescription(name);  
                    repository.save(todo);  
            });  
            repository.findAll().forEach(System.out::println);  
        };  
    }  
}
