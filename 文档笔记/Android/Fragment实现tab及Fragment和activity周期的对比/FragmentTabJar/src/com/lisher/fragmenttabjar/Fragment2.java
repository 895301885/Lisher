package com.lisher.fragmenttabjar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;

public class Fragment2 extends Fragment {

	private View contentView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		contentView = inflater.inflate(R.layout.fragment_layout2, null);
		System.out.println("++++onCreateView");
		return contentView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initEvent();
		System.out.println("++++onActivityCreate");
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		Button button = (Button) contentView
				.findViewById(R.id.fragment2_bt_nexttoactivity);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SecondActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		System.out.println("++++onAttach");
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("++++onCreate ");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		System.out.println("++++onDestroy ");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		System.out.println("++++onDestroyView ");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		System.out.println("++++onDetach ");
		super.onDetach();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		System.out.println("++++onPause ");
		super.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		System.out.println("++++onResume");
		super.onResume();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.out.println("++++onStart");
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		System.out.println("++++onStop");
		super.onStop();
	}

}
