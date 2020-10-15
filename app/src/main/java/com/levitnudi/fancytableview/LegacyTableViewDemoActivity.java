package com.levitnudi.fancytableview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

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
public class LegacyTableViewDemoActivity extends AppCompatActivity {
    ListView listView;
    private InterstitialAd interstitialAd;

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //do something when user presses back
        //exit with code 0
        System.exit(0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legacy_activity_list);


        String[] legacyList = new String[] { "SimpleLegacyTableView", "CustomLegacyTableView","SQLiteToLegacyTableView",
                "LegacyTableViewThemes", "Update LegacyTableView"};

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
                     startActivity(new Intent(getApplicationContext(), SimpleLegacyTableView.class));
                     return;
                 case 1:
                     startActivity(new Intent(getApplicationContext(), CustomLegacyTableView.class));
                     return;
                 case 2:
                     startActivity(new Intent(getApplicationContext(), SQLiteToLegacyTableView.class));
                     return;
                 case 3:
                     startActivity(new Intent(getApplicationContext(), LegacyThemesDemoActivity.class));
                     return;
                 case 4://new feature for creating dynamic tables / updating data on existing table
                     startActivity(new Intent(getApplicationContext(), UpdateTableDemo.class));
                     return;

             }

            }
        });


        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.

            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        interstitialAd.loadAd(adRequest);

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

        if (id == R.id.action_about_id) {
            startActivity(new Intent(LegacyTableViewDemoActivity.this, AboutLegacyTableViewActivity.class));
            finish();
            return true;
        }

        if (id == android.R.id.home) {
            ////exit application completely and kill all running tasks
            System.exit(0);
            return true;
        }

        if (id == R.id.action_share_id) {
            Intent sendIntent = new Intent();
            Uri url = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi!, I'm using LegacyTableView library to make cool TableView projects " +
                    "get it here "+url);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
