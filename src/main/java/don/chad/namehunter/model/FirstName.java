package don.chad.namehunter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

import static don.chad.namehunter.util.NameAppConstants.*;

@Document(collection = "names")
@AllArgsConstructor
@NoArgsConstructor
public class FirstName {

    @Id
    private ObjectId id;

    @Field(NAME)
    private String name;
    @Field(GENDER)
    private String gender;

    @Field(GREAT_BRITAIN)
    @JsonIgnore
    private Integer greatBritain;
    @Field(IRELAND)
    @JsonIgnore
    private Integer ireland;
    @Field(USA)
    @JsonIgnore
    private Integer usa;
    @Field(ITALY)
    @JsonIgnore
    private Integer italy;
    @Field(MALTA)
    @JsonIgnore
    private Integer malta;
    @Field(PORTUGAL)
    @JsonIgnore
    private Integer portugal;
    @Field(SPAIN)
    @JsonIgnore
    private Integer spain;
    @Field(FRANCE)
    @JsonIgnore
    private Integer france;
    @Field(LUXEMBOURG)
    @JsonIgnore
    private Integer luxembourg;
    @Field(THE_NETHERLANDS)
    @JsonIgnore
    private Integer theNetherlands;
    @Field(EAST_FRISIA)
    @JsonIgnore
    private Integer eastFrisia;
    @Field(GERMANY)
    @JsonIgnore
    private Integer germany;
    @Field(AUSTRIA)
    @JsonIgnore
    private Integer austria;
    @Field(SWISS)
    @JsonIgnore
    private Integer swiss;
    @Field(ICELAND)
    @JsonIgnore
    private Integer iceland;
    @Field(DENMARK)
    @JsonIgnore
    private Integer denmark;
    @Field(NORWAY)
    @JsonIgnore
    private Integer norway;
    @Field(SWEDEN)
    @JsonIgnore
    private Integer sweden;
    @Field(FINLAND)
    @JsonIgnore
    private Integer finland;
    @Field(ESTONIA)
    @JsonIgnore
    private Integer estonia;
    @Field(LATVIA)
    @JsonIgnore
    private Integer latvia;
    @Field(LITHUANIA)
    @JsonIgnore
    private Integer lithuania;
    @Field(POLAND)
    @JsonIgnore
    private Integer poland;
    @Field(CZECH)
    @JsonIgnore
    private Integer czech;
    @Field(SLOVAKIA)
    @JsonIgnore
    private Integer slovakia;
    @Field(HUNGARY)
    @JsonIgnore
    private Integer hungary;
    @Field(ROMANIA)
    @JsonIgnore
    private Integer romania;
    @Field(BULGARIA)
    @JsonIgnore
    private Integer bulgaria;
    @Field(BOSNIA_AND_HERZEGOVINA)
    @JsonIgnore
    private Integer bosniaAndHerzegovina;
    @Field(CROATIA)
    @JsonIgnore
    private Integer croatia;
    @Field(KOSOVO)
    @JsonIgnore
    private Integer kosovo;
    @Field(MACEDONIA)
    @JsonIgnore
    private Integer macedonia;
    @Field(MONTENEGRO)
    @JsonIgnore
    private Integer montenegro;
    @Field(SERBIA)
    @JsonIgnore
    private Integer serbia;
    @Field(SLOVENIA)
    @JsonIgnore
    private Integer slovenia;
    @Field(ALBANIA)
    @JsonIgnore
    private Integer albania;
    @Field(GREECE)
    @JsonIgnore
    private Integer greece;
    @Field(RUSSIA)
    @JsonIgnore
    private Integer russia;
    @Field(BELARUS)
    @JsonIgnore
    private Integer belarus;
    @Field(MOLDOVA)
    @JsonIgnore
    private Integer moldova;
    @Field(UKRAINE)
    @JsonIgnore
    private Integer ukraine;
    @Field(ARMENIA)
    @JsonIgnore
    private Integer armenia;
    @Field(AZERBAIJAN)
    @JsonIgnore
    private Integer azerbaijan;
    @Field(GEORGIA)
    @JsonIgnore
    private Integer georgia;
    @Field(KAZAKHSTAN_UZBEKISTAN)
    @JsonIgnore
    private Integer kazakhstanUzbekistan;
    @Field(TURKEY)
    @JsonIgnore
    private Integer turkey;
    @Field(ARABIA_PERSIA)
    @JsonIgnore
    private Integer arabiaPersia;
    @Field(ISRAEL)
    @JsonIgnore
    private Integer israel;
    @Field(CHINA)
    @JsonIgnore
    private Integer china;
    @Field(INDIA_SRI_LANKA)
    @JsonIgnore
    private Integer indiaSriLanka;
    @Field(JAPAN)
    @JsonIgnore
    private Integer japan;
    @Field(KOREA)
    @JsonIgnore
    private Integer korea;
    @Field(VIETNAM)
    @JsonIgnore
    private Integer vietnam;
    @Field(OTHER_COUNTRIES)
    @JsonIgnore
    private Integer otherCountries;

