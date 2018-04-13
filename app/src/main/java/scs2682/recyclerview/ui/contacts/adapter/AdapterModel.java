package scs2682.recyclerview.ui.contacts.adapter;

/**
 * Keeps all needed details for a single item to be used in the adapter.
 * This is more metadata for the adapter, i.e. has layout id for the cell.
 */
public abstract class AdapterModel {
  public final int layoutId;

  public AdapterModel(int layoutId) {
    this.layoutId = layoutId;
  }
}