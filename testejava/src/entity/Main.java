package entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(
	            new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
	            new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
	            new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
	            new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
	            new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
	            new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
	            new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
	            new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
	            new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
	            new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
				));
		
		System.out.println("\n");
		System.out.println("Removendo o João da lista \n");
		employees.remove(1);
		
		System.out.println("\n");
		System.out.println("Imprimindo a lista de funcionarios");
		employees.forEach(System.out::println);
		
		System.out.println("\n");
		System.out.println("Aumentar salario e 10%");
		for(Employee emp : employees) {
			BigDecimal higher = emp.getSalary().multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100));
			emp.setSalary(emp.getSalary().add(higher));
		}
		
		System.out.println("\n");
		System.out.println("Agrupando funcionarios por funcao");
		Map<String, List<Employee>> employeeFunctions = employees.stream()
				.collect(Collectors.groupingBy(Employee::getFunction));
		
		System.out.println("\n");
		System.out.println("Imprimindo funcionarios por funcao");
		employeeFunctions.forEach((function, list) -> {
			System.out.println("funcao " + function);
			list.forEach(System.out::println);
		});
		
		System.out.println("\n");
		System.out.println("Funcionarios com aniversario nos meses 10 e 12");
		employees.stream().filter(emp -> emp.getDateOfBirth().getMonthValue() == 10 || emp.getDateOfBirth().getMonthValue() == 12)
		.forEach(System.out::println);
		
		System.out.println("\n");
		System.out.println("Mostrando funcionario mais velho");
		Employee older = Collections.max(employees, Comparator.comparing(Employee::getDateOfBirth));
		int yearOlder = LocalDate.now().getYear() - older.getDateOfBirth().getYear();
		System.out.println("Funcionario com maior idade " + older.getName() + "idade " + yearOlder);
	
		System.out.println("\n");
		System.out.println("Funcionarios em ordem alfabetica");
		employees.stream()
		.sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		
		System.out.println("\n");
		System.out.println("Soma dos salarios dos funcionarios");
		BigDecimal allSalaryEmployers = employees.stream()
				.map(Employee::getSalary)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Total dos salarios" + String.format("%,.2f", allSalaryEmployers));
		
		
		System.out.println("\n");
		System.out.println("Quantos salarios minimos cada funcionario ganha");
		BigDecimal minimumWage = new BigDecimal("1212.00");
		employees.forEach(emp -> {
			BigDecimal minimumWages = emp.getSalary().divide(minimumWage, 2, RoundingMode.HALF_UP);
			System.out.println(emp.getName() + " = " + minimumWages + "salario minimos");
		});
		
		
		
	}	
		
	
	
	
	
}
