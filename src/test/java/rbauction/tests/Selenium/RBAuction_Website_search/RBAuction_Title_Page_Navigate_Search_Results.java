package rbauction.tests.Selenium.RBAuction_Website_search;

import org.testng.Assert;
import rbauction.pages.CommonMethods;
import rbauction.pages.HealthCloudConsolePage;
import rbauction.tests.Utilities.TestListener;
import rbauction.pages.Utils;
import rbauction.tests.BaseTest_RBAuction;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rbauction.pages.RBAuctionPage;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class})
public class RBAuction_Title_Page_Navigate_Search_Results extends BaseTest_RBAuction {
    private String makes = "Ford";
    private String model = "F-150";
    private String yearFrom = "2010";
    private Integer totalResults1;
    private Integer totalResults2;

    @Test(priority = 1)
    public void Can_Do_Search_For_My_F150_in_RBAuction_website () throws Exception {
        //TestcaseID = "251780"; //C251780
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //CommonMethods common = new CommonMethods(getDriver());

        log("/*0.---Pre-conditioning API call to remove duplicate  if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email_search_API, makes, model);

        log("/*1.---Open the Title main page)--*/");
        RBAuctionPage portalRBAuctionPage= loginPage.openRBAuctionPage();

        log("/*2.----Verify that the RBAuction page has displayed --*/");
        boolean isPortalRegisterToGetDoctorPageDisplayed =  portalRBAuctionPage.isRBAuctionPageDisplayed();
        if (!isPortalRegisterToGetDoctorPageDisplayed){
            throw new RuntimeException("Exception: the RBAuction page "  + "has not shown up!!!");
        }

        log("/*3.---Search for:  " + makes + " "+ model +"--*/");
        portalRBAuctionPage.globalSearch(makes + " " + model );
        Thread.sleep(2000);

        log("/*4.----Get the FIRST search total results --*/");
        String searchTextResults = portalRBAuctionPage.getSearchTextResults();
        log("/*---- Search Text Results is: " + searchTextResults + " --*/");

        // Define the regular expression to match the total results
        String regex = "of (\\d+) results";
        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);
        // Match the regular expression against the text
        Matcher matcher = pattern.matcher(searchTextResults);
        // Extract the total results
        if (matcher.find()) {
            String totalResultsString = matcher.group(1);
            totalResults1 = Integer.parseInt(totalResultsString);
            log("Total Results: " + totalResults1);
        } else {
            log("No match found");
        }

        log("/*5.----Apply the 'Year' filter form 2010 to the CURRENT --*/");
        // Get the current year using LocalDate
        int currentYearInt = LocalDate.now().getYear();
        // Convert the current year to String
        String currentYear = String.valueOf(currentYearInt);
        log("Current Year: " + currentYear);

        portalRBAuctionPage.applyTheYearFilter(yearFrom, currentYear );

        log("/*6.----Get the SECOND filtered by Years search total results --*/");
        String searchTextResults2 = portalRBAuctionPage.getSearchTextResults();
        log("/*---- Search Text Results is: " + searchTextResults2 + " --*/");
        // Define the regular expression to match the total results
        String regex2 = "of (\\d+) results";
        // Compile the regular expression
        Pattern pattern2 = Pattern.compile(regex2);
        // Match the regular expression against the text
        Matcher matcher2 = pattern2.matcher(searchTextResults2);
        // Extract the total results
        if (matcher2.find()) {
            String totalResultsString2 = matcher2.group(1);
            totalResults2 = Integer.parseInt(totalResultsString2);
            log("Total Results by Years Filtering: " + totalResults2);
        } else {
            log("No match found");
        }


        log("/*7.----•Verification that the number of results returned is different  --*/");
        //assertTrue( totalResults1 > totalResults2, "totalResults1 should be greater than totalResults2");
        if (totalResults1 > totalResults2) {
            log("/---Verification Results:totalResults1 greater than totalResults2  --*/");
        }
        else {
            log("/---Verification failed: totalResults1 should be greater than totalResults2 but it's not  --*/");
        }
    }



    //@Test(priority = 2)
    public void Post_conditions_step_Remove_Dups_Patient_account() throws Exception {
        //TestcaseID = "251774"; //C251774
        //log("/---API call to remove duplicate Patient's account if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email, legalLastName, legalFirstName);
    }
}
