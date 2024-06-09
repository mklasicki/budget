package pl.klasicki.budgetapp.expense;

import lombok.Value;

@Value
public class ExpenseRequest {

    String id;
    double value;
    String category;

}
