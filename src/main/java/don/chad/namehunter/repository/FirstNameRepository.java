package don.chad.namehunter.repository;

import don.chad.namehunter.model.FirstName;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstNameRepository extends MongoRepository<FirstName, ObjectId> {

    @Query(value = "{ 'name' : /?0/i }")
    List<FirstName> findContainingString(String expression);

    @Query(value = "{ 'name' : /^?0/i }")
    List<FirstName> findStartingWithString(String expression);

    @Query(value = "{ 'name' : /?0$/i }")
    List<FirstName> findEndingWithString(String expression);

}
