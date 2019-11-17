public class PassByValue {
    public static void method(Person p ){
        p = new Person();
    }

    public static void main(String...args) {
        Person p = new Person();
        p.age = 100;
//      传递的是 对象的引用（p存储的值），但不涉及解引用操作，因此无法修改对象的内容；
        method(p);
        System.out.println(p.age);
    }
}
class Person{
    int age;
}
