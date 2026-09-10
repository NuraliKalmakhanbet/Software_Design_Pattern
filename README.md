Java implementation of the Builder pattern using a car configuration domain for Software Design Patterns.

**Pattern Components**

* **Product (`Car`):** Complex object containing car type, seating capacity, engine, transmission, and GPS specs
* **Builder (`Builder`):** Interface declaring construction steps
* **Concrete Builders:** `SportsCarBuilder` (max 2 seats) and `StandardCarBuilder` (up to 8 seats)
* **Director (`Director`):** Centralizes preset build recipes (`constructSportsCar`, `constructCityCar`)
* **Client (`Main`):** Demonstrates execution via Director presets and method chaining

**Clean Code Highlights**

* **No Magic Numbers:** Named constants (`MIN_SEATS`, `MAX_SEATS`) replace raw literals
* **Validation (SRP):** Isolated `validateState()` method throws `IllegalStateException` on invalid build state
* **DRY & Fluent API:** Presets handled by Director; method chaining simplifies custom setups

**How to Run**

```bash
javac Main.java
java Main
