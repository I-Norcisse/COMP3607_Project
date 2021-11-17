package com;

import java.util.ArrayList;
import java.io.File;


public class AssignmentFile extends FileSearch
{
    @Override
   public ArrayList<Object> extract(ArrayList<Object> assignmentList) throws Exception
    {
        File directory = new File("src/main/java/com/filesToRename/");
        File[] fileList = directory.listFiles();
        int flag = 0;
        
        if (fileList == null) {
            System.out.println("Empty directory.");
        }
        else {
            
            
            for (int i = 0; i < fileList.length; i++) {
                Assignment temp;
                String filename = fileList[i].getName();
                if (filename.contains(".pdf")) {
            
                    temp=new Assignment(fileList[i], filename);
                    assignmentList.add(temp);
                    flag = 1;
                }
            }
        
    }
    
        if (flag == 0) {
            System.out.println("File Not Found");
        }
        return assignmentList; 
  }

}
