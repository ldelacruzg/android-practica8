package app.smty.practica8.Models;

import java.util.Random;

public class RequestForPayment {
    String phoneNumber, countryCode, clientUserId, clientTransactionId;
    int amount, amountWithTax, amountWithoutTax = 0;
    int tax = 10;
    String reference = "none";
    String responseUrl = "http://paystoreCZ.com/confirm.php";

    public RequestForPayment() {
        this.clientTransactionId = Integer.toString(new Random().nextInt());
        this.amountWithTax = amount - (amount * tax / 100);
    }

    public RequestForPayment(String phoneNumber, String countryCode, String clientUserId, int amount) {
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.clientUserId = clientUserId;
        this.amount = amount * 100;
        this.clientTransactionId = Integer.toString(Math.abs(new Random().nextInt()));
        this.amountWithTax = this.amount - this.tax;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public int getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(int amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public int getAmountWithoutTax() {
        return amountWithoutTax;
    }

    public void setAmountWithoutTax(int amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(String clientUserId) {
        this.clientUserId = clientUserId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
