package com;


import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;   

public class ProjectFiles 
{
    private ArrayList<String>missingStudentsList= new ArrayList<String>();
    private ArrayList<Object> studentList= new ArrayList<Object>();
    private ArrayList<Object> assignmentList= new ArrayList<Object>();
    private ArrayList<Student> newStudentList= new ArrayList<Student>();
    private ArrayList<Assignment> newAssignmentList= new ArrayList<Assignment>();
    private Formatter F=new Formatter();
    
    public ProjectFiles()
    {
        
        
    }
    
    public void getStudents()throws Exception{
        FileSearch  csvFile= new CSV();
        studentList=csvFile.extract((ArrayList<Object>)studentList);
        newStudentList=(ArrayList<Student>)(Object)studentList; // casting from a Object type to Student 
    }
    
    public void getAssignments()throws Exception{ 
        AssignmentFile assignmentFileList= new AssignmentFile ();
        assignmentList=assignmentFileList.extract(assignmentList); 
        newAssignmentList=(ArrayList<Assignment>)(Object)assignmentList; // casting from a Object type to Assignment 
    }
    
    public void getFormat(){
        
        try{
         F.formatter( newAssignmentList,  newStudentList); 
        }
        catch (IOException e){
            System.out.println("Error 5");
        }
    }

    public void getMissingStudents(){
        
        for(int i =0; i<this.studentList.size();i++){
            if(newStudentList.get(i).getSubmitted()==false)
                missingStudentsList.add(newStudentList.get(i).getFullName());
                writeMissingToFile();
        }
        
    }

    public void writeMissingToFile(){
        try{
        FileWriter writer = new FileWriter("src/main/java/com/filesToRename/Missing Student Submissions.txt"); 
        for(String str: missingStudentsList) {
        writer.write(str + "\n");
        }
        writer.close();
    }
    catch(IOException e){
        System.out.println("Unable to Write to Missing Students File") ;
    }
    }
}

