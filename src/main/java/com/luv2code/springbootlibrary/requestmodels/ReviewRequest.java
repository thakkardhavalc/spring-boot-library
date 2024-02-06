package com.luv2code.springbootlibrary.requestmodels;

import lombok.Data;

import java.util.Optional;

/**
 * Created By dhhaval thakkar on 2024-02-06
 */
@Data
public class ReviewRequest {

    private double rating;
    private Long bookId;
    private Optional<String> reviewDescription;
}
