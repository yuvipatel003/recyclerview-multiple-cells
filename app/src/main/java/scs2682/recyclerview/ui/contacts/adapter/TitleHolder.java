package scs2682.recyclerview.ui.contacts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Title view holder. Uses R.layout.contacts_titlecell
 */
public class TitleHolder extends RecyclerView.ViewHolder {
  public final TextView text;

  public TitleHolder(@NonNull View view) {
    super(view);

    text = (TextView) view;
  }

  public void bind(@NonNull String title) {
    text.setText(title);
  }
}