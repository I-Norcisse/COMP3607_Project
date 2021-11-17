package com;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;



public class Formatter
{
    private FormatStrategy strategy; 
    public Formatter()
    {
    
    }

    public void setStrategy( FormatStrategy strategy){
        this.strategy=strategy;
    }

    public void checkDirec(File f){
        if(!f.exists()){
            f.mkdirs(); 
        }
    }

    public void formatter(ArrayList<Assignment> newAssignmentFiles, ArrayList<Student> newStudentList) throws IOException{
        
        File f=new File("src/main/java/com/filesToRename/renamedFiles/");
        File directory = new File("src/main/java/com/filesToRename/renamedFiles/");
        CopyFileFormatStrategy copyStrategy= new CopyFileFormatStrategy();
        RenameFileFormatStrategy renameFormat= new RenameFileFormatStrategy();

        for(int x =0 ; x< newAssignmentFiles.size();x++){
            
            checkDirec(f);

            for(int j=0;j<newStudentList.size();j++){
                
                if(newAssignmentFiles.get(x).getName().contains(newStudentList.get(j).getFullName()) && newAssignmentFiles.get(x).getName().contains("_assignsubmission_file_") ){
                    setStrategy(copyStrategy);
                    strategy= new  CopyFileFormatStrategy();
                    strategy.format(newAssignmentFiles, newStudentList, x, j, directory);  
                }

                else if(newAssignmentFiles.get(x).getName().contains(newStudentList.get(j).getFullName()) || newAssignmentFiles.get(x).getName().contains(newStudentList.get(j).getID())||(newAssignmentFiles.get(x).getName().contains(newStudentList.get(j).getfn() ) && newAssignmentFiles.get(x).getName().contains(newStudentList.get(j).getln() ))){
                    setStrategy(renameFormat);
                    strategy= new RenameFileFormatStrategy();
                    strategy.format(newAssignmentFiles, newStudentList, x, j, directory);
                    
                    
                }
                
          }   
        
        }
        
    }
}


