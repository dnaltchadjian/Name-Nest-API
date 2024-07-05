package don.chad.namehunter.repository;

import don.chad.namehunter.model.FirstName;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstNameRepository extends MongoRepository<FirstName, ObjectId> {
}
