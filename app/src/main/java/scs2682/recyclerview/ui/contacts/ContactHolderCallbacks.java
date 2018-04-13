package scs2682.recyclerview.ui.contacts;

import android.support.annotation.NonNull;

import scs2682.recyclerview.data.contacts.Contact;

/**
 * Implemented from AppActivity and passed when instantiating Adapter instance and any ViewHolder instances
 */
public interface ContactHolderCallbacks {
  void onContactHolderClick(@NonNull Contact contact);

  void onContactLongPress(@NonNull Contact contact);
}
