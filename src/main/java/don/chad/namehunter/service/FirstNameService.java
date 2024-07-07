package don.chad.namehunter.service;

import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirstNameService {

    @Autowired
    private FirstNameRepository firstNameRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<FirstName> getNamesFromQuery(String startsWith, String endsWith, String contains) {

        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        if (startsWith != null) {
            criteriaList.add(Criteria.where("name").regex("^" + startsWith, "i"));
        }
        if (endsWith != null) {
            criteriaList.add(Criteria.where("name").regex(endsWith + "$", "i"));
        }
        if (contains != null) {
            criteriaList.add(Criteria.where("name").regex(contains, "i"));
        }
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])));
        return mongoTemplate.find(query, FirstName.class);
    }

}
