package ru.gb.learn.draw;

import ru.gb.learn.box.ToyBox;
import ru.gb.learn.toy.Toy;

import java.util.Arrays;
import java.util.List;

/**
 * The implementation of {@link Drawer}.
 * <p>
 * Draws toys between participants from a list
 */
public class ListDrawer implements Drawer {

    /**
     * @param toyBox a ToyBox to be drawn
     * @apiNote draws toys while ToyBox isn't empty
     * or every participant in list won't participate in the draw
     */
    @Override
    public void draw(ToyBox toyBox) {
        List<String> participants = getParticipantList();
        int size = participants.size();
        if (size == 0) {
            System.out.println("Participant list is empty");
            return;
        }
        int count = 0;
        while (toyBox.isReady()) {
            Toy toy = toyBox.get();
            System.out.println(participants.get(count) + " get the " + toy.getName());
            count++;
            if (count == size) {
                System.out.println("All participants get a toy");
                return;
            }
        }
        System.out.println("ToyBox is empty");
    }

    /**
     * @return list of participants
     * @apiNote returns list of participants
     */
    // todo: actually there should be an interface as well
    private List<String> getParticipantList() {
        return Arrays.asList(new String[]{
                "Vladimir",
                "Olga",
                "Iren",
                "Dmitry",
                "Andrew",
                "John",
                "Pavel",
                "Alexey",
                "Igor",
                "Svetlana"
        });
    }
}
