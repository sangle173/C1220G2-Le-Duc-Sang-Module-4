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
@JsonIgnoreProperties(value = { "joinDate" }, allowGetters = true)
public class Member {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long memberId;
	
	@NotNull
	private String memberName;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonSerialize(using= JsonDataSerializer.class)
	private Date joinDate;
	
	public long getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
}
