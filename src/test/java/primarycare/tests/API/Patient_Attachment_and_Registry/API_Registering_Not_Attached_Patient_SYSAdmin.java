package primarycare.tests.API.Patient_Attachment_and_Registry;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.APICreateCase;
import primarycare.pages.APICreatePatientAccount;
import primarycare.pages.APIDelete;
import primarycare.pages.APISelect;
import primarycare.tests.API_BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

import java.util.Random;



import static primarycare.tests.BaseTest_PrimaryCare.log;

@Listeners({TestListener.class})
public class API_Registering_Not_Attached_Patient_SYSAdmin extends API_BaseTest_PrimaryCare {
    //1.Patient Account
    public String firstName = "Sandy3_Patient_NOT_Attached_API";
    public String lastName = "Prior3_API";
    public String recordTypeId = "0125f0000003ekBAAQ ";
    public String phn = "9873010063";
    public String gender = "Male";
    public String birthdate = "1959-12-05";
    public String preferredCommunicationChannel = "Email";
    public String mobile = "7788793897";
    public String email = "accountToDelete@phsa.ca";
    public String street = "307-7631 Francis Rd";
    public String city = "Richmond";
    public String postalcode = "V6Y1A3";
    public String isActive = "true";

    public String accId;

    //2.select Person Contact ID
    public String personContactId;

    //3.Case
    public String caseRecordTypeId = "0125f000000qtfjAAA";
    ////REFRESH
    public String caseAccountId = "001bZ0000015QIsQAM"; //"3113 Broadmoor";
    public String casePrimaryCareNetwork__c = "001bZ0000015PcUQAU"; //"Richmond - East";
    ////REFRESH
    public String caseReason = "Unattached - Requires attachment to family doctor or nurse practitioner";
    public String caseOrigin = "Web";
    //public String caseContactName = "Sandy3_Patient_NOT_Attached";
    public String caseStatus = "Active";

    public String caseId;


    @Test(priority = 1)
    public void API_Can_Register_Not_Attached_Patient_Account_in_Salesforce_Status_Code_201_as_SysAdmin() {
        TestcaseID = "251776"; //C251776
        APICreatePatientAccount apiinsertAccount = new APICreatePatientAccount();
        log("Create Patient account record.");
        String accountID = apiinsertAccount.insertAccount(recordTypeId, firstName,lastName,phn,gender,
                birthdate,preferredCommunicationChannel, mobile,email,street,city,postalcode,isActive);
        log("Created Patient's id is: " +accountID);
        log("Status Code 201- created success");
        accId=accountID;
    }

    @Test(priority = 2)
    public void API_Can_Select_Patient_PersonContactID_From_Account_Salesforce_as_SysAdmin(){
        TestcaseID = "260763"; //C260763
        APISelect sqlQuery = new APISelect();
        log("Select PersonContactID from Account.");
        String personContactID = sqlQuery.selectPersonAccountIDSQL("SELECT PersonContactId from Account WHERE id = '"+accId+"'", "PersonContactId");
        log("Selected PersonContactID from Account is: " +personContactID);
        //Assert.assertEquals(accountNameReturned, name);
        personContactId=personContactID;
        log("Status Code 200 - Person Contact Id SELECTED request - successfully");
    }

    @Test(priority = 3)
    public void API_Can_Create_Unattached_Case_for_Patient_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "260764"; //C260764
        APICreateCase apiInsertUnattachedCase = new APICreateCase();
        log("Create Unattached CASE for Patient account record.");
        String caseID = apiInsertUnattachedCase.insertUnattachedCase(caseRecordTypeId,
                caseAccountId,casePrimaryCareNetwork__c,caseReason,
                caseOrigin,personContactId,caseStatus);
        log("Unattached Case id is: " +caseID);
        log("Status Code 201- created success");
        caseId=caseID;

    }

    @Test(priority = 4)
    public void API_Delete_Case_for_Patient_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "260765"; //C260765
        APIDelete apiDelete = new APIDelete();
        log("Delete Patient Case from Cases .");
        String apiResponse = apiDelete.deleteCase(caseId);
        log("Deleted Patient Case from Cases is: " +caseId);
        log("Status Code 204 -  Case for Patient Unattached deleted - successfully");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }

    @Test(priority = 5)
    public void API_Delete_Patient_Account_in_Salesforce_Status_Code_204_as_SysAdmin(){
        TestcaseID = "252628"; //C252628
        APIDelete apidelete = new APIDelete();
        log("Delete Patient account from Account.");
        String apiResponse = apidelete.deleteAccount(accId);
        log("Deleted Patient Account from Account is: " +accId);
        log("Status Code 204 - Unattached Patient deleted from Account successfully.");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }
}
