/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;
import java.util.Date;

/**
 *
 * @author Connor
 */

//This is the class definition 
//Here we declare the constructor. 
//We are Declaring the variables - variables must be declared to bring them into the file
public class Person {

private String Firstname;    
private String Surname;
private IAddress Homeaddress;
private Date DOB;
private Date Customersince;



//This is the implementation of a constructor that was declared above.
//This is the default constructor - No parameters, all values either 0 or blank.
//Used to create objects that are blank when initialised.
public Person(){
Firstname = "";
Surname = "";
Homeaddress = new IAddress();
DOB = new Date();
Customersince = new Date();
}


//This is the implementation of a constructor that was declared above.
//This is a constructor with parameters
//Used to create objects that are initialised to specific values - determined by what is passed into them by the object that is using it. 
public Person(String strfirstname, String strsurname, IAddress objhomeaddress, Date datedob, Date datecustomersince){
Firstname = strfirstname;
Surname = strsurname;
Homeaddress = objhomeaddress;
DOB = datedob;
Customersince = datecustomersince;


}
}
