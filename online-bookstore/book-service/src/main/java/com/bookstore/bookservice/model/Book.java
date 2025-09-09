package com.bookstore.bookservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id; // ✅ Proper primary key

	private String title;
	private String author;
	private Double price;
}
