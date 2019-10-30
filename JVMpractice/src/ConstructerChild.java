public class ConstructerChild extends ConstructerParent {
    {age = 11;}
    //int age = 10;
    ConstructerChild(int age) {
        super();
        this.age = age;
        show();
    }

    @Override
    public void show() {
        System.out.println("I'm son   "+age);
    }
}
