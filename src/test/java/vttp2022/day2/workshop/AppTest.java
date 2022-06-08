package vttp2022.day2.workshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
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
    public void testFixedDepositAccount(){
        try{

        }catch(IllegalArgumentException e){
            assertTrue("Only can set duration amd interest once".contains(e.getMessage()))

        }
    }
}
