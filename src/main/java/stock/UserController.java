package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@RequestMapping(value = "/users",consumes ="application/json", produces="application/json")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private CommonService userService;

    
    @PostMapping
    public User create(@RequestBody User user){
    
    	System.out.println(user.getUserName()+"\t"+user.getPassWord());
    	User m=userService.create(user);
    	
        return m;
    }

   

}
