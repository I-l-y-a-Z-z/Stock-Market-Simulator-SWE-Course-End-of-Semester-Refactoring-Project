# Stock Market Simulator — Software Engineering Course Project

This repository is a fork of an existing Java stock market simulator, used as the starting point for an end-of-semester software engineering project. The original application was developed by [12iyad](https://github.com/12iyad), as recorded in the repository's Git history.

The purpose of this fork is to improve the existing codebase using the practices taught in the course. Planned work includes refactoring, SOLID principles, appropriate design patterns, automated testing, and CI/CD. The scope will evolve as additional topics are covered during the semester.

Work completed so far includes Ubuntu compatibility while retaining Windows support, and Git ignore rules for generated files and local IDE configuration.

## Requirements

- Ubuntu or Windows with a Java Development Kit (JDK 8 or newer).
- Both `java` and `javac` available on your `PATH`.

## Compile and run

Open a terminal on Ubuntu, or Command Prompt / PowerShell on Windows, and navigate to the cloned repository.

Create a build directory once:

```sh
mkdir build
```

Compile all Java sources, then start the simulator (the commands are the same on both platforms):

```sh
javac -d build *.java
java -cp build StockMarketSimulator
```

Recompile after changing the source code. The explicit classpath runs the fresh build and keeps generated `.class` files separate from source files.

Enter a username and starting balance, then use the numbered menus. Press **Ctrl+C** to stop the simulator.

## Terminal compatibility

- **Windows:** screen clearing uses the built-in `cmd /c cls` command.
- **Ubuntu:** screen clearing uses ANSI escape sequences in a terminal such as GNOME Terminal; no external `clear` command is needed.
- When Java has no interactive console (for example, redirected output or an IDE output pane), screen clearing is skipped. On Ubuntu it is also skipped when `TERM` is unset or `dumb`.
- If the Windows clear command is unavailable, the simulator continues without clearing the screen.

This is still a developing project, so bugs may remain.
