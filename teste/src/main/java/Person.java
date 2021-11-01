/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author steyl
 */
public class Person {
    private int addressID;
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;
    public person(){
    }
    public person(int id, String fist, String last, String email1, String phone);{
        setAddressID(id);
        setFistName(fist);
        setLastName(last);
        setEmail(email1);
        setPhoneNumber(phone);
    }
    public void setAddressID(int id){
        addressID=id;
    }
    public void getAddressID(){
        return addressID;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email1) {
        email = email1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        phoneNumber = phone;
    }
    
}
