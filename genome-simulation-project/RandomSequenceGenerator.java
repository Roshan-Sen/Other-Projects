import java.util.Random;
/**
 * Generates random DNA sequences. Can also 
 * generate open reading frames for prokaryotic 
 * genomes.
 *
 * @author Roshan Sen
 * @version 04/17/2022
 */
public class RandomSequenceGenerator {
    private double[] baseProbs;
    private String[] peptideCodons;
    private String[] stopCodons;
    /**
     * Constructor for objects of class RandomSequenceGenerator
     */
    public RandomSequenceGenerator() {
        this.setCodons();
        baseProbs = new double[]{0.25, 0.25, 0.25, 0.25}; //{A,C,G,T}
    }
    
    /**
     * Sets the values of the codon lists.
     */
    private void setCodons(){
        peptideCodons = new String[61];
        stopCodons = new String[3];
        int pepIndex = 0;
        int stopIndex = 0;
        String nts = "ACGT";
        for(int i = 0; i < nts.length(); i++){
            for(int j = 0; j < nts.length(); j++){
                for(int k = 0; k < nts.length(); k++){
                    String currentCodon = nts.substring(i, i + 1) + 
                        nts.substring(j, j + 1) + nts.substring(k, k + 1);
                    if(currentCodon.equals("TAA") || currentCodon.equals("TAG") ||
                        currentCodon.equals("TGA")){
                        stopCodons[stopIndex] = currentCodon;
                        stopIndex++;
                    } else{
                        peptideCodons[pepIndex] = currentCodon;
                        pepIndex++;
                    }
                }
            }
        }
    }
    
    /**
     * Builds a random open reading frame with
     * a stop codon. This applies to prokaryotic 
     * ORFs because this method does not add
     * introns.
     * @param length - length of the ORF in amino acids
     * @return String - a new sequence
     */
    public String randomOrf(int length){
        String newOrf = "ATG";
        Random rand = new Random();
        for(int i = 0; i < length - 2; i++){
            int codonIndex = rand.nextInt(peptideCodons.length);
            newOrf += peptideCodons[codonIndex];
        }
        int stopIndex = rand.nextInt(stopCodons.length);
        newOrf += stopCodons[stopIndex];
        return newOrf;
    }
    
    /**
     * Sets the probabilities of each base
     * @param an array of double probabilities
     */
    public void setBaseProbs(double[] newProbs){
        baseProbs = newProbs;
    }
    
    /**
     * Gets the base probabilities.
     * @return baseProbs
     */
    public double[] getBaseProbs(){
        return baseProbs;
    }
    
    /**
     * Builds a random sequence based on the probabilities
     * of each base in the object.
     * @param length - length of the sequence in nucleotides
     * @return newSequence - a random sequence
     */
    public String randomSequence(int length){
        String newSequence = "";
        String[] nucleotides = new String[]{"A", "C", "G", "T"};
        Random rand = new Random();
        for(int i = 0; i < length; i++){
            int nt = rand.nextInt(nucleotides.length);
            newSequence += nucleotides[nt];
        }
        return newSequence;
    }
}
