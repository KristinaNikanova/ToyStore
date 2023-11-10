package ru.gb.learn.draw;

import lombok.AllArgsConstructor;

import java.util.Scanner;

/**
 * Provides a user with Drawer selection
 */
@AllArgsConstructor
public class DrawerFrame {

    private Scanner scanner;

    /**
     * @return Drawer of selected type
     * @apiNote creates the Drawer selected by the user
     */
    public Drawer getDrawer() {
        System.out.println("""
                Select draw type:
                1. Manual
                2. Participants list
                3. Test""");
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again");
                continue;
            }
            Drawer drawer = switch (option) {
                case 1 -> new ManualDrawer(scanner);
                case 2 -> new ListDrawer();
                case 3 -> new TestDrawer(scanner);
                default -> {
                    System.out.println("Incorrect option. Try again");
                    yield null;
                }
            };
            if (drawer != null) return drawer;
        }
    }
}
