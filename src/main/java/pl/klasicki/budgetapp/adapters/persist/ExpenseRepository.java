package pl.klasicki.budgetapp.adapters.persist;

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
import pl.klasicki.budgetapp.expense.Expense;
import pl.klasicki.budgetapp.expense.ExpenseRequest;


@Repository
@AllArgsConstructor
public class ExpenseRepository {

    DSLContext context;

    @Transactional
    public UUID save(Expense expense) {

        var result = context.insertInto(EXPENSE, EXPENSE.ID, EXPENSE.AMOUNT ,EXPENSE.DATE, EXPENSE.CATEGORY)
          .values(UUID.randomUUID(), expense.getAmount(), LocalDateTime.now(), expense.getCategory())
          .returning(EXPENSE.ID)
            .fetchOne();

        return result.getValue(EXPENSE.ID);
    }

    public List<ExpenseDto> getAllExpenses() {
        return context.select(EXPENSE.asterisk()).
            from(EXPENSE)
            .fetch().map(this::toExpenseDto);
    }

    public ExpenseDto findById(UUID id) {
        return context.select(EXPENSE.asterisk()).from(EXPENSE)
            .where(String.valueOf(EXPENSE.ID.equals(id)))
            .fetchOneInto(ExpenseDto.class);
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
