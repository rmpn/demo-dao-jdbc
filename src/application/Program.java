package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Department obj = new Department(1, "Books");

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ====");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ====");

		Department department = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller sel : list) {

			System.out.println(sel);
		}

		System.out.println("\n=== TEST 3: seller findAll ====");

		List<Seller> lista = sellerDao.findAll();

		for (Seller sel : lista) {

			System.out.println(sel);
		}

		System.out.println("\n=== TEST 4: seller insert ====");

		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);

		sellerDao.insert(newSeller);

		System.out.println("Inserted! new id = " + newSeller.getId());

		System.out.println("\n=== TEST 5: seller update ====");

		seller = sellerDao.findById(1);
		seller.setName("Matha Waine");
		sellerDao.update(seller);

		System.out.println(seller);

		System.out.println("\n=== TEST 6: seller deleteById ====");

		System.out.print("Informe o  ID do Vendendor: ");
		int id = sc.nextInt();
       
		seller = sellerDao.findById(id);
		
		System.out.println(seller);
		sellerDao.deleteById(id);
        sc.close();
	}

}
