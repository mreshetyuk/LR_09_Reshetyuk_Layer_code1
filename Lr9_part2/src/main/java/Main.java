import fixtures.JiraJSONFixture;

/**
 * Created by User on 17.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        JiraJSONFixture jiraJSONFixture= new JiraJSONFixture();
        jiraJSONFixture.generateJSONForLogin();

        jiraJSONFixture.generateJSONForSampleIssue();


        jiraJSONFixture.generateJSONForComment();
        jiraJSONFixture.generateJSONforIssueType();
    }

}
