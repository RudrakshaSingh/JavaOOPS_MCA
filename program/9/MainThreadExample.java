public class MainThreadExample {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("Thread Name: " + mainThread.getName());
        System.out.println("Thread Priority: " + mainThread.getPriority());
        System.out.println();

        mainThread.setName("CustomMainThread");
        mainThread.setPriority(Thread.MAX_PRIORITY); // Settin priority 10
        System.out.println("Thread Name: " + mainThread.getName());
        System.out.println("Thread Priority: " + mainThread.getPriority());
        System.out.println();

        System.out.println("Performing operations within main thread");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread is iterating : " + i);
        }
        System.out.println("Main thread terminates.");
    }
}
