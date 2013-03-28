package org.witness.iwitness.app.screens;

import org.witness.iwitness.R;
import org.witness.iwitness.utils.Constants.App;
import org.witness.iwitness.utils.Constants.Codes;
import org.witness.iwitness.utils.Constants.EditorActivityListener;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class FullScreenViewFragment extends Fragment implements OnClickListener {
	View rootView;
	Activity a;
	
	ImageButton toggleControls;
	LinearLayout controlsHolder;
	boolean controlsAreShowing = false;
	
	@SuppressWarnings("unused")
	private final static String LOG = App.Editor.LOG;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater li, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(li, container, savedInstanceState);
		
		rootView = li.inflate(R.layout.fragment_editor_fullscreen_view, null);
		toggleControls = (ImageButton) rootView.findViewById(R.id.toggle_controls);
				
		return rootView;
	}
	
	@Override
	public void onAttach(Activity a) {
		super.onAttach(a);
		this.a = a;
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		((EditorActivityListener) a).lockOrientation(getArguments().getInt(Codes.Extras.SET_ORIENTATION));
		if(getArguments().getInt(Codes.Extras.SET_ORIENTATION) == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			controlsHolder = (LinearLayout) rootView.findViewById(R.id.controls_holder_landscape);
		} else {
			controlsHolder = (LinearLayout) rootView.findViewById(R.id.controls_holder_portrait);
		}
		
		initLayout();
		
	}
	
	private void initLayout() {
		toggleControls.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == toggleControls) {
			if(controlsAreShowing) {
				controlsHolder.setVisibility(View.GONE);
				controlsAreShowing = false;
			} else {
				controlsHolder.setVisibility(View.VISIBLE);
				controlsAreShowing = true;
			}
		}
		
	}

}