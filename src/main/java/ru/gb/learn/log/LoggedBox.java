package ru.gb.learn.log;

import lombok.AllArgsConstructor;
import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.util.List;

/**
 * Wrapper for ToyBox which shall be logged
 */
@AllArgsConstructor
public abstract class LoggedBox implements ToyBox {

    protected ToyBox host;

    @Override
    public void putAll(List<Toy> toyList) {
        host.putAll(toyList);
    }

    @Override
    public void put(Toy toy) {
        host.put(toy);
    }

    @Override
    public Toy get() {
        return host.get();
    }

    @Override
    public boolean isReady() {
        return host.isReady();
    }

    /**
     * @apiNote returns string representation of log
     * @return log as String
     */
    public abstract String getLog();
}
