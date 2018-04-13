package scs2682.recyclerview.data.contacts;

import android.support.annotation.NonNull;

/**
 * Data model with all information for a single person.
 * <p/>
 * This represents a single row in a database table (or an Excel sheet).
 * <p/>
 * For this example, there are collection of Person instances in PersonDataStore.data
 */
public class Contact {
  @NonNull private final String firstName;
  @NonNull private final String lastName;
  @NonNull private final String email;
  @NonNull private final String phone;

  public Contact(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  @NonNull public String getFirstName() {
    return firstName;
  }

  @NonNull public String getLastName() {
    return lastName;
  }

  @NonNull public String getEmail() {
    return email;
  }

  @NonNull public String getPhone() {
    return phone;
  }
}