package primarycare.tests.API.Patient_Attachment_and_Registry;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.*;
import primarycare.tests.API_BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

@Listeners({TestListener.class})
public class API_Registering_Primary_Care_Attached_Patient_SYSAdmin extends API_BaseTest_PrimaryCare {
    //1. Create Patient Account
    public String firstName = "API_Kenton3_Patient_Attached";
    public String lastName = "API_Troup3";
    public String recordTypeId = "0125f0000003ekBAAQ ";
    public String phn = "9873010088";
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

    //2.select Patient PersonContactID from Account
    public String personContactId;

    //3. Create Primary Contact Account
    public String contactRelationsFirstName = "API_Primary3";
    public String contactRelationsLastName = "API_CareContact3";
    ////REFRESH
    public String contactRecordTypeId = "0125f0000002f6sAAA"; //from Account
    ////REFRESH
    //public String contactRecordPersonContactId = "003Aq00000BIdKkIAL";
    ////REFRESH
    public String contactRecord_healthCloudGA__sourceSystem__c = "Health1-00DbZ0000003Lj3"; //from Account
    public String contactRecord_healthCloudGA__sourceSystem__pc = "Health1-00DbZ0000003Lj3";
    ////REFRESH
    public String primaryContactAccountID;//id

    //4.select Primary Care PersonContactID from Account
    public String primaryCarePersonContactID;


    //5. Create ContactContact Relationship
    //public String healthCloudGA__RelatedContact__c = "003Aq00000BOVabIAH"; //API_Kenton's -> PesoContactID
    //public String healthCloudGA__Contact__c = "003Aq00000BOXFpIAP"; // PesoContactID -> API_Primary3 API_CareContact3
    ////REFRESH
    public String healthCloudGA__Role__c = "a16As000000zXddIAE"; //"Primary Contact" record role ->Contact Relation Name role from 'HealthCloudGA__ContactContactRelation__c' Object
    ////REFRESH
    public String contactContactRelationId;



    //6. Create Attached Case
    public String caseRecordTypeId = "0125f000000qtfjAAA";
    ////REFRESH
    public String caseAccountId = "001As00000TBT94IAH"; //"3113 Broadmoor";
    public String casePrimaryCareNetwork__c = "001As00000TB8XCIA1"; //"Richmond - East";
    ////REFRESH
    public String caseReason = "Attached - Family doctor or nurse practitioner is not accepting additional family members";
    public String caseOrigin = "Web";
    //public String caseContactName = "Sandy3_Patient_NOT_Attached";
    ////REFRESH
    public String practitionerAttached__c = "001As00000TBVShIAP";//from "Case" Lori-Ann May Bus
    public String caseStatus = "Attached";
    ////REFRESH

    public String caseId;

    //7. Create Case Contact Role
    public String role = "Current Practitioner";
    ////REFRESH
    public String practitionerContactId = "003As00000POUxnIAH";//from "CaseContactRole" ContactId Lori-Ann May Bus
    ////REFRESH
    public String caseContactRoleID;


    @Test(priority = 1)
    public void API_Can_Register_Person_In_Care_Attached_Patient_Account_in_Salesforce_Status_Code_201_as_SysAdmin() {
        TestcaseID = "251778"; //C251778
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
    public void API_Can_Create_Primary_Contact_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261363"; //C261363
        APICreatePrimaryContactAccount apiInsertPrimaryContactAccount = new APICreatePrimaryContactAccount();
        log("Create Primary account record.");
        String primaryContactId = apiInsertPrimaryContactAccount.insertPrimaryContactAccount(
                contactRelationsFirstName,
                contactRelationsLastName,
                contactRecordTypeId,
                contactRecord_healthCloudGA__sourceSystem__c,
                contactRecord_healthCloudGA__sourceSystem__pc
        );
        log("Primary Contact account id is: " +primaryContactId);
        log("Status Code 201 - Primary Contact account created successfully.");
        primaryContactAccountID = primaryContactId;

    }

    @Test(priority = 4)
    public void API_Can_Select_Primary_Contact_PersonContactID_From_Account_Salesforce_as_SysAdmin(){
        TestcaseID = "261365"; //C261365
        APISelect sqlQuery = new APISelect();
        log("Select Primary Contact PersonContactID from Account.");
        String primaryCarePersonContactId = sqlQuery.selectPersonAccountIDSQL("SELECT PersonContactId from Account WHERE id = '"+primaryContactAccountID+"'", "PersonContactId");
        log("Selected Primary Care PersonContactID from Account is: " +primaryCarePersonContactID);
        //Assert.assertEquals(accountNameReturned, name);
        primaryCarePersonContactID=primaryCarePersonContactId;
        log("Status Code 200 - Primary Care Person Contact Id SELECTED request - successfully");
    }


