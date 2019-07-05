package mediasoft.javaee.task.controllers;

import mediasoft.javaee.task.models.HistoryOfMailing;
import mediasoft.javaee.task.services.HistoryOfMailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryOfMailingService historyOfMailingService;

    @GetMapping("/history/all")
    public List<HistoryOfMailing> getAll(){
        return historyOfMailingService.findAll();
    }

    @GetMapping("/history/get/{mailing_id}")
    public List<HistoryOfMailing> getHistoryOfMailing(@PathVariable(name = "mailing_id") Long mailingId){
        return historyOfMailingService.findAllByMailing_Id(mailingId);
    }

    @PostMapping("/history/received/{mailing_id}")
    public ResponseEntity<Object> setMailingToReceived(@PathVariable(name = "mailing_id") Long mailingId){
        historyOfMailingService.prepareToReceive(mailingId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/history/departed/{mailing_id}")
    public ResponseEntity<Object> sendToAnotherOffice(@PathVariable(name = "mailing_id") Long mailingId, @RequestBody Long indexOfAnotherPostalOffice){
        historyOfMailingService.prepareToDepart(mailingId,indexOfAnotherPostalOffice);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/history/arrived/{mailing_id}")
    public ResponseEntity<Object> updateMailingStatus(@PathVariable(name = "mailing_id") Long mailingId){
        historyOfMailingService.prepareToArrive(mailingId);
        return ResponseEntity.ok().build();
    }
}
