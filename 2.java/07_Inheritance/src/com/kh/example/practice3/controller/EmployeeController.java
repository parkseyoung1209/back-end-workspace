package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController extends Employee{
	private Employee employee = new Employee();
	
	
	//overloading

	public void add(int emp_no, String name, char gender, String phone) {
		employee.setEmp_no(emp_no);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		
	}
	public void add(int emp_no, String name, char gender, String phone, String dept, int salary,double bonus) {
		employee.setEmp_no(emp_no);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}
	public void modify(String phone) {
		employee.setPhone(phone);
	}
	public void modify(int salary) {
		employee.setSalary(salary);
	}
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	public Employee info() {
		return employee;
	}
	
}
