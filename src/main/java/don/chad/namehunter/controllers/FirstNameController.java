package don.chad.namehunter.controllers;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.service.FirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class FirstNameController {

    private final FirstNameService firstNameService;

    @Autowired
    public FirstNameController(FirstNameService firstNameService) {
        this.firstNameService = firstNameService;
    }

    private FirstName getName() {
        List<FirstName> firstNames = firstNameService.getAllFirstNames();
        Random r = new Random();
        int i = r.nextInt(firstNames.size());
        return firstNames.get(i);
    }

    @GetMapping("/api/v1/name")
    public ResponseEntity<String> landingPage() {
        FirstName name = getName();
        return new ResponseEntity<>("Greetings! Random name for you: " + name.getName(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/names")
    public ResponseEntity<List<FirstName>> allNamesPage() {
        List<FirstName> allNames = firstNameService.getAllFirstNames();
        return new ResponseEntity<>(allNames, HttpStatus.OK);
    }

    @GetMapping("/api/v1/namesQuery")
    public ResponseEntity<List<FirstName>> namesQuery(@RequestParam(required = false) String startsWith,
                                                      @RequestParam(required = false) String endsWith,
                                                      @RequestParam(required = false) String contains) {
        List<FirstName> allNames = firstNameService.getNamesFromQuery(startsWith, endsWith, contains);
        return new ResponseEntity<>(allNames, HttpStatus.OK);
    }

}

