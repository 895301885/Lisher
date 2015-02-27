package com.lisher.fragmenttabjar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;

public class MainActivity extends FragmentActivity implements OnClickListener {
	// private Fragment
	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private Fragment4 fragment4;
	private RadioButton radioButton1;
	private RadioButton radioButton2;
	private RadioButton radioButton3;
	private RadioButton radioButton4;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		radioButton1 = (RadioButton) findViewById(R.id.bottom_rb_1);
		radioButton2 = (RadioButton) findViewById(R.id.bottom_rb_2);
		radioButton3 = (RadioButton) findViewById(R.id.bottom_rb_3);
		radioButton4 = (RadioButton) findViewById(R.id.bottom_rb_4);
		radioButton1.setChecked(true);
		radioButton1.setOnClickListener(this);
		radioButton2.setOnClickListener(this);
		radioButton3.setOnClickListener(this);
		radioButton4.setOnClickListener(this);

		radioButton1.performClick();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();// 此事务使用完一次（commit）后就只能重新新建一个管理Fragment
																	// ，我是这样理解的哈哈。

		hidAllFragment(fragmentTransaction);
		switch (v.getId()) {
		case R.id.bottom_rb_1:
			if (fragment1 == null) {
				fragment1 = new Fragment1();
				fragmentTransaction.add(R.id.fragment_group, fragment1);
			} else
				fragmentTransaction.show(fragment1);
			break;
		case R.id.bottom_rb_2:
			if (fragment2 == null) {
				fragment2 = new Fragment2();
				fragmentTransaction.add(R.id.fragment_group, fragment2);
			} else
				fragmentTransaction.show(fragment2);
			break;
		case R.id.bottom_rb_3:
			if (fragment3 == null) {
				fragment3 = new Fragment3();
				fragmentTransaction.add(R.id.fragment_group, fragment3);
			} else
				fragmentTransaction.show(fragment3);
			break;
		case R.id.bottom_rb_4:
			if (fragment4 == null) {
				fragment4 = new Fragment4();
				fragmentTransaction.add(R.id.fragment_group, fragment4);
			} else
				fragmentTransaction.show(fragment4);
			break;
		default:
			break;
		}
		fragmentTransaction.commit();

	}

	private void hidAllFragment(FragmentTransaction fragmentTransaction) {
		if (fragment1 != null)
			fragmentTransaction.hide(fragment1);
		if (fragment2 != null)
			fragmentTransaction.hide(fragment2);
		if (fragment3 != null)
			fragmentTransaction.hide(fragment3);
		if (fragment4 != null)
			fragmentTransaction.hide(fragment4);
	}
}
