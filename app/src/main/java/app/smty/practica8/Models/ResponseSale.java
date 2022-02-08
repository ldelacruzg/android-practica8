package app.smty.practica8.Models;

public class ResponseSale {
    String message;
    int transactionId;

    public ResponseSale() {
    }

    public ResponseSale(String message, int transactionId) {
        this.message = message;
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
