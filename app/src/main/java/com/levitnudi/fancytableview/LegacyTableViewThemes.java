package com.levitnudi.fancytableview;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
public class LegacyTableViewThemes extends AppCompatActivity {

    //declare your table header labels
    int THEME = 0;
    String THEME_NAME = "LegacyTableViewThemes";

    //declare your table content labels [NOTE] the array size should fit all rows and columns of your table
    String mContent[] = new String[]{"2999010", "John Deer", "50", "john@example.com",
            "332312", "Kennedy F", "33", "ken@example.com"
            ,"42343243", "Java Lover", "28", "Jlover@example.com"
            ,"4288383", "Mike Tee", "22", "miket@example.com"};


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

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            THEME = bundle.getInt("THEME", 0);
            THEME_NAME = bundle.getString("NAME", null);
        }

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(THEME_NAME);
        }

        //set table title labels
        LegacyTableView.insertLegacyTitle("Id", "Name", "Age", "Email");
        //set table contents as string arrays
        LegacyTableView.insertLegacyContent("2999010", "John Deer", "50", "john@example.com",
                "332312", "Kennedy F", "33", "ken@example.com"
                ,"42343243", "Java Lover", "28", "Jlover@example.com"
                ,"4288383", "Mike Tee", "22", "miket@example.com");


        LegacyTableView legacyTableView = (LegacyTableView)findViewById(R.id.legacy_table_view);
        legacyTableView.setTitle(LegacyTableView.readLegacyTitle());
        legacyTableView.setContent(LegacyTableView.readLegacyContent());
        legacyTableView.setTheme(THEME);
        legacyTableView.setBottomShadowVisible(false);

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
