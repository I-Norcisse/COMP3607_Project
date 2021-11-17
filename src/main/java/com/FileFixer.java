package com;

public class FileFixer
{
    public static void main(String[] args){

	ProjectFiles f=new ProjectFiles();
	
	try{
	f.getStudents() ;
	
       } 
       catch (Exception e){
        System.out.println("Error Extracting CSV File");
       } 

       try{
        
        f.getAssignments();
        
           } 
           catch (Exception e){
            System.out.println("Error Extracting Assignment Files");
           } 

           try{
           
            f.getFormat();
               } 
               catch (Exception e){
                System.out.println("Error Formatting Assignment Files");
               } 
	
               try{
           
                f.getMissingStudents();
                   } 
                   catch (Exception e){
                    System.out.println("Error Producing Missing Student File");
                   } 
    }
}