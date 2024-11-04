class Box {
    double width;
    double height;
    double length;

    Box() {
        this.width = 0;
        this.height = 0;
        this.length = 0;
    }

    Box(double len, double h, double w) {
        this.width = w;
        this.height = h;
        this.length = len;
    }

    double volume() {
        return height * width * length;
    }

    double volume(double len, double width, double height) {
        return len * width * height;
    }

    void display() {
        System.out.println("Box Dimensions " + width + " * " + height + " * " + length);
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(){
        super();//call def constructor from above
        this.weight = 1000;

    }
    //constructor with four parameters
    BoxWeight(double width,double height,double length, double weight){
        super(width,height,length);
        this.weight = weight;
    }

    void display() {
        super.display();
        System.out.println("Weight of Box " + weight);
    }

}

public class oops02 {
    public static void main(String[] args) {
        Box box = new Box(3, 4, 5);
        System.out.println("Box Volume " + box.volume());
        box.display();

        BoxWeight boxWeight = new BoxWeight(2, 3, 4, 5.5);
        System.out.println("Boxweight volume " + boxWeight.volume());
        boxWeight.display();

        System.out.println();
        BoxWeight boxWeight2 = new BoxWeight();
        boxWeight2.display();
    }
}