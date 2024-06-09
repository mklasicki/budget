package pl.klasicki.budgetapp.adapters.time;

import java.time.Instant;

import pl.klasicki.budgetapp.ports.TimeProvider;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public Instant getTimeSTamp() {
        return Instant.now();
    }
}
