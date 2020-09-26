package com.levitnudi.fancytableview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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

public class SimpleLegacyTableView extends AppCompatActivity {

    //declare your table header labels
    //the title size will determine the number of content labels on each row


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //do something when user presses back
        finish();
    }
    LegacyTableView legacyTableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_table_view);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("SimpleLegacyTableView");
        }

        //set table title labels
        LegacyTableView.insertLegacyTitle("Id", "Name", "Age", "Email");
        //set table contents as string arrays
        LegacyTableView.insertLegacyContent("2999010", "John Deer", "50", "john@example.com",
                "332312", "Kennedy F", "33", "ken@example.com"
                ,"42343243", "Java Lover", "28", "Jlover@example.com"
                ,"4288383", "Mike Tee", "22", "miket@example.com");

        legacyTableView = (LegacyTableView)findViewById(R.id.legacy_table_view);
        legacyTableView.setTitle(LegacyTableView.readLegacyTitle());
        legacyTableView.setContent(LegacyTableView.readLegacyContent());
        //if you want a smaller table, change the padding setting
        //legacyTableView.setTablePadding(7);
        //to enable users to zoom in and out:
        legacyTableView.setZoomEnabled(true);
        legacyTableView.setShowZoomControls(true);

        //remember to build your table as the last step
        legacyTableView.build();


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