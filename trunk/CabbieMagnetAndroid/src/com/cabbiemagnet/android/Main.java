package com.cabbiemagnet.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
		Button companyButton = (Button) findViewById(R.id.company_button);
		final EditText locTextField = (EditText) findViewById(R.id.location_textfield);
		
		companyButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				 Intent intent = new Intent(Main.this, CompaniesActivity.class);
					Bundle b = new Bundle();
					String location = locTextField.getText().toString();
					b.putString("location", location + "");
					intent.putExtras(b);
					Main.this.startActivity(intent);
			}
		});
		
       
        
    }
    
    
    
}