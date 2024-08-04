package don.chad.namenest.service;

import don.chad.namenest.model.CountriesOfOrigin;
import don.chad.namenest.model.FirstName;
import don.chad.namenest.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static don.chad.namenest.util.NameAppConstants.*;

/**
 * The service class for all API calls.
 */
@Service
public class FirstNameService {

    private static final int DEFAULT_PAGE_SIZE = 10;

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

    /**
     * Retrieve a List of names from the database matching the query criteria.
     * @param startsWith an expression to be searched for in the start of a name.
     * @param endsWith an expression to be searched for at the end of a name.
     * @param contains an expression to be searched for in any part of the name.
     * @param gender the implied gender of the name (M, F, or unisex).
     * @param isUnisex whether unisex names are included or not.
     * @param pageNumber a page number for paginated results.
     * @param pageSize the number of results to display per page.
     * @param countriesOfOrigin the country weighting for each name contained within an object.
     * @return a List of FirstName objects which match the query.
     */
    public List<FirstName> getNamesFromQuery(String startsWith, String endsWith, String contains, String gender, boolean isUnisex, Integer pageNumber,
                                             Integer pageSize, CountriesOfOrigin countriesOfOrigin) {
        Query query = constructQuery(startsWith, endsWith, contains, gender, isUnisex, pageNumber, pageSize, countriesOfOrigin);
        List<FirstName> firstNames = mongoTemplate.find(query, FirstName.class);
        firstNames.forEach(FirstName::setCountryMap);
        return firstNames;
    }

    /**
     * Retrieve a count of names from the database matching the query criteria.
     * @param startsWith an expression to be searched for in the start of a name.
     * @param endsWith an expression to be searched for at the end of a name.
     * @param contains an expression to be searched for in any part of the name.
     * @param gender the implied gender of the name (M, F, or unisex).
     * @param isUnisex whether unisex names are included or not.
     * @param pageNumber a page number for paginated results.
     * @param pageSize the number of results to display per page.
     * @param countriesOfOrigin the country weighting for each name contained within an object.
     * @return a count of the names which match the query criteria.
     */
    public long getNameCountFromQuery(String startsWith, String endsWith, String contains, String gender, boolean isUnisex, Integer pageNumber,
                                      Integer pageSize, CountriesOfOrigin countriesOfOrigin) {
        Query query = constructQuery(startsWith, endsWith, contains, gender, isUnisex, pageNumber, pageSize, countriesOfOrigin);
        return mongoTemplate.count(query, FirstName.class);
    }

    /**
     * Constructs a query based on the passed in parameters including regular expressions, gender, and origin countries.
     * @param startsWith an expression to be searched for in the start of a name.
     * @param endsWith an expression to be searched for at the end of a name.
     * @param contains an expression to be searched for in any part of the name.
     * @param gender the implied gender of the name (M, F, or unisex).
     * @param isUnisex whether unisex names are included or not.
     * @param pageNumber a page number for paginated results.
     * @param pageSize the number of results to display per page.
     * @param countriesOfOrigin the country weighting for each name contained within an object.
     * @return a fully built mongo query for finding names.
     */
    private Query constructQuery(String startsWith, String endsWith, String contains, String gender, boolean isUnisex, Integer pageNumber,
                                 Integer pageSize, CountriesOfOrigin countriesOfOrigin) {
        Query query = new Query();
        List<Criteria> baseCriteriaList = new ArrayList<>();
        if (startsWith != null) {
            baseCriteriaList.add(Criteria.where(NAME).regex("^" + startsWith, "i"));
        }
        if (endsWith != null) {
            baseCriteriaList.add(Criteria.where(NAME).regex(endsWith + "$", "i"));
        }
        if (contains != null) {
            baseCriteriaList.add(Criteria.where(NAME).regex(contains, "i"));
        }

        Criteria genderCriteria = getGenderCriteria(gender, isUnisex);
        if (genderCriteria != null) {
            baseCriteriaList.add(genderCriteria);
        }
        Criteria countriesCriteria = getCountriesCriteria(countriesOfOrigin);
        if (countriesCriteria != null) {
            baseCriteriaList.add(countriesCriteria);
        }

        Criteria criteria = new Criteria();
        if (!baseCriteriaList.isEmpty()) {
            criteria.andOperator(baseCriteriaList.toArray(new Criteria[baseCriteriaList.size()]));
        }
        query.addCriteria(criteria);
        query.with(Sort.by(Sort.Direction.ASC, NAME));
        if (pageNumber != null) {
            query.with(PageRequest.of(pageNumber, pageSize == null ? DEFAULT_PAGE_SIZE : pageSize));
        }
        return query;
    }

