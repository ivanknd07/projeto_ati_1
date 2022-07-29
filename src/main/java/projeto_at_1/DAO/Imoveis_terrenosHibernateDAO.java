package projeto_at_1.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projeto_at_1.entities.Imoveis_terrenos;

public class Imoveis_terrenosHibernateDAO implements Imoveis_terrenosDAO {
	 static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("projeto_at_1");
	    static EntityManager entityManager;
	 
	//   @Override
	    public void save(Imoveis_terrenos entity) {
	        entityManager = sessionFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	 
	        if (entity.getId() == 0) {
	            entityManager.persist(entity);
	        } else {
	            entityManager.merge(entity);
	        }
	 
	        entityManager.getTransaction().commit();
	        entityManager.close();
	    }
/*==============================================================================================================*/		    
	 
	   // @Override
	    public void delete(int id) {
	        entityManager = sessionFactory.createEntityManager();
	        Imoveis_terrenos im_ter = entityManager.find(Imoveis_terrenos.class, id);
	        entityManager.getTransaction().begin();
	        entityManager.remove(im_ter);
	        entityManager.getTransaction().commit();
	        entityManager.close();
	    }
/*==============================================================================================================*/		 
	   // @Override
	    public Imoveis_terrenos find(int id) {
	        entityManager = sessionFactory.createEntityManager();
	        Imoveis_terrenos im_ter = entityManager.find(Imoveis_terrenos.class, id);
	        entityManager.close();
	 
	        return im_ter;
	    }
/*==============================================================================================================*/		 
	  // @Override
	    public List<Imoveis_terrenos> findAll() {
	        entityManager = sessionFactory.createEntityManager();
	        List<Imoveis_terrenos> im_ter = entityManager.createQuery("from imoveis_terrenos", Imoveis_terrenos.class).getResultList();
	        entityManager.close();
	 
	        return im_ter;
	    }
/*==============================================================================================================*/		 
	   // @Override
	    public Imoveis_terrenos findByName(String str) {
	        entityManager = sessionFactory.createEntityManager();
	        Imoveis_terrenos im_ter = null;
	 
	        try {
	            im_ter = entityManager.createQuery("from imoveis_terrenos where titulo=?1", Imoveis_terrenos.class).setParameter(1, str)
	                    .getSingleResult();
	        } catch (Exception e) {
	            return null;
	        }
	        entityManager.close();
	 
	        return im_ter;
	    }
/*==============================================================================================================*/		 
	  //  @Override
	    public List<Imoveis_terrenos> findAllByName(String str) {
	        entityManager = sessionFactory.createEntityManager();
	        List<Imoveis_terrenos> im_ter = null;
	 
	        try {
	            im_ter = entityManager.createQuery("from products where titulo=?1", Imoveis_terrenos.class)
	                    .setParameter(1, str).getResultList();
	        } catch (Exception e) {
	            return null;
	        }
	        entityManager.close();
	 
	        return im_ter;
	    }


	
}
