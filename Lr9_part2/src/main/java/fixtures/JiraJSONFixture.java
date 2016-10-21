package fixtures;

import org.json.simple.JSONObject;


import java.util.HashMap;

public class JiraJSONFixture {

    public String generateJSONForLogin() {
        JSONObject credentials = new JSONObject();
        credentials.put("username", "maximreshetyuk");
        credentials.put("password","maximreshetyuk" );

        return credentials.toJSONString();
    }


        public String generateJSONForSampleIssue() {
            JSONObject issue = new JSONObject();
            JSONObject fields = new JSONObject();
            JSONObject project = new JSONObject();
            JSONObject issuetype = new JSONObject();
            JSONObject assignee = new JSONObject();
            JSONObject reporter = new JSONObject();

            issue.put("fields", fields);
            fields.put("project", project);
            fields.put("issuetype", issuetype);
            fields.put("assignee", assignee);
            fields.put("reporter", reporter);
            fields.put("summary", "rest_test");

            project.put("id", "10315");
            issuetype.put("id", "10004");
            assignee.put("name", "maximreshetyuk");
            reporter.put("name", "maximreshetyuk");
            return issue.toJSONString();

    }

        public  String generateJSONForComment(){

            JSONObject comment = new JSONObject();
            comment.put("body","Adding  comment to issue");
            return  comment.toJSONString();

        }

        public  String generateJSONforIssueType(){
            JSONObject typeIssue= new JSONObject();
            JSONObject fields = new JSONObject();
            JSONObject issuetype =new JSONObject();

            typeIssue.put("fields",fields);
            fields.put("issuetype",issuetype );
            issuetype.put("id", "10004");
            return typeIssue.toJSONString();
        }

}
//"{\"fields\": \t{\"issuetype\": {\"id\": \""+issue_type+"\"}}}").
