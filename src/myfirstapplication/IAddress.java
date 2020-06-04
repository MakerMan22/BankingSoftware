/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 *
 * @author Connor
 */
//This is the class definition 
//Here we declare the constructor. 
//We are Declaring the variables - variables must be declared to bring them into the file
public class IAddress {

private String Name;    
private String Street;
private int    HouseNo;
private String HouseName;
private String Area;
private String Postcode;
private String Town;
private String Country;
private String Filename;


//This is the implementation of a constructor that was declared above.
//This is the default constructor - No parameters, all values either 0 or blank.
//Used to create objects that are blank when initialised.
public IAddress(){


Filename = "BranchAddressFile.txt";

this.edit("", "", 0, "", "", "");

}


//This is the implementation of a constructor that was declared above.
//This is a constructor with parameters - used to initialise the attributes to specific values that the class 
//Used to create objects that are initialised to specific values - determined by what is passed into them by the object that is using it. 
public IAddress (String strname,Integer inthouseno,String strhousename, String strstreet, String strtown,String strpostcode,  String strarea,   String strcountry){

this.edit(strname, inthouseno, strhousename, strstreet, strtown, strpostcode, strarea, strcountry);
}

public IAddress (String strname, String strstreet,Integer inthouseno, String strpostcode, String strtown, String strcountry){

this.edit(strname, strstreet, inthouseno, strpostcode, strtown, strcountry);
}

//The purpose of Edit() method is to modify or re-initialise the attributes inside of the class. 
//The data to re-initialise values of attributes can be taken from different resources, such as files, user input, forms, default values, etc
public void edit(String strname, Integer inthouseno,String strhousename, String strstreet,String strtown,String strpostcode,String strarea,String strcountry){
Name = strname;
Street = strstreet;
HouseNo = inthouseno;
HouseName = strhousename;
Area = strarea;
Postcode = strpostcode;
Town = strtown;
Country = strcountry;
}


//The purpose of Edit() method is to modify or re-initialise the attributes inside of the class. 
//The data to re-initialise values of attributes can be taken from different resources, such as files, user input, forms, default values, etc
//This specific method only modifies the values required to edit head office address.
public void edit(String strname, String strstreet,Integer inthouseno, String strpostcode, String strtown, String strcountry){
Name = strname;
Street = strstreet;
HouseNo = inthouseno;
Postcode = strpostcode;
Town = strtown;
Country = strcountry;
}



/*//This method returns a string displaying the current values of the attributes, of the current IAddress object in use. 
public String toString(){ 

return
"Name: "+ Name +"\n"+
"Street: "+ Street +"\n"+
"House Number: "+ HouseNo +"\n"+
"House Name: "+ HouseName +"\n"+
"Area: "+ Area +"\n"+
"Postcode: "+ Postcode +"\n"+
"Town: "+ Town +"\n"+
"Country: "+ Country +"\n";

}*/

//This method returns a string displaying the current values of the attributes, of the current IAddress object in use. 
//This method has been modified for the use of displaying Head office 
public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    {    
        return
        "Name: "+ Name +"\n"+
        "House Number: "+ HouseNo +"\n"+
        "House Name: "+ HouseName +"\n"+
        "Street: "+ Street +"\n"+
        "City: "+ Town +"\n"+        
        "Postcode: "+ Postcode +"\n"+
        "Area: "+ Area +"\n"+
        "Country: "+ Country +"\n";
    }    
    else // We are saving to file. 
    {
        return
        Name +"\n"+
        HouseNo +"\n"+
        HouseName +"\n"+
        Street +"\n"+
        Town +"\n"+
        Postcode +"\n"+
        Area +"\n"+
        Country +"\n";
    }
}

//This method calls on the toString method (as it returns a string), and it applies the returned string (from toString) to the JTextArea.
public void Display(javax.swing.JTextArea src){

    src.append(this.toString(true));

}

public void saveToFile(FileWriter aWriter){

try{
    aWriter.write
        
("Name: "+ Name +"\n"+
"Street: "+ Street +"\n"+
"House Number: "+ HouseNo +"\n"+
"Postcode: "+ Postcode +"\n"+
"City: "+ Town +"\n"+
"Country: "+ Country +"\n");
}

catch(IOException ioe){
System.out.println("Failed to save");
}
}

public void LoadFromFile(BufferedReader bin) throws IOException{

        try{
        Name = bin.readLine().substring(6);  
        Street = bin.readLine().substring(8); 
        HouseNo = Integer.valueOf(bin.readLine().substring(14));
        Postcode = bin.readLine().substring(10);
        Town = bin.readLine().substring(6);
        Country = bin.readLine().substring(9);
        }
        
        catch(IOException ioe){ 
            System.out.println("Failed to read file - error occured in class IAddress");}
        
  
}



public void setName(String name){

this.Name = name;

}

public String getName(){

return Name;

}

public void setStreet(String street){

this.Street = street;

}

public String getStreet(){

return Street;

}

public void setHouseNo(Integer houseno){

this.HouseNo = houseno;

}

public Integer getHouseNo(){

return HouseNo;


}

public void setHouseName(String housename){

this.HouseName = housename;

}

public String getHouseName(){

return HouseName;

}

public void setArea(String area){

this.Area = area;

}

public String getArea(){

return Area;

}

public void setPostcode(String postcode){

this.Postcode = postcode;

}

public String getPostcode(){


return Postcode;

}

public void setTown(String town){

this.Town = town;

}

public String getTown(){


return Town;

}

public void setCountry(String country){

this.Country = country;

}

public String getCountry(){


return Country;

}


}
        
        






