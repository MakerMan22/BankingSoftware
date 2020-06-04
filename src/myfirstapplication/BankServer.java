/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Connor
 */
public class BankServer {
    
    
    private ServerSocket serverSocket= new ServerSocket(2222);
    private Socket aSocket;
    private PrintWriter output;
    private BufferedReader input;
    private CustomerList customerList;

      
        public BankServer() throws IOException{     
        }
       
        public String readInputData() throws IOException{
        
            if(aSocket==null){
            aSocket= serverSocket.accept();
            input = new BufferedReader(new InputStreamReader(aSocket.getInputStream())); 
            }
            
        String inputData  = input.readLine();
        return inputData;
        }
        
        public void sendToClient(String message) throws IOException{
    
        output = new PrintWriter(aSocket.getOutputStream(),true);
        output.println(message);
        aSocket = null;
        
        } 
}
