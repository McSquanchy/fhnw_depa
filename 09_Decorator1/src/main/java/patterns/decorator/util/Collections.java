package patterns.decorator.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Collections {

	public static <T> Collection<T> unmodifiableCollection(Collection<T> c) {
		return new undModifiableColl<>(c);
	}

	public static class undModifiableColl<T> implements Collection<T> {
		private final Collection<T> collection;

		public undModifiableColl(Collection<T> collection) {
			this.collection = collection;
		}

		@Override
		public int size() {
			return collection.size();
		}

		@Override
		public boolean isEmpty() {
			return collection.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return collection.contains(o);
		}

		@Override
		public Iterator<T> iterator() {
			return new Iterator<>() {
				@Override
				public boolean hasNext() {
					return collection.iterator().hasNext();
				}

				@Override
				public T next() {
					return collection.iterator(). next();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

		@Override
		public Object[] toArray() {
			return collection.toArray().clone();
		}

		@Override
		public <T1> T1[] toArray(T1[] a) {
			return collection.toArray(a);
		}

		@Override
		public <T1> T1[] toArray(IntFunction<T1[]> generator) {
			return collection.toArray(generator);
		}

		@Override
		public boolean add(T t) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			if(c == this) return true;
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeIf(Predicate<? super T> filter) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Spliterator<T> spliterator() {
			return null;
		}

		@Override
		public Stream<T> stream() {
			return null;
		}

		@Override
		public Stream<T> parallelStream() {
			return null;
		}
	}
}
