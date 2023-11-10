package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.List;

/**
 * Toys collection. Provides methods to put and get toys.
 */
public interface ToyBox {

    /**
     * @param toyList list of toys
     * @apiNote appends all elements of specified list to the ToyBox
     */
    void putAll(List<Toy> toyList);

    /**
     * @param toy toy
     * @apiNote appends toy to the ToyBox
     */
    void put(Toy toy);

    /**
     * @return toy
     * @apiNote returns a toy from ToyBox
     */
    Toy get();

    /**
     * @return true - if next call of get() will return a toy, false otherwise
     * @apiNote returns a sign that next call of get() will return a toy
     */
    boolean isReady();
}
