package vttp2022.day2.workshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        BankAccount bkAcc= new BankAccount("Khairul Bank Account");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("400");
        assertEquals(500, finalBalance, .1);
    }

    @Test
    public void testFixedDepositAccountChangeInterestAndDuration(){
        try{
            FixedDepositAccount fdAcc =
            new FixedDepositAccount("My FD acc", 10000);

            System.out.println("1. Fixed Deposit Acc balance >" + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Acc balance >" + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(5, 6);

        }catch(IllegalArgumentException e){
            assertTrue("Only can set duration amd interest once".contains(e.getMessage()));

        }
    }

    @Test
    public void testFixedDepositAccountchangeInterestAndDurationOnce(){
        FixedDepositAccount fdAcc = new FixedDepositAccount("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        assertEquals(12, fdAcc.getDuration(), .1);
    }
}
