package pl.klasicki.budgetapp.expense;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Expense {

    String id;
    private double amount;
    private Instant expenseDate;
    private String category;
}
