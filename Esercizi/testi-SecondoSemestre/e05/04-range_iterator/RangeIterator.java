import java.util.Iterator;

//Overview: Questo Iteratore si occuperà di generare numeri da un un intero a fino ad un intero b con salti da c elementi 
public class RangeIterator {
    private final int from;
    private final int to;
    private final int step;

    public RangeIterator(int from, int to, int step) {
        if (!(step > 0))
            throw new IllegalArgumentException("step deve essere maggiore di 0");
        if (to < 0)
            throw new IllegalArgumentException("to deve essere maggiore di 0");
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public RangeIterator(int to, int step) {
        this(0, to, step);
    }

    public RangeIterator(int to) {
        this(to, 1);
    }

    /**
     * AF: from >0 && to>from -> step>0
     */
    /**
     * RI: Questo Iteratore si occuperà di generare numeri da un un intero a fino ad
     * un intero b con salti da c elementi
     */
    public Iterator<Integer> Iterator() {

        return new Iterator<Integer>() {
            int pointer = from;
            boolean hasNext = false;

            @Override
            public boolean hasNext() {
                if (pointer + step <= to) {
                    hasNext = true;
                    pointer += step;
                }
                return hasNext;
            }

            @Override
            public Integer next() {
                hasNext = false;
                return pointer;
            }

        };

    }

}
