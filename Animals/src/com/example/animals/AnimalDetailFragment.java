package com.example.animals;

import junit.framework.Assert;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.animals.dummy.DummyContent;

/**
 * A fragment representing a single Animal detail screen. This fragment is
 * either contained in a {@link AnimalListActivity} in two-pane mode (on
 * tablets) or a {@link AnimalDetailActivity} on handsets.
 */
public class AnimalDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public AnimalDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_animal_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.animal_detail))
					.setText(mItem.content);
			
			if (mItem.picname=="ant") {
				((ImageView) rootView.findViewById(R.id.animal_image)).setImageResource(R.drawable.ant);
			}
			else if (mItem.picname=="hippo") {
				((ImageView) rootView.findViewById(R.id.animal_image)).setImageResource(R.drawable.hippo);
			}
			else if (mItem.picname=="fox") {
				((ImageView) rootView.findViewById(R.id.animal_image)).setImageResource(R.drawable.fox);
			}
			else if (mItem.picname=="shark") {
				((ImageView) rootView.findViewById(R.id.animal_image)).setImageResource(R.drawable.shark);
			}
		}

		return rootView;
	}
}