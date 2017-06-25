package main;

import util.FileHelper;
import util.Input;

/**
 *  Aplicación para jugar Ahorcado similar a la publicada en: 
	http://pasatiempos.elmundo.es/ahorcado/ahorcado.html 
	 
	En este caso la interfaz de usuario se realizará mediante línea de comandos
	
	 Caracteristicas :
	 
	-Iniciar partida
	-Al inicio de cada partida debe mostrarse una pista para la palabra secreta (e.j pais, nombre, provincia, etc) 
	-Durante el juego el usuario podrá reiniciar  la palabra secreta, pero la racha ganadora se reiniciará también. 
	-Cuenta regresiva de fallos
	-Racha ganadora actual y récord de racha ganadora ganadora (con nick si es el caso)
	-Mensaje Partida ganada
	-Mensaje Partida perdida
	-Si el jugador supera el récord de la racha ganadora, mensaje felicitación y opción de guardar su nick (archivo).
	-Salir del juego
	-Diccionario con minimo 20 palabras
	

 * @author campino
 *
 */

public class HangedMain {
	
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		int score = 0;
		int attepts = 0;
		int dificultad = 7;
		String opcion = "";
		String option = "";
		int racha = 0;

		HangedModel.SecretWord secretWord;
		
		
		HangedBoard board = new HangedBoard();
		HangedModel dictionary = new HangedModel("ahorcado");

		
		
		do {
		
			UserInterface.showMenuInicio(board.getStreak());
			option = UserInterface.ScanOpcionMenuInicio();
			
			switch (option) {
				case UserInterface.OPTION_SALIR:
					break;
				case UserInterface.OPTION_DIFICULTAD:
					System.out.println("Elige el nivel de dificultad\n1 (f�cil) - 2 (medio) - 3 (experto)");
					int dif = Input.scannInt();
					while (dif != 1 && dif !=2 && dif!=3){
						System.out.println("opcion no v�lida, pon 1, 2 o 3");
						dif = Input.scannInt();
					}
					if (dif ==1) dificultad = 9;
					else if (dif == 5) dificultad = 5;
				case UserInterface.OPTION_JUGAR:
					board.reset();
					secretWord = dictionary.getNextWord();
					board.startGame(secretWord.word, dificultad);

					do {
						UserInterface.showMenuBoard(board.wordPlayer, secretWord.hint, board.getCurrentfails());
						opcion = UserInterface.scannOpcionMenuBoard();
						
						switch (option) {
						case UserInterface.OPTION_SALIR:
							break;
						case UserInterface.OPTION_RESET:
							board.startGame(dictionary.getNextWord().word, board.getMaxFails());
							board.reset();
							break;
						default:
							while (board.hasLetterInWordPlayer(opcion.charAt(0))){
								System.out.println("Esta letra ya la has puesto");
								opcion = UserInterface.scannOpcionMenuBoard();

							}
							
							int[] aciertos = board.addLetterToWordPlayer(opcion.charAt(0));
							if (aciertos.length==0) board.setCurrentFails(++attepts);
							score += aciertos.length;
							
							if (board.getCurrentfails() == dificultad) {
								attepts = 0;
								score = 0;
								racha = 0;
								board.setStreak(racha);
								UserInterface.showMenuAgain(false, board.getStreak());
								if (UserInterface.scannOptionMenuEndGame().equals("SI")){
								option = UserInterface.OPTION_JUGAR;
								opcion = UserInterface.OPTION_SALIR;
								} else {
									opcion = UserInterface.OPTION_SALIR;
									option = UserInterface.OPTION_SALIR;
								}							}

							if (score == secretWord.word.length()){
								UserInterface.showMenuBoard(board.wordPlayer, secretWord.hint, board.getCurrentfails());
								attepts = 0;
								score = 0;
								board.setStreak(++racha);
								UserInterface.showMenuAgain(true, board.getStreak());
								if (UserInterface.scannOptionMenuEndGame().equals("SI")){
								option = UserInterface.OPTION_JUGAR;
								opcion = UserInterface.OPTION_SALIR;
								} else {
									opcion = UserInterface.OPTION_SALIR;
									option = UserInterface.OPTION_SALIR;
								}
							}
							break;
						}

					}	while (!opcion.equals(UserInterface.OPTION_SALIR));
					break;
			}

	} while(!option.equals("salir"));	
		
		System.out.println("Adi�s");

		

	
}
	
}
