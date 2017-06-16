package test;

import org.junit.Assert;
import org.junit.Test;

import main.HangedBoard;
import main.HangedModel;

public class TestHangedBoard {

	@Test
	public void testAddLetterToWordPlayer(){
		
		HangedBoard board = new HangedBoard(); 
		
		board.startGame("PERRO",2);   
		int[] results = board.addLetterToWordPlayer('R'); 
		int[] expected= new int[]{2,3}; 
		
		Assert.assertEquals(results.length,2);
		Assert.assertEquals(results[0],expected[0]);
		Assert.assertEquals(results[1],expected[1]);
		
		Assert.assertArrayEquals(expected, results);
  		char[] charExpected = "--RR-".toCharArray();
  		Assert.assertArrayEquals(charExpected, board.getWordPlayer());

		
	}
	
	
	
	@Test
	public void testIsWinner() {
	HangedBoard board = new HangedBoard(); 
		
		board.startGame("PERRO",2);   
		int[] results = board.addLetterToWordPlayer('R');
		board.addLetterToWordPlayer('P');
		board.addLetterToWordPlayer('E');
		board.addLetterToWordPlayer('O');
		
		boolean resultsisWin = board.isWinner();
		
		Assert.assertEquals(true, resultsisWin);
		
		
	}
	
	
}
