package don.chad.namehunter.controllers;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.service.FirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class FirstNameController {

    private final FirstNameService firstNameService;

    @Autowired
    public FirstNameController(FirstNameService firstNameService) {
        this.firstNameService = firstNameService;
    }

    private String getName() {
        List<FirstName> firstNames = firstNameService.getAllFirstNames();
        Random r = new Random();
        int i = r.nextInt(firstNames.size());
        return firstNames.get(i).getName();
    }

    @GetMapping("/")
    public ResponseEntity<String> landingPage() {
        return new ResponseEntity<>("Greetings! Random name for you: " + getName(), HttpStatus.OK);
    }

}

