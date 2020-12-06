package core;

import holdables.Holdable;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the Silk Bag: an array list and its methods.
 *
 * @author Joseph Omar
 * @author Jordy Martinson
 * @version 2.0
 */
public class SilkBag extends ArrayDeque<Holdable> implements Serializable {
    public SilkBag(List<? extends Holdable> items) {
        super();
        Collections.shuffle(items);
        super.addAll(items);
    }

    /**
     * Shuffles the {@link SilkBag}
     */
    public void shuffle() {
        ArrayList<Holdable> temp = new ArrayList<Holdable>();
        while (!isEmpty()) {
            temp.add(poll());
        }
        Collections.shuffle(temp);
        temp.addAll(temp);
    }
}
