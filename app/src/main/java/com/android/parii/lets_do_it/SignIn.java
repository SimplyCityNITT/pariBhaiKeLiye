package com.android.parii.lets_do_it;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.parii.lets_do_it.Common.Common;
import com.android.parii.lets_do_it.Model.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignIn extends AppCompatActivity {

    EditText edtPhone,edtPassword;
    Button btnSignIn;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        //init firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        //TODO: uncomment this code and import required library. This code maintains the user session
        final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Kindly wait for a few moments...");
                mDialog.show();
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            mDialog.dismiss();
            Intent homeIntent = new Intent(SignIn.this, Home.class);
            //Common.currentUser = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            startActivity(homeIntent);
            finish();
        }else{
            mDialog.dismiss();
        }

        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override

                public void onClick(View view){


                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Kindly wait for a few moments...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user exists in database!!
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists())
                        {
                            //get user info
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            user.setPhone(edtPhone.getText().toString());//set phone
                            if (user.getPassword().equals(edtPassword.getText().toString()))
                            {
                                {
                                    //Toast.makeText(SignIn.this, "SIGN IN SUCCESSFUL!!", Toast.LENGTH_LONG).show();
                                    Intent homeIntent = new Intent(SignIn.this, Home.class);
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                    finish();
                                }

                            }
                            else
                                {

                                Toast.makeText(SignIn.this, "WRONG PASSWORD!!", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            mDialog.dismiss();

                            Toast.makeText(SignIn.this,"USER DOES NOT EXIST..",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        }

}


