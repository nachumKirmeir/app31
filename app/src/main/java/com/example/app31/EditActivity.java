package com.example.app31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class  EditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etTitle,etSubtitle,etPrice;
    Button btnSave,btnCancel;
    ImageView ivProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etTitle=(EditText)findViewById(R.id.etTitle);
        etPrice=(EditText)findViewById(R.id.etPrice);
        etSubtitle=(EditText)findViewById(R.id.etSubtitle);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        ivProduct=(ImageView)findViewById(R.id.ivProduct);

        //connect to intent if its edit mode
        Intent intent= getIntent();
        if(intent.getExtras()!=null)
        {
            String title = intent.getExtras().getString("title");
            String subtitle = intent.getExtras().getString("sub");
            String price = intent.getExtras().getString("price");
            etTitle.setText(title);
            etSubtitle.setText(subtitle);
            etPrice.setText(price);
        }
    }

    @Override
    public void onClick(View view) {

        if(view == btnSave) {
            if (etPrice.getText().toString().length() > 0 && etTitle.getText().toString().length() > 0 && etSubtitle.getText().toString().length() > 0) {
                Intent intent = new Intent();
                intent.putExtra("price", etPrice.getText().toString());
                intent.putExtra("title", etTitle.getText().toString());
                intent.putExtra("sub", etSubtitle.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
            else
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else if(view == btnCancel){
            setResult(RESULT_CANCELED, null);
            finish();
        }
    }
}