package projeto_at_1;
//import mandacaru3.dao.ProductHibernateDAO;
import projeto_at_1.DAO.Imoveis_terrenosHibernateDAO;
import java.sql.Connection;
import java.util.List;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projeto_at_1.DAO.ConnectionFactory;
import projeto_at_1.DAO.Imoveis_terrenosDAO;
import projeto_at_1.DAO.Imoveis_terrenosJDBCDAO;
import projeto_at_1.entities.Imoveis_terrenos;

public class Main {

	public static void main(String[] args) {
		//Connection conn = ConnectionFactory.getConnection();
 
		
		//Imoveis_terrenos im_ter = new Imoveis_terrenos(3, "chacara","tucuns", 211, 170, 3,1,3, 25000);
		
		//Imoveis_terrenosDAO im_terDAO = new Imoveis_terrenosJDBCDAO();
		
		//im_terDAO.delete(4);
		//Imoveis_terrenos aux = im_terDAO.find(1);
		//List<Imoveis_terrenos> list = im_terDAO.findAll();
		//System.out.println(list);
	//	Imoveis_terrenos aux = im_terDAO.findByName("casa");
		//System.out.println(aux);
		 Imoveis_terrenos im_ter = new Imoveis_terrenos(3, "chacara","tucuns", 211, 170, 3,1,3, 25000);
		 
		  Imoveis_terrenosDAO im_terDAO = new Imoveis_terrenosHibernateDAO();
		  im_terDAO.save(im_ter);
		  System.out.println(im_ter);
		 
		  Imoveis_terrenos aux = im_terDAO.find(1);
	      //System.out.println(aux);
	      
	      aux = im_terDAO.findByName("chacara");
	      
	      System.out.println(aux);
	      
	      List<Imoveis_terrenos> bravo = im_terDAO.findAll();
	   //   System.out.println(bravo);
	      
	    //  im_terDAO.delete(1);
	      
	      bravo = im_terDAO.findAllByName("chacara");
	}

}
