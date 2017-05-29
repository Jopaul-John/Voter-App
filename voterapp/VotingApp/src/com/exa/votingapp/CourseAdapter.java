package com.exa.votingapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bean.Candidate;

public class CourseAdapter extends ArrayAdapter<String> {

	// private List<Candidate> dataSet;
	Context mContext;
	String[] dataSet;
	String[] cid,cname,pname;

	// View lookup cache

	public CourseAdapter(String[] data, Context context) {
		super(context, R.layout.listitem, data);
		this.dataSet = data;
		this.mContext = context;
		Log.d(".............",data[1]);
		cid=data[0].split("---");
		cname=data[1].split("---");
		pname=data[2].split("---");
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return super.getItem(position);
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return dataSet.length;
	}

	@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View rowView=inflater.inflate(R.layout.listitem, null,true);
		Log.d("candidate_id.....",cid.length+"");

	((TextView)	rowView.findViewById(R.id.txtcid)).setText(cid[position].trim());
	((TextView)	rowView.findViewById(R.id.txtcname)).setText(cname[position].trim());
	((TextView)	rowView.findViewById(R.id.txtpname)).setText(pname[position].trim());
String party=pname[position].trim();
ImageView img=(ImageView)rowView.findViewById(R.id.logo);
if("UDF".equals(party)){
	img.setImageResource(R.drawable.udf);
}else if("LDF".equals(party)){
	img.setImageResource(R.drawable.ldf);
}else if("BJP".equals(party)){
	img.setImageResource(R.drawable.bjp);
}
	 
	return rowView;
}

	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// // Get the data item for this position
	// Candidate model = getItem(position);
	// // Check if an existing view is being reused, otherwise inflate the view
	// ViewHolder viewHolder; // view lookup cache stored in tag
	//
	// final View result;
	//
	// if (convertView == null) {
	//
	// viewHolder = new ViewHolder();
	// LayoutInflater inflater = LayoutInflater.from(getContext());
	// convertView = inflater.inflate(R.layout.listitem, parent, false);
	// viewHolder.txtcid = (TextView) convertView.findViewById(R.id.txtcid);
	// viewHolder.txtcname = (TextView) convertView.findViewById(R.id.txtcname);
	// viewHolder.txtpname = (TextView) convertView.findViewById(R.id.txtpname);
	//
	// // viewHolder.txtVersion = (TextView)
	// convertView.findViewById(R.id.version_number);
	// // viewHolder.info = (ImageView)
	// convertView.findViewById(R.id.item_info);
	//
	// convertView.setTag(viewHolder);
	// } else {
	// viewHolder = (ViewHolder) convertView.getTag();
	// result=convertView;
	// }
	//
	// // Animation animation = AnimationUtils.loadAnimation(mContext, (position
	// > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
	// // result.startAnimation(animation);
	// lastPosition = position;
	//
	// viewHolder.txtcid.setText("Candidate id : "+model.getCandidate_id());
	// viewHolder.txtcname.setText("Candidate Name : "+model.getCandidate_name());
	// viewHolder.txtpname.setText("Party Name : "+model.getParty_name());
	//
	// // viewHolder.txtVersion.setText(dataModel.getVersion_number());
	// // viewHolder.info.setOnClickListener(this);
	// // viewHolder.info.setTag(position);
	// // Return the completed view to render on screen
	// return convertView;
	// }
}
