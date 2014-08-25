package net.uyghurdev.avaroid.rengtunush;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class color extends Activity {
	public int  Width;
	public  int  Height;
	public ImageView imvw1;
	public ImageView imvw2;
	public ImageButton imbt1;
	public ImageButton imbt2;
	public RelativeLayout rlt1;
	public RelativeLayout rlt2;
	//public LinearLayout lytmain;
	public TextView txt1;
	public TextView txt2;
	
	private int n =0;
	private MediaPlayer mMediaPlayer;
	private boolean sound = true;
	private Animation right_out;
	private Animation right_in;
	private Animation left_out;
	private Animation left_in;
	private Animation anim_in;
	private Animation anim_out;
	lazim lzm = new lazim();
	private int xTouch = 0, xClickOffset = 0, xOffset = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//lytmain = (LinearLayout) findViewById(R.id.);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		DisplayMetrics dm = new DisplayMetrics();
	    this.getWindowManager().getDefaultDisplay().getMetrics(dm);
	       
		   Width=dm.widthPixels;   
	       Height =dm.heightPixels;
	       if(Width==320&&Height==480){
	    	   setContentView(R.layout.color320_480);
	    	   
	       }
	       else if(Width==480&&Height==800){
	    	   setContentView(R.layout.color480_800);
	    	   
	       }
	       else if(Width==768&&Height==1024){
	    	   setContentView(R.layout.color768_1024);
	    	   
	       }
		

		imvw1 = (ImageView) findViewById(R.id.imgvw1);
		imvw2 = (ImageView) findViewById(R.id.imgvw2);
		imbt1 = (ImageButton) findViewById(R.id.imgbt1);
		imbt2 = (ImageButton) findViewById(R.id.imgbt2);
		rlt1 = (RelativeLayout) findViewById(R.id.LinearLayout01);
		rlt2 = (RelativeLayout) findViewById(R.id.LinearLayout02);
		txt1 = (TextView) findViewById(R.id.TextView01);
		txt2 = (TextView) findViewById(R.id.TextView02);
		
		right_out = AnimationUtils.loadAnimation(this, R.anim.right_out);
		right_in = AnimationUtils.loadAnimation(this, R.anim.right_in);
		left_out = AnimationUtils.loadAnimation(this, R.anim.left_out);
		left_in = AnimationUtils.loadAnimation(this, R.anim.left_in);
		anim_in= AnimationUtils.loadAnimation(this, R.anim.ich);
		anim_out = AnimationUtils.loadAnimation(this, R.anim.sirt);
		
		player(0);
		//back();
		//Next();
		imbt1.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				Next();

			}
		});

		imbt2.setOnClickListener(new ImageButton.OnClickListener() {
			public void onClick(View v) {
				back();

			}
		});
		rlt2.setOnClickListener(new RelativeLayout.OnClickListener() {
			public void onClick(View v) {
				//anim_in();

			}
		});

		imvw2.setOnTouchListener(new ImageView.OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					xTouch = (int) event.getX();
					xClickOffset = xTouch;
				} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
					xOffset += xTouch - (int) event.getX();
					xTouch = (int) event.getX();
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					if (event.getX() - xClickOffset < 20
							&& event.getX() - xClickOffset > -20) {
						player(n);
					}
					if (event.getX() - xClickOffset > 40)// onggha surulgenni
					{
						Next();

					}
					if (event.getX() - xClickOffset < -40)// solgha surulgenni
					{
						
						back();
						
					}

				}
				return true;
			}

		});
	}

	public void Next() {

		n++;
		if (n > 10) {
			n = 0;
		}

		
		rlt1.startAnimation(right_out);
		imvw1.setBackgroundResource(n == 0 ? lzm.mycolor[10]
				: lzm.mycolor[n - 1]);
		txt1.setText(n == 0 ? lzm.colorname[10] : lzm.colorname[n - 1]);
		
		
	    imvw2.setBackgroundResource(lzm.mycolor[n]);
		rlt2.startAnimation(right_in);
		txt2.setText(lzm.colorname[n]);
		

		player(n);
	}

	public void back() {

		n--;
		if (n < 0) {
			n = 10;
		}

		rlt1.startAnimation(left_out);
		imvw1.setBackgroundResource(n == 10 ? lzm.mycolor[0]
				: lzm.mycolor[n + 1]);
		txt1.setText(n == 10 ? lzm.colorname[0] : lzm.colorname[n + 1]);

		rlt2.startAnimation(left_in);
		imvw2.setBackgroundResource(lzm.mycolor[n]);
		txt2.setText(lzm.colorname[n]);
		player(n);

	}
public void anim_in(){
//	n++;
//	if (n > 10) {
//		n = 0;
//	}
//
//	rlt1.startAnimation(anim_in);
//	imvw1.setBackgroundResource(n == 0 ? lzm.mycolor[10]
//			: lzm.mycolor[n - 1]);
//	txt1.setText(n == 0 ? lzm.colorname[10] : lzm.colorname[n - 1]);
//
//	imvw2.setBackgroundResource(lzm.mycolor[n]);
//	rlt2.startAnimation(anim_out);
//	txt2.setText(lzm.colorname[n]);
//
//	player(n);
	
	
}
public void anim_out(){
	
	
	
}
	public void player(int i) {

		if (sound == true) {
			if (mMediaPlayer != null) {
				
					mMediaPlayer.release();
				
			}
			mMediaPlayer = MediaPlayer.create(color.this, lzm.mymp3[i]);
			mMediaPlayer.start();
		} else if (sound == false) {
			if (mMediaPlayer != null) {

				mMediaPlayer.stop();
			}
		}
	}
	

	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, 1, 1, "ئاۋازنى تاقاش").setIcon(R.drawable.sound);
		menu.add(0, 2, 2, "توغرىسىدا").setIcon(R.drawable.about_icon);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1) {

			if (sound == true) {

				Toast toast = new Toast(this);
				ImageView view = new ImageView(this);
				view.setImageResource(R.drawable.off);
				toast.setView(view);
				toast.show();
				sound = false;
			} else {
				Toast toast = new Toast(this);
				ImageView view = new ImageView(this);
				view.setImageResource(R.drawable.on);
				toast.setView(view);
				toast.show();
				sound = true;
			}

		} else if (item.getItemId() == 2) {
			About(color.this);
		}

		return true;

	}

	private void About(Context context) {
		LayoutInflater inflater = LayoutInflater.from(this);
		final View textEntryView = inflater.inflate(R.layout.aboutdialog, null);

		final TextView about = (TextView) textEntryView
				.findViewById(R.id.txtabout);
		about.setText(" ئۇيغۇر يۇمشاق دىتال ئىجادىيەت تورى");
		final TextView txtlink = (TextView) textEntryView
				.findViewById(R.id.txtlink);
		txtlink.setText("www.uyghurdev.net/avaroid");
		Linkify.addLinks(txtlink, Linkify.ALL);
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false);
		builder.setIcon(R.drawable.avar);
		builder.setTitle("رەڭ تونۇش");
		builder.setMessage("               نەشرى1.1.1 ");
		builder.setView(textEntryView);

		builder.setNegativeButton("تاقاش",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						setTitle("");
					}
				});
		builder.show();
	}
}
