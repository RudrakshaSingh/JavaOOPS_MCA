//copy constructor


class copy{
    int a;
    String b;

    copy(){
        this.a=10;
        this.b="ten";
    }
    copy(int a,String b){
        this.a=a;
        this.b=b;
    }
    copy(copy aaa){
        this.a=aaa.a;
        this.b=aaa.b;
    }
    void display(){
        System.out.println("elements are "+a+" and "+b);
    }
}
public class oops03 {
    public static void main(String[] args) {
        copy a=new copy(11,"eleven");
        a.display();

        copy b=new copy(a);
        b.display();

        a.a=12;
        a.display();

        b.display();

    }
}