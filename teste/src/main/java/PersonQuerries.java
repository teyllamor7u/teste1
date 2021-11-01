/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author steyl
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException; 
import java.util.List;
import java.util.ArrayList;

public class PersonQuerries {
    private static final String URL="jdbc:derby:AddressBook";
    private static final String USERNAME= "root" ;
    private static final String PASSWORD= "steyllamor8b,";
    
    private Connection connection= null;
    private PreparedStatement selectAllPeople=null;
    private PreparedStatement selectPeopleByLastName=null;
    private PreparedStatement insertNewPerson=null;
    public PersonQuerries(){
        try{
            connection=DriveManager.getConnection(URL,USERNAME,PASSWORD)
            selectAllPeople= connection.prepareStatement("SELECT *FROM AddressBook");
            insertNewPerson= connection.prepareStatement("INSERT INTO AddressBook"+"(FistName, LastName, Email, PhoneNumber)"+"VALUES(?,?,?,?)");
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
             System.exit(1);
        }
    }
    public List<Person>getAllPeople(){
        List<Person>result=null;
        ResultSet resultSet=null;
        try{
            resultSet= selectAllPeople.executeQuery();
            results= new ArrayList<Person>();
            While(resultSet.next()){
                results.add(new Person(
                resultSet.getInt("addressID"),
                resultSet.getString("LastName"),
                resultSet.getString("Email"),
                resultSet.getString("PhoneNumber")));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            }
            catch(SQLException sqlException){
                sqlException.printStackTrace();
                close();
            }
        }
    }
    public List<Person>get.selectPeopleByLastName(String name){
        List<Person>result=nill;
        ResultSet resultSet=nul;
        try{
            selectPeopleByLastName.setString(1, name);
            resultSet= selectPeopleByLastName.executeQuery();
            results= new ArrayList<Person>();
            While(resultSet.next()){
                results.add(new Person(
                resultSet.getInt("addressID"),
                resultSet.getString("LastName"),
                resultSet.getString("Email"),
                resultSet.getString("PhoneNumber")));
            }
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
        }
        finally{
            try{
                resultSet.close();
            }
            catch(SQLException sqlException){
             sqlException.printStackTrace();
             close();
            }
        }
        return results;
    }
    public int addPerson(String fname,String lname,String email,String num){
         int result=0;
         try{
             insertNewPerson.setString(1, fname);
             insertNewPerson.setString(2, lname);
             insertNewPerson.setString(3, email);
             insertNewPerson.setString(4, num);
             result= insertNewPerson.executeUpdate();
         }
         catch(SQLException sqlException){
             sqlException.printStackTrace();
         }
    }
    public void close(){
        try{
            connection.close();
        }
        catch(SQLException sqlException){
             sqlException.printStackTrace();
         }
    }
    
    
}
