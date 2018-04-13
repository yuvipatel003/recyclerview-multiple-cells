package scs2682.recyclerview.ui.contacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import scs2682.recyclerview.R;
import scs2682.recyclerview.ui.contacts.adapter.AdapterModel;
import scs2682.recyclerview.ui.contacts.adapter.ContactHolder;
import scs2682.recyclerview.ui.contacts.adapter.ContactModel;
import scs2682.recyclerview.ui.contacts.adapter.TitleHolder;
import scs2682.recyclerview.ui.contacts.adapter.TitleModel;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	@NonNull private final List<AdapterModel> models;
	@NonNull private final ContactHolderCallbacks contactHolderCallbacks;

	public Adapter(@NonNull List<AdapterModel> models, @NonNull ContactHolderCallbacks contactHolderCallbacks) {
		this.models = models;
		this.contactHolderCallbacks = contactHolderCallbacks;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// inflate the layout into a view instance
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view;

		switch (viewType) {
			case R.layout.contacts_titlecell:
				// expecting title cell
				view = layoutInflater.inflate(viewType, parent, false);
				return new TitleHolder(view);
			case R.layout.contacts_contactcell:
				// expecting contact cell
				view = layoutInflater.inflate(viewType, parent, false);
				return new ContactHolder(view, contactHolderCallbacks);
		}


		View appActivityCell = layoutInflater.inflate(R.layout.contacts_contactcell, parent, false);

		// return the view holder with the newly created view
		return new ContactHolder(appActivityCell, contactHolderCallbacks);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		AdapterModel model = models.get(position);

		if (holder instanceof TitleHolder && model instanceof TitleModel) {
			// holder and model are for title cell
			((TitleHolder) holder).bind(((TitleModel) model).title);
		}
		else if (holder instanceof ContactHolder && model instanceof ContactModel) {
			// holder and model are for contact cell
			((ContactHolder) holder).bind(((ContactModel) model).contact);
		}
	}

	@Override
	public int getItemCount() {
		return models.size();
	}

	@Override
	public int getItemViewType(int position) {
		// using layoutId as unique id
		return models.get(position).layoutId;
	}
}
