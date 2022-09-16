import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Company {
    Scanner sc = new Scanner(System.in);
    Map<String, Employee> companyMap = new HashMap<>();

    public void Company(){

        String choice = "start";
        while (!choice.equals("exit")) {
            choice = loopChoice();
            switch (choice){
                case "add":
                    companyMap = createMap(companyMap);
                    break;
                case "find":
                    findEmployeeData(companyMap);
                    break;
                case "exit":
                    System.out.println("App closed.");
                    break;
            }



        }
    }

    private void findEmployeeData(Map<String,Employee> companyMap) {
        System.out.print("Searched name: ");
        String fname = sc.nextLine();
        System.out.print("Searched last name: ");
        String lname = sc.nextLine();
        String key = fname+lname;
        if(companyMap.containsKey(key))
            System.out.println(companyMap.get(key));
    }

    private String loopChoice() {
        System.out.println("Please choose action:");
        System.out.println("Addign new Employee - type add");
        System.out.println("Find Employee data - type find");
        System.out.println("Close app - type exit");
        return sc.nextLine().toLowerCase();
    }

    private Map<String,Employee> createMap(Map<String, Employee> companyMap) {
        String choice = "no";
        while (!choice.equals("yes")) {
            Employee employee = createEmployee();
            companyMap.put(employee.getFirstName()+employee.getLastName(), employee);
            System.out.println("Would You like to finish creating employees?");
            System.out.println("Type yes to exit this module.");
            choice = sc.nextLine().toLowerCase();

        }
        return companyMap;
    }

    private Employee createEmployee(){
         String firstName, lastName;
         double salary;
        System.out.print("Please provide employees name: ");
        firstName = sc.nextLine();
        System.out.println();
        System.out.print("Please provice employees last nama: ");
        lastName = sc.nextLine();
        System.out.println();
        System.out.print("Please assing salary to employee: ");
        salary = sc.nextDouble();
        sc.nextLine();
        System.out.println();
        return  new Employee(firstName,lastName,salary);
    }

}
