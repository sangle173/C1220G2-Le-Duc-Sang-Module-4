package com.example.book_exercises.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private long bookId;

	@NotNull
	private String authorName;
	@NotNull
	private String title;
	@NotNull
	private short publishedYear;
	@NotNull
	private int stock;

	public long getBookId() {
		return bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getTitle() {
		return title;
	}

	public short getPublishedYear() {
		return publishedYear;
	}

	public int getStock() {
		return stock;
	}

	public void borrowedOne() {
		this.stock--;
	}

	public void returnedOne() {
		this.stock++;
	}
}
