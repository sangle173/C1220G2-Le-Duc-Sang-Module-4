package com.example.book_exercises.model;

import com.example.book_exercises.JsonDateSerializer.JsonDataSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "borrowedDate" }, allowGetters = true)
public class Borrow {
	@Id
    @GeneratedValue
	private long borrowId;

	@NotNull
	private long borrowerId;

	@NotNull
	private long bookId;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using= JsonDataSerializer.class)
	@CreatedDate
	private Date borrowedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using=JsonDataSerializer.class)
	private Date returnedDate;

	public long getBorrowId() {
		return borrowId;
	}

	public long getBorrowerId() {
		return borrowerId;
	}

	public long getBookId() {
		return bookId;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

}