    @Test(priority = 5)
    public void API_Can_Create_Primary_Contact_Contact_Relationships_with_Patient_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261368"; //C261368
        String healthCloudGA__RelatedContact__c = personContactId; //API_Kenton's -> PersonContactID
        String healthCloudGA__Contact__c = primaryCarePersonContactID; // PersonContactID -> API_Primary3 API_CareContact3
        APICreateContactContactRelations apiInsertPrimaryContactContactRelations = new APICreateContactContactRelations();
        log("Create Primary Contact-Contact Relations for Patient account record.");
        String contactContactRelationID = apiInsertPrimaryContactContactRelations.insertPrimaryContactContactRelations(
                healthCloudGA__RelatedContact__c,
                healthCloudGA__Contact__c,
                healthCloudGA__Role__c
        );
        log("Primary  Contact-Contact Relation id is: " +contactContactRelationID);
        log("Status Code 201- Contact-Contact record created successfully.");
        contactContactRelationId = contactContactRelationID;
    }

    @Test(priority = 6)
    public void API_Can_Create_Primary_Attached_Case_for_Patient_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261369"; //C261369
        APICreateCase apiInsertAttachedCase = new APICreateCase();
        log("Create Attached CASE for Patient account record.");
        String caseID = apiInsertAttachedCase.insertAttachedCase(caseRecordTypeId,
                caseAccountId,casePrimaryCareNetwork__c,caseReason,
                caseOrigin,personContactId,caseStatus,practitionerAttached__c);
        log("Attached Case id is: " +caseID);
        log("Status Code 201- created success");
        caseId=caseID;
    }

    @Test(priority = 7)
    public void API_Can_Create_Practitioner_Case_Contact_Role_for_Patient_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261371"; //C261371
        APICreateCaseContactRole apiInsertPractitionerCaseContactRole = new APICreateCaseContactRole();
        log("Create Practitioner Case Contact Role record.");
        String caseContactRoleId = apiInsertPractitionerCaseContactRole.insertPractitionerCaseContactRole(
                caseId,
                practitionerContactId,//Lori-Ann May Bus
                role
        );
        log("Practitioner Case Contact Role id is: " +caseContactRoleId);
        log("Status Code 201- Case Contact Role created successfully.");
        caseContactRoleID = caseContactRoleId;
    }

    @Test(priority = 8)
    public void API_Delete_Practitioner_Case_Contact_Role_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261372"; //C261372
        APIDelete apiDelete = new APIDelete();
        log("Delete Case_Contact_Role record.");
        String apiResponse = apiDelete.deleteCaseContactRole(caseContactRoleID);
        log("Deleted Case Contact Role record from CaseContactRole is: " +caseContactRoleID);
        log("Status Code 204 -  Case Contact Role record deleted - successfully");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }

    @Test(priority = 9)
    public void API_Delete_Primary_Attached_Case_for_Patient_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "260765"; //C260765
        APIDelete apiDelete = new APIDelete();
        log("Delete Patient Attached Case from Cases .");
        String apiResponse = apiDelete.deleteCase(caseId);
        log("Deleted Patient Attached Case from Cases is: " +caseId);
        log("Status Code 204 -  Case for Patient Attached deleted - successfully");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }

    @Test(priority = 10)
    public void API_Delete_ContactContact_Relation_Record_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261373"; //C261373
        APIDelete apiDelete = new APIDelete();
        log("Delete ContactContact_Relation_Record from 'HealthCloudGA__ContactContactRelation__c' .");
        String apiResponse = apiDelete.deleteContactContactRelation(contactContactRelationId);
        log("Deleted ContactContact_Relation_Record from 'HealthCloudGA__ContactContactRelation__c' is: " +caseId);
        log("Status Code 204 -  ContactContact_Relation_Record Patient Attached deleted - successfully");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }

    @Test(priority = 11)
    public void API_Delete_Primary_Contact_Account_in_Salesforce_as_SysAdmin(){
        TestcaseID = "261375"; //C261375
        APIDelete apiDelete = new APIDelete();
        log("Delete Primary_Contact from Account.");
        String apiResponse = apiDelete.deleteAccount(primaryContactAccountID);
        log("Deleted Primary_Contact from Account is: " +primaryContactAccountID);
        log("Status Code 204 -  Primary_Contact record from Account Attached deleted - successfully");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }

    @Test(priority = 12)
    public void API_Delete_Patient_Account_in_Salesforce_Status_Code_204_as_SysAdmin(){
        TestcaseID = "252628"; //C252628
        APIDelete apidelete = new APIDelete();
        log("Delete Patient account from Account.");
        String apiResponse = apidelete.deleteAccount(accId);
        log("Deleted Patient Account from Account is: " +accId);
        log("Status Code 204 - Attached Patient deleted from Account successfully.");
        log(apiResponse);
        //Assert.assertEquals(accountNameReturned, name);
    }
}
