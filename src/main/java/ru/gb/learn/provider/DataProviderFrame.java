package ru.gb.learn.provider;

import lombok.AllArgsConstructor;

import java.util.Scanner;

/**
 * Provides a user with DataProvider selection
 */
@AllArgsConstructor
public class DataProviderFrame {
    private Scanner scanner;

    /**
     * @return DataProvider of selected type
     * @apiNote creates the DataProvider selected by the user
     */
    public DataProvider getProvider() {
        System.out.println("""
                Select toy data provider:
                1. Toy list generator (automatically generate list)
                2. Toy list reader (read toy list from file)
                3. Toy list creator (input list manually)""");
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again");
                continue;
            }
            DataProvider provider = switch (option) {
                case 1 -> new ToyListGenerator();
                case 2 -> new ToyListReader();
                case 3 -> new ToyListCreator(scanner);
                default -> {
                    System.out.println("Incorrect option. Try again");
                    yield null;
                }
            };
            if (provider != null) return provider;
        }
    }
}
