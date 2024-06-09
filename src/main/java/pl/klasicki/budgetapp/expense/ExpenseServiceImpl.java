package pl.klasicki.budgetapp.expense;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.klasicki.budgetapp.adapters.persist.ExpenseDto;
import pl.klasicki.budgetapp.adapters.persist.ExpenseRepository;
import pl.klasicki.budgetapp.ports.TimeProvider;

@Service
@AllArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements pl.klasicki.budgetapp.ports.ExpenseService {

    ExpenseRepository expenseRepository;
    ExpenseIdGenerator expenseIdGenerator;
    TimeProvider systemTimeProvider;

    @Override
    public UUID insertExpense(ExpenseRequest expenseRequest) {
        var expense = createExpense(expenseRequest);
        return expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseDto> getExpenses() {
        return null;
    }

    @Override
    public ExpenseDto getExpenseById(UUID id) {
        return expenseRepository.findById(id);
    }


    private Expense createExpense(ExpenseRequest expenseRequest) {
        return Expense.builder()
            .id(expenseIdGenerator.generate())
            .amount(expenseRequest.getValue())
            .expenseDate(systemTimeProvider.getTimeSTamp())
            .category(expenseRequest.getCategory())
            .build();
    }

}