    private Map<Integer, List<String>> countryMap;

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

    public Integer getGreatBritain() {
        return greatBritain;
    }

    public void setGreatBritain(Integer greatBritain) {
        this.greatBritain = greatBritain;
    }

    public Integer getIreland() {
        return ireland;
    }

    public void setIreland(Integer ireland) {
        this.ireland = ireland;
    }

    public Integer getUsa() {
        return usa;
    }

    public void setUsa(Integer usa) {
        this.usa = usa;
    }

    public Integer getItaly() {
        return italy;
    }

    public void setItaly(Integer italy) {
        this.italy = italy;
    }

    public Integer getMalta() {
        return malta;
    }

    public void setMalta(Integer malta) {
        this.malta = malta;
    }

    public Integer getPortugal() {
        return portugal;
    }

    public void setPortugal(Integer portugal) {
        this.portugal = portugal;
    }

    public Integer getSpain() {
        return spain;
    }

    public void setSpain(Integer spain) {
        this.spain = spain;
    }

    public Integer getFrance() {
        return france;
    }

    public void setFrance(Integer france) {
        this.france = france;
    }

    public Integer getLuxembourg() {
        return luxembourg;
    }

    public void setLuxembourg(Integer luxembourg) {
        this.luxembourg = luxembourg;
    }

    public Integer getTheNetherlands() {
        return theNetherlands;
    }

    public void setTheNetherlands(Integer theNetherlands) {
        this.theNetherlands = theNetherlands;
    }

    public Integer getEastFrisia() {
        return eastFrisia;
    }

    public void setEastFrisia(Integer eastFrisia) {
        this.eastFrisia = eastFrisia;
    }

    public Integer getGermany() {
        return germany;
    }

    public void setGermany(Integer germany) {
        this.germany = germany;
    }

    public Integer getAustria() {
        return austria;
    }

    public void setAustria(Integer austria) {
        this.austria = austria;
    }

    public Integer getSwiss() {
        return swiss;
    }

    public void setSwiss(Integer swiss) {
        this.swiss = swiss;
    }

    public Integer getIceland() {
        return iceland;
    }

    public void setIceland(Integer iceland) {
        this.iceland = iceland;
    }

    public Integer getDenmark() {
        return denmark;
    }

    public void setDenmark(Integer denmark) {
        this.denmark = denmark;
    }

    public Integer getNorway() {
        return norway;
    }

    public void setNorway(Integer norway) {
        this.norway = norway;
    }

    public Integer getSweden() {
        return sweden;
    }

    public void setSweden(Integer sweden) {
        this.sweden = sweden;
    }

    public Integer getFinland() {
        return finland;
    }

    public void setFinland(Integer finland) {
        this.finland = finland;
    }

    public Integer getEstonia() {
        return estonia;
    }

    public void setEstonia(Integer estonia) {
        this.estonia = estonia;
    }

    public Integer getLatvia() {
        return latvia;
    }

    public void setLatvia(Integer latvia) {
        this.latvia = latvia;
    }

    public Integer getLithuania() {
        return lithuania;
    }

    public void setLithuania(Integer lithuania) {
        this.lithuania = lithuania;
    }

    public Integer getPoland() {
        return poland;
    }

    public void setPoland(Integer poland) {
        this.poland = poland;
    }

    public Integer getCzech() {
        return czech;
    }

    public void setCzech(Integer czech) {
        this.czech = czech;
    }

    public Integer getSlovakia() {
        return slovakia;
    }

    public void setSlovakia(Integer slovakia) {
        this.slovakia = slovakia;
    }

    public Integer getHungary() {
        return hungary;
    }

    public void setHungary(Integer hungary) {
        this.hungary = hungary;
    }

    public Integer getRomania() {
        return romania;
    }

    public void setRomania(Integer romania) {
        this.romania = romania;
    }

    public Integer getBulgaria() {
        return bulgaria;
    }

    public void setBulgaria(Integer bulgaria) {
        this.bulgaria = bulgaria;
    }

    public Integer getBosniaAndHerzegovina() {
        return bosniaAndHerzegovina;
    }

