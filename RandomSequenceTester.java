import java.util.Scanner;

/* This is the tester for the 
RandomSequenceGenerator.java file. */

public class RandomSequenceTester {
	/* Main Program, takes an integer input
	and generates a sequence of that length */
	public static void main(String[] args){
		RandomSequenceGenerator sim = new RandomSequenceGenerator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the sequence length:");
		int length = scan.nextInt();
		String newSeq = sim.generateSequence(length);
		System.out.println("Here is your sequence: " + newSeq);
	}
}
