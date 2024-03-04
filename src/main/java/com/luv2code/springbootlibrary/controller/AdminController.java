package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.requestmodels.AddBookRequest;
import com.luv2code.springbootlibrary.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.luv2code.springbootlibrary.utils.ExtractJWT.payloadJWTExtraction;

/**
 * Created By dhhaval thakkar on 2024-03-04
 */

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = payloadJWTExtraction(token, "\"userType\"");

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }

        adminService.postBook(addBookRequest);
    }

}
