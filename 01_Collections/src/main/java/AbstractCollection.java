import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractCollection<E> implements Collection<E> {

        @Override
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        public boolean remove(Object x) {
            Iterator<E> it = iterator();
            while(it.hasNext()) {
                Object o = it.next();
                if(Objects.equals(o,x)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean modified = false;
            for(E e: c) {
                if (add(e)) {
                    modified = true;
                };
            }
            return modified;
        }

        @Override
        public boolean contains(Object x) {
            for (E e : this) {
                if (Objects.equals(x, e)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            for (Object x : c) {
                if (!contains(x)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            for (Object x : c) {
                if(this.remove(x)) {
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            boolean modified = false;
            for(E e : this) {
                if(!c.contains(e)) {
                    this.remove(e);
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public int size() {
            int count = 0;
            for(E e : this) {
                count++;
            }
            return count;
        }

        @Override
        public void clear() {
            for(E e : this) {
                remove(e);
            }
        }

        @Override
        public Object[] toArray() {
            Object[] result = new Object[this.size()];
            int count = 0;
            Iterator<E> it = iterator();
            while(it.hasNext()){
                Object o = it.next();
                result[count++] = o;
            }
            return result;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] arg) {
            if(arg.length < this.size()) {
                arg = (T[]) Array.newInstance(arg.getClass().getComponentType(), size());
            }
            int count = 0;
            for (E e : this) {
                arg[count++] = (T) e;
            }
            return arg;

        }
}
