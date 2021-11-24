package edu.studio.issue;

import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedReader;

public class IssueExporter {

    public static void main(String[] args) throws IOException {
        GitHubRestClient gitClient = new GitHubRestClient();
        
        if(args.length==0 || args.equals(null) || args.equals("")) {
            System.out.println("Invalid. Please insert a valid PAT token.");
        }
        else {
            String json = gitClient.getIssues(args[0]);
            IssueParser issuePar = new IssueParser();
            List<Issue> issues = issuePar.issueParser(json);
            
            String output = "";
            
            for (Issue issue : issues) {
                output += issue.toString()+System.lineSeparator();
            }
            
            FileOutputStream outStream = new FileOutputStream("actual-output.txt");
            outStream.write(output.getBytes());
            outStream.close();
            
            System.out.println("Output was written successfully");
        }
    }
}
