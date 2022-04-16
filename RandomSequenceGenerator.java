import java.util.Random;

/* This program can generate a random DNA sequence
given a set of probabilities in the order of ACGT.
The default constructor gives a sequence of with 
equal probabilities of each base.*/

public class RandomSequenceGenerator {
	private double[] baseProbs;
	
	/* Constructor for the sequence generator. */
	public RandomSequenceGenerator(double[] probs){
		baseProbs = probs;
	}
	
	/* Default constructor for the sequence generator */
	public RandomSequenceGenerator(){
		this(new double[]{0.25, 0.25, 0.25, 0.25});
	}
	
	/* Set method for probabilities */
	public void setProbabilities(double[] newProbs){
		baseProbs = newProbs;
	}
	
	/* Get method for probabilities */
	public double[] getProbabilities(){
		return baseProbs;
	}
	
	/* Sequence generation method */
	public String generateSequence(int length){
		Random rand = new Random();
		String newSequence = "";
		for(int i = 0; i < length; i++){
			double val = rand.nextDouble();
			if(val < baseProbs[0]){
				newSequence += "A";
			} else if(val < baseProbs[1] + baseProbs[0]) {
				newSequence += "C";
			} else if(val < baseProbs[2] + baseProbs[1] + baseProbs[0]){
				newSequence += "G";
			} else {
				newSequence += "T";
			}
		}
		return newSequence;
	}
}
