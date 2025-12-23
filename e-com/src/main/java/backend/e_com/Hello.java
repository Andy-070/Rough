package backend.e_com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;


@RestController
public class Hello {

    @Autowired
    private EntityManager em;
    
    @GetMapping("/")
    public String hello() {
        return "Hello from andy";
    }

    @GetMapping("/test-db")
    public String testDB() {
        em.createNativeQuery("SELECT 1").getSingleResult();
        return "DB Connected!";
    
    }
}
