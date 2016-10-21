import apis.IssueAPI;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSender;
import fixtures.JiraJSONFixture;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static com.jayway.restassured.RestAssured.given;

public class MyIssue {

    String sessionID = "";
    String key="";
    String newCommentId;
    String issue_type = "10004";
    JiraJSONFixture jiraJSONFixture = new JiraJSONFixture();

    @BeforeTest
    public void login() {
        apis.RequestSender requestSender = new apis.RequestSender();
        requestSender.authenticate();
        String loginBody =jiraJSONFixture.generateJSONForLogin();
        sessionID = requestSender.extractResponseByPath("session.value" );
         System.out.println("SESSIONID=" + sessionID);

    }

    @Test(priority = 10)
    public void createIssue(){
        // RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080";
        apis.RequestSender requestSender = new apis.RequestSender();
        String sampleIssue = jiraJSONFixture.generateJSONForSampleIssue();
        IssueAPI issueAPI = new IssueAPI();
        issueAPI.createIssue(sampleIssue);
        key = requestSender.extractResponseByPath("key" );
        System.out.println("Key=" + key);
        //System.out.println("Key=" + key);
       /* key = given().
                contentType("application/json").
                header("Cookie", "JSESSIONID="+sessionID).
                when().
                body(sampleIssue).
                post("/rest/api/2/issue").
                then().
                assertThat().statusCode(201).extract().path("key");
        System.out.println("Key=" + key);
        */


    }

    @Test(priority = 20)
    public void Add_comment (){

        apis.RequestSender requestSender = new apis.RequestSender();
        String addcomment = jiraJSONFixture.generateJSONForComment();
        IssueAPI issueAPI = new IssueAPI();
        issueAPI.addComment(addcomment, key);
        newCommentId = requestSender.extractResponseByPath("id" );
        System.out.println("newCommentId=" + newCommentId);

    }
        // RestAssured.baseURI = "http://soft.it-hillel.com.ua:8080";

        /*String body =  "{\n" +
                "  \"body\": \"Adding  comment to issue  \" \n"+
                "}";

        newCommentId =  given().
                contentType("application/json").
                header("Cookie", "JSESSIONID="+sessionID).
                when().
                body(body).
                post("/rest/api/2/issue/" + key + "/comment").
                then().assertThat().statusCode(201).
                extract().path("id");

        System.out.println("ID=" + newCommentId);
    } */




    @Test (priority = 30)
    public void deleteComment(){

        IssueAPI delCom = new IssueAPI();
        delCom.delComment(key , newCommentId);

        /*


        given().
                contentType("application/json").
                header("Cookie", "JSESSIONID="+sessionID).
                when().
                //body(body).
                        delete("/rest/api/2/issue/" + key + "/comment/" + newCommentId).
                then().
                assertThat().statusCode(204);
                */




    }



    @Test(priority = 40)
    public void Change_type_issue (){
    String changeIssueJSON = jiraJSONFixture.generateJSONforIssueType();
        IssueAPI changeIssuetype = new IssueAPI();
        changeIssuetype.changeIssue(changeIssueJSON, key);

       /* given().
                contentType("application/json").
                header("Cookie", "JSESSIONID="+sessionID).
                when().
                body("{\"fields\": \t{\"issuetype\": {\"id\": \""+issue_type+"\"}}}").
                ///rest/api/2/issuetype/{id}
                        put("/rest/api/2/issue/"+ key ).
                then().assertThat().statusCode(204);
        */
    }





      @Test(priority = 50)
      //  @Test(priority = 50, enabled = false)
    public void deleteIssue(){

        IssueAPI deleteIssue = new IssueAPI();
        deleteIssue.deleteIssue(key);
/*
        given().
                contentType("application/json").
                header("Cookie", "JSESSIONID="+sessionID).
                when().
                //body(body).
                delete("/rest/api/2/issue/"+ key).
                then().
                assertThat().statusCode(204);

*/

    }



}