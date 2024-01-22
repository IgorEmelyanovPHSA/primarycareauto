package primarycare.tests.API.Provider_and_Rostering;

import org.testng.Assert;
import org.testng.annotations.Test;
import primarycare.pages.APICreateClinicAccount;
import primarycare.pages.APICreatePractitionerAccount;
import primarycare.pages.APIDelete;
import primarycare.pages.APISelect;
import primarycare.tests.API_BaseTest_PrimaryCare;

import static primarycare.tests.BaseTest_PrimaryCare.log;

public class API_Create_Practitioner_Facility_Associated_SysAdmin extends API_BaseTest_PrimaryCare{
    //1.for Practitioner account
    public String firstName = "API_Practitioner_222";//Tanya
    public String lastName = "Director";//Drysdale
    public String birthdate = "1983-07-11";
    public String gender = "Women";
    public String email = "accountToDelete@phsa.ca";
    public String phone = "2502946960";
    public String isActive = "true";
    public String recordTypeId = "0125f000000qtflAAA";
    ///REFRESH
    public String healthCloudGA__SourceSystem__c = "Health1-00DAs000002hhVZ";
    public String healthCloudGA__SourceSystem__pc = "Health1-00DAs000002hhVZ";
    ///REFRESH

    public String accId;
    public String personContactId;


    //2. for Clinic Facility creation
    public String accountClinicName = "API_222 CRATED CLINIC ASSOCIATED";
    public String recordClinicTypeId = "0125f000000qtffAAA";
    public String sourceSystemClinic = "Health1-00D8G0000004adM";
    public String businessClinicEmail = "accountToDelete@phsa.ca";
    public String phoneClinic = "2503652161";
    public String mailingStreetClinic = "1008 COLUMBIA AVE";
    public String mailingCityClinic = "Castlegar";
    public String mailingProvinceClinic = "BC";
    public String mailingPostalCodeClinic = "V1N 1H2";
    public String mailingCountryClinic = "Canada";
    public String mailingLocationStreetClinic = "1008 COLUMBIA AVE";
    public String mailingLocationCityClinic = "Castlegar";
    public String mailingLocationProvinceClinic = "BC";
    public String mailingLocationPostalCodeClinic = "V1N 1H2";
    public String mailingLocationContryClinic = "Canada";
    public String isActive_Clinic = "true";


    ///4.for Practitioner Facility Associated creation
    public String practitionerFacilityName = "API_Practitioner_222 Director | API_222 CRATED CLINIC ASSOCIATED";
    public String clinicAccountId;// = "0018N00000F9StyQAF"; //CASTLEGAR MEDICAL ASSOCIATES
    public String practitionerId; //"0038N00000D9NPoQAN";//Lori-Ann May Bus
    //public String acceptingNewPatients = "Yes";
    //public String maxNewRequests = "77777";
    public String role = "Director";
    //public String role = "Provider";
    //public String role = "Medical Office Assistant";
    public String isActive_associated = "true";
    public String MSP = "09876";

    //5 for delete HCPF
    public String practitionerFacility_accId;

    //9 delete HFN
    public String healthCareFacilityNetwork_Id;
    public String healthcareFacilityNetworkName = "API_Practitioner_222 Director | Panel | API_222 CRATED CLINIC ASSOCIATED";


    @Test(priority = 1)
    public void API_Can_Create_Practitioner_Account_No_Associated_in_Salesforce_Status_Code_201_as_SysAdmin(){
        TestcaseID = "252884"; //C252884
        APICreatePractitionerAccount apiCreatePractitionerAccount = new APICreatePractitionerAccount();
        log("Create Practitioner account record.");
        String accountID = apiCreatePractitionerAccount.insertPractitionerAccount(recordTypeId, firstName,lastName,gender,
                birthdate,phone,email,isActive,MSP,healthCloudGA__SourceSystem__c,healthCloudGA__SourceSystem__pc);
        log("Created Practitioner's id is: " +accountID);
        log("Status Code 201- Practitioner Account has Created - successfully");
        accId = accountID;
    }

    @Test(priority = 2)
    public void API_Can_Select_PersonContactID_From_Account_Salesforce_as_SysAdmin(){
        TestcaseID = "255139"; //C255139
        APISelect sqlQuery = new APISelect();
        log("Select PersonAccountID from Account.");
        String personContactID = sqlQuery.selectPersonAccountIDSQL("SELECT PersonContactId from Account WHERE id = '"+accId+"'", "PersonContactId");
        log("Selected PersonAccountID from Account is: " +personContactID);
        //Assert.assertEquals(accountNameReturned, name);
        personContactId=personContactID;
        log("Status Code 200 - Person Contact Id SELECTED request - successfully");
    }

