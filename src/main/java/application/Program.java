package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();

        System.out.print("Enter the number of Employees: ");
        int qtd = input.nextInt();

        for(int i=1; i<=qtd; i++){
            System.out.println("\nEmployee #" + i +" Data: ");
            System.out.print("\nOutsourced (y/n)? ");
            char op = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Hours: ");
            int hours = input.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();
            if (op == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = input.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employee.add(emp);
            }else{
                Employee emp = new Employee(name, hours, valuePerHour);
                employee.add(emp);
            }
        }

        System.out.println("\nPAYMENTS:");
        for(Employee emp : employee){
            System.out.print("\n" + emp.getName() + " - $" + String.format("%.2f", emp.payment()));
        }

        input.close();
    }
}
