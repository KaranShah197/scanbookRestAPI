package com.springrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="booksdetails")
@EntityListeners(AuditingEntityListener.class)

public class BooksInfo {

	@Id
	@NotNull
	private long barCode;	/*Primary Key, we can have only one book with same barcode */
	@NotBlank
	private String title;
	@NotBlank
	private String author; 
	@NotNull
	private long numberOfPages;
	@NotNull
	private int readFlag;
	
	/*Below are getter and setter methods to swt and get the required information fron Entity Model */
	public long getBarCode() {
		return barCode;
	}
	public void setBarCode(long barCode) {
		this.barCode = barCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public int getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(int readFlag) {
		this.readFlag = readFlag;
	}
}
