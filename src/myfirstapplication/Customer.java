/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Connor
 */

//This is the class definition 
//Here we declare the constructor. 
//We are Declaring the variables - variables must be declared to bring them into the file
public class Customer {

private String Firstname;    
private String Surname;
private IAddress Homeaddress;
private Date DOB;
private Date Customersince;
private SimpleDateFormat simpledateformat= new SimpleDateFormat("dd/MM/yy");
private SimpleDateFormat simpledateformat2= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
private String Filename;
private CurrentAccount customersCurrentAccount;
private ISAAccount CustomersISAAccount;
private SavingAccount CustomersSavingAccount1;
private SavingAccount CustomersSavingAccount2;



//This is the implementation of a constructor that was declared in the definition
//This is the default constructor - No parameters, all values either 0 or blank.
//Used to create objects that are blank when initialised.

public Customer(){
Firstname = "";
Surname = "";
Homeaddress = new IAddress();
DOB = new Date();
Customersince = new Date();
simpledateformat = new SimpleDateFormat("dd/MM/yy");
simpledateformat2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
Filename = "CustomerAddressFile.txt";  
customersCurrentAccount = new CurrentAccount();
//CustomersISAAccount = new ISAAccount();
//CustomersSavingAccount1 = new SavingAccount();
//CustomersSavingAccount2 = new SavingAccount();

}


//This is the implementation of a constructor that was declared in the definition
//This is a constructor with parameters
//Used to create objects that are initialised to specific values - determined by what is passed into them by the object that is using it. 
//This constructor contains account 
public Customer(String strfirstname, String strsurname, String datedob, String datecustomersince,IAddress srcaddress, CurrentAccount srcaccount) throws ParseException{
this.Edit(strfirstname,  strsurname,  datedob, datecustomersince, srcaddress, srcaccount);
}
//This constructor does not contain account
public Customer(String strfirstname, String strsurname, String datedob, String datecustomersince,IAddress srcaddress) throws ParseException{
this.Edit(strfirstname,  strsurname,  datedob, datecustomersince, srcaddress);
}

//This edit method contains account 
public void Edit(String strfirstname, String strsurname, String datedob, String datecustomersince,IAddress srcaddress, CurrentAccount srcaccount) throws ParseException{
Firstname = strfirstname;
Surname = strsurname;
DOB = this.StringToDate(datedob);
Customersince = this.StringToDate(datecustomersince);
Homeaddress = srcaddress;
customersCurrentAccount = srcaccount;
    


}
//This edit method does not contain account
public void Edit(String strfirstname, String strsurname, String datedob, String datecustomersince,IAddress srcaddress) throws ParseException{
//public void Edit(String strfirstname, String strsurname, String datedob, String datecustomersince,String strname, String strstreet,Integer inthouseno, String strhousename, String strarea, String strpostcode, String strtown, String strcountry) throws ParseException{
  
Firstname = strfirstname;
Surname = strsurname;
DOB = this.StringToDate(datedob);
Customersince = this.StringToDate(datecustomersince);
Homeaddress = srcaddress;

}






public void Display(Boolean TrueAllCustomersFalseOneCustomer,javax.swing.JTextArea src){

 if(TrueAllCustomersFalseOneCustomer == true)  // will append all customers as it runs through the list  
    
    {src.append(this.toString(true));
     src.append("\n");
    
    }
 else//False
 
    {src.setText(this.toString(true)); // will clear text area and only show what has been selected 
     src.append("\n");

    }


}

public void DisplayCustomerAccount(Boolean TrueAllCustomersFalseOneCustomer,javax.swing.JTextArea src){

 if(TrueAllCustomersFalseOneCustomer == true)  // will append all customers as it runs through the list  
    
    {src.append(this.getFirstName() + " " + this.getSurname()+"'s account details: \n"); 
    
     src.append("Current Account: "   +this.customersCurrentAccount.Display()   +"\n");
  //   src.append("ISA Account: "       +this.CustomersISAAccount.Display()       +"\n");
  //   src.append("Saving Account 1: "  +this.CustomersSavingAccount1.Display()   +"\n");
  //   src.append("Saving Account 2: "  +this.CustomersSavingAccount2.Display()   +"\n");
     //src.append(this.getCustomersCurrentAccount().toString(true));
     
    
    }
 else//False
     
    {src.setText(this.getFirstName() + " " + this.getSurname()+"'s account details: "+"\n"+"\n"); // will clear text area and only show what has been selected 
     
     src.append("Current Account: "+ "\n"   +this.customersCurrentAccount.Display()   +"\n");
  //   src.append("ISA Account: "+ "\n"       +this.CustomersISAAccount.Display()       +"\n");
  //   src.append("Saving Account 1: "+ "\n"  +this.CustomersSavingAccount1.Display()   +"\n");
  //   src.append("Saving Account 2: "+ "\n"  +this.CustomersSavingAccount2.Display()   +"\n");
    }
}

public boolean CheckDOB(String InputDOB) throws ParseException{
    boolean answer;
    
    DOB = simpledateformat.parse("06/10/19");
    
    Date UserInputDOB = simpledateformat.parse(InputDOB);
    
    if(DOB.equals(UserInputDOB)){
        answer = true;    
    }
    
    else{
        answer = false;
    }
    
    
    return answer;
}

public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    { 
      //  String customersAddress = Homeaddress.toString(true);
        
        return     
        "First Name: "+ Firstname+"\n"+
        "Surname: "+ Surname+"\n"+
        "DOB: "+ DOB+"\n"+
        "Customer Since: "+ Customersince+"\n"+ this.getHomeaddress().toString(true);
              
    }
    else //We are saving to file
    {
        
        return
        Firstname+"\n"+
        Surname+"\n"+
        DOB+"\n"+
        Customersince+"\n"+
        this.getHomeaddress().toString(false)+
        this.getCustomersCurrentAccount().getSortcode()+"\n"+
        this.getCustomersCurrentAccount().getAccountNo() ;
    }
             
}

