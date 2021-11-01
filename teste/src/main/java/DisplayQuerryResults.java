/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author steyl
 */
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
public class DisplayQuerryResults extends JFrame {
    static final String DATABASE_URL="jdbc:mysql://localhost/books";
    static final String USERNAME="root";
    static final String PASSWORD="steyllamor8b,";
    
    static final String DEFAULT_QUERRY="select*From Authors";
    private ResultSetTableModel tableModel;
    private JTextArea querryArea;
    public DisplayQuerryResult(){
        super("Displying Querry Results");
        try{
            tableModel= new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFALT_QUERRY);
            querryArea= new JtextArea(DEFALT_QUERRY,3,100);
            querryArea.setWrapStyleWord(true);
            querryArea.setLineWrap(true);
            JScrollPane scrollPane= new JScrollPane(querryArea,
                    ScrollPaneConstans.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstans.HORIZONTAL_SCROLLBAR_NEERVER);
            JButton submitButton = new JButton("Subimit Querry");
            Box boxNorth= Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);
            JTable resultTable= new JTable(tableModel);
            JLabel filterLabel=new JLabel("Filter:");
            final JTextField filterText=new JTextField();
            JButton filterButton=new JButton("Apply Filter");
            Box boxSouth= Box.createHorizontalBox();
            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);
            submitButton.addActionListener(
                new ActionListener(){
                    public void action performed(ActionEvent event){
                        try{
                            tableModel.setQuerry(DEFAULT_QUERRY);
                        }
                        catch(SQLException sqlException){
                            JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                            "Database error", JOptionPane.ERROR_MESSAGE);
                            try{
                                tableModel.setQuerry(DEFAULT_QUERRY);
                                querryArea.setText(DEFAULT_QUERRY);
                            }
                            catch(SQLException sqlException2){
                                JOptionPane.showMessageDialog(null, sqlException2.getMessage(),
                            "Database error", JOptionPane.ERROR_MESSAGE);
                                tableModel.disconnectFromDatabase();
                                System.exit(1);
                            }
                        }
                    }
                }
            );
            final TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            setSize(500,250);
            setVisible(true);
            filterButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String text=filterText.getText();
                        if(text.length()==0)
                            sorter.setRowFilter(null);
                        else{
                            try{
                                sorter.setRowFilter(
                                RowFilter.regexFilter(text));
                            }
                            catch(PatternSytaxException pse){
                                JOptionPane.showMessageDialog(null, "bad regex patten",
                             JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    
                }
            );
        }
        catch(SQLException sqlException){
            JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                            "Database error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(
            new WindowAdapter(){
                public void windowClosed(WindowEvent event){
                    tableModel.disconnectFromDatabase();
                    System.exit(0);
                }
            }
        );
    }
    public static void main(string args[]){
        new DisplayQuerryResults();
    }
}
