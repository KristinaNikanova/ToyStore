package ru.gb.learn.draw;

import lombok.AllArgsConstructor;
import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.util.Scanner;

/**
 * The implementation of {@link Drawer}.
 * <p>
 * Requests the count of iterations of the test from a user
 * and draws toys from specified ToyBox while it isn't empty or test won't be done
 */
@AllArgsConstructor
public class TestDrawer implements Drawer {

    private Scanner scanner;

    /**
     * @param toyBox a ToyBox to be drawn
     * @apiNote draws toys while ToyBox isn't empty or test won't be done
     */
    @Override
    public void draw(ToyBox toyBox) {
        int count = getCount();
        while (toyBox.isReady()) {
            Toy toy = toyBox.get();
            System.out.println("toy = " + toy);
            count--;
            if (count == 0) {
                System.out.println("Test is done");
                return;
            }
        }
        System.out.println("ToyBox is empty");
    }

    /**
     * @return iterations count
     * @apiNote requests the count of iterations of the test from a user
     */
    private int getCount() {
        int count;
        System.out.println("Enter count of iterations:");
        while (true) {
            try {
                count = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again");
                continue;
            }
            if (count < 1) {
                System.out.println("Incorrect value. Try again");
                continue;
            }
            return count;
        }
    }
}