public Date StringToDate(String userinput) throws ParseException{
    
    if(userinput.length()==8)
    {
    //dd/MM/yy conversion    
    Date dateOutput = simpledateformat.parse(userinput);
    return dateOutput;
    }
    else
    {   
    //EEE MMM dd HH:mm:ss z yyyy conversion    
    Date dateOutput = simpledateformat2.parse(userinput);
    return dateOutput;
    }
    
}

public void Withdrawal(Double WithdrawalAmount){

customersCurrentAccount.Withdrawal(WithdrawalAmount);
}

public void Deposit(Double DepositAmount){

customersCurrentAccount.Deposit(DepositAmount);
}


public void setFirstName(String firstname){

this.Firstname = firstname;
}

public String getFirstName(){

return Firstname;
}

public void setSurname(String surname){

this.Surname = surname;
}

public String getSurname(){

return Surname;
}

public void setHomeaddress(IAddress homeaddress){

this.Homeaddress = homeaddress;
}

public IAddress getHomeaddress(){

return Homeaddress;
}

public void setDOB(Date dob){

this.DOB = dob;
}

public Date getDOB(){

return DOB;
}

public void setCustomerSince(Date customersince){

this.Customersince = customersince;
}

public Date getCustomerSince(){

return Customersince;
}

public void setCustomersCurrentAccount(CurrentAccount customerscurrentaccount){

customersCurrentAccount = customerscurrentaccount;

}

public CurrentAccount getCustomersCurrentAccount(){

return customersCurrentAccount;

}

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public Date getCustomersince() {
        return Customersince;
    }

    public void setCustomersince(Date Customersince) {
        this.Customersince = Customersince;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String Filename) {
        this.Filename = Filename;
    }

    public ISAAccount getCustomersISAAccount() {
        return CustomersISAAccount;
    }

    public void setCustomersISAAccount(ISAAccount CustomersISAAccount) {
        this.CustomersISAAccount = CustomersISAAccount;
    }

    public SavingAccount getCustomersSavingAccount1() {
        return CustomersSavingAccount1;
    }

    public void setCustomersSavingAccount1(SavingAccount CustomersSavingAccount1) {
        this.CustomersSavingAccount1 = CustomersSavingAccount1;
    }

    public SavingAccount getCustomersSavingAccount2() {
        return CustomersSavingAccount2;
    }

    public void setCustomersSavingAccount2(SavingAccount CustomersSavingAccount2) {
        this.CustomersSavingAccount2 = CustomersSavingAccount2;
    }
}
