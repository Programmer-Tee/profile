package com.example.tobeisun.facebook_profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// tampered with styles.xml ; the empty " "
public class MainActivity extends AppCompatActivity {

    private static final int IMAGERESULT = 1; //IT IS STATIC BECAUSE IT IS GOING TO REMAIN CONSTANT AND PRIVATE BECAUSE IT IS JUST FOR THAT "CLASS"

    EditText username ;
    EditText status ;
    ImageView picture ;
    Button save ;
  DatabaseReference db ;
    Uri selectedimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        username =(EditText) findViewById(R.id.editTextUsername);
        status =(EditText) findViewById(R.id.editTextStatus);
        save =(Button) findViewById(R.id.saveprofile);
        picture =(ImageView)findViewById(R.id.Imagetoupload);


        db =FirebaseDatabase.getInstance().getReference().child("users");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            pickpicture() ; // the method is down down down
            }
        });











        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }







    private void pickpicture() {
// allows the gallery to be opened and for you to be able to select from the gallery

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        //startactivity for result because when the user selects a picture ,  we get the result of the image we select

        // then give the image selected a unique id so we know how to call it or something , the id is given upppp
        startActivityForResult(gallery, IMAGERESULT);




    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override  // this is the continuation of the method
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // CHECK IF IT IS THE GALLERY GANGAN THAT IS CALLED , IF THE RESULT IS OKAY AND THAT AN IMAGE HAS BEEN SELECTED
        if(requestCode==IMAGERESULT && resultCode==RESULT_OK && data !=null)
        {
            // to display the image selected , create an URI which is a uniform resource indicator ,

            selectedimage = data.getData();               // this shows the address of the image on the phone


            picture.setImageURI(selectedimage); // displays the image in the image view
        }
}}
