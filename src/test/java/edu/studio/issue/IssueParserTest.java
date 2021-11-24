package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IssueParserTest {

    @Test
    void testParseIssueWithValidJson() throws IOException {
        IssueParser parser = new IssueParser();
        String json = Files.readString(Paths.get("src/test/resources/sample-output.txt")); 
        
        User user0 = new User();
        user0.setId(6319957);
        user0.setLogin("ms-O");
        
        User user1 = new User();
        user1.setId(6319957);
        user1.setLogin("ms-0");
        
        User user2 = new User();
        user2.setId(6319957);
        user2.setLogin("ms-O");
        
        User user3 = new User();
        user3.setId(6319957);
        user3.setLogin("ms-O");
        
        User assignee3 = new User();
        assignee3.setId(24360383);
        assignee3.setLogin("uphunyal]");
        
        List<Issue> issues = parser.issueParser(json);
        assertNotNull(issues);
        assertEquals(4, issues.size());  
        
        Issue issue0 = issues.get(0);
        assertEquals(1044979109, issue0.getId());
        assertEquals("Thu Nov 04 16:47:23 EDT 2021", issue0.getCreatedAt().toString());
        assertEquals(user0, issue0.getUser());
        assertEquals(null, issue0.getClosedAt());
        assertEquals(4, issue0.getNumber());
        assertEquals("minimal fields", issue0.getTitle());
        assertEquals(null, issue0.getBody());
        assertEquals(null, issue0.getAssignee());

        Issue issue1 = issues.get(1);
        assertEquals(1042639334, issue1.getId());
        assertEquals("Tue Nov 02 17:37:34 EDT 2021", issue1.getCreatedAt().toString());
        assertEquals(user1, issue1.getUser());
        assertEquals(null, issue1.getClosedAt());
        assertEquals(3, issue1.getNumber());
        assertEquals("New one added via POST", issue1.getTitle());
        assertEquals("This is our new issue", issue1.getBody());
        assertEquals(null, issue1.getAssignee());

        Issue issue2 = issues.get(2);
        assertEquals(1038774698, issue2.getId());
        assertEquals("Thu Oct 28 17:47:17 EDT 2021", issue2.getCreatedAt().toString());
        assertEquals(user2, issue2.getUser());
        assertEquals("Thu Oct 28 17:47:43 EDT 2021", issue2.getClosedAt().toString());
        assertEquals(2, issue2.getNumber());
        assertEquals("A second issue", issue2.getTitle());
        assertEquals("Something doesn't work", issue2.getBody());
        assertEquals(null, issue2.getAssignee());

        Issue issue3 = issues.get(3);
        assertEquals(1038569375, issue3.getId());
        assertEquals("Thu Oct 28 14:12:03 EDT 2021", issue3.getCreatedAt().toString());     
        assertEquals(user3, issue3.getUser());
        assertEquals(null, issue3.getClosedAt());
        assertEquals(1, issue3.getNumber());
        assertEquals("A first issue's title", issue3.getTitle());
        assertEquals(assignee3, issue3.getAssignee());

    }
}
