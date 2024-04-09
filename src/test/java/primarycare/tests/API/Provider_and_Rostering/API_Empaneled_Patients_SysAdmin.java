package primarycare.tests.API.Provider_and_Rostering;

import org.testng.annotations.Test;
import primarycare.pages.*;
import primarycare.tests.API_BaseTest_PrimaryCare;

public class API_Empaneled_Patients_SysAdmin extends API_BaseTest_PrimaryCare{
    //for Test 1.-select
    private String empaneledPatientPHN =  "9876923304"; //'BABY GIRL' "MUNCIE" <-- 'Prosacco' "Garth"
    public String empaneledId;

    //for Test 3. insert
    ///REFRESH
    public String patient__c = "001Aq00000OW8WDIA1";//'BABY GIRL' 'MUNCIE' <-- Prosacco Garth - the same as Patient_ID__c in Account.
    public String healthcare_facility_network__c = "0bYAq0000003BFPMA2";//"Karen Beegan | Panel | NORTH SHORE PRIMARY CARE MED HOME" from "HealthcareFacilityNetwork"
    ///REFRESH
    public String panel__c = "Active";
    public String roster__c = "Pending";

    @Test(priority = 1)
    public void API_Can_Select_EmpaneledID_From_Panel_Member__c_Salesforce_Status_Code_200_as_SysAdmin(){
        TestcaseID = "275926"; //C275926
        APISelect sqlQuery = new APISelect();
        log("Select Empaneled Patient record Id from 'Panel_Member__c' Table.");
        String empaneledPatientRecordID = sqlQuery.selectEmpaneledPatientRecordIdByPHN("SELECT Id FROM Panel_Member__c WHERE Patient__r.PHN__c = '"+empaneledPatientPHN+"'", "Id");
        log("Selected Empaneled Patient 'Prosacco Garth' record Id from 'Panel_Member__c' is: " +empaneledPatientRecordID);
        log("Status Code 200 - Empaneled Patient record Id SELECTED request  - successfully");
        empaneledId = empaneledPatientRecordID;
    }

    @Test(priority = 2)
    public void API_Can_Remove_Empaneled_Patient_Record_in_Salesforce_Status_Code_204_as_SysAdmin(){
        TestcaseID = "275927"; //C275927
        if(empaneledId==null){
                log("No Empaneled Patients records for 'Prosacco Garth'.");
                log("Nothings to delete - do nothing.");
        }
        else {
                log("Empaneled Patients records for 'Prosacco Garth' has founded.");
                log("lets Delete it");
                //remove Empaneled Patient from "Panel_Member_c" Table
                APIDelete api_delete_empaneled_patient = new APIDelete();
                log("Delete Empaneled Patient record from 'Panel_Member_c'.");
                String apiResponse= api_delete_empaneled_patient.deleteEmpaneledPatientRecord(empaneledId);
                log("Deleted Empaneled Patient record from 'Panel_Member_c' is: " + empaneledId);
                log(apiResponse);
                log("Status Code 204 - Empaneled Patient 'Prosacco Garth' Deleted - successfully");
        }
    }

    @Test(priority = 3)
    public void API_Can_Create_EMPANELED_Record_In_Salesforce_Status_Code_201_as_SysAdmin(){
        TestcaseID = "275925"; //C275925
        APIInsert apiCreatePanelMemberRecord = new APIInsert();
        String panelMemberRecordID = apiCreatePanelMemberRecord.insertPanelMember(patient__c,
                healthcare_facility_network__c,
                panel__c, roster__c);
        log("Created Panel Member's record id is: " +panelMemberRecordID);
        log("Status Code 201 - Empaneled record 'Prosacco Garth' created success");
    }

}
