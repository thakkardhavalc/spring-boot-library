package com.luv2code.springbootlibrary.dao;

import com.luv2code.springbootlibrary.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By dhhaval thakkar on 2024-03-05
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByUserEmail(String userEmail);
}
