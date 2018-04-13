package scs2682.recyclerview.ui.contacts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import scs2682.recyclerview.R;
import scs2682.recyclerview.data.contacts.Contact;
import scs2682.recyclerview.ui.contacts.ContactHolderCallbacks;

/**
 * View holder for model.Person. It's using R.layout.appactivity_cell as the layout to bind data
 */
public class ContactHolder extends RecyclerView.ViewHolder {
  private final TextView firstAndLastName;
  private final TextView email;
  private final TextView phone;

  private Contact contact;

  /**
   * ViewHolder for R.layout.appactivity_cell
   */
  public ContactHolder(View view, final ContactHolderCallbacks contactHolderCallbacks) {
    super(view);

    firstAndLastName = (TextView) view.findViewById(R.id.firstAndLastName);
    email = (TextView) view.findViewById(R.id.email);
    phone = (TextView) view.findViewById(R.id.phone);

    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        contactHolderCallbacks.onContactHolderClick(contact);
      }
    });

    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View view) {
        contactHolderCallbacks.onContactLongPress(contact);
        return true;
      }
    });
  }

  public void bind(@NonNull Contact contact) {
    this.contact = contact;

    firstAndLastName.setText(contact.getFirstName() + " " + contact.getLastName());
    email.setText(contact.getEmail());
    phone.setText(contact.getPhone());
  }
}