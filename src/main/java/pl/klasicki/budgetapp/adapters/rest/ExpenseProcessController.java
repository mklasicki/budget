package pl.klasicki.budgetapp.adapters.rest;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.klasicki.budgetapp.interceptors.ControllerCode;
import pl.klasicki.budgetapp.expense.ExpenseRequest;
import pl.klasicki.budgetapp.expense.ExpenseServiceImpl;

@RestController
@RequestMapping("api/expense")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseProcessController {

    ExpenseServiceImpl expenseService;

//    @ControllerCode(code = "insert expense")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UUID> insertExpense(@RequestBody ExpenseRequest expenseRequest) {
        return ResponseEntity.ok(expenseService.insertExpense(expenseRequest));
    }

}
