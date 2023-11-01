import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortedLinkedListLab sortedLinkedListLab = new SortedLinkedListLab(true);
        Cat[] cats = new Cat[10];
        for (int i = 0; i < cats.length; i++) {
            Random rand = new Random();
            cats[i] = new Cat((i + 5) * rand.nextInt(10), (i + 3) * rand.nextInt(10));
            sortedLinkedListLab.add(cats[i]);
        }
        System.out.println(sortedLinkedListLab);

        System.out.println(sortedLinkedListLab.find(cats[3]) ? "Found!" : "Not found!");
        Cat newCat = new Cat(cats[1].getHeight(), cats[1].getWeight() + 3);
        System.out.println(sortedLinkedListLab.find(newCat) ? "Found!" : "Not found!");

        sortedLinkedListLab.delete(cats[4]);
        System.out.println(sortedLinkedListLab);
        sortedLinkedListLab.delete(newCat);
        System.out.println();

        sortedLinkedListLab.reverse();
        System.out.println(sortedLinkedListLab);
    }
}
