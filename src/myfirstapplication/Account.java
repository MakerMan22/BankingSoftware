/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//MODIFIED VERSION FOR ITERATION 2
//THIS ONLY INSTANTIATES SORT CODE AND ACCOUNT NUMBER AS THAT IS ALL THAT IS REQUIRED FOR ITERATION 2 
package myfirstapplication;

/**
 *
 * @author Connor
 */
abstract class Account {
    
    protected String  Sortcode;
    protected String  AccountNo;
    protected Double  Balance;
    protected String  NameOfBank;
    protected Double  Rate;
    protected String  LastReportedDate;
    
    public Account(){
    
        
     Sortcode = "";
     AccountNo = "";
     Balance = 0.0;
     NameOfBank ="";
     Rate = 1.2;
     LastReportedDate = "01/01/1900";
    
    }
    
    public Account(String Strsortcode, String intaccountno, Double doublebalance, String strnameofbank, Double doublerate){
    
        
     Sortcode = Strsortcode;
     AccountNo = intaccountno;
     Balance = doublebalance;
     NameOfBank =strnameofbank;
     Rate = doublerate;
 //    LastReportedDate = strlastreporteddate;
    
    }
    public Account(String Strsortcode, String intaccountno){
        this.edit(Strsortcode, intaccountno);
    
    }
    
    public void edit(String Strsortcode, String intaccountno){
     Sortcode = Strsortcode;
     AccountNo = intaccountno;
    
    }
    
    
    
    public void edit (String Strsortcode, String intaccountno, Double doublebalance, String strnameofbank, Double doublerate){
    
        
     Sortcode = Strsortcode;
     AccountNo = intaccountno;
     Balance = doublebalance;
     NameOfBank =strnameofbank;
     Rate = doublerate;
 //    LastReportedDate = strlastreporteddate;
    
    }
    
    public String displayNewAccount(){
    
    return this.toString(Boolean.TRUE);
    
    }
    
    public String toString(Boolean DisplayingtoGUI){
     
    
    if(DisplayingtoGUI == true)
    {    
        return
        "Sortcode: "+ Sortcode +"\n"+
        "Account Number: "+ AccountNo +"\n"+
        "Balance: "+ Balance +"\n"+
        "Name of Bank: "+ NameOfBank +"\n"+
        "Rate: "+ Rate +"\n"+        
        "Last Reported Date: "+ LastReportedDate +"\n";
    }    
    else // We are saving to file. 
    {
        return
         Sortcode +"\n"+
         AccountNo +"\n"+
         Balance +"\n"+
         NameOfBank +"\n"+
         Rate +"\n"+        
         LastReportedDate +"\n";
    }
}

    public abstract void Withdrawal(double amount);
    
    public abstract void Deposit(double amount);

    public String getSortcode() {
        return Sortcode;
    }

    public void setSortcode(String Sortcode) {
        this.Sortcode = Sortcode;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double Balance) {
        this.Balance = Balance;
    }

    public String getNameOfBank() {
        return NameOfBank;
    }

    public void setNameOfBank(String NameOfBank) {
        this.NameOfBank = NameOfBank;
    }

    public Double getRate() {
        return Rate;
    }

    public void setRate(Double Rate) {
        this.Rate = Rate;
    }

    public String getLastReportedDate() {
        return LastReportedDate;
    }

    public void setLastReportedDate(String LastReportedDate) {
        this.LastReportedDate = LastReportedDate;
    }


    
    
    
       
  
      
 
    
}
