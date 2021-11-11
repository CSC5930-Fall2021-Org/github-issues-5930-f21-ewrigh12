package edu.studio.issue;

import kong.unirest.Unirest;

public class GitHubRestClient {

    protected static final String TEST_AREA_URL = "https://api.github.com/repos/CSC5930-Fall2021-Org/ghi-demos-5930f21/issues?state=all&creater=ms-O";
    
    public String getIssues(String bearerToken) {
        GitHubRestClient client = new GitHubRestClient();
        String issueResponse = Unirest.get(TEST_AREA_URL).header("Authorization", "Bearer " + bearerToken).asString().getBody();
        return issueResponse;
    }
}
