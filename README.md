# Mutation Testing Workshop

A hands-on workshop exploring mutation testing with practical examples in TypeScript and Java.

## Workshop Structure

### TypeScript base code instructions

All the examples are placed under `mutation-tests-ts-example` directory.

#### Branch: `step-1` - Initial Implementation
Contains production code and tests **without** mutation testing frameworks.

**To run tests:**
```bash
npm npm run test
```

**Activity:** Review the code and tests. Discuss what edge cases might be missing. 
Can you spot untested scenarios just by reading the code? You might add missing test case scenarios :)

#### Branch: `step-2` - Mutation Testing Enabled
Same code and tests, now with mutation testing framework configured (stryker)[https://stryker-mutator.io/].

To run mutation testing using Stryker:
```bash
npm run test:mutation
```

**Purpose:** Run mutation tests to discover gaps that traditional testing metrics miss.

📊 Report available at: `mutation-tests-ts-example/reports/mutation/mutation.html`

### Java based code

All the examples are placed under `mutation-tests-java-example` directory.

#### Branch: `step-1` - Initial Implementation
Contains production code and tests **without** mutation testing frameworks.

**To run tests:**
```bash
./gradlew test
```

**Activity:** Review the code and tests. Discuss what edge cases might be missing.
Can you spot untested scenarios just by reading the code? You might add missing test case scenarios :)

#### Branch: `step-2` - Mutation Testing Enabled
Same code and tests, now with mutation testing framework configured (pitest)[https://github.com/pitest].

To run mutation testing using pitest:
```bash
./gradlew pitest
```

**Purpose:** Run mutation tests to discover gaps that traditional testing metrics miss.

📊 Report available at: `build/reports/pitest/index.html`
