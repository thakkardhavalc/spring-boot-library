package com.luv2code.springbootlibrary.requestmodels;

import lombok.Data;

/**
 * Created By dhhaval thakkar on 2024-03-04
 */
@Data
public class AddBookRequest {

    private String title;
    private String author;
    private String description;
    private int copies;
    private String category;
    private String img;
}
