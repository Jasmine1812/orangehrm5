package jsonData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class EmployeeInfo {
    public static EmployeeInfo getEmployeeInfo(String filename){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + filename),EmployeeInfo.class);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    @JsonProperty("firstname")
    String firstName;

    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("middlename")
    String middleName;

    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("lastname")
    String lastName;

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("PersonalDetails")
    PersonalDetails personalDetails;

    static class PersonalDetails{

        @JsonProperty("otherId")
        String otherID;

        @JsonProperty("driversLicenseNumber")
        String driversLicenseNumber;

        @JsonProperty("dateOfBirth")
        String dateOfBirth;

        @JsonProperty("gender")
        String gender;

        @JsonProperty("licenseExpiryDate")
        String licenseExpiryDate;

        @JsonProperty("maritalStatus")
        String maritalStatus;

        @JsonProperty("nationality")
        String nationality;
    }

    public String getOtherID() {
        return personalDetails.otherID;
    }

    public String getDriversLicenseNumber() {
        return personalDetails.driversLicenseNumber;
    }

    public String getDateOfBirth() {
        return personalDetails.dateOfBirth;
    }

    public String getGender() {
        return personalDetails.gender;
    }

    public String getLicenseExpiryDate() {
        return personalDetails.licenseExpiryDate;
    }

    public String getMaritalStatus() {
        return personalDetails.maritalStatus;
    }

    public String getNationality() {
        return personalDetails.nationality;
    }

}
