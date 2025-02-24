package dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


import metier.Produit;
import org.hibernate.query.Query;

public class ProduitDAO {

	public List<Produit> findAllProduits(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Produit";
			Query<Produit> query = session.createQuery(hql,Produit.class); 
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
    public List<Produit> getProduitsParMotCle(String motCle) throws Exception {
        if (motCle == null || motCle.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot-clé de recherche est vide !");
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Produit p WHERE p.libellePro LIKE :motCle";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            query.setParameter("motCle", "%" + motCle + "%");

            List<Produit> result = query.list();
            System.out.println("Produits trouvés: " + result.size());
            return result;
        } catch (Exception e) {
            System.err.println("Erreur Hibernate dans ProduitDAO: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public Produit getProduitById(int id) {
    	try (Session session=HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Produit where idPro=:id";
			Query<Produit> query = session.createQuery(hql,Produit.class);
			query.setParameter("id", id);
			Produit res = query.uniqueResult();
			return res;
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
    }
    
    
}

