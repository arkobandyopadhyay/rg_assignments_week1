import java.util.ArrayList;
class Employee{
    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name , String department){
        this.id=id;
        this.name=name;
        this.department=department;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + "]";
    }
}
public class EmployeeCRUD {
    private ArrayList<Employee> employees=new ArrayList<>();
    
    // Create
    public void addEmployee(Employee e){
        employees.add(e);
        System.out.println("Added:"+e);
    }

    //Read
    public void listEmployees(){
        System.out.println("Employee List:");
        for(Employee e:employees){
            System.out.println(e);
        }
    }

    //Update
    public boolean updateEmployee(int id, String newName , String newDepartment){
        for(Employee e:employees){
            if(e.getID()==id){
                e.setName(newName);
                e.setDepartment(newDepartment);
                System.out.println("Updated :"+e);
                return true;
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    //Delete
    public boolean deleteEmployee(int id){
        for(Employee e:employees){
            if(e.getID()==id){
                employees.remove(e);
                System.out.println(e);
                return true;
            }
        }
        System.out.println("Employee not found");
        return false;
    }
    public static void main(String [] args){
          EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Arko", "SE"));
        crud.addEmployee(new Employee(2, "Arghya", "HR"));

        // Read
        crud.listEmployees();

        // Update
        crud.updateEmployee(1, "Arko Bandyopadhyay", "SDE");

        // Delete
        crud.deleteEmployee(2);

        // Final list
        crud.listEmployees();
    }
    
}
