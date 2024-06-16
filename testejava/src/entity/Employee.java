package entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {
	
	private BigDecimal salary;
	private String function;
	
	
	public Employee() {
		
	}
	
	public Employee(String name, LocalDate dateOfBirth, BigDecimal salary, String function) {
		super(name, dateOfBirth);
		this.salary = salary;
		this.function = function;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	
	public void highSalary(BigDecimal percentege) {
		this.salary = this.salary.add(this.salary.multiply(percentege));
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		return super.toString() + ", Salary: R$ " + decimalFormat.format(salary) + ", Function: " + function;
	}
	
	
	
	
	
	
	
}
