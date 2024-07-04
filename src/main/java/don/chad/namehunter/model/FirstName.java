package don.chad.namehunter.model;

import com.opencsv.bean.CsvBindByName;

public class FirstName {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "gender")
    private String gender;

    public String getName() {
        return name.replaceAll("\\+", " ");
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
