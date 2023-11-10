package ru.gb.learn.box;

import ru.gb.learn.toy.Toy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * The implementation of {@link ToyBox} ignoring toy amount.
 * <p>
 * Unlimited amount of each toy type. Probabilities depends on toy weights.
 */
public class LootToyBox implements ToyBox {

    protected final Random random = new Random();
    protected final TreeMap<Float, Toy> toyMap = new TreeMap<>();
    protected float totalWeight = 0;

    /**
     * @param toyList list of toys
     * @apiNote appends all elements of specified list to the ToyBox
     */
    @Override
    public void putAll(List<Toy> toyList) {
        for (Toy toy : toyList) put(toy);
    }

    /**
     * @param newToy toy
     * @apiNote <ul>
     * <li>appends specified toy, if ToyBox doesn't contain it and toy weight doesn't equal 0</li>
     * <li>recalculates probabilities of toys depends on the specified toy,
     * if ToyBox contains specified toy and toy weight doesn't equal 0</li>
     * <li>removes specified toy and recalculates probabilities of elements depends on it,
     * if ToyBox contains specified toy and toy weight equals 0</li>
     * <li>the collection of ToyBox won't change, if ToyBox contains specified toy and
     * it current weight equals specified one</li>
     * </ul>
     */
    @Override
    public void put(Toy newToy) {
        for (Map.Entry<Float, Toy> entry : toyMap.entrySet()) {
            Toy oldToy = entry.getValue();
            if (oldToy.getName().equals(newToy.getName())) {
                if (oldToy.getWeight() == newToy.getWeight()) return;
                Map<Float, Toy> subTreeMap = toyMap.tailMap(entry.getKey(), false);
                if (newToy.getWeight() == 0) toyMap.remove(entry.getKey());
                else toyMap.replace(entry.getKey(), newToy);
                reconnect(subTreeMap, newToy.getWeight() - oldToy.getWeight());
                return;
            }
        }
        if (newToy.getWeight() != 0) {
            toyMap.put(totalWeight, newToy);
            totalWeight += newToy.getWeight();
        }
    }

    /**
     * @param subTreeMap collection of toys
     * @param delta      value of the correction of probabilities
     * @apiNote calculates new values of probabilities and reconnect toys depends on
     * the toy specified in {@link #put(Toy)}
     */
    protected void reconnect(Map<Float, Toy> subTreeMap, float delta) {
        totalWeight += delta;
        if (subTreeMap.isEmpty()) return;
        List<Entry> reconnectList = new ArrayList<>(subTreeMap.size());
        Iterator<Map.Entry<Float, Toy>> iterator = subTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Float, Toy> entry = iterator.next();
            reconnectList.add(new Entry(entry.getKey() + delta, entry.getValue()));
            iterator.remove();
        }
        for (Entry entry : reconnectList) {
            toyMap.put(entry.key, entry.value);
        }
    }

    /**
     * @return a toy from ToyBox, or null if ToyBox is empty
     * @apiNote if ToyBox is not empty, returns random toy based on toys probabilities, or returns null
     */
    @Override
    public Toy get() {
        if (toyMap.isEmpty()) return null;
        return toyMap.floorEntry(random.nextFloat(totalWeight)).getValue();
    }

    /**
     * @return true if ToyBox is not empty
     */
    @Override
    public boolean isReady() {
        return !toyMap.isEmpty();
    }

    /**
     * record intended for temporal data storage in case of entry reconnection
     *
     * @param key   key associated with the toy
     * @param value toy
     */
    private record Entry(float key, Toy value) {
    }
}
