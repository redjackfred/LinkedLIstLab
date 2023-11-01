public class Cat implements Comparable<Cat> {
    private int weight;
    private int height;
    private static int index;
    private int catNumber;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.catNumber = index;
        index++;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                ", No." + catNumber +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        if(this.weight > o.weight){
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else{ // If two cats are the same weight, then we compare their height
            if(this.height > o.height){
                return 1;
            }else if(this.height < o.height){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}
