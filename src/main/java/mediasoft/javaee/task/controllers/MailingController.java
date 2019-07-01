package mediasoft.javaee.task.controllers;

import mediasoft.javaee.task.models.Mailing;
import mediasoft.javaee.task.services.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MailingController {
    @Autowired
    private MailingService mailingService;

    @GetMapping("/mailing")
    public List<Mailing> getMailings(){
        return mailingService.findAll();
    }

    @PostMapping("/mailing")
    public ResponseEntity<Object> setMailing(@RequestBody Mailing mailing){
        mailingService.save(mailing);
        return ResponseEntity.ok().build();
    }
}
