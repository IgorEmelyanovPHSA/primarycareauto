package primarycare.pages;

import static io.restassured.RestAssured.*;

public class APIDelete {
    public String deleteAccount(String accId){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseforDelete = String.valueOf
                (
                given().
                header("Authorization", "Bearer " + acc_token).
                when().
                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Account/" + accId)
                //then().statusCode(204).log().body().extract().path("id");
                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }

    public String deletePractitionerFacility(String practitionerFacility_accId){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseforDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/HealthcarePractitionerFacility/" + practitionerFacility_accId)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }

    public String deleteCase(String caseId){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseForDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Case/" + caseId)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseForDelete;
    }

    public String deleteCaseContactRole(String caseContactRoleID){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseforDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/CaseContactRole/" + caseContactRoleID)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }

    public String deleteContactContactRelation(String contactContactRelationId){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseforDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/HealthCloudGA__ContactContactRelation__c/" + contactContactRelationId)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }

    public String deleteHealthcareFacilityNetwork(String practitionerFacility_accId){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return

        String responseforDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/HealthcareFacilityNetwork/" + practitionerFacility_accId)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }

    public String deleteEmpaneledPatientRecord(String empaneledPatientRecord_Id){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        //return
        String responseforDelete = String.valueOf
                (
                        given().
                                header("Authorization", "Bearer " + acc_token).
                                when().
                                delete("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Panel_Member__c/" + empaneledPatientRecord_Id)
                                //then().statusCode(204).log().body().extract().path("id");
                                .then().statusCode(204).log().all()
                );
        return responseforDelete;
    }


}
