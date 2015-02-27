package com.lisher.fragmenttabjar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		System.out.println("++++onActivityCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		System.out.println("++++onCreateView");
		return inflater.inflate(R.layout.fragment_layout1, null);
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
