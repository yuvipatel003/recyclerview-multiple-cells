package scs2682.recyclerview.ui.contacts.adapter;

import android.support.annotation.NonNull;

/**
 * Metadata details for Adapter to know what to load and supply when a ContactHolder
 * is suppose to be created or updated.
 */
public class TitleModel extends AdapterModel {
  @NonNull public final String title;

  public TitleModel(int layoutId, @NonNull String title) {
    super(layoutId);
    this.title = title;
  }
}
