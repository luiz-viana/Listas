package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("How many employees will be registered? ");
		int x = sc.nextInt();

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < x; i++) {
			System.out.println("ID: ");
			int id = sc.nextInt();
			while(hasId(list, id)) {
				System.out.println("This id already taken! try another id! ");
				id = sc.nextInt();
			}
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary: ");
			double salary = sc.nextDouble();

			Employee aux = new Employee(id, name.toUpperCase(), salary);

			list.add(aux);
		}

		System.out.println("==========list=========");
		for (Employee pessoa : list) {
			System.out.println("Employee #" + (list.indexOf(pessoa) + 1));
			System.out.println("ID: " + pessoa.getId());
			System.out.println("Name: " + pessoa.getName());
			System.out.printf("Salary: %.2f$ \n" , pessoa.getSalary());
			System.out.println();
		}

		System.out.println("Enter the employee ID that will have a salary increase: ");
		int idIncreaseSalary = sc.nextInt();
		
		//Employee emp = list.stream().filter(x -> x.getId() == idIncreaseSalary).findFirst().orElse(null);
		
		Integer pos = position(list, idIncreaseSalary);
		if (pos == null) {
			System.out.println("This id does not exist! ");		
		}else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			list.get(pos).increaseSalary(percentage);
		}

		

		System.out.println("==========list-updated=========");
		for (Employee pessoa : list) {
			System.out.println("Employee #" + list.indexOf(pessoa) + 1);
			System.out.println("ID: " + pessoa.getId());
			System.out.println("Name: " + pessoa.getName());
			System.out.println("Salary: " + pessoa.getSalary());
			System.out.println();
		}

		for (Employee emp : list) {
			System.out.println(emp.toString());
		}
		
	}
	
	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return 1;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
	
	
}
