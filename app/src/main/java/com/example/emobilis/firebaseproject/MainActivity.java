package com.example.emobilis.firebaseproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText mName,mEmail,mAge;
ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName=findViewById(R.id.inputName);
        mEmail=findViewById(R.id.inputEmail);
        mAge=findViewById(R.id.inputAge);
    }
//put the save code here
    public void save(View view) {
     String name=mName.getText().toString();
     String email=mEmail.getText().toString();
     String age=mAge.getText().toString();
     progress = new ProgressDialog(this);
     progress.setMessage("saving...");
     if (name.isEmpty()||email.isEmpty()||age.isEmpty()){
         Toast.makeText(this,"fill all fields", Toast.LENGTH_SHORT);
         return;
     }
     long time=System.currentTimeMillis();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users/"+time);
        User members = new User(name,email,age);
        progress.show();
        ref.setValue(members).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progress.dismiss();
                if (task.isSuccessful()){
                    mName.setText("");
                    mEmail.setText("");
                    mAge.setText("");
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
//put the fetch code here
    public void fetch(View view) {
        Intent fetch = new Intent(getApplicationContext(),userActivity.class);
        startActivity(fetch);
    }
}
