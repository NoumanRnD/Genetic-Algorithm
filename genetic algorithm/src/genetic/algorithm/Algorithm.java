 
package genetic.algorithm;

public class Algorithm {

   
    private static final double crossoveruniformRate = 1;
    private static final double mutationRate = 0.035;
    private static final int matchsize = 5;
    private static final boolean bestcheck = true;

    
    public static Population evolvePopulation(Population pop) {
        Population populationObject = new Population(pop.size(), false);

        // Keep our best individual
        if (bestcheck) {
            populationObject.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int checkoffset;
        if (bestcheck) {
            checkoffset = 1;
        } else {
            checkoffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = checkoffset; i < pop.size(); i++) {
            SinglePerson indiv1 = tournamentSelection(pop);
            SinglePerson indiv2 = tournamentSelection(pop);
            SinglePerson newIndiv = crossover(indiv1, indiv2);
            populationObject.saveIndividual(i, newIndiv);
        }

        
        for (int i = checkoffset; i < populationObject.size(); i++) {
            mutate(populationObject.getIndividual(i));
        }

        return populationObject;
    }

   
    private static SinglePerson crossover(SinglePerson indiv1, SinglePerson indiv2) {
        SinglePerson newSol = new SinglePerson();
        // Loop through genes
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= crossoveruniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

   
    private static void mutate(SinglePerson indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

  
    private static SinglePerson tournamentSelection(Population pop) {
       
        Population tournament = new Population(matchsize, false);
     
        for (int i = 0; i < matchsize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // Get the fittest
        SinglePerson fittest = tournament.getFittest();
        return fittest;
    }
}