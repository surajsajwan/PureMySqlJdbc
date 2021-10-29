package com.greycampus;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMysqlJdbc {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which operation to perform");
		int choice = sc.nextInt();
		GetSet gs = new GetSet();
		switch (choice) {
		case 1: {
			System.out.println("Enter employee no");
			int eno = sc.nextInt();
			System.out.println("Enter employee name");
			String name = sc.next();
			System.out.println("ENter employee salary");
			double salary = sc.nextDouble();
			gs.setEno(eno);
			gs.setName(name);
			gs.setSalary(salary);
			InsertMysqlJdbc insertMysqlJdbc = new InsertMysqlJdbc();
			insertMysqlJdbc.insert(gs);
			break;
		}
		case 2:{
			DisplayDataMySql dsp = new DisplayDataMySql();
			ArrayList<GetSet> obj = dsp.display();
			obj.forEach(a ->{
				System.out.println(a.getEno());
				System.out.println(a.getSalary());
				System.out.println(a.getName());
			});
			break;
		}
		default:
			System.out.println("Not selected a valid choice ");
		}
	}

}
