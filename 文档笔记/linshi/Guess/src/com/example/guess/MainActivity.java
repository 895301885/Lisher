package com.example.guess;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
	private GridViewResultAdapter adapter;
	private Button buttonSure;
	private EditText editText;
	private Gallery gallery;
	private int inputNum;
	private List<Integer> listResult;
	private List<List<Integer>> listsCommend;
	private int successCout = 0;
	private TextView textViewC1;
	private TextView textViewC2;
	private TextView textViewC3;
	private TextView textViewC4;
	private TextView textViewScCount;
	EditText editTextPwd;
	Button buttonSurePwd;
	LinearLayout linearLayoutPwd;

	private void getThreeNum(List<Integer> paramList) {
		while (true) {
			if (paramList.size() == 3)
				return;
			int i = getARadomNum();
			if (!paramList.contains(Integer.valueOf(i)))
				paramList.add(Integer.valueOf(i));
		}
	}

	private void initCommendNum() {
		ArrayList localArrayList1 = new ArrayList();
		getThreeNum(localArrayList1);
		this.listsCommend.add(localArrayList1);
		ArrayList localArrayList2 = new ArrayList();
		getThreeNum(localArrayList2);
		this.listsCommend.add(localArrayList2);
		ArrayList localArrayList3 = new ArrayList();
		getThreeNum(localArrayList3);
		this.listsCommend.add(localArrayList3);
		ArrayList localArrayList4 = new ArrayList();
		getThreeNum(localArrayList4);
		this.listsCommend.add(localArrayList4);
		this.textViewC1.setText("第" + (1 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(0)).get(0) + "-"
				+ ((List) this.listsCommend.get(0)).get(1) + "-"
				+ ((List) this.listsCommend.get(0)).get(2) + ")");
		this.textViewC2.setText("第" + (2 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(1)).get(0) + "-"
				+ ((List) this.listsCommend.get(1)).get(1) + "-"
				+ ((List) this.listsCommend.get(1)).get(2) + ")");
		this.textViewC3.setText("第" + (3 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(2)).get(0) + "-"
				+ ((List) this.listsCommend.get(2)).get(1) + "-"
				+ ((List) this.listsCommend.get(2)).get(2) + ")");
		this.textViewC4.setText("第" + (4 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(3)).get(0) + "-"
				+ ((List) this.listsCommend.get(3)).get(1) + "-"
				+ ((List) this.listsCommend.get(3)).get(2) + ")");
	}

	public int getARadomNum() {
		return 1 + (int) (4.0D * Math.random());
	}

	@Override
	public void onClick(View paramView) {
		if (this.editText.getText().toString().equals("")) {
			Toast.makeText(this, "输入数字只能为0~4", 1000).show();
			return;
		}
		this.inputNum = Integer.parseInt(this.editText.getText().toString());
		this.editText.setText("");
		if ((this.inputNum < 0) || (this.inputNum > 4)) {
			Toast.makeText(this, "输入数字只能为0~4", 1000).show();
			return;
		}
		this.listResult.add(Integer.valueOf(this.inputNum));
		this.adapter.notifyDataSetChanged();
		if (this.listResult.size() > 1)
			this.gallery.setSelection(-2 + this.listResult.size());
		if (this.inputNum == 0
				|| ((List) this.listsCommend.get(0)).contains(Integer
						.valueOf(this.inputNum)))
			this.successCout = (1 + this.successCout);
		this.listsCommend.remove(0);
		ArrayList localArrayList = new ArrayList();
		getThreeNum(localArrayList);
		this.listsCommend.add(localArrayList);
		this.textViewC1.setText("第" + (1 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(0)).get(0) + "-"
				+ ((List) this.listsCommend.get(0)).get(1) + "-"
				+ ((List) this.listsCommend.get(0)).get(2) + ")");
		this.textViewC2.setText("第" + (2 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(1)).get(0) + "-"
				+ ((List) this.listsCommend.get(1)).get(1) + "-"
				+ ((List) this.listsCommend.get(1)).get(2) + ")");
		this.textViewC3.setText("第" + (3 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(2)).get(0) + "-"
				+ ((List) this.listsCommend.get(2)).get(1) + "-"
				+ ((List) this.listsCommend.get(2)).get(2) + ")");
		this.textViewC4.setText("第" + (4 + this.listResult.size()) + "期("
				+ ((List) this.listsCommend.get(3)).get(0) + "-"
				+ ((List) this.listsCommend.get(3)).get(1) + "-"
				+ ((List) this.listsCommend.get(3)).get(2) + ")");
		this.textViewScCount.setText("猜对" + this.successCout + "次");
	}

	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_main);
		this.gallery = ((Gallery) findViewById(R.id.guess_gv1));
		this.editText = ((EditText) findViewById(R.id.ed_input));
		this.buttonSure = ((Button) findViewById(R.id.but_sure));
		this.textViewC1 = ((TextView) findViewById(R.id.c1));
		this.textViewC2 = ((TextView) findViewById(R.id.c2));
		this.textViewC3 = ((TextView) findViewById(R.id.c3));
		this.textViewC4 = ((TextView) findViewById(R.id.c4));
		this.textViewScCount = ((TextView) findViewById(R.id.count));
		editTextPwd = (EditText) findViewById(R.id.ed_pwd);
		buttonSurePwd = (Button) findViewById(R.id.pwd_srue);
		linearLayoutPwd = (LinearLayout) findViewById(R.id.lin_pwd);
		this.listResult = new ArrayList();
		this.listsCommend = new ArrayList();
		this.adapter = new GridViewResultAdapter(this, this.listResult);
		this.buttonSure.setOnClickListener(this);
		this.gallery.setAdapter(this.adapter);
		buttonSurePwd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (editTextPwd.getText().toString().equals("666888")) {
					linearLayoutPwd.setVisibility(View.GONE);
				} else {
					Toast.makeText(MainActivity.this, "密码错误，请重新输入", 2000)
							.show();
					editTextPwd.setText("");
				}
			}
		});
		initCommendNum();
	}
}
