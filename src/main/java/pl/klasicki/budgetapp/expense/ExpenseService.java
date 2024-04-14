package pl.klasicki.budgetapp.expense;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ExpenseService {

    ExpenseRepository expenseRepository;

    UUID insertExpense(Expense expense) {
        var result = expenseRepository.insertExpense(expense)
            .orElseThrow(() -> new IllegalArgumentException("Error while saving expense with id " + expense.getId()));
        log.info("Inserted new expense with id " + result);
        return result;
    }

    public List<ExpenseDto> getExpenses() {
        var result = expenseRepository.getAllExpenses();
        log.info("Found " + result.size() + " expenses");
        return result;
    }
}
