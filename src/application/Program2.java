package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		List<Department> list = new ArrayList<>();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=====Test 1: findById =====");
		
        Department dep = departmentDao.findById(1);
        System.out.println(dep);
        
        
        System.out.println("=====Test 2: findALL =====");
        
        list = departmentDao.findAll();
        
        for (Department d : list) {
			
        	System.out.println(d);
		}
        
        System.out.println("=====Test 3: insert =====");
        
        Department department = new Department("Services");
        System.out.println(department);
        departmentDao.insert(department);
        
        System.out.println("=====Test 4: update =====");
        department = departmentDao.findById(7);
        department.setName("Finanças");
        departmentDao.update(department);
        
        
        
	}

}
