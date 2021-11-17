package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class CopyFileFormatStrategy implements FormatStrategy{
    @Override
    public void format (ArrayList<Assignment> newAssignmentFiles, ArrayList<Student> newStudentList, int x,int j, File directory) throws IOException{
                    newStudentList.get(x).setSubmitted(true);
                     String formattedName="src/main/java/com/filesToRename/renamedFiles/"+newAssignmentFiles.get(x).getName();
                     File[] fileList = directory.listFiles();
                     int flag=0;
                     for (int n = 0; n < fileList.length; n++) {
                        
                        String filename = fileList[n].getName();
                        if (filename.contains(newAssignmentFiles.get(x).getName())) {
                            System.out.println("File is already in renamed folder ");
                            System.out.println(newAssignmentFiles.get(x).getName());
                            flag=1;
                        }
                    }
                    if(flag==0){

                     File rename = new File(formattedName);
 
                     try{
                     Files.copy(newAssignmentFiles.get(x).getFile().toPath(),rename.toPath());
                     System.out.println("File Successfully Moved ");
 
                     }
                     catch (Exception e) {
                         System.out.println("Operation Failed");
                     }
                     System.out.println(rename.getName());
                    }
    }

}
