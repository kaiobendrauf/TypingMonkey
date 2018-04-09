import java.io.PrintStream;
import java.util.Locale;


class TypingMonkey {
	// Name : Katrin Obendrauf
	// Assignment : Typing Monkey
	// Date : 01/10/16
	
	static final int POPULATION_SIZE 			= 1000,
					 MATING_POOL_MULTIPLICATION = 1000,
					 TARGET_THRESHOLD 			= 800,
					 MAX_GENERATIONS 			= 30;
	static final double LOW_MATING_POOL_CUT_OFF	= 0.001,
					    HIGH_MATING_POOL_CUT_OFF= 1.;
	
	PrintStream out;
	
	TypingMonkey() {
		Locale.setDefault(Locale.US);
		out = new PrintStream(System.out);
	}
	
	DNA[] arraySetup(){
		DNA[] result = new DNA[POPULATION_SIZE];
		for(int i =0; i<result.length; i++)	{
			result[i] = new DNA();
		}
		return result;
	}
	
	DNARow createMatingPool(DNA[] population){
		DNARow result = new DNARow((int)(POPULATION_SIZE * MATING_POOL_MULTIPLICATION));
		
		for (int i=0; i<population.length; i++){
			int n;
			
			if(population[i].fitness() > HIGH_MATING_POOL_CUT_OFF){
				n = (int)(HIGH_MATING_POOL_CUT_OFF * (double)MATING_POOL_MULTIPLICATION);
			} else if (population[i].fitness() < LOW_MATING_POOL_CUT_OFF){
				n = (int)(LOW_MATING_POOL_CUT_OFF * (double)MATING_POOL_MULTIPLICATION);
			} else {
				n = (int)(population[i].fitness() * (double)(MATING_POOL_MULTIPLICATION));
			}
		
			for(int ii = 0; ii<n; ii++){
				result.add(population[i]);
			}
		}
		return result;
	}
	
	void start (){
		DNA[] population = arraySetup();
		int generationNumber = 1;
		
		int totalTargetsFound = 0;
		while(true){
			
			int targetFoundCounter = 0;
			for (int i=0; i<population.length; i++){
				DNARow matingPool = createMatingPool(population);
				DNA parentA = matingPool.get((int)(Math.random()*(matingPool.numberOfElements)));
				DNA parentB = matingPool.get((int)(Math.random()*(matingPool.numberOfElements)));
				
				DNA child = parentA.crossover(parentB);
				child.mutate();
				out.printf("%s\t", child.getPhrase());
				
				if(child.getPhrase().equals(child.TARGET)){
					targetFoundCounter += 1;
					totalTargetsFound += 1;
				}
				
				if (targetFoundCounter>=TARGET_THRESHOLD){
					out.printf("\n\nFound %s %d time(s) after %d generations, and %d time(s) this generation.", child.TARGET, totalTargetsFound, generationNumber, targetFoundCounter);
					System.exit(1);
				}
				population[i] = child;
			}
			if (generationNumber == MAX_GENERATIONS){
				out.printf("\n\nFound %s %d time(s) after %d generations, and %d time(s) this generation.", population[0].TARGET, totalTargetsFound, generationNumber, targetFoundCounter);
				System.exit(1);
			}
			out.println("\n");
			generationNumber += 1;
		}

	}
	public static void main(String[] args) {
		new TypingMonkey().start();
	}
}
