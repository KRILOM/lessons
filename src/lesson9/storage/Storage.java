package lesson9.storage;

import java.util.Iterator;

public class Storage implements Iterable{
    Container head;

    public void add(Object value) {
        if (head == null) {
            head = new Container(value);

            return;
        }

        find(-1).next = new Container(value);
    }

    public Object get(int idx) {
        Container res = find(idx);

        return res == null ? -1 : res.element;
    }

    private Container find(int idx) {
        if (idx == 0)
            return head;

        int cnt = 0;

        Container container = head;

        while (container != null) {
            if (cnt++ == idx)
                return container;

            if (idx < 0 && container.next == null)
                return container;

            container = container.next;
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new StorageIterator(head);
    }

    private static class StorageIterator implements Iterator {
        private Container next;

        private StorageIterator(Container next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            Object res = next.element;

            next = next.next;

            return res;
        }
    }
}
