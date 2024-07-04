package don.chad.namehunter.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import don.chad.namehunter.model.FirstName;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtlasUtil {

    public static List<FirstName> NAME_LIST = createNameList();
    public static Map<String, FirstName> NAME_ATLAS = createNameAtlas(NAME_LIST);

    private static List<FirstName> createNameList() {

        Path path = Path.of("src/main/resources/firstnames.csv");
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<FirstName> cb = new CsvToBeanBuilder<FirstName>(reader)
                    .withType(FirstName.class)
                    .withSeparator(';')
                    .build();

            List<FirstName> parse = cb.parse();
            return parse;

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
