package org.example.mobile;

import java.util.List;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact){
        if(!myContacts.contains(contact)){
            myContacts.add(contact);
            return true;
        }
        return false;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        if(myContacts.contains(oldContact)){
            myContacts.set(myContacts.indexOf(oldContact), newContact);
            return true;
        }
        return false;
    }
    public boolean removeContact(Contact contact){
        int index = findContact(contact);
        if(index == -1) return false;

        myContacts.remove(index);
        return true;
    }

    public int findContact(Contact contact){
        for(int i = 0; i < myContacts.size(); i++){
            if(Objects.equals(myContacts.get(i).getName(), contact.getName()) && Objects.equals(myContacts.get(i).getPhoneNumber(), contact.getPhoneNumber())){
                return i;
            }
        }
        return -1;
    }

    public int findContact(String contact){
        for(int i = 0; i < myContacts.size(); i++){
            if(Objects.equals(myContacts.get(i).getName(), contact) || Objects.equals(myContacts.get(i).getPhoneNumber(), contact)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact){
        for (Contact myContact : myContacts) {
            if (Objects.equals(myContact.getName(), contact) || Objects.equals(myContact.getPhoneNumber(), contact)) {
                return myContact;
            }
        }
        return null;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    private int whichIndex(Contact contact){
        for(int i = 0; i < myContacts.size(); i++){
            if(Objects.equals(myContacts.get(i).getName(), contact.getName()) && Objects.equals(myContacts.get(i).getPhoneNumber(), contact.getPhoneNumber())){
                return i;
            }
        }
        return -1;
    }


    public void print() {
        System.out.print("MobilePhone{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts= [" );
        for(Contact contact : myContacts){
            System.out.print("[" + contact.getName() + ", " + contact.getPhoneNumber() + "] ");
        }
        System.out.print("]}");
    }
}
