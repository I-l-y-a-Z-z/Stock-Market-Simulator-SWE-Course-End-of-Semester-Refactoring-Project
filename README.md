# Stock Market Simulator

Developing and upgrading my first year university object-oriented programming project.

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

Recompile after changing the source code. The explicit classpath uses your fresh build instead of the precompiled `.class` files included in the original repository.

Enter a username and starting balance, then use the numbered menus. Press **Ctrl+C** to stop the simulator.

## Terminal compatibility

- **Windows:** screen clearing uses the built-in `cmd /c cls` command.
- **Ubuntu:** screen clearing uses ANSI escape sequences in a terminal such as GNOME Terminal; no external `clear` command is needed.
- When Java has no interactive console (for example, redirected output or an IDE output pane), screen clearing is skipped. On Ubuntu it is also skipped when `TERM` is unset or `dumb`.
- If the Windows clear command is unavailable, the simulator continues without clearing the screen.

This is still a developing project, so bugs may remain.
