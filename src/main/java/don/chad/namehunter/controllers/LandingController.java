package don.chad.namehunter.controllers;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.util.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class LandingController {

    private final AtlasService atlasService;

    @Autowired
    public LandingController(AtlasService atlasService) {
        this.atlasService = atlasService;
    }

    private String getName() {
        List<FirstName> firstNames = atlasService.getNameList();
        Random r = new Random();
        int i = r.nextInt(firstNames.size());
        return firstNames.get(i).getName();
    }

    @GetMapping("/")
    public String landingPage() {
        return "Greetings! Random name for you: " + getName();
    }

}

