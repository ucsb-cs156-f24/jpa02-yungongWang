package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_this() {
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(1));
    }

    @Test
    public void equals_return_correct_boolean() {
        // T, T
        Team team2 = new Team("test-team");
        assertEquals(true, team.equals(team2));
        // F, T
        team2.name = "test-team2";
        assertEquals(false, team.equals(team2));
        // F, F
        team2.addMember("member");
        assertEquals(false, team.equals(team2));
        // T, F
        team2.name = "test-team";
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void hashCode_return_correct_code() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_return_correct_code2() {
        // instantiate t as a Team object
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
