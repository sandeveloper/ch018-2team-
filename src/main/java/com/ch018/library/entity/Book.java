package com.ch018.library.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;


@Entity
@Table(name="books")
public class Book implements Serializable{
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid", unique = true, nullable = false)
	private int bId;
        
        @Column(name="title")
	private String title;
        
        @Column(name="authors")
	private String authors;
        
        @ManyToOne()
        @JoinColumn(name = "gid")
        private Genre genre;
        
        @Column(name="year_public")
	private int year;
        
        @Column(name="publisher")
	private String publisher;
        
        @Column(name="pages")
	private int pages;
        
        @Column(name="description")
	private String description;
        
        @Column(name = "bookcase")
        //@OneToOne(targetEntity = BookCase.class)
        //@JoinColumn(name = "caseid", referencedColumnName = "id")
        private int bookcase;
        
        @Column(name="shelf")
        //@OneToOne(targetEntity = BookCase.class)
        //@JoinColumn(name = "shelfid", referencedColumnName = "shelfid")
	private int shelf;
        
        @Column(name="term")
	private int term;
        
        @OneToMany(targetEntity = BooksInUse.class, mappedBy = "book")
	private Set<Person> personsUse;
	
	public Book() {
		
	}
	
	public Book(Book b) {
		title = b.getTitle();
	}

        public int getbId() {
            return bId;
        }

        public void setbId(int bId) {
            this.bId = bId;
        }
	
	
	public String getTitle() {
		return title;
	}
	
	
	public String getAuthors() {
		return authors;
	}
	
	
	public int getYear() {
		return year;
	}
	
	
	public String getPublisher() {
		return publisher;
	}
	
	
	public int getPages() {
		return pages;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public int getShelf() {
		return shelf;
	}
	
	
	public int getTerm() {
		return term;
        }
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}

    public Set<Person> getPersonsUse() {
        return personsUse;
    }

    public void setPersonsUse(Set<Person> personsUse) {
        this.personsUse = personsUse;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getBookcase() {
        return bookcase;
    }

    public void setBookcase(int bookcase) {
        this.bookcase = bookcase;
    }

       
    
        

    
        
        
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this.title.equals(((Book) obj).getTitle())
				&& this.getAuthors().equals(((Book) obj).getAuthors())
				&& this.getPublisher().equals(((Book) obj).getPublisher())) {
			return true;
		}
		return false;
	}
	
	@Override 
	public int hashCode() {
		return this.bId;
	}

	@Override
	public String toString() {
		return bId + " " + getTitle() + " " + getAuthors() + " " + getYear();
	}

	
}
