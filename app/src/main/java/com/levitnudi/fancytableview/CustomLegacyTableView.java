package com.levitnudi.fancytableview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.levitnudi.legacytableview.LegacyTableView;
import static com.levitnudi.legacytableview.LegacyTableView.BOLD;
import static com.levitnudi.legacytableview.LegacyTableView.CENTER;
import static com.levitnudi.legacytableview.LegacyTableView.CUSTOM;
import static com.levitnudi.legacytableview.LegacyTableView.ODD;

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
public class CustomLegacyTableView extends AppCompatActivity {
    //declare your table header labels
    //the title size will determine the number of content labels on each row

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_table_view);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("CustomLegacyTableView");
        }

        final LegacyTableView tableView = (LegacyTableView)findViewById(R.id.legacy_table_view);
        /*
        [OPTIONAL] default column seperator characters are (د) character
        default row seperator is (\n) character
        you may need to change if your set of data contains these characters
        if you don't change the seperators, any character similar in your data set
        will be excluded in your table. It is therefore adviseable to use least
        commonly used characters
        tableView.setColumnSeperator("'");
        tableView.setRowSeperator("\n");
        tableView.setLegacyColumnSeperator("'");*/

        //set table title labels
        LegacyTableView.insertLegacyTitle("Id", "Name", "Age", "Email");
        //set table contents as string arrays
        LegacyTableView.insertLegacyContent("2999010", "John Deer", "50", "john@example.com",
                "332312", "Kennedy F", "33", "ken@example.com"
                ,"42343243", "Java Lover", "28", "Jlover@example.com"
                ,"4288383", "Mike Tee", "22", "miket@example.com");
        //make sure to indicate custom as other features may not work with default table theme
        tableView.setTheme(CUSTOM);
        //get titles and contents
        tableView.setContent(LegacyTableView.readLegacyContent());
        tableView.setTitle(LegacyTableView.readLegacyTitle());
        tableView.setBottomShadowVisible(true);

        tableView.setHighlight(ODD);//highlight rows oddly or evenly
        //tableView.setHighlight(EVEN);
        tableView.setBottomShadowVisible(true);
        tableView.setFooterTextAlignment(CENTER);

        tableView.setFooterText(getString(R.string.footer_text));
        tableView.setTableFooterTextSize(5);
        tableView.setTableFooterTextColor("#009688");

        tableView.setTitleTextAlignment(CENTER);
        tableView.setContentTextAlignment(CENTER);
        tableView.setTablePadding(20);//increasing spacing will increase the table size
        //tableView.setBottomShadowColorTint("#ffffff");

        //tableView.setBackgroundEvenColor("#FFCCBC");
        //tableView.setBackgroundEvenColor("#303F9F");
        tableView.setBackgroundOddColor("#FFCCBC");
        //you can also declare your color values as global strings to make your work easy :)
        tableView.setHeaderBackgroundLinearGradientBOTTOM("#FF5722");//header background bottom color
        tableView.setHeaderBackgroundLinearGradientTOP("#009688");//header background top color
        tableView.setBorderSolidColor("#009688");
        tableView.setTitleFont(BOLD);
        tableView.setZoomEnabled(true);
        tableView.setShowZoomControls(true);
        //by default the initial scale is 100, you
        // may change this depending on various screen sizes
        tableView.setInitialScale(90);
        tableView.setContentTextColor("#009688");
        tableView.build();

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
