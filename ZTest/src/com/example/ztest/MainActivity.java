package com.example.ztest;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final int CAPTURE_RESULT = 1245;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((Button)findViewById(R.id.button_scan)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
				intent.setAction(Intents.Scan.ACTION);
				startActivityForResult(intent, CAPTURE_RESULT);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
	  if (RESULT_OK==resultCode) {
	    TextView b = (TextView)findViewById(R.id.barcode);
	    String s = data.getExtras().getString(Intents.Scan.RESULT);
	    b.setText(null==s ? "<ERROR>" : s);
	  }
	  super.onActivityResult(requestCode, resultCode, data);
  }

}
