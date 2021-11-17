package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class RenameFileFormatStrategy implements FormatStrategy {

    @Override
    public void format(ArrayList<Assignment> newAssignmentFiles, ArrayList<Student> newStudentList, int x, int j,File directory) throws IOException {
                    newStudentList.get(x).setSubmitted(true);
                    String formattedName="src/main/java/com/filesToRename/renamedFiles/"+newStudentList.get(j).getFullName()+"_"+newStudentList.get(j).getIdentifier()+"_"+"assignsubmission_file_"+newAssignmentFiles.get(x).getName();
                    File[] fileList = directory.listFiles();
                    int flag = 0; 
                    for (int n = 0; n < fileList.length; n++) {
                        String filename = fileList[n].getName();
                        if (filename.contains(newStudentList.get(j).getFullName()+"_"+newStudentList.get(j).getIdentifier()+"_"+"assignsubmission_file_"+newAssignmentFiles.get(x).getName())) {
                            System.out.println("File is already in renamed folder");
                            flag=1;
                        }
                        
                    }
                    if(flag==0){
                    File rename = new File(formattedName);

                    try{
                    Files.copy(newAssignmentFiles.get(x).getFile().toPath(),rename.toPath());
                    System.out.println("File Successfully Rename and Moved ");

                    }
                    catch (Exception e) {
                        System.out.println("Operation Failed");
                    }
                
                    System.out.println(rename.getName());
                    }
                    
                    }
    }
    

