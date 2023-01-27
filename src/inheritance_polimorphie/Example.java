package inheritance_polimorphie;


/**
 *      Depends on the arguments used in the method of the class
 *      Top a = new Middle();
 *      a.m(tm) will try to execute the method in class Middle
 *      if it doesn't find method m(with the right argument)
 *      implemented in class Middle it will execute method m
 *      implemented in CLass Top (Declared Type)
 *
 *      public void animalSound(Animal a){
 *             System.out.println("Class Lion - animalSound(Animal)");}
 *
 */
public class Example {

    public static class Animal{
        public void animalSound(){
            System.out.println("Class Animal - animalSound()");
        }

        public void animalSound(Animal a){
            System.out.println("Class Animal - animalSound(Animal)");
        }
    }

    public static class Giraffe extends Animal{
        public void animalSound(){
            System.out.println("Class Giraffe - animalSound()");
        }
        public void animalSound(Animal a){
            System.out.println("Class Giraffe - animalSound(Animal)");
        }
        public void animalSound(Giraffe a){
            System.out.println("Class Giraffe - animalSound(Giraffe)");
        }
    }

    public static class Lion extends Animal{

        public void animalSound(){
            System.out.println("Class Lion - animalSound()");
        }



        public void animalSound(MountainLion x){
            System.out.println("Class Lion - animalSound(MountainLion)");

        }
    }

    public static class MountainLion extends Lion {
        public void animalSound() {
            System.out.println("Class MontainLion - animalSound()");
        }

        public void animalSound(Giraffe a) {
            System.out.println("Class MontainLion - animalSound(Giraffe)");
        }

        public void animalSound(Animal a){
            System.out.println("Class Animal - animalSound(Animal)");
        }
    }


    public static void main(String[] args){
        Animal myLion = new Lion();
        Animal myMountainLion = new MountainLion();
        Lion lionMountainLion =  new MountainLion();

        //(Top Animal = Middle Lion).animalSound(Top Animal = Bottom MountainLion)
        myLion.animalSound(myMountainLion);
        myLion.animalSound(lionMountainLion);

        myMountainLion.animalSound(myLion);
        myMountainLion.animalSound(lionMountainLion);

        myMountainLion.animalSound(new Lion());
        new MountainLion().animalSound(myMountainLion);
    }

    public static void animalCombination(){
        Animal animalAnimal = new Animal();
        Animal animalGiraffe = new Giraffe();
        Animal animalLion = new Lion();
        Animal animalMontain = new MountainLion();

        Lion lionLion = new Lion(); //Lion aa = new Animal() nao pode
        // nao pode Lion LionGiraffe = new Giraffe();
        Lion lionMountain = new MountainLion();
        Giraffe giraffeGiraffe = new Giraffe();
        MountainLion momoLion = new MountainLion();

        System.out.println("\tAnimal");
        animalAnimal.animalSound();
        animalGiraffe.animalSound();
        animalMontain.animalSound();
        animalLion.animalSound();

        animalAnimal.animalSound(giraffeGiraffe);
        animalAnimal.animalSound(lionLion);
        animalGiraffe.animalSound(animalMontain);
        // System.out.println("Giraffe");


        System.out.println("\tLion");
        lionLion.animalSound();
        lionLion.animalSound(animalAnimal);
    }
}
