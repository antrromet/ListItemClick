package com.antrromet.listitemclick;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter
{

	private ArrayList<Person>	people;
	private OnClickListener		clickListener;
	private View				convertView;

	public ListAdapter(ArrayList<Person> people, OnClickListener clickListener)
	{
		this.people = people;
		this.clickListener = clickListener;
	}

	@Override
	public int getCount()
	{
		if (people != null)
		{
			return people.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int pos)
	{
		return people.get(pos);
	}

	@Override
	public long getItemId(int pos)
	{
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent)
	{
		ViewHolder holder;
		convertView = view;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
			holder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
			holder.callButton = (Button) convertView.findViewById(R.id.callButton);
			holder.msgButton = (Button) convertView.findViewById(R.id.msgButton);
			convertView.setTag(holder);
		} else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameTextView.setText(people.get(position).getName());

		setClickListeners(holder.callButton);
		setClickListeners(holder.msgButton);

		setTagsToViews(holder.callButton, position);
		setTagsToViews(holder.msgButton, position);

		return convertView;
	}

	/**
	 * Sets the onClickListener on the view
	 * 
	 * @param view
	 */
	private void setClickListeners(View view)
	{
		view.setOnClickListener(clickListener);
	}

	/**
	 * Sets the position tag to the views
	 * 
	 * @param view
	 * @param position
	 */
	private void setTagsToViews(View view, int position)
	{
		view.setTag(R.id.key_position, position);
	}

	static class ViewHolder
	{
		TextView	nameTextView;
		Button		callButton;
		Button		msgButton;
	}

}
