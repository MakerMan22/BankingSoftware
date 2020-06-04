/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
/**
 *
 * @author Connor
 */
public class BranchList {
ArrayList<Branch>Branches;
BranchList Subdepartments;
Branch aBranch;
String Filename;
    
    
public BranchList(){
Branches = new ArrayList<>();
aBranch = new Branch();
Filename = "BranchAddressFile.txt";


}

public void add(Branch src) throws IOException{

    //do not combine methods in the same action 
    Branches.add (src);
}

public void remove(Customer src){
    
    Branches.remove (src);
}

public void remove(String Manager) throws IOException{
for(int i = 0; i <Branches.size();i++)
{
  
    if ((Branches.get(i).getManager().equals(Manager))){
    
    Branches.get(0).wipeFile();
    
    Branches.remove(i);
    }
    
}
for(int i = 0; i < Branches.size();i++)
{
   Branches.get(i).saveToFile(true);
}


}

public void display (javax.swing.JTextArea src){

src.setText(null);    
for(int i = 0; i <Branches.size();i++)
{
 src.append("Branch number: " + i + "\n");
 Branches.get(i).Display(src);  
 src.append("\n"+"\n");
 
}
System.out.print(Branches.toString());
}

public void newCustomer(){

    Customer nextcustomer = new Customer();

}

public void newSubdepartment(){

Subdepartments = new BranchList();

}
public void saveToFile(boolean append) throws IOException{

   this.wipeFile();

    for(int i = 0; i <Branches.size();i++)

    
        try{
    
    FileWriter aWriter = new FileWriter(Filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(Branches.get(i).toString(false));
    

    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save customer array");
}
    
}

public void loadFromFile() throws FileNotFoundException, IOException, ParseException{

    String record;

FileReader reader;

    reader = new FileReader(Filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
   
    while ((record = bin.readLine())!=null)
    {     
     
       aBranch = new Branch();
              
       aBranch.Edit(bin.readLine(), bin.readLine(), bin.readLine(),
                      new IAddress(bin.readLine(),Integer.valueOf(bin.readLine()), bin.readLine(), 
                      bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine()));
        
       add(aBranch);
      
       }
 
    
    bin.close();
    bin =null;
    
}

public void wipeFile(){

 try{
    FileWriter aWriter = new FileWriter(Filename,false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
    

}


}

