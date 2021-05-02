package inputOutput;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class Start {
	
	public static void printCharacter(String a)
	{
		
		try {
			System.out.println(Arrays.toString(a.getBytes("US-ASCII"))); //the getBytes method basically gets the representation of the character in the format you specified in 
			System.out.println(Arrays.toString(a.getBytes("UTF-16")));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		printCharacter("a + 1");
		printCharacter("*");
		printCharacter("333");
		System.out.println("a" + 3);
	}

}
