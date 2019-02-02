package it.sevenbits;

import java.util.UUID;

public class Account implements Comparable<Account> {
    private String id;
    private long balance;

    public Account(long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    @Override
    public int compareTo(Account account) {
        return Math.toIntExact(balance - account.balance);
    }

    public void addToBalance(long value) throws Exception {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

}