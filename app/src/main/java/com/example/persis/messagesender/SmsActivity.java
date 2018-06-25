package com.example.persis.messagesender;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {

    EditText etSmsNumber;
    TextView tvSmsMsg;
    Button  btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etSmsNumber = (EditText)findViewById(R.id.etSmsNumber);
        tvSmsMsg = (TextView) findViewById(R.id.tvSmsMsg);
        btnSendSms = (Button) findViewById(R.id.btnSendSms);

        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tvSmsMsg.setText(msg);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = etSmsNumber.getText().toString();

                      if(num.length()==0)
                      {
                          etSmsNumber.setError("Number is empty");
                          etSmsNumber.requestFocus();
                          return;

                      }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:" + num));
                i.putExtra("sms_body", msg);
                startActivity(i);
            }
        });


    }
}
