package pl.klasicki.budgetapp.ports;

import java.util.List;
import java.util.UUID;

import pl.klasicki.budgetapp.adapters.persist.ExpenseDto;
import pl.klasicki.budgetapp.expense.ExpenseRequest;

public interface ExpenseService {

   UUID insertExpense(ExpenseRequest expenseRequest);

   List<ExpenseDto> getExpenses();

   ExpenseDto getExpenseById(UUID id);

}
