/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javax.swing.table.AbstractTableModel;
public class ResultSetTableModel extends AbstractTableModel {
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase= false;
    public ResultSetTableModel (String url,String username,
            String password,String querry)throw SQLException{
        connection = DriveManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY)
                connectedToDatabase=true;
        setQuerry (Querry);       
    }
    public Class getColumnClass(int column) throws IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       try{
           String className=metaData.getColumnClassName(column+1);
           return Class.forName(className);
       
       }
       catch(Exception exception){
           exception.printStackTrace();
       }
       return Object.class;
    }
    public int getColumnCout() throw IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       try{
           
           return metaData.getColumnCount();
       
       }
       catch(Exception exception){
           sqlException.printStackTrace();
       }
       return 0
    }
    public String getColumnName(int column) throw IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       try{
           
           return metaData.getColumnName(column+1):
       
       }
       catch(Exception exception){
           sqlException.printStackTrace();
       }
       return "";
    }
    public int getRowCount() throw IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       
       
       return numberOfRows;
    }
    public Object getValueAt(int row, int column) throw IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       try{
           resultSet.absolute(row+1);
           return resultSet.getObject(column+1);
       }
       catch(Exception exception){
           sqlexception.printStackTrace();
       }
       return "";
    }
    public void setQuerry(String querry) throw IllegalStateException{
       if(!connectedToDatabase) 
           throw new IllegalStateException("not connected to database");
       
           
           resultSet= statement.executeQuery(querry) ;
           metaData=resultSet.getMetaData();
      
           resultSet.last()
           numberOfRows= resultSet.getRow();
    }
    public void disconnectFromDatabase(){
       if(connectedToDatabase) 
       {   
            try{
                resultSet.close();
                statement.close();
                connection.close();
       
             }
            catch(SQLException sqlexception){
                 sqlexception.printStackTrace();
            }
             finally{
                 connectedToDatabase= false;
            }
       }
    }
}
