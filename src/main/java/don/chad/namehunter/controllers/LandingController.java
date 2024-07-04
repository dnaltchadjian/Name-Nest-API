package don.chad.namehunter.controllers;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.util.AtlasUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class LandingController {

    @GetMapping("/")
    public String index() {
        List<FirstName> firstNames = AtlasUtil.NAME_LIST;

        Random r = new Random();
        int i = r.nextInt(firstNames.size());

        return "Greetings! Random name for you: " + firstNames.get(i).getName();
    }

}

