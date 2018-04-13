package scs2682.recyclerview.ui.contacts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import scs2682.recyclerview.R;
import scs2682.recyclerview.data.contacts.Contact;
import scs2682.recyclerview.data.contacts.ContactsDataStore;
import scs2682.recyclerview.ui.contacts.adapter.AdapterModel;
import scs2682.recyclerview.ui.contacts.adapter.ContactHolder;
import scs2682.recyclerview.ui.contacts.adapter.ContactModel;
import scs2682.recyclerview.ui.contacts.adapter.TitleModel;

/**
 * Contacts fragment
 */
public class Contacts extends Fragment implements ContactHolderCallbacks {
  /**
   * Replacing any existing fragments with this one, by calling 'replace()' rather 'add()'
   *
   * @param parentViewId ID of the parent view, in which this fragment's view will be added
   */
  public static void create(@NonNull FragmentManager fragmentManager, int parentViewId) {
    fragmentManager.beginTransaction()
        .replace(parentViewId, new Contacts(), null)
        .commit();
  }

  private ContactsDataStore contactsDataStore;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.contacts, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    contactsDataStore = new ContactsDataStore();
    contactsDataStore.addAll();

    List<AdapterModel> adapterModels = setupAdapterModels();

    // create an adapter instance with no items initially
    Adapter adapter = new Adapter(adapterModels, this);

    RecyclerView recyclerView = (RecyclerView) view;
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(adapter);
  }


  /**
   * Called from any {@link ContactHolder} instance click
   *
   * @param contact contact
   */
  @Override
  public void onContactHolderClick(@NonNull Contact contact) {
    Toast.makeText(getActivity(), "Click for " + contact.getFirstName() + " " + contact.getLastName(), Toast.LENGTH_SHORT)
        .show();
  }

  /**
   * Called from any {@link ContactHolder} instance long press
   *
   * @param contact contact
   */
  @Override
  public void onContactLongPress(@NonNull Contact contact) {
    Toast.makeText(getActivity(), "Long press for " + contact.getFirstName() + " " + contact.getLastName(),
        Toast.LENGTH_SHORT)
        .show();
  }

  /**
   * Goes through all contacts, filtering the ones without emails, without phones and then creates a
   * complete list of AdapterModel instances (ContactModel and TitleModel) to show properly different cell types:
   * for title and for any contact
   */
  private List<AdapterModel> setupAdapterModels() {
    // we need 3 separate filters - for contacts without emails, without phones, and then contacts with both emails and phones
    List<Contact> noEmails = new ArrayList<>();
    List<Contact> noPhones = new ArrayList<>();
    List<Contact> withEmailsAndPhones = new ArrayList<>();

    // iterate through personalDataStore and move around contacts as expected
    for (Contact contact : contactsDataStore.getData()) {
      if (contact == null) {
        continue;
      }

      if (!contact.getEmail().isEmpty() && !contact.getPhone().isEmpty()) {
        // has email and phone
        withEmailsAndPhones.add(contact);
      }
      else {
        if (contact.getEmail().isEmpty()) {
          // no email
          noEmails.add(contact);
        }

        if (contact.getPhone().isEmpty()) {
          // no phone
          noPhones.add(contact);
        }
      }
    }

    // and then we need to add the complete list of AdapterModel instances
    List<AdapterModel> adapterModels = new ArrayList<>();

    // add meta data for "With Emails and Phones" view holder and cell
    adapterModels.add(new TitleModel(R.layout.contacts_titlecell, getString(R.string.with_emails_and_phones)));

    // add metadata for all contacts with both emails and phones
    for (Contact contact : withEmailsAndPhones) {
      adapterModels.add(new ContactModel(R.layout.contacts_contactcell, contact));
    }

    // add title for "No Emails" view holder and cell
    adapterModels.add(new TitleModel(R.layout.contacts_titlecell, getString(R.string.no_emails)));

    // add metadata for all contacts with no meials
    for (Contact contact : noEmails) {
      adapterModels.add(new ContactModel(R.layout.contacts_contactcell, contact));
    }

    // add title for "No Phones" view holder and cell
    adapterModels.add(new TitleModel(R.layout.contacts_titlecell, getString(R.string.no_phones)));

    // add metadata for all contacts with no meials
    for (Contact contact : noPhones) {
      adapterModels.add(new ContactModel(R.layout.contacts_contactcell, contact));
    }

    // return the prepared list of AdapterModel instances
    return adapterModels;
  }
}
