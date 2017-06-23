package main;

import util.Input;

public class UserInterface {
	public static final String OPTION_SALIR = "salir";
	public static final String OPTION_JUGAR = "jugar";
	public static final String OPTION_DIFICULTAD = "dificultad";

	public static final String OPTION_RESET = "reset";

	
	
	public static void showMenuInicio(int score){
		System.out.println("*******************");
		System.out.println("JUEGO DEL AHORCADO");
		System.out.println("*******************");
		System.out.println("Racha actual de " + score);
		System.out.println("jugar\nsalir\ndificultad");
		System.out.print("Elige una opción : ");	
	}
	
	
	public static String ScanOpcionMenuInicio(){
		
		String option;
		boolean isOKI = false; 
		do{
			
			option = Input.scannLine().toLowerCase();
			isOKI = !(option.equals(OPTION_JUGAR)||
							  option.equals(OPTION_SALIR)||
							  	option.equals(OPTION_DIFICULTAD)); 	
			if(isOKI)
				System.out.println("Opción no válida. Vuelva a intentarlo: ");
			
		}while(isOKI);
		
		return option;
	}	
	

	
	public static void showMenuBoard(char[] wordPlayer, String hint, int attepts){		
		System.out.println("Salir");
		System.out.println("Reset");			
		System.out.println("Pista : " + hint);					
			//char[] c = wordPlayer.toCharArray();
						
		for(int i=0; i<wordPlayer.length;i++){
			System.out.print(wordPlayer[i] + " ");			
		}				
		System.out.println("Intentos : " + attepts);			
	}
	
	
	public static String scannOpcionMenuBoard(){
		String valid=null;
		while(valid==null){
			String option=Input.scannLine().toLowerCase();
				if (option.equals(OPTION_SALIR)){
					valid=option; 
					break;
				}else if(option.equals(OPTION_RESET)){
					valid=option;
					break;
				}else if(option.length()==1){
					valid=option.toUpperCase();
					break;
				}else{
					System.out.println(option + " No es opcion valida,Vuelva a intentarlo ");
				}
		}
		
		return valid;
	}
	
	
	public static void showMenuAgain(boolean winner, int streak){
		if (winner){
			System.out.println("\n\n\t\t\t HAS GANADO \t\t\t");
			System.out.print("\n\n\t\t Felicidades llevas " + streak + " racha");
			if (streak>1)
				System.out.print("s");
			System.out.print("\n\n\t Quieres continuar jugando?  teclea Si o No");
			
		}else{
			System.out.println("\n\t\t\t ----- ");
			System.out.println("\t\t\t |   O ");
			System.out.println("\t\t\t |   | ");
			System.out.println("\t\t\t |   ^ ");
			System.out.println("\t\t\t |_____");
			System.out.println("\n\t\t\t GAME OVER");
			System.out.print("\n\n\t Quieres continuar jugando?  teclea Si o No");
		}
	}
	
	
	
	

	
	
	public static String scannOptionMenuEndGame(){
		String key= Input.scannLine();
		key = key.toUpperCase();	
		String isKeyOk= null;				
		while (isKeyOk==null){
			switch (key){
				case "SI": 
					isKeyOk= key;
					break;
				case "NO":
					isKeyOk= key;
					break;
				default:
					System.out.print("\n\n\t Opcion no valida. Teclea Si o No. ");
					break;			
			}			
		}
		return isKeyOk; 
	}
	
}
