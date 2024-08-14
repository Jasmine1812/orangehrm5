package staticVariable;

public class EmployeeObject {
    public static EmployeeObject getEmployeeObject(){
        return new EmployeeObject();
    }

    public static final String FIRST_NAME =  "Nguyen";
    public static final String MIDDLE_NAME =  "Trong";
    public static final String LAST_NAME =  "Bia";

}
