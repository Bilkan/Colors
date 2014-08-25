package net.uyghurdev.avaroid.rengtunush;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
public class main extends Activity {
	/** Called when the activity is first created. */
	 
	 public Handler hand=new Handler();
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
       setContentView(R.layout.main);
       

       hand.postDelayed( new Runnable() {
	        public void run() {
	        	
	        		Intent color = new Intent();
					color.setClass(main.this,color.class);
					main.this.startActivity(color);
	        	
	        	
	        }
	        },3000);
   }
}