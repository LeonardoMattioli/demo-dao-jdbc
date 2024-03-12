package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("========= TESTE 1: seller findbyid ============");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n========= TESTE 2: seller findbydepartment ============");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n========= TESTE 3: seller findAll ============");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n========= TESTE 4: seller insert ============");
        Seller newSeller = new Seller(null, "Leonardo", "leonardo@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted new id = " + newSeller.getId());

        System.out.println("\n========= TESTE 5: seller update ============");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Updated");
    }
}