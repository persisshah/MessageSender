package com.example.persis.messagesender;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {

    TextView tvEmailMsg;
    EditText etSubject,etEmailId;
    Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        tvEmailMsg = (TextView)findViewById(R.id.tvEmailMsg);
        etEmailId = (EditText)findViewById(R.id.etEmailId);
        etSubject = (EditText)findViewById(R.id.etSubject);
        btnSendEmail = (Button)findViewById(R.id.btnSendEmail);

        Intent i = getIntent();
         String msg = i.getStringExtra("msg");
        tvEmailMsg.setText(msg);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmailId.getText().toString().equals(""))
                {
                   etEmailId.setError("Enter Valid Email Id");
                    etEmailId.requestFocus();
                    return;
                }

                if (etSubject.getText().toString().equals(""))
                {
                    etSubject.setError("Subject Field Cannot be empty");
                    etEmailId.requestFocus();
                    return;
                }

                Intent EmailIntent= new Intent(Intent.ACTION_SENDTO);
                EmailIntent.setData(Uri.parse("mailto:" + etEmailId.getText().toString()));
                EmailIntent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                EmailIntent.putExtra(Intent.EXTRA_TEXT,tvEmailMsg.getText().toString());
                startActivity(EmailIntent);
            }
            });

    }
}
