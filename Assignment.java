package com;

import java.io.File;

public class Assignment 
{
    private File file;
    private String name="";
    
    //Constructor 
    public Assignment(File file, String name){
        this.file=file;
        this.name=name;
    }
    // Accessors 
    public File getFile(){ 
        return this.file;
    }
    
    public String getName(){
        return this.name;
    }
    
   
}
