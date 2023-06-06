import java.util.ArrayList;
import java.util.List;

/**
 * Overview:
 * questa classe rappresenta una coda di interi
 */
public class IntQueue {
    // Campi
    List<Integer> queue;
    int size;

    /**
     * AF: size deve essere >=0
     */
    /**
     * IR: ogni elemento di queue rappresenta un elemento
     * della coda e size rappresenta il numero massimo di elementi della coda
     */

    public IntQueue(int size) {
        queue = new ArrayList<Integer>();
        this.size = size;
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    /**
     * QUesto metodo si occupa di aggiungere un elemento in coda alla nostra coda
     * 
     * @param n
     * @throws IllegalAction quando
     */

    // REQUIRES:---
    // EFFECTS: Questo metodo si occupa di aggiungere un elemento in coda alla
    // nostra coda, se aggiungendo l'elemento si supera la capacità specificata dal
    // campo size, lancia l'eccezione IllegalAction
    // MODIFIES:---

    public void enqueue(int n) throws IllegalAction {
        if (queue.size() >= size) {
            throw new IllegalAction("size massima superata!");
        }

        queue.add(0, n);
    }

    // REQUIRES:---
    // EFFECTS: Questo metodo si occupa di restituire il primo elementi della coda,
    // se la coda è vuota viene lanciata l'eccezione EmptyQueueExeption
    // MODIFIES:---
    /**
     * Questo metodo si occupa di restituire il primo elementi della coda, se la
     * coda è vuota viene lanciata l'eccezione EmptyQueueExeption
     * 
     * @return
     * @throws EmptyQueueExeption
     */

    public int dequeue() throws EmptyQueueExeption {
        if (queue.size() == 0) {
            throw new EmptyQueueExeption("la coda è vuota");
        }
        int n = queue.get(queue.size() - 1);
        queue.remove(n);
        return n;
    }

    public boolean repOk(ArrayList<Integer> queue, int size) {
        return queue.size() < size && size > 0;
    }

}
