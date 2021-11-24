package edu.studio.issue;

import kong.unirest.Unirest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import kong.unirest.Unirest;

class GitHubRestClientTest {
    
    @Test
    void testGetIssues() throws IOException {
        GitHubRestClient client = new GitHubRestClient();
        String bearerToken = System.getProperty("bearer.token");
        assertNotNull(bearerToken);
        assertTrue(bearerToken.length() > 0);
        
        String expectedJson = Files.readString(Paths.get("src/test/resources/testarea.json").toAbsolutePath());
        assertNotNull(expectedJson);
        assertTrue(expectedJson.length() > 0);
        
        String actualJson = client.getIssues(bearerToken);
        assertEquals(expectedJson,actualJson);
 
    }

}
