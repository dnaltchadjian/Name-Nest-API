package don.chad.namehunter.controllers;

import don.chad.namehunter.model.CountriesOfOrigin;
import don.chad.namehunter.model.FirstName;
import don.chad.namehunter.service.FirstNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class FirstNameController {

    private final FirstNameService firstNameService;

    @Autowired
    public FirstNameController(FirstNameService firstNameService) {
        this.firstNameService = firstNameService;
    }

    private FirstName getName() {
        List<FirstName> firstNames = firstNameService.getAllFirstNames();
        Random r = new Random();
        int i = r.nextInt(firstNames.size());
        return firstNames.get(i);
    }

    @GetMapping("/api/v1/name")
    public ResponseEntity<String> landingPage() {
        FirstName name = getName();
        return new ResponseEntity<>("Greetings! Random name for you: " + name.getName(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/names")
    public ResponseEntity<List<FirstName>> allNamesPage() {
        List<FirstName> allNames = firstNameService.getAllFirstNames();
        return new ResponseEntity<>(allNames, HttpStatus.OK);
    }

    @GetMapping("/api/v1/namesQuery")
    public ResponseEntity<List<FirstName>> namesQuery(@RequestParam(required = false) String startsWith,
                                                      @RequestParam(required = false) String endsWith,
                                                      @RequestParam(required = false) String contains,
                                                      @RequestParam(required = false) String gender,
                                                      @RequestParam(required = false) boolean isUnisex,
                                                      @RequestParam(required = false) Integer pageNumber,
                                                      @RequestParam(required = false) Integer pageSize,
                                                      @RequestParam(required = false) boolean greatBritain,
                                                      @RequestParam(required = false) boolean ireland,
                                                      @RequestParam(required = false) boolean usa,
                                                      @RequestParam(required = false) boolean italy,
                                                      @RequestParam(required = false) boolean malta,
                                                      @RequestParam(required = false) boolean portugal,
                                                      @RequestParam(required = false) boolean spain,
                                                      @RequestParam(required = false) boolean france,
                                                      @RequestParam(required = false) boolean luxembourg,
                                                      @RequestParam(required = false) boolean theNetherlands,
                                                      @RequestParam(required = false) boolean eastFrisia,
                                                      @RequestParam(required = false) boolean germany,
                                                      @RequestParam(required = false) boolean austria,
                                                      @RequestParam(required = false) boolean swiss,
                                                      @RequestParam(required = false) boolean iceland,
                                                      @RequestParam(required = false) boolean denmark,
                                                      @RequestParam(required = false) boolean norway,
                                                      @RequestParam(required = false) boolean sweden,
                                                      @RequestParam(required = false) boolean finland,
                                                      @RequestParam(required = false) boolean estonia,
                                                      @RequestParam(required = false) boolean latvia,
                                                      @RequestParam(required = false) boolean lithuania,
                                                      @RequestParam(required = false) boolean poland,
                                                      @RequestParam(required = false) boolean czech,
                                                      @RequestParam(required = false) boolean slovakia,
                                                      @RequestParam(required = false) boolean hungary,
                                                      @RequestParam(required = false) boolean romania,
                                                      @RequestParam(required = false) boolean bulgaria,
                                                      @RequestParam(required = false) boolean bosniaAndHerzegovina,
                                                      @RequestParam(required = false) boolean croatia,
                                                      @RequestParam(required = false) boolean kosovo,
                                                      @RequestParam(required = false) boolean macedonia,
                                                      @RequestParam(required = false) boolean montenegro,
                                                      @RequestParam(required = false) boolean serbia,
                                                      @RequestParam(required = false) boolean slovenia,
                                                      @RequestParam(required = false) boolean albania,
                                                      @RequestParam(required = false) boolean greece,
                                                      @RequestParam(required = false) boolean russia,
                                                      @RequestParam(required = false) boolean belarus,
                                                      @RequestParam(required = false) boolean moldova,
                                                      @RequestParam(required = false) boolean ukraine,
                                                      @RequestParam(required = false) boolean armenia,
                                                      @RequestParam(required = false) boolean azerbaijan,
                                                      @RequestParam(required = false) boolean georgia,
                                                      @RequestParam(required = false) boolean kazakhstanUzbekistan,
                                                      @RequestParam(required = false) boolean turkey,
                                                      @RequestParam(required = false) boolean arabiaPersia,
                                                      @RequestParam(required = false) boolean israel,
                                                      @RequestParam(required = false) boolean china,
                                                      @RequestParam(required = false) boolean indiaSriLanka,
                                                      @RequestParam(required = false) boolean japan,
                                                      @RequestParam(required = false) boolean korea,
                                                      @RequestParam(required = false) boolean vietnam,
                                                      @RequestParam(required = false) boolean otherCountries) {
        CountriesOfOrigin countriesOfOrigin = new CountriesOfOrigin();
        countriesOfOrigin.setAlbania(albania);
        countriesOfOrigin.setArabiaPersia(arabiaPersia);
        countriesOfOrigin.setArmenia(armenia);
        countriesOfOrigin.setAustria(austria);
        countriesOfOrigin.setAzerbaijan(azerbaijan);
        countriesOfOrigin.setBelarus(belarus);
        countriesOfOrigin.setBosniaAndHerzegovina(bosniaAndHerzegovina);
        countriesOfOrigin.setBulgaria(bulgaria);
        countriesOfOrigin.setChina(china);
        countriesOfOrigin.setCroatia(croatia);
        countriesOfOrigin.setCzech(czech);
        countriesOfOrigin.setDenmark(denmark);
        countriesOfOrigin.setEastFrisia(eastFrisia);
        countriesOfOrigin.setEstonia(estonia);
        countriesOfOrigin.setFinland(finland);
        countriesOfOrigin.setFrance(france);
        countriesOfOrigin.setGeorgia(georgia);
        countriesOfOrigin.setGermany(germany);
        countriesOfOrigin.setGreatBritain(greatBritain);
        countriesOfOrigin.setGreece(greece);
        countriesOfOrigin.setHungary(hungary);
        countriesOfOrigin.setIceland(iceland);
        countriesOfOrigin.setIndiaSriLanka(indiaSriLanka);
        countriesOfOrigin.setIreland(ireland);
        countriesOfOrigin.setIsrael(israel);
        countriesOfOrigin.setItaly(italy);
        countriesOfOrigin.setJapan(japan);
        countriesOfOrigin.setKazakhstanUzbekistan(kazakhstanUzbekistan);
        countriesOfOrigin.setKorea(korea);
        countriesOfOrigin.setKosovo(kosovo);
        countriesOfOrigin.setLatvia(latvia);
        countriesOfOrigin.setLithuania(lithuania);
        countriesOfOrigin.setLuxembourg(luxembourg);
        countriesOfOrigin.setMacedonia(macedonia);
        countriesOfOrigin.setMalta(malta);
        countriesOfOrigin.setMoldova(moldova);
        countriesOfOrigin.setMontenegro(montenegro);
        countriesOfOrigin.setNorway(norway);
        countriesOfOrigin.setOtherCountries(otherCountries);
        countriesOfOrigin.setPoland(poland);
        countriesOfOrigin.setPortugal(portugal);
        countriesOfOrigin.setRomania(romania);
        countriesOfOrigin.setRussia(russia);
        countriesOfOrigin.setSerbia(serbia);
        countriesOfOrigin.setSlovakia(slovakia);
        countriesOfOrigin.setSlovenia(slovenia);
        countriesOfOrigin.setSpain(spain);
        countriesOfOrigin.setSweden(sweden);
        countriesOfOrigin.setSwiss(swiss);
        countriesOfOrigin.setTheNetherlands(theNetherlands);
        countriesOfOrigin.setTurkey(turkey);
        countriesOfOrigin.setUkraine(ukraine);
        countriesOfOrigin.setUsa(usa);
        countriesOfOrigin.setVietnam(vietnam);
        List<FirstName> allNames = firstNameService.getNamesFromQuery(startsWith, endsWith, contains, gender, isUnisex, pageNumber, pageSize, countriesOfOrigin);
        return new ResponseEntity<>(allNames, HttpStatus.OK);
    }

    @GetMapping("/api/v1/namesCount")
    public ResponseEntity<Long> namesCount(@RequestParam(required = false) String startsWith,
                                                      @RequestParam(required = false) String endsWith,
                                                      @RequestParam(required = false) String contains,
                                                      @RequestParam(required = false) String gender,
                                                      @RequestParam(required = false) boolean isUnisex,
                                                      @RequestParam(required = false) Integer pageNumber,
                                                      @RequestParam(required = false) Integer pageSize,
                                                      @RequestParam(required = false) boolean greatBritain,
                                                      @RequestParam(required = false) boolean ireland,
                                                      @RequestParam(required = false) boolean usa,
                                                      @RequestParam(required = false) boolean italy,
                                                      @RequestParam(required = false) boolean malta,
                                                      @RequestParam(required = false) boolean portugal,
                                                      @RequestParam(required = false) boolean spain,
                                                      @RequestParam(required = false) boolean france,
                                                      @RequestParam(required = false) boolean luxembourg,
                                                      @RequestParam(required = false) boolean theNetherlands,
                                                      @RequestParam(required = false) boolean eastFrisia,
                                                      @RequestParam(required = false) boolean germany,
                                                      @RequestParam(required = false) boolean austria,
                                                      @RequestParam(required = false) boolean swiss,
                                                      @RequestParam(required = false) boolean iceland,
                                                      @RequestParam(required = false) boolean denmark,
                                                      @RequestParam(required = false) boolean norway,
                                                      @RequestParam(required = false) boolean sweden,
                                                      @RequestParam(required = false) boolean finland,
                                                      @RequestParam(required = false) boolean estonia,
                                                      @RequestParam(required = false) boolean latvia,
                                                      @RequestParam(required = false) boolean lithuania,
                                                      @RequestParam(required = false) boolean poland,
                                                      @RequestParam(required = false) boolean czech,
                                                      @RequestParam(required = false) boolean slovakia,
                                                      @RequestParam(required = false) boolean hungary,
                                                      @RequestParam(required = false) boolean romania,
                                                      @RequestParam(required = false) boolean bulgaria,
                                                      @RequestParam(required = false) boolean bosniaAndHerzegovina,
                                                      @RequestParam(required = false) boolean croatia,
                                                      @RequestParam(required = false) boolean kosovo,
                                                      @RequestParam(required = false) boolean macedonia,
                                                      @RequestParam(required = false) boolean montenegro,
                                                      @RequestParam(required = false) boolean serbia,
                                                      @RequestParam(required = false) boolean slovenia,
                                                      @RequestParam(required = false) boolean albania,
                                                      @RequestParam(required = false) boolean greece,
                                                      @RequestParam(required = false) boolean russia,
                                                      @RequestParam(required = false) boolean belarus,
                                                      @RequestParam(required = false) boolean moldova,
                                                      @RequestParam(required = false) boolean ukraine,
                                                      @RequestParam(required = false) boolean armenia,
                                                      @RequestParam(required = false) boolean azerbaijan,
                                                      @RequestParam(required = false) boolean georgia,
                                                      @RequestParam(required = false) boolean kazakhstanUzbekistan,
                                                      @RequestParam(required = false) boolean turkey,
                                                      @RequestParam(required = false) boolean arabiaPersia,
                                                      @RequestParam(required = false) boolean israel,
                                                      @RequestParam(required = false) boolean china,
                                                      @RequestParam(required = false) boolean indiaSriLanka,
                                                      @RequestParam(required = false) boolean japan,
                                                      @RequestParam(required = false) boolean korea,
                                                      @RequestParam(required = false) boolean vietnam,
                                                      @RequestParam(required = false) boolean otherCountries) {
        CountriesOfOrigin countriesOfOrigin = new CountriesOfOrigin();
        countriesOfOrigin.setAlbania(albania);
        countriesOfOrigin.setArabiaPersia(arabiaPersia);
        countriesOfOrigin.setArmenia(armenia);
        countriesOfOrigin.setAustria(austria);
        countriesOfOrigin.setAzerbaijan(azerbaijan);
        countriesOfOrigin.setBelarus(belarus);
        countriesOfOrigin.setBosniaAndHerzegovina(bosniaAndHerzegovina);
        countriesOfOrigin.setBulgaria(bulgaria);
        countriesOfOrigin.setChina(china);
        countriesOfOrigin.setCroatia(croatia);
        countriesOfOrigin.setCzech(czech);
        countriesOfOrigin.setDenmark(denmark);
        countriesOfOrigin.setEastFrisia(eastFrisia);
        countriesOfOrigin.setEstonia(estonia);
        countriesOfOrigin.setFinland(finland);
        countriesOfOrigin.setFrance(france);
        countriesOfOrigin.setGeorgia(georgia);
        countriesOfOrigin.setGermany(germany);
        countriesOfOrigin.setGreatBritain(greatBritain);
        countriesOfOrigin.setGreece(greece);
        countriesOfOrigin.setHungary(hungary);
        countriesOfOrigin.setIceland(iceland);
        countriesOfOrigin.setIndiaSriLanka(indiaSriLanka);
        countriesOfOrigin.setIreland(ireland);
        countriesOfOrigin.setIsrael(israel);
        countriesOfOrigin.setItaly(italy);
        countriesOfOrigin.setJapan(japan);
        countriesOfOrigin.setKazakhstanUzbekistan(kazakhstanUzbekistan);
        countriesOfOrigin.setKorea(korea);
        countriesOfOrigin.setKosovo(kosovo);
        countriesOfOrigin.setLatvia(latvia);
        countriesOfOrigin.setLithuania(lithuania);
        countriesOfOrigin.setLuxembourg(luxembourg);
        countriesOfOrigin.setMacedonia(macedonia);
        countriesOfOrigin.setMalta(malta);
        countriesOfOrigin.setMoldova(moldova);
        countriesOfOrigin.setMontenegro(montenegro);
        countriesOfOrigin.setNorway(norway);
        countriesOfOrigin.setOtherCountries(otherCountries);
        countriesOfOrigin.setPoland(poland);
        countriesOfOrigin.setPortugal(portugal);
        countriesOfOrigin.setRomania(romania);
        countriesOfOrigin.setRussia(russia);
        countriesOfOrigin.setSerbia(serbia);
        countriesOfOrigin.setSlovakia(slovakia);
        countriesOfOrigin.setSlovenia(slovenia);
        countriesOfOrigin.setSpain(spain);
        countriesOfOrigin.setSweden(sweden);
        countriesOfOrigin.setSwiss(swiss);
        countriesOfOrigin.setTheNetherlands(theNetherlands);
        countriesOfOrigin.setTurkey(turkey);
        countriesOfOrigin.setUkraine(ukraine);
        countriesOfOrigin.setUsa(usa);
        countriesOfOrigin.setVietnam(vietnam);
        Long nameCount = firstNameService.getNameCountFromQuery(startsWith, endsWith, contains, gender, isUnisex, pageNumber, pageSize, countriesOfOrigin);
        return new ResponseEntity<>(nameCount, HttpStatus.OK);
    }

}

