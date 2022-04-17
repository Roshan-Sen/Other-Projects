import java.util.Scanner;

/**
 * This tests the RandomSequenceGenerator.
 *
 * @author Roshan Sen
 * @version 04/17/2022
 */
public class RandomSequenceTester {
    public static void main(String[] args){
        RandomSequenceGenerator randomizer = new RandomSequenceGenerator();
        System.out.println(randomizer.randomOrf(8));
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter length of new random sequence: ");
        int length = scan.nextInt();
        String newSequence = randomizer.randomSequence(length);
        System.out.println("Here is the sequence: " + newSequence);
    }
}
