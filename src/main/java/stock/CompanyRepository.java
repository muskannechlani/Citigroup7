package stock;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "http://localhost:4200")
public interface CompanyRepository extends CrudRepository<Company, String> {//extends JpaRepository<Company, Integer> {

	 List<Company> findAll();

	 Company save(Company comp);
	
}
