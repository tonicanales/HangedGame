package main;


public class HangedBoard {

	
	/** Arreglo de caracteres que representa la palabra secreta */
	private char wordSecret[]; 
	
	/** Arreglo de caracteres que representa la palabra que el jugador va armando
	 *  al inicio de la partida contiene caracteres '-', tantos como el tamaño de la palabra secreta */
	private char wordPlayer[];
	
	/** fallos cometidos durante la partida actual */
	private int currentfails;
	/** maximo numero de fallos posibles  */
	private int maxFails; 
	/** Partidas ganadas en racha, esto es, consecutivamente */
	private int streak;
	
	
	public HangedBoard(){
		//TODO complete definicion del contructor 
	}
	
	
	/**
	 * Inicia una partida de ahorcado. 
	 * @param secret arreglo de caracteres con la palabra secreta
	 * @param maxFails numero maximo de fallos posibles 
	 */
	public void startGame(char[] secret, int maxFails){
		//TODO complete el metodo 
		
	}
	
	/**
	 * Inicia una partida de ahorcado. 
	 * @param secret String con la palabra secreta
	 * @param maxFails numero maximo de fallos posibles 
	 */
	public void startGame(String secret, int maxFails){
		//TODO complete el metodo 
		
	}
	
	/**
	 * Reinicia todas las variables, el estado del juego queda como al iniciar la aplicacion
	 */
	public void reset(){
		//TODO complete el metodo 
	}
	
	
	public boolean hasLetterInWordSecret(char ch){
		//TODO complete el metodo 
		return false;
	}
	
	public boolean hasLetterInWordPlayer(char ch){
		//TODO complete el metodo 
		return false;
	}
	
	/**
	 * @return si la palabra secreta es igual a la palabra del jugador 
	 */
	public boolean isWinner(){
		return false; 
	}
	
	/**
	 * @return si fails==maxFailsla 
	 */
	public boolean isGameOver(){
		return false; 
	}
	
	
	/**
	 * Si la letra ch hace parte de wordSecret entonces adiciona la letra ch a la palabra del jugador wordPlayer. 
	 * El metodo retorna las posiciones de la palabra donde la letra fue adicionada. 
	 * 
	 * E.j: Si la palabra secreta es  SOLO y la palabra del jugador es  - - L - cuando se llama el metodo 
	 * addLetterToWordPlayer('O') debe retornar un arreglo con las posiciones {1,3}
	 * 
	 * Si la letra ch no hace parte de wordSecret entonces retorna un arreglo de cero elementos.
	 * 
	 * @param  ch letra a agregar a la plabra del jugador wordPlayer
	 * @return arreglo de enteros con las posiciones donde ch fue agregada, si la letra 
	 */
	public int[] addLetterToWordPlayer(char ch){
		if(hasLetterInWordPlayer(ch))
			throw new RuntimeException("Error de programacion, wordPlayer ya contiene esta letra."
					+ " Use el metodo hasLetterInWordPlayer() antes de invicar este metodo");
		
		//TODO completar este metodo
		//TODO desarrollar un Test unitario para este metodo
		return null; 	
	}


	/**
	 * 
	 * @return palabra del jugador wordPlayer
	 */
	public char[] getWordPlayer() {
		return wordPlayer;
	}


	/**
	 * COntador de racha (strak)
	 * @return retorna el numero de partidas ganadas consecutivas
	 */
	public int getStreak() {
		return streak;
	}

	public int getCurrentfails() {
		return currentfails;
	}

	public int getMaxFails() {
		return maxFails;
	}
	
}
