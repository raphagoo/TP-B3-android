package com.example.tp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tp.database.AppDatabase;
import com.example.tp.database.dao.ContactDao;
import com.example.tp.models.Contact;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_SELECT_PICTURE = 1;
    private static final String TAG = "TP_APP";
    private ImageButton favorite;
    private CircleImageView profilePicture;
    private boolean fav;
    private TextInputEditText birthDate;
    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favorite = findViewById(R.id.favorite);
        profilePicture = findViewById(R.id.imageButton);
        birthDate = findViewById(R.id.editText3);
        tvAge = findViewById(R.id.textView);
        fav = false;
        //ContactDao contactListDao = AppDatabase.getInstance(this).contactDao();

        //List<Contact> contactList = contactListDao.getAll();



        birthDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                displayDatePicker();
            }
        });


        birthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    displayDatePicker();
                }
            }
        });



        Spinner spinner = findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // TODO Auto-generated method stub
                Log.v(TAG, "onCreate " + pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

    }

    @Override
    public void onClick(View v){
        // TODO add this at the top, inside the class MainActivity
        // private static final Integer REQUEST_CODE_SELECT_PICTURE = 2345; // Arbitrary value

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_SELECT_PICTURE);

        // TODO : Run the "android_intent_select_picture_in_gallery_result" live template, outside of a method, but inside of the MainActivity class.
    }

    public void setFavorite(View v){
        if(!fav) {
            favorite.setImageResource(R.drawable.favorite);
            fav = true;
        }
        else{
            favorite.setImageResource(R.drawable.favorite_off);
            fav = false;
        }
    }

    public void saveContact(View v){
        //Contact currentUser = new Contact("Tristan", "SALAUN", "H", "Mobile", "+3361234567", "29/03/1979", "IMAGE");
        //AppDatabase.getInstance(this).contactDao().insertAll(currentUser);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT_PICTURE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    profilePicture.setImageURI(data.getData());
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayDatePicker() {
        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this);
        dpd.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // TODO: do something with the selected date
                birthDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);


                LocalDate today = LocalDate.now();
                LocalDate birthDay = LocalDate.of(year, month+1, dayOfMonth);

                tvAge.setText(Period.between(birthDay, today).getYears() + " ans");
            }
        });
        dpd.show();
    }

    // Create an entity class, then use : android_db_room_01_entity
    // Create a file BaseDao and use : android_db_room_02_BaseDao
    // Create a file ObjectDao corresponding to the entity class, exemple UserDao and use : android_db_room_03_objectDao
    // Create a file AppDatabase use android_db_room_04_AppDatabase and customize the file with the Dao Objects.
}
