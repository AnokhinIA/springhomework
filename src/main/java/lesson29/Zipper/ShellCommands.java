package lesson29.Zipper;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {

    @ShellMethod(value = "hello", key = {"hello", "g"})
    public int add(int a, int b) {
        return a + b;
    }
}
