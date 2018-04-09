class DNARow {
	int maxNumberOfElements;
	DNA[] DNAArray;
	int numberOfElements;
	
	DNARow(){
		maxNumberOfElements = 0;
		DNAArray = new DNA[maxNumberOfElements];
		numberOfElements = 0;
	}
	
	DNARow(int maxNumberOfElements){
		this.maxNumberOfElements = maxNumberOfElements;
		DNAArray = new DNA[maxNumberOfElements];
		numberOfElements = 0;
	}
	
	void add(DNA DNAToAdd){
		DNAArray[numberOfElements] = DNAToAdd;
		numberOfElements += 1;
	}
	
	DNA get(int position){
		return DNAArray[position];
	}
}
