package pl.klasicki.budgetapp.adapters.rest;

import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.klasicki.budgetapp.adapters.persist.ExpenseDto;
import pl.klasicki.budgetapp.expense.ExpenseServiceImpl;

@RestController
@RequestMapping("api/expense")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseSearchController {

    ExpenseServiceImpl expenseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getExpenses());
    }

//    @ControllerCode(code = "find by id")
    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ExpenseDto> findById(@RequestParam UUID id, @RequestParam String type, @RequestParam String element) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }
}
