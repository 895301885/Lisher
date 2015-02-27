package com.lisher.fragmenttabjar;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SecondActivity extends Activity {
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		System.out.println("Activity____OnCreate");
		textView = (TextView) findViewById(R.id.second_tv);
		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this,
						ThridActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("Activity____OnStart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnReStart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnReSume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnDestory");
		super.onDestroy();
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		System.out.println("Activity____OnAttachedToWindow");
		super.onAttachedToWindow();
	}

}
