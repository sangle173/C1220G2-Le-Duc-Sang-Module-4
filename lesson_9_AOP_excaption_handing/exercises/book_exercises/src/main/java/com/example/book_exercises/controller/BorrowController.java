package com.example.book_exercises.controller;

import com.example.book_exercises.model.Book;
import com.example.book_exercises.model.Borrow;
import com.example.book_exercises.model.Member;
import com.example.book_exercises.repository.BookRepository;
import com.example.book_exercises.repository.BorrowRepository;
import com.example.book_exercises.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("borrow")
public class BorrowController {

	@Autowired
	private BorrowRepository borrowRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping
	public List<Borrow> getAllBorrow() {
		return borrowRepository.findAll();
	}
	
	@GetMapping("/findByBorrowerId")
	public List<Borrow> getByBorrowerId(@RequestParam(value="borrowerId")long borrowerId){
		return borrowRepository.findByBorrowerId(borrowerId);
	}
	
	@GetMapping("/findByBookId")
	public List<Borrow> getByBookId(@RequestParam(value="bookId")long bookId){
		return borrowRepository.findByBookId(bookId);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Borrow>> getBorrowById(@PathVariable(value = "id") long id) {
		Optional<Borrow> borrow = borrowRepository.findById(id);
		return ResponseEntity.ok().body(borrow);
	}
	
	@PostMapping
	public String addBorrow(@Valid @RequestBody Borrow borrow) {
		Member member = memberRepository.findById(borrow.getBorrowerId()).get();
		Book book = bookRepository.findById(borrow.getBookId()).get();
		
		if (book.getStock() < 1) {
			return "Your requested book \"" + book.getTitle() + "\" is out of stock!";
		}
		
		book.borrowedOne();
		bookRepository.save(book);
		
		borrowRepository.save(borrow);
		return member.getMemberName() + " has borrowed one copy of \"" + book.getTitle() + "\"!";
	}
	
	@PutMapping
	public Borrow returnBorrow(@RequestBody Borrow borrowBody) {
		long borrowId = borrowBody.getBorrowId();
		Borrow borrow = borrowRepository.findById(borrowId).get();
		Book book = bookRepository.findById(borrow.getBookId()).get();
		
		book.returnedOne();
		bookRepository.save(book);
		Date currentDate = new Date();
		borrow.setReturnedDate(currentDate);
		return borrowRepository.save(borrow);
	}
}
