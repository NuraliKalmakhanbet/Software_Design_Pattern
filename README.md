# Assignment 1: Builder Design Pattern

Java implementation of the Builder pattern using a car configuration domain for Software Design Patterns (ShP-2216)[cite: 2].

**Pattern Components**

* **Product (`Car`):** Complex object containing car type, seating capacity, engine, transmission, and GPS specs[cite: 1, 2].
* **Builder (`Builder`):** Interface declaring construction steps[cite: 1, 2].
* **Concrete Builders:** `SportsCarBuilder` (max 2 seats) and `StandardCarBuilder` (up to 8 seats)[cite: 1, 2].
* **Director (`Director`):** Centralizes preset build recipes (`constructSportsCar`, `constructCityCar`)[cite: 1, 2].
* **Client (`Main`):** Demonstrates execution via Director presets and method chaining[cite: 1, 2].

**Clean Code Highlights**

* **No Magic Numbers:** Named constants (`MIN_SEATS`, `MAX_SEATS`) replace raw literals[cite: 2].
* **Validation (SRP):** Isolated `validateState()` method throws `IllegalStateException` on invalid build state[cite: 2].
* **DRY & Fluent API:** Presets handled by Director; method chaining simplifies custom setups[cite: 1, 2].

**How to Run**

```bash
javac Main.java
java Main
