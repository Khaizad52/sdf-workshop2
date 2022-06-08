package vttp2022.day2.workshop;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
//package to generate uuid
import java.util.UUID;


public class BankAccount {
    //bank account
    private String name ="";

    
    //this is a generated account id from java util UUID class
    private String acctId = UUID.randomUUID()
                                .toString()
                                .substring(0, 8);
    //holds the bank acc balance
    private float balance = 0f;

    //list of transaction history in the event of changes done
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    
    private LocalDateTime accountCreationDate;
    public LocalDateTime accountClosingDate;

    //Constructor with bank acct name
    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    //2nd Constructor with bank acct name and initial balance
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    //Getter and Setter for the rest of the properties
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAcctId() {
        return acctId;
    }
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public List<String> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }
    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }
    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }
    public float withdraw(String withdrawAmt){
        Float withdrawAmtF = null;
        try{
             withdrawAmtF = Float.parseFloat(withdrawAmt);

            if (withdrawAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Withdraw amount cannot be negative or zero");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account closed already");
            }
            this.balance = this.balance - withdrawAmtF.floatValue();

            //construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //save the event log into the txnlinkedlist
            transaction.add(txnStrbld.toString());
            //update the deposit amount
            

        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid Withdraw Amount");
        }
        return withdrawAmtF;

    }
    public void deposit(String depositAmt){
        Float depositAmtF = null;
        try{
            depositAmtF = Float.parseFloat(depositAmt);

            if (depositAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Deposit amount cannot be negative or zero");
            }

            if(this.isClosed()){
                throw new IllegalArgumentException("Account closed already");
            }
            this.balance = this.balance + depositAmtF.floatValue();

            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append("at");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            transaction.add(txnStrbld.toString());
            

        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid Deposit Amount");
        }
    }
    
}
