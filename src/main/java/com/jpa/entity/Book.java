package com.jpa.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="book")
public class Book {
	
	@Column(name="id")
    private Integer id;
	
    @Column(name="name")
    private String name;
    
	private BookCategory bookCategory;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @ManyToOne
    @JoinColumn(name = "book_category_id")  // the column with foreign key
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }	
    
}

