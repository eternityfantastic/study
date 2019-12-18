public class SystemUtilf {

    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }


    public static void main(String[] args) {
//        admin来自是同一块常量池
        System.out.println(isAdmin("admin"));//true
//        Admin 和 admin不是同一块常量池
        System.out.println(isAdmin("Admin"));//false
    }
}
