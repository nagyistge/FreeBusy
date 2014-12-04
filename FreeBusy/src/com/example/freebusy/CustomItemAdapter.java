package com.example.freebusy;

import java.util.List;
import Model.User;
import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomItemAdapter extends ArrayAdapter<User> {

	List<User> users;
	
	public CustomItemAdapter(Context context, int resource, List<User> professors) {
		super(context, resource, professors);
		users = professors;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null)
		{
			LayoutInflater infl = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
			convertView = infl.inflate(R.layout.professors_list, parent, false);
		}
		
		ImageView professor_image = (ImageView) convertView.findViewById((R.id.professor_image));
		ImageView consult_button = (ImageView) convertView.findViewById((R.id.consult_button));
		ImageView schedule_button = (ImageView) convertView.findViewById((R.id.schedule_button));
		ImageView toggle = (ImageView) convertView.findViewById((R.id.toggle_image));
		TextView professor_name = (TextView) convertView.findViewById((R.id.professor_name));
		TextView college_text = (TextView) convertView.findViewById((R.id.college_text));
		
		User temp = users.get(position);
		
//		professor_image.setImageResource(temp.get());
		professor_name.setText(temp.getName());
		college_text.setText(temp.getCollege());
		if(temp.getToggleStatus()==1)
			toggle.setImageResource(R.drawable.green_toggle);
		else
		{
			toggle.setImageResource(R.drawable.red_toggle);
			consult_button.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}
	

}
