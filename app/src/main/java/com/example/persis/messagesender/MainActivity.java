package com.example.persis.messagesender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMsg;
    Button btnSms,btnWhatsapp,btnEmail,btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMsg = (EditText)findViewById(R.id.etMsg);
        btnSms = (Button)findViewById(R.id.btnSms);
        btnWhatsapp = (Button)findViewById(R.id.btnWhatsapp);
        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnSend = (Button)findViewById(R.id.btnSend);


        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();

                if(msg.length()==0)
                {
                    etMsg.setError("Message is empty");
                    etMsg.requestFocus();
                    return;
                }

                Intent i = new Intent(MainActivity.this, SmsActivity.class);
                i.putExtra("msg",msg);
                startActivity(i);



            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                if(msg.length()==0)
                {
                    etMsg.setError("Message is empty");
                    etMsg.requestFocus();
                    return;
                }

                Intent i = new Intent(MainActivity.this,EmailActivity.class);
                i.putExtra("msg",msg);
                startActivity(i);


            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                if(msg.length()==0)
                {
                    etMsg.setError("Message is empty");
                    etMsg.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT,etMsg.getText().toString());
                try
                {
                    startActivity(i);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Whatsappp not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = etMsg.getText().toString();
                if(msg.length()==0)
                {
                    etMsg.setError("Message is empty");
                    etMsg.requestFocus();
                    return;
                }


                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("Text/plain");
                i.putExtra(Intent.EXTRA_TEXT,etMsg.getText().toString());
                startActivity(i);
            }
        });
    }
}
