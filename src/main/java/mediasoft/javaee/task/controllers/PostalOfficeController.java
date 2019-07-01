package mediasoft.javaee.task.controllers;

import mediasoft.javaee.task.models.PostalOffice;
import mediasoft.javaee.task.services.PostalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostalOfficeController {
    @Autowired
    private PostalOfficeService postalOfficeService;

    @GetMapping("/offices")
    public List<PostalOffice> getPostalOffices(){
        return postalOfficeService.findAll();
    }

    @PostMapping("/offices")
    public ResponseEntity<Object> addOffice(@RequestBody PostalOffice postalOffice){
        PostalOffice officeCandidate = postalOfficeService.findByName(postalOffice.getName()).orElse(null);
        if(officeCandidate != null){
            throw new IllegalArgumentException("Такое отделение уже есть");
        }
        postalOfficeService.save(postalOffice);
        return ResponseEntity.ok().build();
    }
}
