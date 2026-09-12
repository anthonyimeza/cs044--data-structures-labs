
import java.util.Random;

public class Ecosystem {
    private Animal[] river;
    private Random random;

    private void addRandom(Animal a){
        int attempts = 0;
        while(attempts < river.length){
            int index = random.nextInt(river.length);
            if (river[index] == null){
                river[index] = a;
                break;
            }
            attempts++;
        }
    }

    private void spawnChild(Animal[] targetRiver, Animal child){
        int start = random.nextInt(targetRiver.length);

        for (int i = 0; i < targetRiver.length; i++){
            int index = (start + i) % targetRiver.length;
            if (targetRiver[index] == null){
                targetRiver[index] = child;
                return;
            }
        }

    }

    public Ecosystem(int riverSize, int numBears, int numFish) {
        this.river = new Animal[riverSize];
        this.random = new Random();


        for (int i = 0; i < numBears; i++){
            addRandom(new Bear());
        }
        for (int i = 0; i < numFish; i++){
            addRandom(new Fish());
        }
    }

    public void runStep(){

        Animal[] newRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal currentAnimal = river[i];
            if (currentAnimal == null) continue;

            int move = random.nextInt(3) - 1;
            int target = i + move;

            if (target < 0 || target >= river.length) {
                target = i;
            }

            Animal occupier = newRiver[target];

            if (occupier == null) {
                newRiver[target] = currentAnimal;
            } else if (currentAnimal.getClass() == occupier.getClass()){

                newRiver[i] = occupier;
                spawnChild((newRiver), currentAnimal instanceof Bear ? new Bear() : new Fish());
            } else {
                newRiver[target] = (currentAnimal instanceof Bear) ? currentAnimal : occupier;
            }
        }

        this.river = newRiver;
    }

    public void visualize(){
        for (Animal animal : river){
            System.out.print(animal == null ? "-" : animal.toString());
        }
        System.out.println();
    }

    public static void main(String[] args){
        Ecosystem eco = new Ecosystem(20, 3, 6);
        eco.visualize();

        for(int step = 0; step < 6; step++){
            eco.runStep();
            eco.visualize();
        }

    }
}