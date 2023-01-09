package ru.slorimer.Project2BOOT.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bookname")
    @NotEmpty(message = "empty name")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String bookName;

    @Column(name = "author")
    @NotEmpty(message = "empty name")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String author;

    @Column(name = "createdyear")
    @Min(value = 0, message = "Age should be greater than 0")
    private int createdYear;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "takenat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;

    public Book(){}

    public Book(String bookName, String author, int createdYear) {
        this.bookName = bookName;
        this.author = author;
        this.createdYear = createdYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(int createdYear) {
        this.createdYear = createdYear;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
