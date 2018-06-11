 
package genetic.algorithm;

public class FitnessCalculations {

    

    static byte[] solution = new byte[64];

    
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    
    static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
         
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    
    static int getFitness(SinglePerson individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our cadidates
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
    }
    
    
    static int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}