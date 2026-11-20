# Stock Market Simulator — Software Engineering Course Project

This repository is a fork of an existing Java stock market simulator, used as the starting point for an end-of-semester software engineering project. The original application was developed by [12iyad](https://github.com/12iyad), as recorded in the repository's Git history.

The purpose of this fork is to improve the existing codebase using the practices taught in the course. Planned work includes refactoring, SOLID principles, appropriate design patterns, automated testing, and CI/CD. The scope will evolve as additional topics are covered during the semester.

Work completed so far includes Ubuntu compatibility while retaining Windows support, Git ignore configuration, and a Java 17 Maven build with the course dependencies.

## Requirements

- Ubuntu or Windows with **JDK 17 or newer**. The project compiles to Java 17 bytecode and requires Java 17+ to run.
- `JAVA_HOME` pointing to the JDK, with `java` on your `PATH`.
- Internet access on the first build to download Maven and dependencies. The Maven Wrapper is included, so a separate Maven installation is unnecessary.
- On Ubuntu, the wrapper needs `curl` or `wget`, `unzip`, and `sha256sum` (normally provided by coreutils). The Windows wrapper uses PowerShell.

## Course dependencies

Versions follow the supplied lecture PDFs rather than automatically selecting the newest release.

| Component | Version | Lecture reference (PDF page) | Use |
| --- | --- | --- | --- |
| Java target | 17 | Requested project baseline; compatible with the testing lecture | Compile and run |
| Gson | 2.11.0 | Design Patterns, p. 8 | JSON library; included for course work, not yet used by simulator logic |
| JUnit Jupiter | 6.0.3 | Software Testing, p. 33 | Tests only |
| Mockito JUnit Jupiter | 5.23.0 | Software Testing, p. 47 | Tests only |
| Maven Shade Plugin | 3.6.0 | Design Patterns, p. 12 | Packages a runnable JAR including runtime dependencies |

The build lecture's older example uses JUnit 5.11.0 and Java 21. This project uses the testing lecture's JUnit 6.0.3 with the requested Java 17 baseline. The JUnit BOM aligns its modules and Mockito's transitive JUnit dependency. See the [JUnit 6.0.3 build guidance](https://docs.junit.org/6.0.3/running-tests/build-support.html).

The wrapper pins Maven **3.9.16** and Maven Wrapper **3.3.4**. Supporting Maven plugins are pinned in `pom.xml`; their versions are build choices, not versions specified by the professor. Python/pytest and Gradle are alternative lecture tools, not dependencies of this Maven-based Java application.

## Build and test

Run these commands from the cloned repository using JDK 17 or newer.

Ubuntu:

```sh
./mvnw clean verify
```

Windows (PowerShell or Command Prompt):

```powershell
.\mvnw.cmd clean verify
```

To run tests alone, use `./mvnw test` on Ubuntu or `.\mvnw.cmd test` on Windows. `CourseDependenciesTest` is a dependency-integration smoke test for JUnit parameterized tests, Mockito's extension and Gson; it is not yet a test suite for simulator behavior.

The existing application sources remain at the repository root. Maven compiles only those root Java sources as application code; tests are in `src/test/java`, and generated output is in the ignored `target/` directory. No source refactoring is included in this setup.

## Run

After a successful build, the command is the same on both platforms:

```sh
java -jar target/stock-market-simulator.jar
```

Enter a username and starting balance, then use the numbered menus. Press **Ctrl+C** to stop the simulator.

Rebuild after changing the source code. JUnit and Mockito are not bundled with the application JAR.

## Terminal compatibility

- **Windows:** screen clearing uses the built-in `cmd /c cls` command.
- **Ubuntu:** screen clearing uses ANSI escape sequences in a terminal such as GNOME Terminal; no external `clear` command is needed.
- When Java has no interactive console (for example, redirected output or an IDE output pane), screen clearing is skipped. On Ubuntu it is also skipped when `TERM` is unset or `dumb`.
- If the Windows clear command is unavailable, the simulator continues without clearing the screen.

This is still a developing project, so bugs may remain.
