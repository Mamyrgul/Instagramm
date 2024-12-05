package dataBase;

public class Counter {
    public static Long userId=1L;
    public static Long counterDepartmentId(){
        return ++userId;
    }
}