    /**
     * Create query criteria based on the gender provided in the URL.
     * @param gender the gender string.
     * @param isUnisex whether unisex names are included in the criteria.
     * @return the criteria for gender under a logical $or operator.
     */
    private Criteria getGenderCriteria(String gender, boolean isUnisex) {
        List<Criteria> genderCriteria = new ArrayList<>();
        if (gender != null) {
            if (isUnisex) {
                genderCriteria.add(Criteria.where(GENDER).is("?"));
                genderCriteria.add(Criteria.where(GENDER).is("?F"));
                genderCriteria.add(Criteria.where(GENDER).is("?M"));
            }
            genderCriteria.add(Criteria.where(GENDER).regex(gender));
            genderCriteria.add(Criteria.where(GENDER).is("?"));

            return new Criteria().orOperator(genderCriteria);
        }
        return null;
    }

    /**
     * Create query criteria based on the countries of origin specified in the URL.
     * @param countriesOfOrigin object containing the countries of origin.
     * @return the criteria including all countries under a logical $or operator.
     */
    private Criteria getCountriesCriteria(CountriesOfOrigin countriesOfOrigin) {

        List<Criteria> criteriaList = new ArrayList<>();

        if (countriesOfOrigin.isAlbania()) {
            criteriaList.add(Criteria.where(ALBANIA).exists(true));
        }
        if (countriesOfOrigin.isArabiaPersia()) {
            criteriaList.add(Criteria.where(ARABIA_PERSIA).exists(true));
        }
        if (countriesOfOrigin.isArmenia()) {
            criteriaList.add(Criteria.where(ARMENIA).exists(true));
        }
        if (countriesOfOrigin.isAzerbaijan()) {
            criteriaList.add(Criteria.where(AZERBAIJAN).exists(true));
        }
        if (countriesOfOrigin.isBelarus()) {
            criteriaList.add(Criteria.where(BELARUS).exists(true));
        }
        if (countriesOfOrigin.isBosniaAndHerzegovina()) {
            criteriaList.add(Criteria.where(BOSNIA_AND_HERZEGOVINA).exists(true));
        }
        if (countriesOfOrigin.isBulgaria()) {
            criteriaList.add(Criteria.where(BULGARIA).exists(true));
        }
        if (countriesOfOrigin.isChina()) {
            criteriaList.add(Criteria.where(CHINA).exists(true));
        }
        if (countriesOfOrigin.isCroatia()) {
            criteriaList.add(Criteria.where(CROATIA).exists(true));
        }
        if (countriesOfOrigin.isCzech()) {
            criteriaList.add(Criteria.where(CZECH).exists(true));
        }
        if (countriesOfOrigin.isDenmark()) {
            criteriaList.add(Criteria.where(DENMARK).exists(true));
        }
        if (countriesOfOrigin.isEastFrisia()) {
            criteriaList.add(Criteria.where(EAST_FRISIA).exists(true));
        }
        if (countriesOfOrigin.isEstonia()) {
            criteriaList.add(Criteria.where(ESTONIA).exists(true));
        }
        if (countriesOfOrigin.isFinland()) {
            criteriaList.add(Criteria.where(FINLAND).exists(true));
        }
        if (countriesOfOrigin.isFrance()) {
            criteriaList.add(Criteria.where(FRANCE).exists(true));
        }
        if (countriesOfOrigin.isGeorgia()) {
            criteriaList.add(Criteria.where(GEORGIA).exists(true));
        }
        if (countriesOfOrigin.isGermany()) {
            criteriaList.add(Criteria.where(GERMANY).exists(true));
        }
        if (countriesOfOrigin.isGreatBritain()) {
            criteriaList.add(Criteria.where(GREAT_BRITAIN).exists(true));
        }
        if (countriesOfOrigin.isGreece()) {
            criteriaList.add(Criteria.where(GREECE).exists(true));
        }
        if (countriesOfOrigin.isHungary()) {
            criteriaList.add(Criteria.where(HUNGARY).exists(true));
        }
        if (countriesOfOrigin.isIceland()) {
            criteriaList.add(Criteria.where(ICELAND).exists(true));
        }
        if (countriesOfOrigin.isIndiaSriLanka()) {
            criteriaList.add(Criteria.where(INDIA_SRI_LANKA).exists(true));
        }
        if (countriesOfOrigin.isIreland()) {
            criteriaList.add(Criteria.where(IRELAND).exists(true));
        }
        if (countriesOfOrigin.isIsrael()) {
            criteriaList.add(Criteria.where(ISRAEL).exists(true));
        }
        if (countriesOfOrigin.isItaly()) {
            criteriaList.add(Criteria.where(ITALY).exists(true));
        }
        if (countriesOfOrigin.isJapan()) {
            criteriaList.add(Criteria.where(JAPAN).exists(true));
        }
        if (countriesOfOrigin.isKazakhstanUzbekistan()) {
            criteriaList.add(Criteria.where(KAZAKHSTAN_UZBEKISTAN).exists(true));
        }
        if (countriesOfOrigin.isKorea()) {
            criteriaList.add(Criteria.where(KOREA).exists(true));
        }
        if (countriesOfOrigin.isKosovo()) {
            criteriaList.add(Criteria.where(KOSOVO).exists(true));
        }
        if (countriesOfOrigin.isLatvia()) {
            criteriaList.add(Criteria.where(LATVIA).exists(true));
        }
        if (countriesOfOrigin.isLithuania()) {
            criteriaList.add(Criteria.where(LITHUANIA).exists(true));
        }
        if (countriesOfOrigin.isLuxembourg()) {
            criteriaList.add(Criteria.where(LUXEMBOURG).exists(true));
        }
        if (countriesOfOrigin.isMacedonia()) {
            criteriaList.add(Criteria.where(MACEDONIA).exists(true));
        }
        if (countriesOfOrigin.isMalta()) {
            criteriaList.add(Criteria.where(MALTA).exists(true));
        }
        if (countriesOfOrigin.isMoldova()) {
            criteriaList.add(Criteria.where(MOLDOVA).exists(true));
        }
        if (countriesOfOrigin.isMontenegro()) {
            criteriaList.add(Criteria.where(MONTENEGRO).exists(true));
        }
        if (countriesOfOrigin.isNorway()) {
            criteriaList.add(Criteria.where(NORWAY).exists(true));
        }
        if (countriesOfOrigin.isOtherCountries()) {
            criteriaList.add(Criteria.where(OTHER_COUNTRIES).exists(true));
        }
        if (countriesOfOrigin.isPoland()) {
            criteriaList.add(Criteria.where(POLAND).exists(true));
        }
        if (countriesOfOrigin.isPortugal()) {
            criteriaList.add(Criteria.where(PORTUGAL).exists(true));
        }
        if (countriesOfOrigin.isRomania()) {
            criteriaList.add(Criteria.where(ROMANIA).exists(true));
        }
        if (countriesOfOrigin.isRussia()) {
            criteriaList.add(Criteria.where(RUSSIA).exists(true));
        }
        if (countriesOfOrigin.isSerbia()) {
            criteriaList.add(Criteria.where(SERBIA).exists(true));
        }
        if (countriesOfOrigin.isSlovakia()) {
            criteriaList.add(Criteria.where(SLOVAKIA).exists(true));
        }
        if (countriesOfOrigin.isSlovenia()) {
            criteriaList.add(Criteria.where(SLOVENIA).exists(true));
        }
        if (countriesOfOrigin.isSpain()) {
            criteriaList.add(Criteria.where(SPAIN).exists(true));
        }
        if (countriesOfOrigin.isSweden()) {
            criteriaList.add(Criteria.where(SWEDEN).exists(true));
        }
        if (countriesOfOrigin.isSwiss()) {
            criteriaList.add(Criteria.where(SWISS).exists(true));
        }
        if (countriesOfOrigin.isTheNetherlands()) {
            criteriaList.add(Criteria.where(THE_NETHERLANDS).exists(true));
        }
        if (countriesOfOrigin.isTurkey()) {
            criteriaList.add(Criteria.where(TURKEY).exists(true));
        }
        if (countriesOfOrigin.isUkraine()) {
            criteriaList.add(Criteria.where(UKRAINE).exists(true));
        }
        if (countriesOfOrigin.isUsa()) {
            criteriaList.add(Criteria.where(USA).exists(true));
        }
        if (countriesOfOrigin.isVietnam()) {
            criteriaList.add(Criteria.where(VIETNAM).exists(true));
        }

        if (criteriaList.isEmpty()) {
            return null;
        }

        return new Criteria().orOperator(criteriaList);
    }

}
