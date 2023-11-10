package ru.gb.learn.log;

import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of {@link LoggedBox} which logs all calls of ToyBox methods
 */
public class FullLoggedBox extends LoggedBox {

    private final List<String> log = new ArrayList<>();

    public FullLoggedBox(ToyBox host) {
        super(host);
    }

    @Override
    public void putAll(List<Toy> toyList) {
        if (toyList.isEmpty()) log.add("putAll for empty list");
        else {
            StringBuilder sb = new StringBuilder();
            String indent = "    ";
            String ls = "\n";
            sb.append("putAll for list:")
                    .append(ls);
            for (Toy toy : toyList) {
                sb.append(indent)
                        .append(toy.toString())
                        .append(ls);
            }
            sb.deleteCharAt(sb.length() - 1);
            log.add(sb.toString());
        }
        super.putAll(toyList);
    }

    @Override
    public void put(Toy toy) {
        log.add("put " + (toy == null ? "null" : toy.toString()));
        super.put(toy);
    }

    @Override
    public Toy get() {
        Toy toy = super.get();
        log.add("get " + (toy == null ? "null" : toy.toString()));
        return toy;
    }

    @Override
    public String getLog() {
        if (log.isEmpty()) return "Log is empty";
        String ls = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append("Records in log: ")
                .append(log.size())
                .append(ls);
        for (String record : log) {
            sb.append(record)
                    .append(ls);
        }
        return sb.toString();
    }
}
