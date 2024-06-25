package queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TransactionProcessor {
    private final BlockingQueue<Transaction> transactionQueue;
    private final TransactionHistory transactionHistory;

    public TransactionProcessor(int queueCapacity) {
        this.transactionQueue = new LinkedBlockingQueue<>(queueCapacity);
        this.transactionHistory = new TransactionHistory();
    }

    public void startProcessing(int producerCount, int consumerCount) {
        for (int i = 0; i < producerCount; i++) {
            new Thread(new Producer()).start();
        }
        for (int i = 0; i < consumerCount; i++) {
            new Thread(new Consumer()).start();
        }
    }

    private class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    String transactionId = UUID.randomUUID().toString();
                    long timestamp = System.currentTimeMillis();
                    String type = "BUY";
                    double amount = Math.random() * 10;

                    Transaction transaction = new Transaction(transactionId, timestamp, type, amount);
                    transactionQueue.put(transaction);

                    System.out.println("Produced: " + transaction);
                    Thread.sleep(100); // time taken to produce a transaction
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Transaction transaction = transactionQueue.take();
                    processTransaction(transaction);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void processTransaction(Transaction transaction) {
            System.out.println("Processed: " + transaction);
            transactionHistory.add(transaction);
        }
    }   
}