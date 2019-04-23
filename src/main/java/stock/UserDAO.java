package stock;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
@Repository
@Transactional
public class UserDAO {

	 @Autowired
	 private EntityManager entityManager;
	 public User findUserAccount(String userName) {
		 System.out.println(userName);
	        try {
	        	String sql = "Select e from " + User.class.getName() + " e " //
	                    + " Where e.userName = :userName ";
	        	
	            Query query = entityManager.createQuery(sql, User.class);
	            query.setParameter("userName", userName);
	            
	            return (User) query.getSingleResult();

	        } catch (Exception e) {
	        	System.out.println("occured");
	            return null;
	        }
	    }
	
	 public ArrayList<Company> getCompany(String userName)
	 {
		 
		 try {
	        	String sql = "Select e from " + Company.class.getName() + " e "  + " Where e.userName = :userName ";
	                 
	        	
	            Query query = (Query) entityManager.createQuery(sql,Company.class).setParameter("userName", userName);
	          
	            return   (java.util.ArrayList<Company>) query.getResultList();

	        } catch (Exception e) {
	        	System.out.println(e);
	            return null;
	        }
		
	 }
	 @Transactional
	 public Company save_Company(Company comp)
	 { entityManager.createNativeQuery("INSERT INTO company   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
		 .setParameter(1, comp.getUserName())
		 .setParameter(2, comp.getSymbol())
	       .setParameter(3, comp.getCompanyName())
	       .setParameter(4, comp.getPreviousClose())
	       .setParameter(5, comp.getChange())
	       .setParameter(6, comp.getChangePercent())
	       .setParameter(7, comp.getLatestTime())
	       .setParameter(8, comp.getPrimaryExchange())
	       .setParameter(9, comp.getSector())
	       .setParameter(10, comp.getMarketCap())
	       .setParameter(11, comp.getOpen())
	       .setParameter(12, comp.getHigh())
	       .setParameter(13, comp.getLow())
	       .setParameter(14, comp.getClose())
	       .setParameter(15, comp.getPreviousClose())
	       .setParameter(16, comp.getLatestVolume())
	       .setParameter(17, comp.getWeek52High())
	       .setParameter(18, comp.getWeek52Low())
	       .executeUpdate();
		return comp;
		 
	 }
	 
	    
}
