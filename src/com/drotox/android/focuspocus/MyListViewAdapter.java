package com.drotox.android.focuspocus;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * ListView adapter used to display SearchResults and present
 * QuickAction menu
 * 
 * @author Damian Flannery
 *
 */
public class MyListViewAdapter extends BaseAdapter {

	private static final String TAG = "LazyAdapter";
	private Context mContext;
	private ArrayList<Food> mData = new ArrayList<Food>();
	private static LayoutInflater mInflater;
	
	/**
	 * Constructor
	 * @param activity context
	 * @param cookie obtained from login
	 */
	public MyListViewAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	/**
	 * Set data for adapter
	 * @param foodItems ArrayList of Foods items
	 */
	public void setItems(ArrayList<Food> foodItems) {
		mData = foodItems;
	}

	/**
	 * Add data to adapter
	 * @param foodItems ArrayList of Foods items
	 */
	public void addItems(ArrayList<Food> foodItems) {
		mData.addAll(foodItems);
	}

	/**
	 * return size of data in adapter
	 */
	public int getCount() {
		return mData.size();
	}

	/**
	 * Get Food item at position in adapter
	 */
	public Food getItem(int position) {
		return mData.get(position);
	}

	/**
	 * Get item id of Food at position
	 */
	public long getItemId(int position) {
		return position;
	}

	/**
	 * Class to store child views that will be recycled in listview
	 */
	public static class ViewHolder {
		public ImageView image;
		public TextView title;
		public TextView serving;
		public TextView cals;
		public TextView fat;
		public TextView carbs;
		public TextView protein;
		public ImageView more;
		public RelativeLayout rail;
	}

	/**
	 * Construct view that is displayed for given row as called
	 * by ListAdapter
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
	
		View vi = convertView;
		ViewHolder holder;

		// if convertview is null create and inflate from xml. Otherwise reuse.
		if (convertView == null) {
			vi = mInflater.inflate(R.layout.row_search_result, null);
			holder = new ViewHolder();
			holder.title = (TextView) vi.findViewById(R.id.search_result_title);
			holder.serving = (TextView) vi.findViewById(R.id.search_result_serving);
			holder.cals = (TextView) vi.findViewById(R.id.search_result_cals_tv);
			holder.fat = (TextView) vi.findViewById(R.id.search_result_fat_tv);
			holder.carbs = (TextView) vi.findViewById(R.id.search_result_carbs_tv);
			holder.protein = (TextView) vi.findViewById(R.id.search_result_protein_tv);
			holder.more = (ImageView) vi.findViewById(R.id.context_rail_affordance);
			holder.rail = (RelativeLayout) vi.findViewById(R.id.show_context_rail);
			
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		// get data from corresponding Offer object and populate ViewHolder
		Food food = mData.get(position);
		holder.title.setText(food.getName());
		holder.serving.setText("servings: " + food.getServings());
		holder.cals.setText("cals " + food.getCals());
		holder.fat.setText("fat 0g");
		holder.carbs.setText("carbs 0g");
		holder.protein.setText("protein 0g");
		
	
		//The important bit!!!
		holder.more.setOnClickListener(new OnItemClickListener(position));
		holder.rail.setOnClickListener(new OnItemClickListener(position));
		return vi;
	}
		
	/**
	 * Listener that listens for touches on *more* icon and 
	 * on row itself. 
	 * 
	 * @author Damian Flannery
	 *
	 */
	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;
		}
		
		@Override
		public void onClick(View view) {
			Log.v(TAG, "onItemClick for view " + view.getId() + "at position" + mPosition);
			final Food food = getItem(mPosition);

			switch(view.getId()) {
				//row clicked so show product detail
				case R.id.show_context_rail:
					Toast.makeText(mContext, "row clicked on " + food.getName() + " at psoition " + mPosition, Toast.LENGTH_SHORT).show();
					
					break;
				
				//more icon clicked so show quick action menu or whatever
				case R.id.context_rail_affordance:
					Toast.makeText(mContext, "more icon clicked on "  + food.getName() + " at position " + mPosition, Toast.LENGTH_SHORT).show();
					
					break;
			}	
		}
		
	}
}