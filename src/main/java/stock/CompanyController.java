package stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping({"/stocks"})
public class CompanyController {
	 @Autowired
	    private CommonService userService;
	 @Autowired
	  CompanyRepository repository;
	 @Autowired
	 private EntityManager entityManager;
	    
      @PostMapping
	    public Company createCompany(@RequestBody Company comp){
    		LocalDateTime localDateTime = LocalDateTime.now();
        	System.out.println(localDateTime);
	    	
	    	comp.setLatestTime(localDateTime.toString());
	    	
	    	Company temp=userService.createCompany(comp);
	    	
	    	return temp;
	    }
    
	 @GetMapping("savedstocks/{username}")
	  	    public List<Company> findAll(@PathVariable String username){
		 	List<Company> customers = new ArrayList<>();
		 	
	       
		 	System.out.println("returned");
	
	    userService.findAllcompanies(username).forEach(customers::add);
	      System.out.println(customers);
	        return customers;
	    }
	 
	 @PostMapping("/saved")
	  public ResponseEntity<String> deleteStock(@RequestBody Company comp) {

	     return userService.deleteCompany(comp);
	  }
}
