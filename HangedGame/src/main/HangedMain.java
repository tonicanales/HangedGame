package main;

import util.FileHelper;

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
	
	private static final int MAX_FAILS = 4;

	
	
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		int score = 10;
		
		HangedBoard board = new HangedBoard();
		HangedModel dictionary = new HangedModel("ahorcado");
		
		
		UserInterface.showMenuInicio(score);
		String option = UserInterface.ScanOpcionMenuInicio();
		
		if (option.equals(UserInterface.OPTION_SALIR)){
			return;
		} else if (option.equals(UserInterface.OPTION_JUGAR)){
			HangedModel.SecretWord secretWord = dictionary.getNextWord();
			board.reset();
			
			startGame()
			
			UserInterface.showMenuBoard(secretWord, secretWord.hint, attepts);

		}
		
		
	}



	private static void startGame() {
		// TODO Auto-generated method stub
		
	}
	
}
