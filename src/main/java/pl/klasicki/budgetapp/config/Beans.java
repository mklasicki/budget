package pl.klasicki.budgetapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.klasicki.budgetapp.adapters.time.SystemTimeProvider;
import pl.klasicki.budgetapp.expense.ExpenseIdGenerator;
import pl.klasicki.budgetapp.expense.UuidExpenseIdGenerator;
import pl.klasicki.budgetapp.ports.TimeProvider;

@Configuration
public class Beans {

    @Bean
    TimeProvider timeProvider() {
        return new SystemTimeProvider();
    }

    @Bean
    ExpenseIdGenerator expenseIdGenerator() {
        return new UuidExpenseIdGenerator();
    }

}
