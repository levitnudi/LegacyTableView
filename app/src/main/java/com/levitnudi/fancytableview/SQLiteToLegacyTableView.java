package com.levitnudi.fancytableview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.levitnudi.legacytableview.LegacyTableView;

/*
 * Copyright 2018 Levit Nudi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SQLiteToLegacyTableView extends AppCompatActivity {
    //Sqlite DB Class
    SQLiteDatabase db;

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //do something when user presses back
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_table_view);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("SQLiteToLegacyTableView");
        }

        //initialize database and insert dummy data
        initializeDatabase();
        //get dummy data from database and insert in the arrays
        getFromDatabase();

        LegacyTableView legacyTableView = (LegacyTableView)findViewById(R.id.legacy_table_view);
        //once you have inserted contents and titles, you can retrieve them
        //using readLegacyTitle() and readLegacyContent() methods
        legacyTableView.setTitle(LegacyTableView.readLegacyTitle());
        legacyTableView.setContent(LegacyTableView.readLegacyContent());
        //if you want a smaller table, change the padding setting
        legacyTableView.setTablePadding(7);
        //to enable users to zoom in and out:
        legacyTableView.setZoomEnabled(true);
        legacyTableView.setShowZoomControls(true);
        //remember to build your table as the last step
        legacyTableView.build();


    }


    public void initializeDatabase(){
        db = openOrCreateDatabase(getString(R.string.app_name), Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS legacy_table(_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PERSON_ID TEXT, PERSON_NAME TEXT, PERSON_AGE TEXT, PERSON_EMAIL TEXT);");

        Cursor cursor = db.rawQuery("SELECT * FROM legacy_table", null);
        cursor.moveToFirst();
        String PERSON_ID = "";
        String PERSON_NAME = "";
        String PERSON_AGE = "";
        String PERSON_EMAIL = "";
        //insert into the dummy table if no data exists
        if (cursor.getCount() == 0) {
            for(int i = 0; i<10; i++) {
                PERSON_ID = "Person Name "+i;
                PERSON_NAME = "John Deer "+i;
                PERSON_AGE = "2"+i;
                PERSON_EMAIL = "johndeer2"+i+"@farmer.com";
                //inserting our dummy data into sqlite database

                db.execSQL("INSERT INTO legacy_table(PERSON_ID, PERSON_NAME, PERSON_AGE, PERSON_EMAIL) VALUES('"
                        + PERSON_ID + "' ,'" + PERSON_NAME + "','" + PERSON_AGE + "','" + PERSON_EMAIL + "' );");
            }
        }
        cursor.moveToNext();
        cursor.close();
    }


    public void getFromDatabase(){

        Cursor cursor =  db.rawQuery("SELECT * FROM legacy_table", null);

        if(cursor.getCount()>0){
               //use database column names or custom names for the columns
               /* insert your column titles using legacy insertLegacyTitle() function*/
               LegacyTableView.insertLegacyTitle(cursor.getColumnName(1), cursor.getColumnName(2),
                       cursor.getColumnName(3), cursor.getColumnName(4));
        }
        while(cursor.moveToNext()) {
            //simple table content insert method for table contents
            LegacyTableView.insertLegacyContent(cursor.getString(1),
                    cursor.getString(2), cursor.getString(3), cursor.getString(4));
        }
        //remember to close your database to avoid memory leaks
        cursor.close();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                //finish activity once user presses back button
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}