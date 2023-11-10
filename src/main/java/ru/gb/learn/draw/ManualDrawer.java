package ru.gb.learn.draw;

import lombok.AllArgsConstructor;
import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.util.Scanner;

/**
 * The implementation of {@link Drawer}.
 * <p>
 * Provides a user with manual draw of toys
 */
@AllArgsConstructor
public class ManualDrawer implements Drawer {

    private Scanner scanner;

    /**
     * @param toyBox a ToyBox to be drawn
     * @apiNote draws toys while ToyBox isn't empty or user won't enter "exit"
     */
    @Override
    public void draw(ToyBox toyBox) {
        while (toyBox.isReady()) {
            System.out.println("Enter anything to get toy or \"exit\" to quit app");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) return;
            Toy toy = toyBox.get();
            System.out.println("toy = " + toy);
        }
        System.out.println("ToyBox is empty");
    }
}
