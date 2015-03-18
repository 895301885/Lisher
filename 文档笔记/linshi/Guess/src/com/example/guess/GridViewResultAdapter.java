package com.example.guess;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class GridViewResultAdapter extends BaseAdapter {
	private List<Integer> contentString;
	private Activity context;
	private LayoutInflater layoutInflater;

	public GridViewResultAdapter(Activity paramActivity, List<Integer> paramList) {
		System.out.println("ssss" + paramList.size());
		this.context = paramActivity;
		this.layoutInflater = LayoutInflater.from(paramActivity);
		this.contentString = paramList;
	}

	public class ViewHodler {
		public TextView textViewDesc;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.contentString.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.contentString.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		System.out.println("第" + (position + 1) + "期("
				+ this.contentString.get(position) + ")");
		ViewHodler localViewHodler;
			convertView = this.layoutInflater.inflate(
					R.layout.gridadapter_layout, null);
			localViewHodler = new ViewHodler();
			localViewHodler.textViewDesc = ((TextView) convertView
					.findViewById(R.id.content_textString));
			localViewHodler.textViewDesc.setText("第" + (position + 1) + "期("
					+ this.contentString.get(position) + ")");
		return convertView;
	}

}