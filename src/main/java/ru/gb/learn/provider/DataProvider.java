package ru.gb.learn.provider;

import ru.gb.learn.toy.Toy;

import java.util.List;

/**
 * Provides with data for ToyBox creation
 */
public interface DataProvider {

    /**
     * @return list of toys
     * @apiNote returns list of toys
     */
    List<Toy> getToyList();
}
