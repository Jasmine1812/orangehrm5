package utilities;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerConfig {

    //    Faker faker = new Faker(new Locale("vi", "vi"));
    Faker faker = new Faker();
    public static DataFakerConfig getFaker(){
        return new DataFakerConfig();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getNameContact(){
        return faker.name().fullName();
    }
    public String getRelationship(){
        return faker.relationships().direct();
    }

    public String getOtherId(){
        return faker.idNumber().valid();
    }


    public String getDriversLicenseNumber() {
        return faker.drivingLicense().toString();
    }

    public String getNationality() {
        return faker.country().name();
    }

    public String getMaritalStatus() {
        return faker.demographic().maritalStatus();
    }

    public String getMiddleName() {
        return faker.name().nameWithMiddle();
    }

    public String getStreet1() {
        return faker.address().streetAddressNumber();
    }

    public String getStreet2() {
        return faker.address().streetAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getStateProvince() {
        return faker.address().state();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getHomeTelephone() {
        return faker.phoneNumber().cellPhone();
    }

    public String getWorkTelephone() {
        return faker.phoneNumber().phoneNumberInternational();
    }
    public String getGender(){
        return faker.gender().toString();
    }

    public String getMobile() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getComment() {
        return faker.text().text(10,30);
    }

    public String getEmployeeID() {
        return  faker.idNumber().valid();
    }
}
