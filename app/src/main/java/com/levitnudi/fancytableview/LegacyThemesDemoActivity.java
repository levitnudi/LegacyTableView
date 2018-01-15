package com.levitnudi.fancytableview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.levitnudi.legacytableview.LegacyTableView.DESKTOP;
import static com.levitnudi.legacytableview.LegacyTableView.ECOKENYA;
import static com.levitnudi.legacytableview.LegacyTableView.GOLDALINE;
import static com.levitnudi.legacytableview.LegacyTableView.LAVICI;
import static com.levitnudi.legacytableview.LegacyTableView.LEVICI;
import static com.levitnudi.legacytableview.LegacyTableView.MAASAI;
import static com.levitnudi.legacytableview.LegacyTableView.MESH;
import static com.levitnudi.legacytableview.LegacyTableView.OCEAN;
import static com.levitnudi.legacytableview.LegacyTableView.ORIO;
import static com.levitnudi.legacytableview.LegacyTableView.SKELETON;

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
public class LegacyThemesDemoActivity extends AppCompatActivity {
    ListView listView;

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //do something when user presses back
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legacy_activity_list);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("LegacyThemesDemoActivity");
        }


        String[] legacyList = new String[] { "OCEAN", "LAVICI", "GOLDALINE",
                "ECOKENYA", "DESKTOP", "MAASAI",
                "LEVICI", "ORIO", "SKELETON", "MESH"};

        listView = (ListView) findViewById(R.id.listview);

        // Bind array strings into an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                legacyList);
        listView.setAdapter(adapter);

        // Get ListView item click
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Get the click position and set it into a string
                String items = (String) listView.getItemAtPosition(position);
                //set intent
                Intent intent = new Intent(getApplicationContext(), LegacyTableViewThemes.class);
             switch (position){
                 case 0:
                     intent.putExtra("THEME", OCEAN);
                     intent.putExtra("NAME", "OCEAN");
                     startActivity(intent);
                     return;
                 case 1:
                     intent.putExtra("THEME", LAVICI);
                     intent.putExtra("NAME", "LAVICI");
                     startActivity(intent);
                     return;
                 case 2:
                     intent.putExtra("THEME", GOLDALINE);
                     intent.putExtra("NAME", "GOLDALINE");
                     startActivity(intent);
                     return;
                 case 3:
                     intent.putExtra("THEME", ECOKENYA);
                     intent.putExtra("NAME", "ECOKENYA");
                     startActivity(intent);
                     return;
                 case 4:
                     intent.putExtra("THEME", DESKTOP);
                     intent.putExtra("NAME", "DESKTOP");
                     startActivity(intent);
                     return;
                 case 5:
                     intent.putExtra("THEME", MAASAI);
                     intent.putExtra("NAME", "MAASAI");
                     startActivity(intent);
                     return;
                 case 6:
                     intent.putExtra("THEME", LEVICI);
                     intent.putExtra("NAME", "LEVICI");
                     startActivity(intent);
                     return;
                 case 7:
                     intent.putExtra("THEME", ORIO);
                     intent.putExtra("NAME", "ORIO");
                     startActivity(intent);
                     return;
                 case 8:
                     intent.putExtra("THEME", SKELETON);
                     intent.putExtra("NAME", "SKELETON");
                     startActivity(intent);
                     return;
                 case 9:
                     intent.putExtra("THEME", MESH);
                     intent.putExtra("NAME", "MESH");
                     startActivity(intent);
                     return;
                 default:
                     intent.putExtra("THEME", OCEAN);
                     intent.putExtra("NAME", "OCEAN");
                     startActivity(intent);
                     return;
             }

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
