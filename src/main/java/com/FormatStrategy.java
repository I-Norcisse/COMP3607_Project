package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 public interface FormatStrategy {
    public void format (ArrayList<Assignment> newAssignmentFiles, ArrayList<Student> newStudentList,int x, int j,File directory) throws IOException;

 }