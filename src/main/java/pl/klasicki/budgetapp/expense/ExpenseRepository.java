package pl.klasicki.budgetapp.expense;

import static pl.klasicki.jooq.Tables.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@AllArgsConstructor
public class ExpenseRepository {

    DSLContext context;

    @Transactional
    public Optional<UUID> insertExpense(Expense expense) {

        var result = context.insertInto(EXPENSE, EXPENSE.ID, EXPENSE.AMOUNT ,EXPENSE.DATE, EXPENSE.CATEGORY)
          .values(expense.getId(), expense.getAmount(), LocalDateTime.now(), expense.getCategory())
          .returning(EXPENSE.ID)
            .fetchOne();

        return Optional.of(result.getValue(EXPENSE.ID));
    }

    public List<ExpenseDto> getAllExpenses() {
        return context.select(EXPENSE.asterisk()).
            from(EXPENSE)
            .fetch().map(this::toExpenseDto);
    }

    private ExpenseDto toExpenseDto(Record result) {
        return ExpenseDto.builder()
            .id(result.get(EXPENSE.ID).toString())
            .amount(result.get(EXPENSE.AMOUNT).toString())
            .date(result.get(EXPENSE.DATE).toString())
            .category(result.get(EXPENSE.CATEGORY))
            .build();
    }
}
