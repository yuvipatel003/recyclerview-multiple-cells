package scs2682.recyclerview.data.contacts;

import java.util.ArrayList;

/**
 * In-memory presentation of a database table. Think about an Excel sheet where all rows are stored as
 * 'Person' instances inside 'DataStore.data' collection
 */
public class ContactsDataStore {
  private final ArrayList<Contact> data;

  public ContactsDataStore() {
    data = new ArrayList<>();
  }

  public ArrayList<Contact> getData() {
    return data;
  }

  /**
   * Adding list of hardcoded items, for the sake of the example
   */
  public void addAll() {
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", "1231231234"));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "robert.deniro@fake.com", "3453453456"));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", "6786786789"));
    data.add(new Contact("Dustin", "Hofman", "", "7897897890"));
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", "1231231234"));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "robert.deniro@fake.com", ""));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", "6786786789"));
    data.add(new Contact("Dustin", "Hofman", "dustin.hofman@fake.com", "7897897890"));
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", "1231231234"));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "robert.deniro@fake.com", ""));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", "6786786789"));
    data.add(new Contact("Dustin", "Hofman", "dustin.hofman@fake.com", "7897897890"));
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", "1231231234"));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "", "3453453456"));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", "6786786789"));
    data.add(new Contact("Dustin", "Hofman", "dustin.hofman@fake.com", "7897897890"));
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", ""));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "robert.deniro@fake.com", "3453453456"));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", "6786786789"));
    data.add(new Contact("Dustin", "Hofman", "dustin.hofman@fake.com", "7897897890"));
    data.add(new Contact("Jack", "Nicholson", "jack.nicholson@fake.com", ""));
    data.add(new Contact("Marlon", "Brando", "marlon.brando@fake.com", "2342342345"));
    data.add(new Contact("Robert", "De Niro", "", "3453453456"));
    data.add(new Contact("Al", "Pacino", "al.pacino@fake.com", "5675675678"));
    data.add(new Contact("Daniel", "Day-Lewis", "daniel.del.lewis@fake.com", ""));
    data.add(new Contact("Dustin", "Hofman", "dustin.hofman@fake.com", "7897897890"));
  }
}
