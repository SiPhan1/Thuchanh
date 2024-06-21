package com.example.demoJava.entity;

import com.example.demoJava.validator.annotation.ValidCategoryId;
import com.example.demoJava.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.*;


@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public @NotNull(message = "Price is required") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is required") Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public @NotEmpty(message = "Title must not be empty") @Size(max = 50, min = 1, message = "Title must be less than 50 characters") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "Title must not be empty") @Size(max = 50, min = 1, message = "Title must be less than 50 characters") String title) {
        this.title = title;
    }

    public Book(Long id, User user, Category category, Double price, String author, String title) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.price = price;
        this.author = author;
        this.title = title;
    }
}
