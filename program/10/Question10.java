class ChildThread extends Thread {
    public ChildThread(String name) {
        super(name); // Call the parent (Thread) class constructor to set thread name
    }
    @Override
    public void run() {
        System.out.println(getName() + " is starting.....");
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " operation " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }

        System.out.println(getName() + " is complete.");
    }
}
public class Question10 {
    public static void main(String[] args) {
        System.out.println("Main thread is starting.....");

        ChildThread firstChildThread = new ChildThread("Child_1");
        ChildThread secondChildThread = new ChildThread("Child_2");
        firstChildThread.start();
        secondChildThread.start();

        for(int i=1;i<=3;i++){
            System.out.println("Main thread operation " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        System.out.println("Main thread is complete.");
    }
}