    @Test(priority = 3)
    public void API_Can_Create_Clinic_Account_in_Salesforce_Status_Code_201_as_SysAdmin(){
        TestcaseID = "255149"; //C255149
        APICreateClinicAccount apiCreateClinic = new APICreateClinicAccount();
        log("Create a Clinic account record.");
        String accountClinicID = apiCreateClinic.insertClinicAccount(accountClinicName,recordClinicTypeId,
                sourceSystemClinic, businessClinicEmail,phoneClinic,mailingStreetClinic,mailingCityClinic,
                mailingProvinceClinic,mailingPostalCodeClinic,mailingCountryClinic,
                mailingLocationStreetClinic,mailingLocationCityClinic,
                mailingLocationProvinceClinic,mailingLocationPostalCodeClinic,
                mailingLocationContryClinic,isActive_Clinic);
        log("Created a Clinic Facility id is: " +accountClinicID);
        log("Status Code 201- Clinic Account has Created - successfully");
        clinicAccountId = accountClinicID;
    }


    @Test(priority = 4)
    public void API_Can_Create_Practitioner_DIRECTORs_Facility_Associated_in_Salesforce_Status_Code_201_as_SysAdmin(){
        TestcaseID = "252895"; //252895
        APICreatePractitionerAccount apiCreateDirectorAccount = new APICreatePractitionerAccount();
        log("Create Practitioner DIRECTOR's Associated account record.");
        String accountID = apiCreateDirectorAccount.insertDirectorAssociatedAccount(practitionerFacilityName,
                clinicAccountId,personContactId,role,isActive_associated);
        log("Created Director Practitioner id is: " +accountID);
        log("Status Code 201 - Director's Associated Health Practitioner Facility has Created  - successfully");
        practitionerFacility_accId = accountID;
    }


    @Test(priority = 5)
    public void API_Delete_Practitioner_DIRECTORs_Facility_Associated_in_Salesforce_as_SysAdmin(){
        TestcaseID = "255857"; //C255857
        APIDelete apidelete_practitionerFacility = new APIDelete();
        log("Delete PractitionerFacility from HealthcarePractitionerFacility.");
        String apiResponse = apidelete_practitionerFacility.deletePractitionerFacility(practitionerFacility_accId);
        log("Deleted PractitionerFacility from HealthcarePractitionerFacility is: " +practitionerFacility_accId);
        log(apiResponse);
        log("Status Code 204 - Director's Associated HealthPractitionerFacility  Deleted - successfully");
    }

    @Test(priority = 6)
    public void API_Delete_the_Clinic_Account_in_Salesforce__Status_Code_204_as_SysAdmin(){
        TestcaseID = "255859"; //C255859
        APIDelete apidelete_Clinic = new APIDelete();
        log("Delete Clinic from Account");
        String apiResponse = apidelete_Clinic.deleteAccount(clinicAccountId);
        log("Deleted Clinic from Account is: " +clinicAccountId);
        log(apiResponse);
        log("Status Code 204 -  Clinic from Account  Deleted - successfully");
    }

    @Test(priority = 7)
    public void API_Delete_the_Practitioner_Account_in_Salesforce__Status_Code_204_as_SysAdmin(){
        TestcaseID = "252885"; //C252885
        APIDelete apidelete_Practitioner = new APIDelete();
        log("Delete Practitioner from Account");
        String apiResponse = apidelete_Practitioner.deleteAccount(accId);
        log("Deleted Practitioner from Account is: " +accId);
        log(apiResponse);
        log("Status Code 204 -  Practitioner from Account  Deleted - successfully");
    }

    @Test(priority = 8)
    public void API_Can_Select_HealthcareFacilityNetworkID_in_Salesforce__Status_Code_200_as_SysAdmin(){
        TestcaseID = "262533"; //C262533
        APISelect sqlQuery = new APISelect();
        log("Select Healthcare Facility Network Id from HealthcareFacilityNetwork.");
        String healthcareFacilityNetworkID = sqlQuery.selectPractitionerFacilityIdIDSQL("SELECT Id from HealthcareFacilityNetwork WHERE Name = '"+healthcareFacilityNetworkName+"'", "Id");
        log("Selected Healthcare Facility Network Id from HealthcareFacilityNetwork is: " +healthcareFacilityNetworkID);
        //Assert.assertEquals(accountNameReturned, name);
        log("Status Code 200 - Healthcare Facility Network Id SELECTED request - successfully");
        healthCareFacilityNetwork_Id = healthcareFacilityNetworkID;
    }

    @Test(priority = 9)
    public void API_Delete_Practitioner_DIRECTORs_Healthcare_Facility_Network_in_Salesforce_as_SysAdmin(){
        TestcaseID = "262532"; //C262532
        //healthCareFacilityNetwork_Id="0bYAq00000009jFMAQ";
        APIDelete apidelete_practitionerFacility = new APIDelete();
        log("Delete PractitionerFacility from HealthcareFacilityNetwork.");
        String apiResponse = apidelete_practitionerFacility.deleteHealthcareFacilityNetwork(healthCareFacilityNetwork_Id);
        log("Deleted PractitionerFacility from HealthcareFacilityNetwork is: " +healthCareFacilityNetwork_Id);
        log(apiResponse);
        log("Status Code 204 - HealthcareFacilityNetwork  Deleted - successfully");
    }





}
