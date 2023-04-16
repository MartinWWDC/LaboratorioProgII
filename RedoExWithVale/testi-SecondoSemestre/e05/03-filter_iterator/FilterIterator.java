import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {
  private Iterator<T> source;
  private Predicate<T> filter;
  private boolean hasNext=false;
  private T next=null;

  public FilterIterator(final Iterator<T> source, Predicate<T> filter) {
      this.source = source;
      this.filter=filter;
  }
  @Override
  public boolean hasNext() {
    while(!hasNext &&source.hasNext()){
        next=source.next();
        hasNext=filter.test(next);
    }  
    return hasNext;
  }
  
  @Override
  public T next() {
    if(!hasNext) throw new NoSuchElementException();
    hasNext=false;
    return next;
  }
  public static void main(String[] args) {
    Iterator<Integer> filtered =
        new FilterIterator<>(
            List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).iterator(), new IsGreaterThan(5));
    while (filtered.hasNext()) System.out.println(filtered.next());
  }
}