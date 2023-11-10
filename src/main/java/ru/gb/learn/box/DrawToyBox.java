package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.Map;

/**
 * The implementation of {@link ToyBox}.
 * <p>
 * Limited amount of each toy type. Probabilities depends on toy weights.
 */
public class DrawToyBox extends LootToyBox {

    /**
     * @param newToy toy
     * @apiNote <ul>
     * <li>appends specified toy, if ToyBox doesn't contain it and toy weight and amount don't equal 0</li>
     * <li>recalculates probabilities of toys depends on the specified toy,
     * if ToyBox contains specified toy and toy weight and amount don't equal 0</li>
     * <li>removes specified toy and recalculates probabilities of elements depends on it,
     * if ToyBox contains specified toy and toy weight or amount equals 0</li>
     * <li>the collection of ToyBox won't change, if ToyBox contains specified toy and
     * it current weight equals specified one (just updates amount)</li>
     * </ul>
     */
    @Override
    public void put(Toy newToy) {
        for (Map.Entry<Float, Toy> entry : toyMap.entrySet()) {
            Toy oldToy = entry.getValue();
            if (oldToy.getName().equals(newToy.getName())) {
                oldToy.setAmount(newToy.getAmount());
                if (oldToy.getWeight() == newToy.getWeight() && newToy.getAmount() != 0) return;
                Map<Float, Toy> subTreeMap = toyMap.tailMap(entry.getKey(), false);
                float delta;
                if (newToy.getWeight() == 0 || newToy.getAmount() == 0) {
                    toyMap.remove(entry.getKey());
                    delta = -oldToy.getWeight();
                } else {
                    toyMap.replace(entry.getKey(), newToy);
                    delta = newToy.getWeight() - oldToy.getWeight();
                }
                reconnect(subTreeMap, delta);
                return;
            }
        }
        if (newToy.getWeight() != 0 && newToy.getAmount() != 0) {
            toyMap.put(totalWeight, newToy);
            totalWeight += newToy.getWeight();
        }
    }

    /**
     * @return a toy from ToyBox, or null if ToyBox is empty
     * @apiNote if ToyBox is not empty, returns random toy based on toys probabilities, or returns null.
     * <p>
     * reduces toy amount. if toy amount equals 0, removes toy from ToyBox
     */
    @Override
    public Toy get() {
        if (toyMap.isEmpty()) return null;
        float key1 = random.nextFloat(totalWeight);
        Map.Entry<Float, Toy> entry = toyMap.floorEntry(key1);
        Toy toy = entry.getValue();
        toy.setAmount(toy.getAmount() - 1);
        if (toy.getAmount() == 0) {
            float delta = -toy.getWeight();
            Map<Float, Toy> subTreeMap = toyMap.tailMap(entry.getKey(), false);
            toyMap.remove(entry.getKey());
            reconnect(subTreeMap, delta);
        }
        return toy;
    }
}
