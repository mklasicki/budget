package pl.klasicki.budgetapp.ports;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimeSTamp();

}
