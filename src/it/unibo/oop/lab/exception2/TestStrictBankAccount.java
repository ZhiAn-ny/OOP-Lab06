package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {
	
	private static final int INITIAL_BALANCE = 10_000;
	private static final int MAX_ATM_TRANSICTIONS = 10;

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	var mario = new StrictBankAccount(1, INITIAL_BALANCE, MAX_ATM_TRANSICTIONS);
    	var luigi = new StrictBankAccount(2, INITIAL_BALANCE, MAX_ATM_TRANSICTIONS);
    	
    	// Test WrongAccountHolderException
    	luigi.withdraw(1, 150);
    	
    	// Test NotEnoughFoundsException
    	mario.withdraw(1, 12000);
    	
    	// Test TransictionOverQuotaException
    	for (int i = 0; i < MAX_ATM_TRANSICTIONS; i++) {
    		mario.withdrawFromATM(1, 250);
    	}
    	// Quota reached
    	mario.withdrawFromATM(1, 250);
    	
    }
}
