package com.example.directdm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    EditText etMobileNumber,etMessage;
    String strMessage, strMobileNumber="";
    CountryCodePicker countryCodePicker;
    Button btnSendMessage;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor("#000000"));
        }


        //Edittexts
        etMobileNumber=findViewById(R.id.etMobileNumber);
        etMessage=findViewById(R.id.etMessage);

        //Button for sending message
        btnSendMessage=findViewById(R.id.btnSendMessage);

        //country code picker
        countryCodePicker=findViewById(R.id.countryCPicker);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if any of the mobile number and message is empty
                if(etMessage.getText().toString().isEmpty() || etMobileNumber.getText().toString().isEmpty() ){
                    Toast.makeText(MainActivity.this, "Enter Mobile number and Message", Toast.LENGTH_SHORT).show();
                }

                //if it is not empty
                else{
                    //merge mobile number with country code
                    countryCodePicker.registerCarrierNumberEditText(etMobileNumber);
                    strMobileNumber=countryCodePicker.getFullNumber();

                    strMessage=etMessage.getText().toString();

                    //checking if whatsapp is installed on my device or not
                    boolean installed=appInstalledOrNot("com.whatsapp");
                    if (installed){
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+strMobileNumber+
                                "&text="+strMessage));
                        startActivity(intent);

                        //after message is sent, empty the edit text
                        etMobileNumber.setText("");
                        etMessage.setText("");
                    }

                    //if app is not installed
                    else{
                        Toast.makeText(MainActivity.this, "First install Whatsapp on your device", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //function to check whatsapp is installed ot not
    private boolean appInstalledOrNot(String str) {
        PackageManager packageManager=getPackageManager();
        boolean appInstalled;
        try {
            packageManager.getPackageInfo(str,PackageManager.GET_ACTIVITIES);
            appInstalled=true;
        }catch (PackageManager.NameNotFoundException e){
            appInstalled=false;
        }
        return appInstalled;
    }
}