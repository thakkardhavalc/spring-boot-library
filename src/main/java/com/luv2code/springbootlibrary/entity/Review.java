package com.luv2code.springbootlibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * Created By dhhaval thakkar on 2024-02-01
 */
@Entity
@Table(name = "review")
@Getter
@Setter
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "rating")
    private double rating;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "review_description")
    private String reviewDescription;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                ", bookId=" + bookId +
                ", reviewDescription='" + reviewDescription + '\'' +
                '}';
    }
}