    public void setBosniaAndHerzegovina(Integer bosniaAndHerzegovina) {
        this.bosniaAndHerzegovina = bosniaAndHerzegovina;
    }

    public Integer getCroatia() {
        return croatia;
    }

    public void setCroatia(Integer croatia) {
        this.croatia = croatia;
    }

    public Integer getKosovo() {
        return kosovo;
    }

    public void setKosovo(Integer kosovo) {
        this.kosovo = kosovo;
    }

    public Integer getMacedonia() {
        return macedonia;
    }

    public void setMacedonia(Integer macedonia) {
        this.macedonia = macedonia;
    }

    public Integer getMontenegro() {
        return montenegro;
    }

    public void setMontenegro(Integer montenegro) {
        this.montenegro = montenegro;
    }

    public Integer getSerbia() {
        return serbia;
    }

    public void setSerbia(Integer serbia) {
        this.serbia = serbia;
    }

    public Integer getSlovenia() {
        return slovenia;
    }

    public void setSlovenia(Integer slovenia) {
        this.slovenia = slovenia;
    }

    public Integer getAlbania() {
        return albania;
    }

    public void setAlbania(Integer albania) {
        this.albania = albania;
    }

    public Integer getGreece() {
        return greece;
    }

    public void setGreece(Integer greece) {
        this.greece = greece;
    }

    public Integer getRussia() {
        return russia;
    }

    public void setRussia(Integer russia) {
        this.russia = russia;
    }

    public Integer getBelarus() {
        return belarus;
    }

    public void setBelarus(Integer belarus) {
        this.belarus = belarus;
    }

    public Integer getMoldova() {
        return moldova;
    }

    public void setMoldova(Integer moldova) {
        this.moldova = moldova;
    }

    public Integer getUkraine() {
        return ukraine;
    }

    public void setUkraine(Integer ukraine) {
        this.ukraine = ukraine;
    }

    public Integer getArmenia() {
        return armenia;
    }

    public void setArmenia(Integer armenia) {
        this.armenia = armenia;
    }

    public Integer getAzerbaijan() {
        return azerbaijan;
    }

    public void setAzerbaijan(Integer azerbaijan) {
        this.azerbaijan = azerbaijan;
    }

    public Integer getGeorgia() {
        return georgia;
    }

    public void setGeorgia(Integer georgia) {
        this.georgia = georgia;
    }

    public Integer getKazakhstanUzbekistan() {
        return kazakhstanUzbekistan;
    }

    public void setKazakhstanUzbekistan(Integer kazakhstanUzbekistan) {
        this.kazakhstanUzbekistan = kazakhstanUzbekistan;
    }

    public Integer getTurkey() {
        return turkey;
    }

    public void setTurkey(Integer turkey) {
        this.turkey = turkey;
    }

    public Integer getArabiaPersia() {
        return arabiaPersia;
    }

    public void setArabiaPersia(Integer arabiaPersia) {
        this.arabiaPersia = arabiaPersia;
    }

    public Integer getIsrael() {
        return israel;
    }

    public void setIsrael(Integer israel) {
        this.israel = israel;
    }

    public Integer getChina() {
        return china;
    }

    public void setChina(Integer china) {
        this.china = china;
    }

    public Integer getIndiaSriLanka() {
        return indiaSriLanka;
    }

    public void setIndiaSriLanka(Integer indiaSriLanka) {
        this.indiaSriLanka = indiaSriLanka;
    }

    public Integer getJapan() {
        return japan;
    }

    public void setJapan(Integer japan) {
        this.japan = japan;
    }

    public Integer getKorea() {
        return korea;
    }

    public void setKorea(Integer korea) {
        this.korea = korea;
    }

    public Integer getVietnam() {
        return vietnam;
    }

    public void setVietnam(Integer vietnam) {
        this.vietnam = vietnam;
    }

    public Integer getOtherCountries() {
        return otherCountries;
    }

    public void setOtherCountries(Integer otherCountries) {
        this.otherCountries = otherCountries;
    }

