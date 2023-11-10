package ru.gb.learn.provider;

import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The implementation of {@link DataProvider}.
 * <p>
 * Generates data of toys
 */
public class ToyListGenerator implements DataProvider {

    /**
     * @return list of toys
     * @apiNote returns list of toys created with using generated data
     */
    @Override
    public List<Toy> getToyList() {
        Random random = new Random();
        String[] names = {"Teddy Bear", "Robot", "Barbie", "Jet", "Constructor", "Soccer ball"};
        int capacity = 10;
        List<Toy> toyList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            toyList.add(new Toy(names[random.nextInt(names.length)],
                    random.nextFloat(),
                    random.nextInt(11)));
        return toyList;
    }
}
