package util;
import java.util.Scanner;

public class Input {
	
	public static int scannInt(){
		int var;
		try {
		Scanner reader = new Scanner(System.in);
		var = reader.nextInt();
		} catch (Exception e) {
			System.out.println("Introduce un número");
			var=0;
		}
		//reader.close();
		return var;
	}

	public static float scannFloat(){
		Scanner reader = new Scanner(System.in);
		float var = reader.nextFloat();
		//reader.close();
		return var;
	}
	
	public static String scannLine(){
		Scanner reader = new Scanner(System.in);
		String var = reader.nextLine();
		//reader.close();
		return var;
	}
}
