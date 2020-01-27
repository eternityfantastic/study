public class CompareByAge implements Compare<Employ> {

    @Override
    public boolean compare(Employ emp) {
        if(emp.age>18){
            return true;
        }
        return false;
    }
}
