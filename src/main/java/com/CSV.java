package com;


import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class CSV extends FileSearch { 

    public String doesExist(){
        File directory = new File("src/main/java/com/filesToRename/");
        String File="";
        
        String[] fileList = directory.list();
        if (fileList == null) {
            System.out.println("Empty directory. No Student file");
        }
        else {
  
            
            for (int i = 0; i < fileList.length; i++) {
                String fileName = fileList[i];
                if (fileName.contains(".csv")) {
                    System.out.println(fileName + " found");
                    File=fileName;
                    return File;
                    
                }
            }
        }
  
        
            
            return "File Not Found";
        
    }

    @Override
    public ArrayList<Object> extract(ArrayList<Object> studentList) throws Exception
    {
        String csvFile=doesExist();
        if(csvFile.contains("File Not Found")){
            System.out.println(csvFile);
            return studentList;
        }
        Scanner sc = new Scanner(new File("src/main/java/com/filesToRename/"+csvFile));  
        sc.useDelimiter("Participant");    
        sc.next();
        sc.useDelimiter(",");    
        
        while (sc.hasNext())  
        {  
            Student temp=new Student();
            String str =sc.next();
            if (str.contains("Participant")){   
                str=str.replaceFirst("Participant ","");
                str=str.replaceFirst("\n","");
                str=str.replaceFirst("\r","");
                temp.setIdentifier(str); 
                str=sc.next();
                temp.setFullName(str);
                String[] result = str.split(" ");
                temp.setln(result[0]);
                temp.setfn(result[1]);
                str=sc.next();
                temp.setID(str);
                studentList.add(temp);
         }
            
        }   
        sc.close();  
     
        return studentList;
      
    }
}