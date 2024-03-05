package com.luv2code.springbootlibrary.requestmodels;

import lombok.Data;

/**
 * Created By dhhaval thakkar on 2024-03-05
 */
@Data
public class PaymentInfoRequest {

    private int amount;
    private String currency;
    private String receiptEmail;
}
