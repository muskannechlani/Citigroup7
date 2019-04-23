package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.persistence.*;
@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private CompanyRepository comprepository;
	@Autowired
	private UserDAO userdao;


	@Autowired
	EntityManager entityManager;



	public String loadUserByUsername(String userName,String passWord)  {
		User u=null;
		try {  
			User appUser = this.userdao.findUserAccount(userName);
			u=appUser;

			if (appUser == null) {
				System.out.println("User not found! " + userName);
				try {
					return "Failure";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(!appUser.getPassWord().equals(passWord))
			{
				try {
					throw new Exception("User " + userName + " entered password  wrong");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "Failure";
				}
			}
			else 
				System.out.println("Found User: "+u.getUserName());
		}catch(Exception e)
		{
			System.out.println(e); 
		}
		return "Success";
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		
		String m= loadUserByUsername(user.getUserName(), user.getPassWord());
		
		if(m.equals("Success"))
			return user;
		else 
			return null;
	}

	@Override
	public Company createCompany(Company comp) {

		
		userdao.save_Company(comp);
		
		return comp;
	}

	
@Override
@Transactional
	public ResponseEntity<String> deleteCompany( Company comp) {

		String userName=comp.getUserName();
		String latestTime=comp.getLatestTime();
		try {
			String sql = 
					"delete from "+Company.class.getName() +" e  where e.userName= :userName AND   e.latestTime= :latestTime ";
			System.out.println(sql);
			int deletedCount=	 entityManager.createQuery(sql).setParameter("userName", userName).setParameter("latestTime", latestTime).executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
			
		    return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
		  }

	@Override
	public List<Company> findAllcompanies(String user) {
		// TODO Auto-generated method stub
System.out.println(user);
		return  (List<Company>) userdao.getCompany( user);//comprepository.findAll()
	}





}
