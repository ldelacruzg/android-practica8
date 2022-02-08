package app.smty.practica8.Models;

public class ResponseSaleClient {
    String email, clientTransactionId, phoneNumber, transactionStatus, document;
    int amount;

    public ResponseSaleClient() {
    }

    public ResponseSaleClient(String email, String clientTransactionId, String phoneNumber,
                              String transactionStatus, String document, int amount) {
        this.email = email;
        this.clientTransactionId = clientTransactionId;
        this.phoneNumber = phoneNumber;
        this.transactionStatus = transactionStatus;
        this.document = document;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
