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
public class SavingAccount extends Account{
    
    
    Double WithdrawalLimit;
    

public SavingAccount(){

WithdrawalLimit = 200.0;
}

public SavingAccount (String aSortCode, Integer aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aWithdrawalLimit){

    this.Create(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate, aWithdrawalLimit);
    
}



public void Create (String aSortCode, Integer aAccountNo, Double aBalance, String aNameOfBank, Double aRate,Double aWithdrawalLimit){

//super.Create(aSortCode, aAccountNo, aBalance, aNameOfBank, aRate);
WithdrawalLimit = aWithdrawalLimit;

}

public String Display(){

    return 
            "Withdrawal Limit: " + WithdrawalLimit+"\n" + 
            super.toString(true);
  
}

public void depositMonthlyInterest(){}

public void CalculateCharges(){}



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

}



