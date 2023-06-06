import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range {
    // campi
    int i;
    int f;
    int salto;

    public Range(int i, int f, int salto) {
        if (!(salto > 0))
            throw new IllegalArgumentException("salto deve essere maggiore di 0");
        if (f < 0)
            throw new IllegalArgumentException("f deve essere maggiore di 0");
        this.i = i;
        this.f = f;
        this.salto = salto;
    }

    public Iterator<Integer> Iterator() {

        return new Iterator<Integer>() {
            boolean hasNext = false;
            int point = i;

            @Override
            public boolean hasNext() {
                point += salto;
                if (point <= f) {
                    hasNext = true;
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                if (!hasNext) {
                    throw new NoSuchElementException();
                }
                hasNext = false;
                return point;
            }

        };
    }

}