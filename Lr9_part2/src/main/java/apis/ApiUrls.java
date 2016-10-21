package apis;

/*class Value {
    test.java.MyIssue.

    String key =  ;

        } */


public enum ApiUrls {


    LOGIN("/rest/auth/1/session"),
    ISSUE("/rest/api/2/issue"),
    COMMENT("/rest/api/2/issue/"),
    ISSUECHANGE("/rest/api/2/issue/"),
    ISSUEDELETE("/rest/api/2/issue/");

    //put("/rest/api/2/issue/"+ key ).
    //DELCOM("/rest/api/2/issue/" + key + "/comment/" + newCommentId);
    //post("/rest/api/2/issue/" + key + "/comment").


    private String uri;

    ApiUrls(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }
}
