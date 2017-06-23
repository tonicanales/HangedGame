package main;

import util.FileHelper;

/**
 * Esta clase funciona como diccionario de palabras. Las palabras se guardaran en un archivo, cada linea 
 * correspondera a un par palabra:pista
 * 
 * @author campino
 *
 */
public class HangedModel {
	
	private String[] Words;
	final String FILE_NAME;

	public HangedModel(String fileDictionary){
		FILE_NAME = fileDictionary;
		loadWords();
	}
	
	
	/**
	 * Carga todo el diccionario de palabras desde el fichero
	 */
	private void loadWords(){
		Words = FileHelper.readFile(FILE_NAME);
	}
	
	/**
	 * retorna una palabra seleccionada aleatoriamente del arreglo newWord
	 * si no hay mas palabras disponibles en newWord, reinicia los arreglos. 
	 * es decir carga nuevamente las palabras desde el fichero con loadWords()
	 * @return
	 */
	public SecretWord getNextWord(){
		if (Words.length==0){
			loadWords();
		}
		int num = Words.length;
		int aleatorio = (int) (Math.random()*Words.length);
		SecretWord nuevapalabra = new SecretWord(Words[aleatorio]);
		removeFromNewWords(aleatorio);
		return nuevapalabra;
	}

	private void removeFromNewWords(int aleatorio) { 
		String[] copyWord = new String[Words.length-1];
		for (int i=0, j=0; i<copyWord.length; i++, j++){
			if(i==aleatorio) {
				j++;
			}
			copyWord[i]=Words[j];
		}
		Words=copyWord;		
	}
	
	public static class SecretWord{
		
		public final String word;
		public final String hint;
		
		private SecretWord(String fileLineWord){
			String value[] = fileLineWord.split(":");
			this.word = value[0];
			this.hint = value[1];
	}
		
		
		
		
	}	

	
	
}
