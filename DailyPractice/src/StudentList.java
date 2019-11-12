import java.util.*;

public class StudentList{
    ArrayList<Student> students = new ArrayList<>();
    Random random = new Random();

    StudentList(int size) {
        for (int i = 0; i < size; i++){
            Student s = new Student("伞兵"+i+"号",Integer.toString(i),Math.floor(random.nextDouble()*100));
            students.add(s);
        }
    }
    public void iterCollection(){
//        迭代器一去不复返
        Iterator iterator = students.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

class Student implements Comparable{
    String name;
    String grad;
    double score;

    public Student(String name, String grad, double score) {
        this.name = name;
        this.grad = grad;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", grad='" + grad + '\'' + ", score=" + score + '}';
    }

    @Override
    public int compareTo(Object o) {
        Student stu  = (Student)o;
        return (int) (this.score -  stu.score);
    }
}

class StudentTest {
    public static void main(String[] args) {
        StudentList s1 = new StudentList(5);
        //System.out.println(s1.students);
        s1.iterCollection();
        System.out.println("=============================");
        Collections.sort(s1.students);
        s1.iterCollection();
    }
}
