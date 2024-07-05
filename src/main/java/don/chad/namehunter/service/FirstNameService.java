package don.chad.namehunter.service;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirstNameService {

    @Autowired
    private FirstNameRepository firstNameRepository;

    private List<FirstName> nameList;

    public List<FirstName> getAllFirstNames() {
        if (nameList == null) {
            nameList = createNameList();
        }
        return nameList;
    }

    private List<FirstName> createNameList() {
        return firstNameRepository.findAll();
    }

    private static Map<String, FirstName> createNameAtlas(List<FirstName> nameList) {
        Map<String, FirstName> nameAtlas = new HashMap<>();
        for (FirstName firstName : nameList) {
            nameAtlas.put(firstName.getName(), firstName);
        }
        return nameAtlas;
    }

}
