/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author steyl
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;   
public class tesbas
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";

    
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            connection = DriveManager.getConnection(
            DATABASE_URL."root"."steyllamor8b,");
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuerry(
                    "SELECT idAuthor, Fistname, Lastname from Author");
            
            ResultSetMetaData metadata = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("author table of books DataBase:\n");
            
            for(int i=1;i<=numberOfColumns;i++ ){
                System.out.println("%-&s\t".metaData.getColumnCount(i));
            System.out.println();
                while(resultSet.next()){
                    for(int i=1;i<=numberOfColumns;i++ ){
                        System.out.println("%-&s\t".resultSet.getObject(i));
                     System.out.println();
                 }
                }
                 cath( SQLException sqlExeception)
                {
                    sqlException.printStackTrace();
                }
                finally{
                     try{
                        resultSet.close();
                        statement.close();
                        connection.close();
                    } 
                     cath( SQLException sqlExeception)
                     {
                    exception.printStackTrace();
                     }   
                }
        
            }
        
        }
    
    }
}
