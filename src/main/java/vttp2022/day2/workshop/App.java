package vttp2022.day2.workshop;

import vttp2022.day2.BankAccount;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "MY ATM Machine - POSSBank" );
        BankAccount bkAcc = new BankAccount("Khairul Bank Account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("30");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("400");
        System.out.println("My new account balance >" + bkAcc.getBalance());

    }
}
