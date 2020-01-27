public class Employ {
    int age ;
    int salary;
    String name;

    public Employ(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employ{" + "age=" + age + ", salary=" + salary + ", name='" + name + '\'' + '}';
    }
}
