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
public class User {
    String name;
    String role;
    String password;
    String filename;
    
    
public User(){
    name = "";
    role = "Bank Employee";
    password = "";
    filename = "login.txt";     
   
    }

public User(String strname, String strrole, String strpassword, String strfilename){
    name = strname;
    role = strrole;
    password = strpassword;
    filename = strfilename; 
}

public boolean roleSelected(String struserinput){
boolean hasUserSelectedRole;

String userinput = struserinput;

if(userinput!="Please select an option")
hasUserSelectedRole = true;
    else
    hasUserSelectedRole =false;

return hasUserSelectedRole;
    }
             
public boolean isRegistered(String newName, String newPassword, String newRole) throws IOException{
    
    boolean isRegistered;
    name =newName;
    password = newPassword;
    role = newRole;
    
    
    FileWriter writer;
    try{
    writer = new FileWriter(filename,true);
    writer.write(name+System.getProperty("line.separator"));
    writer.write(password+System.getProperty("line.separator"));
    writer.write(role+System.getProperty("line.separator"));
    writer.write("##"+System.getProperty("line.separator"));
    isRegistered = true;
    writer.flush();
    writer.close();
    writer = null;
    }catch(IOException ioe){   
    isRegistered = false;}
    
    return isRegistered;
    
    
}

//Formerly isUser
public boolean isCustomer(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }

catch(IOException ioe){
isFound = false;
}

    return isFound;
}

public boolean isManager(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }

catch(IOException ioe){
isFound = false;
}

    return isFound;
}

public boolean isAdministrator(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }

catch(IOException ioe){
isFound = false;
}

    return isFound;
}

public boolean isAdvisor(String newName, String newPassword, String newRole){
name = newName;
password = newPassword;
role = newRole;
boolean isFound = false;
String record;
FileReader reader;
try{
    reader = new FileReader(filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
    while ((record = bin.readLine())!=null){
        if(name.contentEquals(record))
            record = bin.readLine();
            if(password.contentEquals(record))
                record = bin.readLine();
                if(role.contentEquals(record))
                    isFound=true;
    }
    bin.close();
    bin =null;
    }

catch(IOException ioe){
isFound = false;
}

    return isFound;
}



public void setName(String name){

this.name = name;

}

public String getName(){

return name;

}

public void setRole(String role){

this.role = role;

}

public String getRole(){

return role;

}

public void setPassword(String password){

this.password = password;

}

public String getPassword(){

return password;

}




}
