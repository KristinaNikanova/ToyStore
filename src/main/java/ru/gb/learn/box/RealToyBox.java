package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The simplest implementation of {@link ToyBox} ignoring toy amount and weight.
 * <p>
 * Toys amount and probabilities depends on what toys in what amount are added.
 */
public class RealToyBox implements ToyBox {

    private final Random random = new Random();
    private final List<Toy> toyList = new ArrayList<>();

    /**
     * @param toyList list of toys
     * @apiNote appends all elements of specified list to the ToyBox
     */
    @Override
    public void putAll(List<Toy> toyList) {
        this.toyList.addAll(toyList);
    }

    /**
     * @param toy toy
     * @apiNote appends toy to the ToyBox
     */
    @Override
    public void put(Toy toy) {
        toyList.add(toy);
    }

    /**
     * @return a toy from ToyBox, or null if ToyBox is empty
     * @apiNote if ToyBox is not empty, removes toy with random index from ToyBox and returns it,
     * or returns null
     */
    @Override
    public Toy get() {
        if (toyList.isEmpty()) return null;
        return toyList.remove(random.nextInt(toyList.size()));
    }

    /**
     * @return true if ToyBox is not empty
     */
    @Override
    public boolean isReady() {
        return !toyList.isEmpty();
    }
}
