package pl.klasicki.budgetapp.expense;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Expense {
    private UUID id;
    private BigDecimal amount;
    private Date expenseDate;
    private String category;
}
