package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    Assignment assignmentFile;
    File file = new File("file.txt");
    @BeforeEach 
    public void setUp(){
       assignmentFile = new Assignment(file, "fileName");
    }
    @Test
    void testGetFile() {
        File expFile= new File("file.txt");
        assertEquals(expFile, assignmentFile.getFile());
    }

    @Test
    void testGetName() {

    }
}
