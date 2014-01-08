
package main;

public class NumAleatorio {

	public NumAleatorio(){
		
	}
	
	public static int numEntre(int min, int max){
		int random = 0;
		random = (int) (Math.random() * ((max - min) + 1)) + min;
		return random;
	}
	
	
	
}
