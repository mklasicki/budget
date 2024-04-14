CREATE TABLE IF NOT EXISTS budget.expense (
  id uuid not null,
  amount money NOT NULL,
  date timestamp NOT NULL,
  category VARCHAR NOT NULL,
PRIMARY KEY (id)
);