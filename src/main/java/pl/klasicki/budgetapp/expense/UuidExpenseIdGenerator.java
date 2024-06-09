package pl.klasicki.budgetapp.expense;

import java.util.UUID;

public class UuidExpenseIdGenerator implements ExpenseIdGenerator{
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
