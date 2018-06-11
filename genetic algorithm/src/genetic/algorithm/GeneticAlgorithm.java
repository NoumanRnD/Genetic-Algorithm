 
package genetic.algorithm;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.ArrayUtils; 
public class GeneticAlgorithm {

   static  int Population = 0;
    
    public static void main(String[] args) {
        //binary 
    FitnessCalculations.setSolution("1111000000011110000000000000000000000001111000000000000000001111");
 
      int[] a = new int[100];
         Population myPopobj = new Population(50, true);
        
       
     
        while (myPopobj.getFittest().getFitness() < FitnessCalculations.getMaxFitness()) {
          
            Population++;
               a [Population] = myPopobj.getFittest().getFitness();
            System.out.println("Population: " + Population + " Fittest: " + myPopobj.getFittest().getFitness());
          
            myPopobj = Algorithm.evolvePopulation(myPopobj);
        }
        
        List b = Arrays.asList(ArrayUtils.toObject(a));
        System.out.println("Solution found!");
        System.out.println("Population: " + Population);
        System.out.println("max fitness: " +Collections.max(b));
       System.out.println("Average fitness: " + calculateAverage(b));
        System.out.println("Genes:");
        System.out.println(myPopobj.getFittest());

    }
    private static double calculateAverage(List <Integer> marks) {
   Integer sum = 0;
  if(!marks.isEmpty()) {
    for (Integer mark : marks) {
        sum += mark;
    }
    return sum.doubleValue() / marks.size();
  }
  return sum;
}
}
