package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parents.Employee;


public class EmployeeController {
	Employee employee = new Employee();
	// 이름으로 사람 찾기
	public Employee findEmployeeByname(String name, Employee[] empArr) {
			for(int i = 0; i<empArr.length; i++) {
			if(empArr[i].getName().equals(name)) {
				
				return empArr[i];
			}
		} 
			return null;
	}
	// 찾는 사람의 연봉은?
	public int getAnnualSalary(Employee e) {
		if(e instanceof Engineer) {
			Engineer engineer = (Engineer) e;
			return engineer.getSalary() * 12 + engineer.getBonus();
		}
		return e.getSalary() *12;
	}
	//전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(Employee employee : empArr) {
			sum += getAnnualSalary(employee);
		}
		return sum;
	}
}
