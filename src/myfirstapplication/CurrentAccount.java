/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Connor
 */
public class CurrentAccount extends Account{

Double Overdraft;
String Conditions;
Double AvailableBalance;

    
public CurrentAccount (){  
    Overdraft = 100.0;
    Conditions = "";
    AvailableBalance = 0.0;
//The rest of its attibutes its attribues from Account. ( not confirmed if this works or not)
}

 public CurrentAccount(String Strsortcode, String straccountno ){
        super.edit(Strsortcode, straccountno);
        
        Overdraft = 100.0;
        AvailableBalance = this.calculateAvailableBalance();
 }



public CurrentAccount (String aSortCode, String aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aOverdraft, String aCondition, Double aAvailableBalance){

    this.edit(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate, aOverdraft, aCondition, aAvailableBalance);
    


}



public void edit (String aSortCode, String aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aOverdraft, String aCondition, Double aAvailableBalance){

super.edit(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate);
Overdraft = aOverdraft;
Conditions = aCondition;
AvailableBalance = aAvailableBalance;
}

public void edit (String aSortCode, String aAccountNo){

super.edit(aSortCode, aAccountNo);

}





public String Display(){

    return 
            
            
            "Overdraft: " + Overdraft + "\n" +
            "Conditions: "+ Conditions + "\n"+
            "Available Balance: "+ AvailableBalance + "\n"+
            super.toString(true);
    //return super.displayNewAccount();
    
}

public void depositMonthlyInterest(){}

public void CalculateCharges(){}


public boolean performTransaction(Double costinput){
boolean complete = false;


    if(costinput <= this.getAvailableBalance()){
        complete = true;
        if(costinput<=super.getBalance()){
        super.setBalance(Balance-costinput);//IF IT CAN BE PAID FOR WITH BALANCE ALONE       
        }
        else if(costinput>super.getBalance()){
        this.setOverdraft(Overdraft-(costinput-Balance)); //IF IT NEEDS TO BE PAID FOR WITH BALANCE AND OVERDRAFT
        super.setBalance(0.0);
        
        }
        
        this.calculateAvailableBalance();


}
return complete;
}


public Double calculateAvailableBalance(){
    
    AvailableBalance = Overdraft+super.Balance;

return AvailableBalance;

}







    @Override
    public void Withdrawal(double amount) {

        Balance = Balance - amount;

        JTextArea src = new JTextArea();
        src.setText("Withdrawal Successful");    
        JOptionPane.showMessageDialog(null, src);        

    }

    @Override
    public void Deposit(double amount) {
    Balance = Balance + amount;

        JTextArea src = new JTextArea();
        src.setText("Deposit Successful");    
        JOptionPane.showMessageDialog(null, src);        

    }

    public Double getOverdraft() {
        return Overdraft;
    }

    public void setOverdraft(Double Overdraft) {
        this.Overdraft = Overdraft;
    }

    public Double getAvailableBalance() {
        return AvailableBalance;
    }

    public void setAvailableBalance(Double AvailableBalance) {
        this.AvailableBalance = AvailableBalance;
    }


    
    


}
