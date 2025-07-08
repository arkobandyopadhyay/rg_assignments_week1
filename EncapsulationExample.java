public class EncapsulationExample {
    // Step 1: Make fields private
    private String name;
    private int age;

    // Step 2: Provide public getters and setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > 0) {
            age = newAge;
        } else {
            System.out.println("Invalid age!");
        }
    }

    // Testing encapsulation
    public static void main(String[] args) {
        EncapsulationExample s = new EncapsulationExample();
        s.setName("Arko Bandyopadhyay");
        s.setAge(22);

        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
    }
}
