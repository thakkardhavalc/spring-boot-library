package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.entity.Message;
import com.luv2code.springbootlibrary.requestmodels.AdminQuestionRequest;
import com.luv2code.springbootlibrary.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.luv2code.springbootlibrary.utils.ExtractJWT.payloadJWTExtraction;

/**
 * Created By dhhaval thakkar on 2024-02-26
 */
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessagesController {

    private final MessagesService messagesService;

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest) {

        String userEmail = payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{

        String userEmail = payloadJWTExtraction(token, "\"sub\"");
        String admin = payloadJWTExtraction(token, "\"userType\"");

        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only.");
        }

        messagesService.putMessage(adminQuestionRequest, userEmail);
    }
}
