package com.example.program3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txt_Username;
    EditText txt_Password;
    Button button;

    String regularexpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_Username=(EditText) findViewById(R.id.txtloginusername);
        txt_Password=(EditText) findViewById(R.id.txtloginpassword);

        button=(Button) findViewById(R.id.loginbutton);
        button.setOnClickListener(this);
    }

    public void onClick(View v){
        String username=txt_Username.getText().toString();
        String password=txt_Password.getText().toString();
        if(validatePassword(password)){
            Bundle bundle = new Bundle();
            bundle.putString("user", username);
            bundle.putString("pass", password);
            Intent it=new Intent(this, LoginActivity.class);

            it.putExtra("data", bundle);
            startActivity(it);
        }
        else
        {
            Toast.makeText(getBaseContext(),"INVALID PASSWORD",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validatePassword(String password) {
        Pattern pattern=Pattern.compile(regularexpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}