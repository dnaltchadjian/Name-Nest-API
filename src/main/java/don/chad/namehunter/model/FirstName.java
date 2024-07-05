package don.chad.namehunter.model;

import com.opencsv.bean.CsvBindByName;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "names")
@AllArgsConstructor
@NoArgsConstructor
public class FirstName {

    @Id
    private ObjectId id;

    private String name;

    private String gender;

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name.replaceAll("\\+", " ");
    }

    public String getGender() {
        return gender;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
