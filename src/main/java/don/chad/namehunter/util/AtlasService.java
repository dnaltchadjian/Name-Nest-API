package don.chad.namehunter.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import don.chad.namehunter.model.FirstName;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AtlasService {

    private List<FirstName> nameList;

    public List<FirstName> getNameList() {
        if (nameList == null) {
            nameList = createNameList();
        }
        return nameList;
    }

    private static List<FirstName> createNameList() {

        Path path = Path.of("src/main/resources/firstnames.csv");
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<FirstName> cb = new CsvToBeanBuilder<FirstName>(reader)
                    .withType(FirstName.class)
                    .withSeparator(';')
                    .build();
            return cb.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    private static Map<String, FirstName> createNameAtlas(List<FirstName> nameList) {
        Map<String, FirstName> nameAtlas = new HashMap<>();
        for (FirstName firstName : nameList) {
            nameAtlas.put(firstName.getName(), firstName);
        }
        return nameAtlas;
    }

}
