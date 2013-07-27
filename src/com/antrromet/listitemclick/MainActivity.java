package com.antrromet.listitemclick;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private ListView mListView;
	private ListAdapter mAdapter;
	private ArrayList<Person> mPeople;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.listView);
		prepareDummyPeople();
		mAdapter = new ListAdapter(mPeople, this);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
	}

	/**
	 * Prepares the list with dummy set of data
	 */
	private void prepareDummyPeople() {
		mPeople = new ArrayList<Person>();
		Person person;

		person = new Person("Adam", "123");
		mPeople.add(person);

		person = new Person("Bobby", "234");
		mPeople.add(person);

		person = new Person("Cary", "345");
		mPeople.add(person);

		person = new Person("Dan", "456");
		mPeople.add(person);

		person = new Person("Elian", "567");
		mPeople.add(person);

		person = new Person("Frank", "678");
		mPeople.add(person);

		person = new Person("Ghost", "789");
		mPeople.add(person);

		person = new Person("Harry", "890");
		mPeople.add(person);

		person = new Person("Ivy", "901");
		mPeople.add(person);

		person = new Person("Joe", "101");
		mPeople.add(person);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag(R.id.key_position);
		if (v.getId() == R.id.callButton) {
			call(mPeople.get(position).getNumber());
		} else if (v.getId() == R.id.msgButton) {
			message(mPeople.get(position).getNumber());
		}
	}

	/**
	 * Calls the given number
	 * 
	 * @param number
	 */
	private void call(String number) {
		Intent callIntent = new Intent(Intent.ACTION_DIAL);
		callIntent.setData(Uri.parse("tel:" + number));
		startActivity(callIntent);
	}

	/**
	 * Messages the given number
	 * 
	 * @param number
	 */
	private void message(String number) {
		Intent msgIntent = new Intent(Intent.ACTION_VIEW);
		msgIntent.setData(Uri.parse("sms:" + number));
		startActivity(msgIntent);
	}

	/*
	 * The list item click will work only when the buttons are set to not taking
	 * focus by setting focusable as false
	 */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(this, mPeople.get(arg2).getName() + " Clicked",
				Toast.LENGTH_SHORT).show();
	}

}
