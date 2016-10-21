package apis;

public class IssueAPI extends RequestSender {

    RequestSender requestSender = new RequestSender();

    public void createIssue(String body) {
        requestSender
                .createRequest(body)
                .post(ApiUrls.ISSUE.getUri());

    }

    public void addComment(String body, String key) {
        requestSender
                .createRequest(body)
                .post(ApiUrls.COMMENT.getUri()  + key + "/comment");
    }

    public  void delComment(String key ,String newCommentId ) {
        requestSender
                .createRequest()
                .delete(ApiUrls.COMMENT.getUri()+ key + "/comment/" + newCommentId  );
    }

    public void changeIssue (String body , String key){
        requestSender
                .createRequest()
                .put(ApiUrls.ISSUECHANGE.getUri()+key );

    }
    public void deleteIssue ( String key){
        requestSender
                .createRequest()
                .delete(ApiUrls.ISSUEDELETE.getUri()+key );

    }
}
