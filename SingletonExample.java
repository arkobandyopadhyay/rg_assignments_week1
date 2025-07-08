public class SingletonExample {
    // Step 1: Create a private static variable to hold the single instance
    private static SingletonExample instance;

    // Step 2: Make the constructor private so that new objects can't be created
    private SingletonExample() {
        System.out.println("Singleton instance created");
    }

    // Step 3: Provide a public static method to return the single instance
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample(); // create the instance if it doesn't exist
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonExample obj1 = SingletonExample.getInstance();

        SingletonExample obj2 = SingletonExample.getInstance();
        System.out.println("Are obj1 and obj2 same? " + (obj1 == obj2));
    }
}
