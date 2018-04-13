package scs2682.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import scs2682.recyclerview.ui.contacts.Contacts;

public class AppActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.appactivity);

    // add Contacts fragment
    Contacts.create(getSupportFragmentManager(), R.id.appActivity);
  }
}