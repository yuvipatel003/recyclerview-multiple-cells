package scs2682.recyclerview.ui.contacts.adapter;

import android.support.annotation.NonNull;

import scs2682.recyclerview.data.contacts.Contact;

/**
 * Metadata details for Adapter to know what to load and supply when a ContactHolder
 * is suppose to be created or updated.
 */
public class ContactModel extends AdapterModel {
  @NonNull public final Contact contact;

  public ContactModel(int layoutId, @NonNull Contact contact) {
    super(layoutId);
    this.contact = contact;
  }
}
