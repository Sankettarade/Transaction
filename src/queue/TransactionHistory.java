package queue;

import java.util.*;
import java.util.concurrent.locks.*;

public class TransactionHistory implements List<Transaction> {
    private final List<Transaction> transactionList;
    private final ReentrantLock lock = new ReentrantLock();

    public TransactionHistory() {
        this.transactionList = new ArrayList<>();
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return transactionList.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return transactionList.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        try {
            return transactionList.contains(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<Transaction> iterator() {
        lock.lock();
        try {
            return new ArrayList<>(transactionList).iterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        try {
            return transactionList.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        lock.lock();
        try {
            return transactionList.toArray(a);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean add(Transaction transaction) {
        lock.lock();
        try {
            return transactionList.add(transaction);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        try {
            return transactionList.remove(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        lock.lock();
        try {
            return transactionList.containsAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends Transaction> c) {
        lock.lock();
        try {
            return transactionList.addAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Transaction> c) {
        lock.lock();
        try {
            return transactionList.addAll(index, c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        lock.lock();
        try {
            return transactionList.removeAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        lock.lock();
        try {
            return transactionList.retainAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            transactionList.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction get(int index) {
        lock.lock();
        try {
            return transactionList.get(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction set(int index, Transaction element) {
        lock.lock();
        try {
            return transactionList.set(index, element);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void add(int index, Transaction element) {
        lock.lock();
        try {
            transactionList.add(index, element);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Transaction remove(int index) {
        lock.lock();
        try {
            return transactionList.remove(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        lock.lock();
        try {
            return transactionList.indexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        lock.lock();
        try {
            return transactionList.lastIndexOf(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<Transaction> listIterator() {
        lock.lock();
        try {
            return new ArrayList<>(transactionList).listIterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ListIterator<Transaction> listIterator(int index) {
        lock.lock();
        try {
            return new ArrayList<>(transactionList).listIterator(index);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<Transaction> subList(int fromIndex, int toIndex) {
        lock.lock();
        try {
            return new ArrayList<>(transactionList.subList(fromIndex, toIndex));
        } finally {
            lock.unlock();
        }
    }
}