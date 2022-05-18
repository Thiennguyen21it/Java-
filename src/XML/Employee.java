package XML;

public class Employee {
    private  String ID;
    private  String Firstname;
    private  String Lastname;
    private  int Age;
    private  double Salary;

    public Employee(String ID, String firstname, String lastname, int age, double salary) {
        this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Age=" + Age +
                ", Salary=" + Salary +
                '}';
    }

}
