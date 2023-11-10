package ru.gb.learn.draw;

import ru.gb.learn.box.ToyBox;

/**
 * A drawer of ToyBox
 */
public interface Drawer {

    /**
     * @param toyBox a ToyBox to be drawn
     * @apiNote draws toys from a ToyBox
     */
    void draw(ToyBox toyBox);
}
