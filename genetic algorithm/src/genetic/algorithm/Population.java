 
package genetic.algorithm;

public class Population {

    SinglePerson[] individuals;
 
    public Population(int populationSize, boolean initialise) {
        individuals = new SinglePerson[populationSize];
     
        if (initialise) {
          
            for (int i = 0; i < size(); i++) {
                SinglePerson newIndividual = new SinglePerson();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

   
    public SinglePerson getIndividual(int index) {
        return individuals[index];
    }

    public SinglePerson getFittest() {
        SinglePerson fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

     
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, SinglePerson indiv) {
        individuals[index] = indiv;
    }

     
}