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
public class ISAAccount extends Account{
    
Double MaximumLimitPerYear;    
Double DepositedThisYear;    
   

public ISAAccount(){

MaximumLimitPerYear = 3250.0;
DepositedThisYear = 0.0;

}

public ISAAccount (String aSortCode, Integer aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aMaximumLimitPerYear, Double aDepositedThisYear){

this.Create(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate, aMaximumLimitPerYear, aDepositedThisYear);

}



public void Create (String aSortCode, Integer aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aMaximumLimitPerYear, Double aDepositedThisYear){

//super.Create(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate);
MaximumLimitPerYear = aMaximumLimitPerYear;
DepositedThisYear = aDepositedThisYear;
}

public String Display(){

    return 
            "Max Limit Per Year: " + MaximumLimitPerYear + "\n" +
            "Deposited This Year: "+ DepositedThisYear + "\n"+
            super.toString(true);
   
   
}

public void depositYearlyInterest(){}

public void CalculateCharges(){}

 public void Withdrawal(double amount){   
    if(Balance<0){
    
     Balance = Balance - amount;
     
     DepositedThisYear = DepositedThisYear - amount;
    }
 
 else{
 
  JTextArea src = new JTextArea();
        src.setText("You cannot withdraw more than your balance");    
        JOptionPane.showMessageDialog(null, src);     
 
 }

}
    
    
 
 public  void Deposit(double amount){
 
 if(DepositedThisYear<=3250&&amount<3250){
     
    Balance = Balance + amount;
     
    DepositedThisYear = DepositedThisYear + amount;
 }
 
 else{
 
  JTextArea src = new JTextArea();
        src.setText("ISA Limit reached");    
        JOptionPane.showMessageDialog(null, src);     
 
 
 }
 
 
 
 
 
 }
 }
 
 
 

    