    public Map<Integer, List<String>> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap() {
        Map<Integer, List<String>> countryMap = new LinkedHashMap<>();
        countryMap.computeIfAbsent(albania, v -> new ArrayList<>()).add(ALBANIA);
        countryMap.computeIfAbsent(armenia, v -> new ArrayList<>()).add(ARMENIA);
        countryMap.computeIfAbsent(arabiaPersia, v -> new ArrayList<>()).add(ARABIA_PERSIA);
        countryMap.computeIfAbsent(austria, v -> new ArrayList<>()).add(AUSTRIA);
        countryMap.computeIfAbsent(azerbaijan, v -> new ArrayList<>()).add(AZERBAIJAN);
        countryMap.computeIfAbsent(belarus, v -> new ArrayList<>()).add(BELARUS);
        countryMap.computeIfAbsent(bosniaAndHerzegovina, v -> new ArrayList<>()).add(BOSNIA_AND_HERZEGOVINA);
        countryMap.computeIfAbsent(bulgaria, v -> new ArrayList<>()).add(BULGARIA);
        countryMap.computeIfAbsent(china, v -> new ArrayList<>()).add(CHINA);
        countryMap.computeIfAbsent(croatia, v -> new ArrayList<>()).add(CROATIA);
        countryMap.computeIfAbsent(czech, v -> new ArrayList<>()).add(CZECH);
        if (denmark != null) {
            countryMap.computeIfAbsent(denmark, v -> new ArrayList<>()).add(DENMARK);
        }
        if (eastFrisia != null) {
            countryMap.computeIfAbsent(eastFrisia, v -> new ArrayList<>()).add(EAST_FRISIA);
        }
        if (estonia != null) {
            countryMap.computeIfAbsent(estonia, v -> new ArrayList<>()).add(ESTONIA);
        }
        if (finland != null) {
            countryMap.computeIfAbsent(finland, v -> new ArrayList<>()).add(FINLAND);
        }
        if (france != null) {
            countryMap.computeIfAbsent(france, v -> new ArrayList<>()).add(FRANCE);
        }
        if (georgia != null) {
            countryMap.computeIfAbsent(georgia, v -> new ArrayList<>()).add(GEORGIA);
        }
        if (germany != null) {
            countryMap.computeIfAbsent(germany, v -> new ArrayList<>()).add(GERMANY);
        }
        if (greatBritain != null) {
            countryMap.computeIfAbsent(greatBritain, v -> new ArrayList<>()).add(GREAT_BRITAIN);
        }
        if (greece != null) {
            countryMap.computeIfAbsent(greece, v -> new ArrayList<>()).add(GREECE);
        }
        if (hungary != null) {
            countryMap.computeIfAbsent(hungary, v -> new ArrayList<>()).add(HUNGARY);
        }
        if (iceland != null) {
            countryMap.computeIfAbsent(iceland, v -> new ArrayList<>()).add(ICELAND);
        }
        if (indiaSriLanka != null) {
            countryMap.computeIfAbsent(indiaSriLanka, v -> new ArrayList<>()).add(INDIA_SRI_LANKA);
        }
        if (ireland != null) {
            countryMap.computeIfAbsent(ireland, v -> new ArrayList<>()).add(IRELAND);
        }
        if (israel != null) {
            countryMap.computeIfAbsent(israel, v -> new ArrayList<>()).add(ISRAEL);
        }
        if (italy != null) {
            countryMap.computeIfAbsent(italy, v -> new ArrayList<>()).add(ITALY);
        }
        if (japan != null) {
            countryMap.computeIfAbsent(japan, v -> new ArrayList<>()).add(JAPAN);
        }
        if (kazakhstanUzbekistan != null) {
            countryMap.computeIfAbsent(kazakhstanUzbekistan, v -> new ArrayList<>()).add(KAZAKHSTAN_UZBEKISTAN);
        }
        if (korea != null) {
            countryMap.computeIfAbsent(korea, v -> new ArrayList<>()).add(KOREA);
        }
        if (kosovo != null) {
            countryMap.computeIfAbsent(kosovo, v -> new ArrayList<>()).add(KOSOVO);
        }
        if (latvia != null) {
            countryMap.computeIfAbsent(latvia, v -> new ArrayList<>()).add(LATVIA);
        }
        if (lithuania != null) {
            countryMap.computeIfAbsent(lithuania, v -> new ArrayList<>()).add(LITHUANIA);
        }
        if (luxembourg != null) {
            countryMap.computeIfAbsent(luxembourg, v -> new ArrayList<>()).add(LUXEMBOURG);
        }
        if (macedonia != null) {
            countryMap.computeIfAbsent(macedonia, v -> new ArrayList<>()).add(MACEDONIA);
        }
        if (malta != null) {
            countryMap.computeIfAbsent(malta, v -> new ArrayList<>()).add(MALTA);
        }
        if (moldova != null) {
            countryMap.computeIfAbsent(moldova, v -> new ArrayList<>()).add(MOLDOVA);
        }
        if (montenegro != null) {
            countryMap.computeIfAbsent(montenegro, v -> new ArrayList<>()).add(MONTENEGRO);
        }
        if (norway != null) {
            countryMap.computeIfAbsent(norway, v -> new ArrayList<>()).add(NORWAY);
        }
        if (otherCountries != null) {
            countryMap.computeIfAbsent(otherCountries, v -> new ArrayList<>()).add(OTHER_COUNTRIES);
        }
        if (poland != null) {
            countryMap.computeIfAbsent(poland, v -> new ArrayList<>()).add(POLAND);
        }
        if (portugal != null) {
            countryMap.computeIfAbsent(portugal, v -> new ArrayList<>()).add(PORTUGAL);
        }
        if (romania != null) {
            countryMap.computeIfAbsent(romania, v -> new ArrayList<>()).add(ROMANIA);
        }
        if (russia != null) {
            countryMap.computeIfAbsent(russia, v -> new ArrayList<>()).add(RUSSIA);
        }
        if (serbia != null) {
            countryMap.computeIfAbsent(serbia, v -> new ArrayList<>()).add(SERBIA);
        }
        if (slovakia != null) {
            countryMap.computeIfAbsent(slovakia, v -> new ArrayList<>()).add(SLOVAKIA);
        }
        if (slovenia != null) {
            countryMap.computeIfAbsent(slovenia, v -> new ArrayList<>()).add(SLOVENIA);
        }
        if (spain != null) {
            countryMap.computeIfAbsent(spain, v -> new ArrayList<>()).add(SPAIN);
        }
        if (sweden != null) {
            countryMap.computeIfAbsent(sweden, v -> new ArrayList<>()).add(SWEDEN);
        }
        if (swiss != null) {
            countryMap.computeIfAbsent(swiss, v -> new ArrayList<>()).add(SWISS);
        }
        if (turkey != null) {
            countryMap.computeIfAbsent(turkey, v -> new ArrayList<>()).add(TURKEY);
        }
        if (theNetherlands != null) {
            countryMap.computeIfAbsent(theNetherlands, v -> new ArrayList<>()).add(THE_NETHERLANDS);
        }
        if (ukraine != null) {
            countryMap.computeIfAbsent(ukraine, v -> new ArrayList<>()).add(UKRAINE);
        }
        if (usa != null) {
            countryMap.computeIfAbsent(usa, v -> new ArrayList<>()).add(USA);
        }
        if (vietnam != null) {
            countryMap.computeIfAbsent(vietnam, v -> new ArrayList<>()).add(VIETNAM);
        }
        countryMap.remove(null);
        this.countryMap = countryMap;
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", greatBritain=" + greatBritain +
                ", ireland=" + ireland +
                ", usa=" + usa +
                ", italy=" + italy +
                ", malta=" + malta +
                ", portugal=" + portugal +
                ", spain=" + spain +
                ", france=" + france +
                ", luxembourg=" + luxembourg +
                ", theNetherlands=" + theNetherlands +
                ", eastFrisia=" + eastFrisia +
                ", germany=" + germany +
                ", austria=" + austria +
                ", swiss=" + swiss +
                ", iceland=" + iceland +
                ", denmark=" + denmark +
                ", norway=" + norway +
                ", sweden=" + sweden +
                ", finland=" + finland +
                ", estonia=" + estonia +
                ", latvia=" + latvia +
                ", lithuania=" + lithuania +
                ", poland=" + poland +
                ", czech=" + czech +
                ", slovakia=" + slovakia +
                ", hungary=" + hungary +
                ", romania=" + romania +
                ", bulgaria=" + bulgaria +
                ", bosniaAndHerzegovina=" + bosniaAndHerzegovina +
                ", croatia=" + croatia +
                ", kosovo=" + kosovo +
                ", macedonia=" + macedonia +
                ", montenegro=" + montenegro +
                ", serbia=" + serbia +
                ", slovenia=" + slovenia +
                ", albania=" + albania +
                ", greece=" + greece +
                ", russia=" + russia +
                ", belarus=" + belarus +
                ", moldova=" + moldova +
                ", ukraine=" + ukraine +
                ", armenia=" + armenia +
                ", azerbaijan=" + azerbaijan +
                ", georgia=" + georgia +
                ", kazakhstanUzbekistan=" + kazakhstanUzbekistan +
                ", turkey=" + turkey +
                ", arabiaPersia=" + arabiaPersia +
                ", israel=" + israel +
                ", china=" + china +
                ", indiaSriLanka=" + indiaSriLanka +
                ", japan=" + japan +
                ", korea=" + korea +
                ", vietnam=" + vietnam +
                ", otherCountries=" + otherCountries +
                '}';
    }
}
