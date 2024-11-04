class box {
    int a,b;

    box(){
        this.a=100;
        this.b=200;
    }
    box(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void add() {
        int c = a + b;
        System.out.println("addition of 2 number"+c);
    }
    void sub(){
        int c = a - b;
        System.out.println("subtraction of 2 number"+c);
    }
    void display() {
        System.out.println("Box with dimensions: a = " + a + ", b = " + b);
    }
}

class boxWeight extends box {
    int c;
    boxWeight(int a,int b,int c){
        super(a, b);
        this.c=c;
    }
    void multiply(){
        int d=a*b*c;
        System.out.println("multiply of 3 number "+d);
    }
    void multiply(int a,int b){
        System.out.println("mutiply of 2 number "+a*b);
    }
    // Overriding the display method
    void display() {
        System.out.println("Overidding BoxWeight with additional dimension c = " + c);
    }
}

public class oops01 {
    public static void main(String[] args) {
        boxWeight bw = new boxWeight(10, 20, 15);

        System.out.println();
        bw.add();       // Adds a and b from the base class
        bw.sub();       // Subtracts a and b from the base class
        bw.multiply();  // Multiplies a, b, and c
        bw.multiply(5, 4); // Multiplies two numbers using the overloaded method
        bw.display();

        System.out.println();

        box bw1 = new box(1,2);
        bw1.display();

        box bw2 = new box();
        bw2.display();

    }
}