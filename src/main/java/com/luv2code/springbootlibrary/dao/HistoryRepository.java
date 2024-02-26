package com.luv2code.springbootlibrary.dao;

import com.luv2code.springbootlibrary.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By dhhaval thakkar on 2024-02-26
 */
@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    Page<History> findBooksByUserEmail(@RequestParam("email") String userEmail, Pageable pageable);
}
