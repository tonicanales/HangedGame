package main;

import util.Input;

public class UserInterface {
	public static final String OPTION_SALIR = "salir";
	public static final String OPTION_JUGAR = "jugar";
	
	public static void showMenuInicio(int score){
		System.out.println("JUEGO DEL AHORCADO"+ "\n");
		System.out.println("Máxima puntuación: " + score+ "\n");
		System.out.println("Jugar: J"+ "\n");
		System.out.println("Salir: S"+ "\n");
		System.out.println("Dificultad: D"+ "\n");
		System.out.println("Elige una opción");
	}
	
	public static void showMenuBoard(String wordPlayer, String hint, int attepts){		
		if(attepts<2){			
			System.out.println("[SA] Salir");
			System.out.println("[RE] Reset");			
			System.out.println("Pista : " + hint);					
			char[] c = wordPlayer.toCharArray();
						
			for(int i=0; i<c.length;i++){
				System.out.print(c[i] + " ");			
			}				
			System.out.println("Intentos : " + attepts);			
		}		
	}
	
	
	
	
	public static void showMenuAgain(boolean winner){
		
		
	}
	
	
	public static String ScanOpcionMenuInicio(){
		
		String opcion= Input.scannLine().toUpperCase();
		if (opcion.equals("J")){
		} else if (opcion.equals("S")){
			} else if (opcion.equals("D")){
				} else {
					System.out.println("Opcion no válida");
					ScanOpcionMenuInicio();
				}
		return opcion;
	}	
	
	
}
