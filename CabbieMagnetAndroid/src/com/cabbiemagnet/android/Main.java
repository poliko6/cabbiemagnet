package com.cabbiemagnet.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
		Button companyButton = (Button) findViewById(R.id.company_button);
		
		companyButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				 Intent intent = new Intent(Main.this, CompaniesActivity.class);
					Bundle b = new Bundle();
					b.putString("location", "Horsens");
					intent.putExtras(b);
					Main.this.startActivity(intent);
			}
		});
		
       
        
    }
    
    
    
}