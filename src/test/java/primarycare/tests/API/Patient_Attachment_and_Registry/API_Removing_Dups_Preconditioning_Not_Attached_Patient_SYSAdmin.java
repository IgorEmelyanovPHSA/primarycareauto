package primarycare.tests.API.Patient_Attachment_and_Registry;

import primarycare.pages.APIDelete;
import primarycare.pages.APISelect;
import primarycare.tests.Utilities.ApiQueries;
import primarycare.tests.Utilities.TestListener;
import primarycare.tests.API_BaseTest_PrimaryCare;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
public class API_Removing_Dups_Preconditioning_Not_Attached_Patient_SYSAdmin extends API_BaseTest_PrimaryCare {
    private String legalFirstName = "Sandy";
    private String legalLastName = "Prior";
    //private boolean isIndigenous = false;
    private String email = "accountToDelete@phsa.ca";

    //for API
    public String personContactId;
    public String caseId;
    public String accId;


    @Test(priority = 1)
    public void API_Precondition_Delete_Dups_Patient_and_Case_in_Salesforce_as_SysAdmin(){
        TestcaseID = "251774"; //C251774
        //log("/*0.---Pre-Condition API Remove 'Sandy Prior' with the Case from SF --*/");
        //1.find personContactID
        APISelect sqlQuery1 = new APISelect();
        log("Select PersonContactID 'Sandy Prior' from Account.");
        try {
            String personContactID = sqlQuery1.selectPersonAccountIDSQL("SELECT PersonContactId from Account " +
                    "WHERE FirstName = '"+legalFirstName+"' and LastName = '"+legalLastName+"' and PersonEmail = '"+email+"'"  , "PersonContactId");
            log("Selected PersonContactID from Account is: " +personContactID);
            personContactId=personContactID;
            log("Status Code 200 - Person Contact Id SELECTED request - successfully");
            log("/*---'Sandy Prior' with 'accountToDelete@phsa.ca' has founded");
        } catch (Exception e) {
            log("/*---No 'Sandy Prior' with 'accountToDelete@phsa.ca' at all in SF");
            //throw e;
        }
        if(personContactId==null){
            log("Finish API Preconditioning because no Patient 'Sandy' Dups. ");
        }
        else {
            //2. find Patient ID
            APISelect sqlQuery2 = new APISelect();
            log("Select AccID 'Sandy Prior' from Account.");
            String patientAccID = sqlQuery2.selectPersonAccountIDSQL("SELECT Id from Account " +
                    "WHERE FirstName = '"+legalFirstName+"' and LastName = '"+legalLastName+"' and PersonEmail = '"+email+"'"  , "Id");
            log("Selected Patient AccID 'Sandy Prior' from Account is: " +patientAccID);
            accId=patientAccID;
            log("Status Code 200 - Patient AccID 'Sandy Prior' SELECTED request - successfully");
            //3.find Case ID
            APISelect sqlQuery3 = new APISelect();
            try {
                log("Select CaseId for 'Sandy Prior' from  the 'Case'.");
                String caseIDReturned = sqlQuery3.selectCaseIDSql("SELECT Id from Case " + "WHERE ContactId = '" + personContactId + "'", "Id");
                log("Selected CaseId for 'Sandy Prior' from 'Case' is: " + caseIDReturned);
                caseId = caseIDReturned;
            }catch (Exception e) {
                log("/*---No 'Cases' for 'Sandy Prior' with 'accountToDelete@phsa.ca' at all in SF");
            }
            if(caseId==null){
                log("Finish API Preconditioning because no 'Cases' for 'Sandy' Dups. ");
            }
            else {
                //4.remove 'Case' first
                APIDelete apiDelete = new APIDelete();
                log("Delete Patient Case for 'Sandy Prior' from Cases .");
                String apiResponse1 = apiDelete.deleteCase(caseId);
                log("Deleted Patient Case for 'Sandy Prior' from Cases is: " + caseId);
                log("Status Code 204 -  Case for Patient for 'Sandy Prior' deleted - successfully");
                log(apiResponse1);
                //Assert.assertEquals(accountNameReturned, name);
                //5.and remove the actual "Sandy Prior"
                APIDelete apidelete = new APIDelete();
                log("Delete Patient account for 'Sandy Prior' from Account.");
                String apiResponse2 = apidelete.deleteAccount(accId);
                log("Deleted Patient Account for 'Sandy Prior' from Account is: " + accId);
                log("Status Code 204 - Patient 'Sandy' with '' deleted from Account successfully.");
                log(apiResponse2);
            }
        }
    }



}
