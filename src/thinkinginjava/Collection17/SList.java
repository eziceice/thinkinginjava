package src.thinkinginjava.Collection17;

/**
 * Created by Ryan on 2017/3/15.
 */
public class SList<T> {
    private Link link;
    private int size = 10;
    private int index = 0;

    @Override
    public String toString() {
        return super.toString();
    }

    class SListIterator {
        public boolean hasNext() {
            return size > index;
        }
        public T next() {
            return link.next;
        }
    }

    class Link {
        String item;
        T next;
    }
}
