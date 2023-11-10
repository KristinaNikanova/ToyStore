package ru.gb.learn.log;

import lombok.AllArgsConstructor;
import ru.gb.learn.box.ToyBox;

import java.util.Scanner;

/**
 * Provides a user with LoggedBox selection
 */
@AllArgsConstructor
public class LoggedBoxFrame {
    private Scanner scanner;

    /**
     * @param host ToyBox which shall be logged
     * @return LoggedBox of selected type or null if option "Disable log" is selected
     * @apiNote wraps specified ToyBox with LoggedBox of selected type
     */
    public LoggedBox selectLog(ToyBox host) {
        System.out.println("""
                Select log option:
                1. Full log
                2. Statistic
                3. Disable log""");
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again");
                continue;
            }
            LoggedBox wrappedBox = null;
            switch (option) {
                case 1 -> wrappedBox = new FullLoggedBox(host);
                case 2 -> wrappedBox = new StatsLoggedBox(host);
                case 3 -> {
                    return null;
                }
                default -> System.out.println("Incorrect option. Try again");
            }
            if (wrappedBox != null) return wrappedBox;
        }
    }
}
