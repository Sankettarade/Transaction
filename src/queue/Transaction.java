package queue;

import java.util.UUID;

public class Transaction {

 private String transactionId;
 private long timeStamp;
 private String transactionType;
 private double amount;

     public Transaction(String transactionId, long timeStamp, String transactionType, double amount) {
    	 
    	 this.transactionId = UUID.randomUUID().toString();
    	 this.timeStamp = System.currentTimeMillis();
    	 this.transactionType = transactionType;
    	 this.amount = amount;
    	 
    }

	public String getTransactionId() {
		return transactionId;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", timestamp=" + timeStamp + ", transactionType="
	
				+ transactionType + ", amount=" + amount + "]";
	}
        
}
