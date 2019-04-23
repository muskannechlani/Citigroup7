package stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface CommonService {

    User create(User user);
    Company createCompany(Company comp);
    public ResponseEntity<String> deleteCompany( Company comp) ;
    List<Company> findAllcompanies(String user);
    }
