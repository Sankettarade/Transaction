package queue;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {

		public static void main(String[] args) {
			
			TransactionHistory transactionHistory = new TransactionHistory();

			 // Create a thread pool
			        ExecutorService executor = Executors.newFixedThreadPool(5);

			 // Producer task to add transactions to the history
			    Runnable producerTask = () -> {
			        for (int i = 0; i < 5; i++)
			        {
			               String transactionId = UUID.randomUUID().toString();
			               long timestamp = System.currentTimeMillis();
			               String type = "BUY";
			               double amount = Math.random() * 10;

			                Transaction transaction = new Transaction(transactionId, timestamp, type, amount);

			                transactionHistory.add(transaction);

			                System.out.println("Added: " + transaction);
			         }
			        };

			        
			        Runnable consumerTask = () -> {
			            while (true) {
			                if (!transactionHistory.isEmpty()) {
			                    Transaction transaction = transactionHistory.get(0);
			                    transactionHistory.remove(transaction);
			                    System.out.println("Processed: " + transaction);
			                }
			            }
			        };

			        // Submit producer tasks
			        for (int i = 0; i < 5; i++) {
			            executor.submit(producerTask);
			        }

			        // Submit consumer tasks
			        for (int i = 0; i < 5; i++) {
			            executor.submit(consumerTask);
			        }

			        // Shutdown the executor after some time
			        try {
			            Thread.sleep(5000); // task is run for 5 seconds
			        } catch (InterruptedException e) {
			            Thread.currentThread().interrupt();
			        }

			        executor.shutdownNow();
			        
			        TransactionProcessor processor = new TransactionProcessor(50);
			        processor.startProcessing(5, 5);
			    }		
	}

