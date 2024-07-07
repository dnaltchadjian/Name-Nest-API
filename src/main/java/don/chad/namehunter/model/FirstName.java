package don.chad.namehunter.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "names")
@AllArgsConstructor
@NoArgsConstructor
public class FirstName {

    @Id
    private ObjectId id;

    private String name;

    private String gender;

    @Field("Great Britain")
    private Integer greatBritain;

    private Integer ireland;
    private Integer usa;
    private Integer italy;
    private Integer malta;
    private Integer portugal;
    private Integer spain;
    private Integer france;
    private Integer luxembourg;
    @Field("the Netherlands")
    private Integer theNetherlands;
    @Field("East Frisia")
    private Integer eastFrisia;
    private Integer germany;
    private Integer austria;
    private Integer swiss;
    private Integer iceland;
    private Integer denmark;
    private Integer norway;
    private Integer sweden;
    private Integer finland;
    private Integer estonia;
    private Integer latvia;
    private Integer lithuania;
    private Integer poland;
    @Field("Czech Republic")
    private Integer czech;
    private Integer slovakia;
    private Integer hungary;
    private Integer romania;
    private Integer bulgaria;
    @Field("Bosnia and Herzegovina")
    private Integer bosniaAndHerzegovina;
    private Integer croatia;
    private Integer kosovo;
    private Integer macedonia;
    private Integer montenegro;
    private Integer serbia;
    private Integer slovenia;
    private Integer albania;
    private Integer greece;
    private Integer russia;
    private Integer belarus;
    private Integer moldova;
    private Integer ukraine;
    private Integer armenia;
    private Integer azerbaijan;
    private Integer georgia;
    @Field("Kazakhstan/Uzbekistan,etc")
    private Integer kazakhstanUzbekistan;
    private Integer turkey;
    @Field("Arabia/Persia")
    private Integer arabiaPersia;
    private Integer israel;
    private Integer china;
    @Field("India/Sri Lanka")
    private Integer indiaSriLanka;
    private Integer japan;
    private Integer korea;
    private Integer vietnam;
    @Field("other countries")
    private Integer otherCountries;

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
