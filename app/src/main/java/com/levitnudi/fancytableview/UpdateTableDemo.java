package com.levitnudi.fancytableview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

//update table data, theme, fonts, colors, languages etc
public class UpdateTableDemo extends AppCompatActivity {
    LegacyTableView legacyTableView;

    int updateCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_table_demo);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Update LegacyTable");
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //update with incremented values (dynamic table demo)
                //you can choose to set totally new values here
                //every time you build your table, the previous values are cleared. You therefore
                //shouldn't miss this step (add your title and content AGAIN even if either of the two;
                //content or title is being updated. Below code structure should be enough to update
                //entire table with new values
                //you can choose to update theme, colors and fonts as well, however, original look and feel may not
                //be guaranteed in such a case. If you find a better way, please feel free to contribute.

                //the library supports any form of characters including chinese. Make sure that characters
                //used are not clashing with table constants e.g row and column splitters. In case they do,
                //you can always change row or column splitters e.g setRowSeperator("your_character")

                LegacyTableView.insertLegacyTitle("Student ID 你好！"+updateCount++, "Name Student Name 你好！"+updateCount++, "Student Age 你好！"+updateCount++, "Student Email 你好！"+updateCount++);

                LegacyTableView.insertLegacyContent("2999010"+updateCount++, "John Deer2 你好！"+updateCount++, "50"+updateCount++, "john@example.com"+updateCount++,
                        "3323123"+updateCount++, "Karen J 你好！"+updateCount++, "30"+updateCount++, "karen@example.com"+updateCount++
                        ,"42343243"+updateCount++, "Android Lovers 你好！"+updateCount++, "28", "android@example.com"+updateCount++
                        ,"4288383"+updateCount++, "Levit Barry 你好！"+updateCount++, "25", "lb@example.com"+updateCount++);

                //don't skip this step, make sure to add your new values to your table (both title and content)
                legacyTableView.setTitle(LegacyTableView.readLegacyTitle());
                legacyTableView.setContent(LegacyTableView.readLegacyContent());

                //NOTE -: USE legacyTableView.rebuild() NOT legacyTableView.build(); to update table
                legacyTableView.rebuild();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
