package pl.klasicki.budgetapp.expense;

import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.klasicki.budgetapp.ControllerCode;

@RestController
@RequestMapping("/expense")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseController {
    ExpenseService expenseService;

    @ControllerCode(code = "insert expense")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UUID> insertExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.insertExpense(expense));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getExpenses());
    }

    @ControllerCode(code = "find by id")
    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExpenseDto> findById(@RequestParam UUID id, @RequestParam String type, @RequestParam String element) {
        return ResponseEntity.ok(expenseService.findById(id));
    }
}
