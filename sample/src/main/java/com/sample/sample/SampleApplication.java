package com.sample.sample;

import com.sample.sample.model.Book;
import com.sample.sample.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SampleApplication {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner createSomeBooks() {
		Arrays.asList(new Book[]{new Book("bk01","XML Developer's Guide","Gambardella"),
				new Book("bk02","Midnight Rain","Ralls"),
				new Book("bk03","Immortals of meluha","Amish")}).stream().forEach(book -> bookRepository.save(book));

		return null;
	}
}
