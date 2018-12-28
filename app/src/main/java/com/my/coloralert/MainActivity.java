package com.my.coloralert;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.app.Activity;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double randomcolor = 0;
	private double randomstring = 0;
	private double randombutton = 0;
	private double counter = 0;
	private double timer = 0;
	private boolean continuetimer = false;
	private boolean timerboolean = false;
	
	private ArrayList<String> colors = new ArrayList<>();
	private ArrayList<String> spinnerdata = new ArrayList<>();
	
	private TextView textview1;
	private LinearLayout linear1;
	private Button button1;
	private Button button2;
	
	private Intent i = new Intent();
	private TimerTask time;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		textview1 = (TextView) findViewById(R.id.textview1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				continuetimer = true;
				if (randombutton == 0) {
					counter++;
					if (timer > 1200) {
						timer = timer - 50;
					}
					time.cancel();
					_render();
				}
				else {
					continuetimer = false;
					time.cancel();
					SketchwareUtil.showMessage(getApplicationContext(), "finish");
					i.putExtra("key1", String.valueOf((long)(counter)));
					i.putExtra("counterkey1", String.valueOf((long)(randombutton)));
					i.setClass(getApplicationContext(), ScoreActivity.class);
					startActivity(i);
					finish();
				}
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (continuetimer) {
									button1.setEnabled(false);
									button2.setEnabled(false);
									i.putExtra("timerkey1", "0");
									i.putExtra("key3", String.valueOf((long)(counter)));
									i.setClass(getApplicationContext(), ScoreActivity.class);
									startActivity(i);
									finish();
								}
							}
						});
					}
				};
				_timer.schedule(time, (int)(timer));
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				continuetimer = true;
				if (randombutton == 1) {
					counter++;
					if (timer > 1200) {
						timer = timer - 50;
					}
					time.cancel();
					_render();
				}
				else {
					continuetimer = false;
					time.cancel();
					SketchwareUtil.showMessage(getApplicationContext(), "finish");
					i.putExtra("key2", String.valueOf((long)(counter)));
					i.putExtra("counterkey2", String.valueOf((long)(randombutton)));
					i.setClass(getApplicationContext(), ScoreActivity.class);
					startActivity(i);
					finish();
				}
				time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (continuetimer) {
									button1.setEnabled(false);
									button2.setEnabled(false);
									i.putExtra("key4", String.valueOf((long)(counter)));
									i.putExtra("timerkey2", "1");
									i.setClass(getApplicationContext(), ScoreActivity.class);
									startActivity(i);
									finish();
								}
							}
						});
					}
				};
				_timer.schedule(time, (int)(timer));
			}
		});
	}
	private void initializeLogic() {
		_start();
		_render();
		timer = 2000;
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						finish();
					}
				});
			}
		};
		_timer.schedule(time, (int)(5000));
	}
	
	private void _start () {
		colors.add("green");
		colors.add("blue");
		colors.add("yellow");
		colors.add("red");
		colors.add("purple");
		spinnerdata.add("level 1");
		spinnerdata.add("level 2");
	}
	
	
	private void _render () {
		randomcolor = SketchwareUtil.getRandom((int)(0), (int)(4));
		randomstring = SketchwareUtil.getRandom((int)(0), (int)(4));
		randombutton = SketchwareUtil.getRandom((int)(0), (int)(1));
		timerboolean = true;
		if (randomcolor == randomstring) {
			_render();
		}
		else {
			if (randombutton == 0) {
				if (randomstring == 0) {
					textview1.setText("GREEN");
					button2.setText("GREEN");
				}
				if (randomstring == 1) {
					textview1.setText("BLUE");
					button2.setText("BLUE");
				}
				if (randomstring == 2) {
					textview1.setText("YELLOW");
					button2.setText("YELLOW");
				}
				if (randomstring == 3) {
					textview1.setText("RED");
					button2.setText("RED");
				}
				if (randomstring == 4) {
					textview1.setText("PURPLE");
					button2.setText("PURPLE");
				}
				if (randomcolor == 0) {
					textview1.setTextColor(0xFF4CAF50);
					button1.setText("GREEN");
				}
				if (randomcolor == 1) {
					textview1.setTextColor(0xFF2196F3);
					button1.setText("BLUE");
				}
				if (randomcolor == 2) {
					textview1.setTextColor(0xFFFFEB3B);
					button1.setText("YELLOW");
				}
				if (randomcolor == 3) {
					textview1.setTextColor(0xFFF44336);
					button1.setText("RED");
				}
				if (randomcolor == 4) {
					textview1.setTextColor(0xFF9C27B0);
					button1.setText("PURPLE");
				}
			}
			else {
				if (randomstring == 0) {
					button1.setText("GREEN");
					textview1.setText("GREEN");
				}
				if (randomstring == 1) {
					textview1.setText("BLUE");
					button1.setText("BLUE");
				}
				if (randomstring == 2) {
					textview1.setText("YELLOW");
					button1.setText("YELLOW");
				}
				if (randomstring == 3) {
					textview1.setText("RED");
					button1.setText("RED");
				}
				if (randomstring == 4) {
					textview1.setText("PURPLE");
					button1.setText("PURPLE");
				}
				if (randomcolor == 0) {
					textview1.setTextColor(0xFF4CAF50);
					button2.setText("GREEN");
				}
				if (randomcolor == 1) {
					textview1.setTextColor(0xFF2196F3);
					button2.setText("BLUE");
				}
				if (randomcolor == 2) {
					textview1.setTextColor(0xFFFFEB3B);
					button2.setText("YELLOW");
				}
				if (randomcolor == 3) {
					textview1.setTextColor(0xFFF44336);
					button2.setText("RED");
				}
				if (randomcolor == 4) {
					textview1.setTextColor(0xFF9C27B0);
					button2.setText("PURPLE");
				}
			}
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
