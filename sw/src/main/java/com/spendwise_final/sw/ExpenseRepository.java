package com.spendwise_final.sw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Spring Boot automatically turns this method name into a SQL query!
    List<Expense> findByCategoryIgnoreCase(String category);
}