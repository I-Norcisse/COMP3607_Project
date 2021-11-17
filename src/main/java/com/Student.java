package com;



public class Student
{
    private String firstName="";
    private String lastName="";
    private String ID="";
    private String Identifier="";
    private String fullName="";
    private boolean submitted=false;

    
    // Accessors 
    public boolean getSubmitted(){
        return this.submitted;
    }

    public String getIdentifier(){
        return this.Identifier;
    }
    
     public String getFullName(){
        return this.fullName;
    }
    
    public String getln(){
        return this.lastName;
    }
    public String getfn(){
        return this.firstName;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public void setln(String last){
       this.lastName=last; 
    }
    public void setfn(String first){
       this.firstName=first; 
    }
    
    public void setID(String id){
       this.ID=id; 
    }
    
    public void setIdentifier(String identifier){
       this.Identifier=identifier; 
    }
    
    public void setFullName(String name){
        this.fullName=name;
    }
    public void setSubmitted(boolean b){
       this.submitted=b; 
    }
}
