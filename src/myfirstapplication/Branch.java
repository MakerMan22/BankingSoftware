/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Connor
 */

//This is the class definition 
//Here we declare the constructor. 
//We are Declaring the variables - variables must be declared to bring them into the file
public class Branch {

private String Workinghours;    
private String Sortcode;
private String Manager;
private IAddress Mailingaddress;
private String Filename;


//This is the implementation of a constructor that was declared above.
//This is the default constructor - No parameters, all values either 0 or blank.
//Used to create objects that are blank when initialised.
public Branch(){

Workinghours = "";    
Sortcode = "";
Manager= "";
//Using an IAddress object - called in the default (blank) constructor 
Mailingaddress = new IAddress();
Filename = "BranchAddressFile.txt";
}


//This is the implementation of a constructor that was declared above.
//This is a constructor with parameters - used to initialise the attributes to specific values that the class 
//Used to create objects that are initialised to specific values - determined by what is passed into them by the object that is using it. 
public Branch(String strworkinghours, String strsortcode, String strmanager, IAddress objMailingaddress){

    this.Edit(strworkinghours, strsortcode, strmanager, objMailingaddress);

}


//The purpose of Edit() method is to modify or re-initialise the attributes inside of the class. 
//The data to re-initialise values of attributes can be taken from different resources, such as files, user input, forms, default values, etc
//This edit method DOES NOT include MailingAdress (object) of Class IAddress Values. 
public void Edit(String strmanager, String strworkinghours, String strsortcode){

Manager= strmanager;
Workinghours = strworkinghours;    
Sortcode = strsortcode;
}


//The purpose of Edit() method is to modify or re-initialise the attributes inside of the class. 
//The data to re-initialise values of attributes can be taken from different resources, such as files, user input, forms, default values, etc
//Contains an object from the class IAddress - so this edit method initialises the variable 'Mailingaddress' to the default values of IAddress
public void Edit(String strmanager, String strworkinghours, String strsortcode,  IAddress objMailingaddress){

this.Edit(strmanager, strworkinghours, strsortcode );
Mailingaddress = objMailingaddress;
}


//The purpose of Edit() method is to modify or re-initialise the attributes inside of the class. 
//The data to re-initialise values of attributes can be taken from different resources, such as files, user input, forms, default values, etc
//This edit method is specifically for editing head office address
public void Edit(String strworkinghours, String strname, String strstreet, int inthouseno, String strpostcode, String strtown, String strcountry){

Workinghours = strworkinghours;    
Mailingaddress.edit(strname, strstreet, inthouseno, strpostcode, strtown, strcountry);
}

public void Edit(String strworkinghours, IAddress src){

Workinghours = strworkinghours;    
Mailingaddress =src;
}

//This method returns a string displaying the current values of the attributes, of the current Branch object in use. 
public String toString(){
    
return
"Working Hours: "+ Workinghours; //+"\n"+
//"Sort Code: "+ Sortcode +"\n"+
//"Manager: "+ Manager; 
}

//This method calls on the toString method (as it returns a string), and it applies the returned string (from toString) to the JTextArea.
// It also uses the object Mailingaddress of class IAdress to display attributes of that object.
public void Display (javax.swing.JTextArea src){
    
//   src.setText(null);//Stops it repeating 
   src.append(this.toString(true));
   
   //src.append("\n"+"\n"+"\n");
   
   //Mailingaddress.Display(src);
//src.append(String.valueOf(Mailingaddress));
//Test both of these - will duplicate 
}

public void saveToFile(boolean append) throws IOException{

try{
    FileWriter aWriter = new FileWriter(Filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(this.toString(false)+Mailingaddress.toString(false));
    
    //Mailingaddress.saveToFile(aWriter);
    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save branch array");
}
}

public void LoadFromFile(){

String record;

FileReader reader;
try{
    reader = new FileReader(Filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    
    while ((record = bin.readLine())!=null)
       {     
        Workinghours = record.substring(15);    
        Mailingaddress.LoadFromFile(bin);           
       }
    
    bin.close();
    bin =null;
    
    }

catch(IOException ioe){
        System.out.print("Failed to read file - error occured in class branch");
   
}


}

public void wipeFile(){
try{
    FileWriter aWriter = new FileWriter(Filename,false);
    }

catch(IOException ioe){
System.out.println("Failed to wipe file");
}
}

public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    {  
        return     
        "Manager: "+ Manager+"\n"+
        "Workinghours: "+ Workinghours+"\n"+
        "SortCode: "+ Sortcode+"\n"+ this.getMailingaddress().toString(true);
    }
    else 
    {
        return
        Manager+"\n"+
        Workinghours+"\n"+
        Sortcode+"\n"+ this.getMailingaddress().toString(false);
    }
             
}    




public void setManager(String manager){

this.Manager = manager;

}

public String getManager(){

return Manager;

}

public void setSortcode(String sortcode){

this.Sortcode = sortcode;

}

public String getSortcode(){

return Sortcode;

}

public void setWorkinghours(String workinghours){

this.Workinghours = workinghours;

}

public String getWorkinghours(){

return Workinghours;

}

public void setMailingaddress(IAddress mailingaddress){

this.Mailingaddress = mailingaddress;

}

public IAddress getMailingaddress(){

return Mailingaddress;

}
    }


