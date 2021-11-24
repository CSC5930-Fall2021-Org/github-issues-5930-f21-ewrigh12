package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void testProperties() {
        Issue issue = new Issue();
        issue.setId(999);
        assertEquals(999, issue.getId());
        
        Date now = new Date();
        issue.setCreatedAt(now);
        assertEquals(now,issue.getCreatedAt());
        
        User user = new User();
        user.setId(42);
        issue.setUser(user);
        assertEquals(user, issue.getUser());
    }
    
    @Test
    void testEqualsValueEquality() {
        Issue issueA = new Issue();
        issueA.setId(999);
        
        Issue issueB = new Issue();
        issueB.setId(999);
        
        assertEquals(issueA,issueB);
        
        assertEquals(issueA.hashCode(), issueB.hashCode());
    }

    @Test 
    void testCompareToWhenFirstIsBigger() {
        Issue issueC = new Issue();
        issueC.setId(1000);
        
        Issue issueD = new Issue();
        issueD.setId(999);
        
        assertTrue(issueC.compareTo(issueD) > 0);
    }
    
    @Test 
    void testCompareToWhenFirstIsSmaller() {
        Issue issueE = new Issue();
        issueE.setId(999);
        
        Issue issueF = new Issue();
        issueF.setId(1000);
        
        assertTrue(issueE.compareTo(issueF) < 0);
    }
    
    @Test
    void testCompareToWhenFirstIsEqual() {
        Issue issueG = new Issue();
        issueG.setId(1000);
        
        Issue issueH = new Issue();
        issueH.setId(1000);
        
        assertTrue(issueG.compareTo(issueH) == 0);
    }
    
}
