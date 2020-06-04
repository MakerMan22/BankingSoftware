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
public class CustomerList {
private ArrayList<Customer>Clients;
private String Filename;
private Customer aCustomer;
private Integer CustomerIndex;
    
public CustomerList(){

//Clients=null;
Clients=new ArrayList<>();
Filename = "CustomerAddressFile.txt";
aCustomer= new Customer();
CustomerIndex = 1;
}

public void add(Customer src) throws IOException{

    //do not combine methods in the same action 
    Clients.add (src);

}

public void remove(Customer src){
Clients.remove (src);
}

public void remove(String Firstname, String Surname) throws IOException{
for(int i = 0; i <Clients.size();i++)
{
    
    if ((Clients.get(i).getFirstName().equals(Firstname))&&(Clients.get(i).getSurname().equals(Surname))){ 
            
         Clients.remove(i);
         
        }
}

this.wipeFile();

for(int i = 0; i <Clients.size();i++){
        
    this.saveToFile(true);
    
    }

}


public Customer findAccount(String sortCode, String accountNumber){

    Customer c = null;
for(Customer customer : this.Clients){

    if(customer.getCustomersCurrentAccount().getSortcode().equalsIgnoreCase(sortCode)){
    
        if(customer.getCustomersCurrentAccount().AccountNo.equalsIgnoreCase(accountNumber)){
        
        c = customer;
        break;
        
        }
    
    }       
}    
return c;
}


public void display (javax.swing.JTextArea src){

src.setText(null);    
for(int i = 0; i <Clients.size();i++)
{
 src.append("Client number: " + i + "\n");
   Clients.get(i).Display(true,src);  
// Clients.get(i).Display(true,src);  
 src.append("\n");
 
}
System.out.print(Clients.toString());
}

public void loadFromFile() throws FileNotFoundException, IOException, ParseException{

    String record;

FileReader reader;

    reader = new FileReader(Filename);
    BufferedReader bin = new BufferedReader(reader);
    record = new String();
   
    while ((record = bin.readLine())!=null)
    {     
     
       aCustomer = new Customer();
              
       aCustomer.Edit(bin.readLine(), bin.readLine(), bin.readLine(), bin.readLine(),
                      new IAddress(bin.readLine(), Integer.valueOf(bin.readLine()), bin.readLine(), 
                      bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine()),
                      new CurrentAccount(bin.readLine(),bin.readLine()));
        
       add(aCustomer);
      
       }
 
    
    bin.close();
    bin =null;
    
}

public void saveToFile(boolean append) throws IOException{

   this.wipeFile();

    for(int i = 0; i <Clients.size();i++)

    {try{
    
    FileWriter aWriter = new FileWriter(Filename,true);
    aWriter.write(System.getProperty("line.separator"));
    aWriter.write(Clients.get(i).toString(false));
    

    aWriter.close();
    }

catch(IOException ioe){
System.out.println("Failed to save customer array");
}}
}

public void wipeFile(){

 try{
    FileWriter aWriter = new FileWriter(Filename,false);
    }
    catch(IOException ioe){
    System.out.println("Failed to wipe file");
    }
    

}

public boolean FindCustomerz(int selection, String dataToCompare){

    String datatocompare = dataToCompare;
    Boolean clientFound = false;
   // int x = 0;
    switch (selection)
    {

        case 1:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getFirstName().equals(datatocompare))){
                   
                    clientFound = true;
                    
                     CustomerIndex = i;
                     
                }
              
            } 
        break;    
        case 2:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getSurname().equals(datatocompare))){
                    
                    clientFound = true;
                    
                     CustomerIndex = i;
                    
                 
                }    
            }
        break;
        case 3:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getDOB().equals(datatocompare))){
                     
                    clientFound = true;
                    
                     CustomerIndex = i;
                    
                   
                }    
            }
        break;   
    }
    
    if(clientFound==false){
     
                //src.setText("No results found");
                
    }
     
return clientFound;
}


public void DisplayCustomerAccount(int selection, String dataToCompare, javax.swing.JTextArea src){

    String datatocompare = dataToCompare;
    Boolean clientFound = false;
    switch (selection)
    {

        case 1:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getFirstName().equals(datatocompare))){
                   
                    Clients.get(i).DisplayCustomerAccount(false,src);
                    
            // Clients.get(i).getAddress();
                     
                     clientFound = true;
                }
              
            } 
        break;    
        case 2:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getSurname().equals(datatocompare))){
                     Clients.get(i).DisplayCustomerAccount(false,src);
                     clientFound = true;
                }    
            }
        break;
        case 3:

            for(int i = 0; i <Clients.size();i++)
            {
                if ((Clients.get(i).getDOB().equals(datatocompare))){
                     Clients.get(i).DisplayCustomerAccount(false,src);
                     clientFound = true;
                }    
            }
        break;   
    }
    
    if(clientFound==false){
     
                src.setText("No results found");
                
    }
}

public void Withdrawal(Double WithdrawalAmount){



}

    public ArrayList<Customer> getClients() {
        return Clients;
    }

    public void setClients(ArrayList<Customer> Clients) {
        this.Clients = Clients;
    }

    public Integer getCustomerIndex() {
        return CustomerIndex;
    }

    public void setCustomerIndex(Integer CustomerIndex) {
        this.CustomerIndex = CustomerIndex;
    }

    
    
}

