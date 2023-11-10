package ru.gb.learn.log;

import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * The implementation of {@link LoggedBox} which logs statistic of calls of method {@link #get()}
 */
public class StatsLoggedBox extends LoggedBox {

    private final HashMap<String, Integer> stats = new HashMap<>();

    private int commonCount = 0;

    public StatsLoggedBox(ToyBox host) {
        super(host);
    }

    @Override
    public Toy get() {
        Toy toy = super.get();
        if (toy == null) return null;
        Integer toyCount = stats.get(toy.getName());
        if (toyCount == null) toyCount = 0;
        stats.put(toy.getName(), toyCount + 1);
        commonCount++;
        return toy;
    }

    @Override
    public String getLog() {
        if (commonCount == 0) return "Log is empty";
        String ls = "\n";
        DecimalFormat df = new DecimalFormat(" (#.##%)");
        StringBuilder sb = new StringBuilder();
        sb.append("Common count: ")
                .append(commonCount)
                .append(ls);
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            int toyCount = entry.getValue();
            String countStr = switch (toyCount) {
                case 1 -> "once";
                case 2 -> "twice";
                default -> toyCount + " times";
            };
            String percentage = df.format((double) toyCount / commonCount);
            sb.append(entry.getKey())
                    .append(" was drawn ")
                    .append(countStr)
                    .append(percentage)
                    .append(ls);
        }
        return sb.toString();
    }
}
