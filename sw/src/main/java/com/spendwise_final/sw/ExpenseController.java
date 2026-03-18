package com.spendwise_final.sw;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // GET: http://localhost:8080/api/expenses
    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    // POST: http://localhost:8080/api/expenses
    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    // GET: http://localhost:8080/api/expenses/total
    @GetMapping("/total")
    public Double getTotal() {
        return service.getTotalSpending();
    }

    // GET: http://localhost:8080/api/expenses/category/Food
    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return service.getExpensesByCategory(category);
    }
    // URL: http://localhost:8080/api/expenses/category/Food/total
    @GetMapping("/category/{category}/total")
    public Double getTotalByCategory(@PathVariable String category) {
        return service.getTotalByCategory(category);
    }

    // PUT: http://localhost:8080/api/expenses/1 (Updates expense with ID 1)
    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }

    // DELETE: http://localhost:8080/api/expenses/1 (Deletes expense with ID 1)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteExpense(id);
    }
}
