package com.spendwise_final.sw;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    // 1. Get All
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    // 2. Add New
    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }

    // 3. Math: Get Total Spending
    public Double getTotalSpending() {
        return repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // 4. Filter by Category
    public List<Expense> getExpensesByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    // 5. Delete an Expense by its ID
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }

    // 6. Update an existing Expense
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> existing = repository.findById(id);

        if (existing.isPresent()) {
            Expense expense = existing.get();
            expense.setDescription(updatedExpense.getDescription());
            expense.setAmount(updatedExpense.getAmount());
            expense.setCategory(updatedExpense.getCategory());
            expense.setDate(updatedExpense.getDate());
            return repository.save(expense);
        }
        return null; // If the ID doesn't exist
    }
    public Double getTotalByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category)
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}