package TypingMonkey;


class DNA {
	
	static final double MUTATION_RATE = .0001;
	static final String TARGET = "to be or not to be",
				 		ALPHABET = "1234567890=qwertyuiopasdfghjklzxcvbnm QWERTY<>?UIOPASDFGHJKLZXCVBNM,.;'[]!@#$%^^^&*()_+";
	
	char[] genes;
	
	
	DNA(){
		genes = new char[TARGET.length()]; 
		for (int i = 0; i<genes.length; i++){
			genes[i] = (char) randomCharGenerator();
		}
	}
	
	char randomCharGenerator() {
		 String alphabet = ALPHABET;
	        int random = (int) (Math.random() * alphabet.length());
	        char result = alphabet.charAt(random);
	        return result;   
	}
	
	double fitness(){
		int numberOfCorrectChars = 0;
		for(int i = 0; TARGET.length() >i; i++){
			if (genes[i] == TARGET.charAt(i)){
				numberOfCorrectChars += 1;
			}
		}
		double fitnessScore = (numberOfCorrectChars/(double)TARGET.length());
		return (fitnessScore*fitnessScore);
		
	}
	
	DNA crossover(DNA partner){
		DNA child = new DNA();
		for (int i=0; i < genes.length; i++){
			if (Math.random()<.5){
				child.genes[i] = genes[i];
			} else {
				child.genes[i] = partner.genes[i];
			}
		}
		return child;
	}
	
	void mutate(){
		for(int i=0; i<genes.length; i++){
			if (Math.random() < MUTATION_RATE){
				genes[i] =  randomCharGenerator();
			}
		}
	}
	
	String getPhrase(){
		String phrase = "";
		for(int i=0; i<genes.length; i++){
			phrase += genes[i]; 
		}
		return phrase;
	}
}
