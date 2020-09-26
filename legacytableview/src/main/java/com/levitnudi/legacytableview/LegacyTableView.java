package com.levitnudi.legacytableview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import java.util.LinkedList;
import java.util.List;

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
 *
 * To get started, familiarize with the variables and methods used herein
 * it is easy to customize the variables to suit your own common words
 * Check webview documentation to understand various methods that can be implemented
 * You will need to understand HTML and CSS to modify and make this library even better
 * Feel free to share your eureka! moments :)
 * levitnudi@gmail.com
 */
public class LegacyTableView extends WebView {
    List<String> tableContent = new LinkedList<>();
    private static String COLUMN_SEPERATOR = "د";
    private static String LEGACY_COLUMN_SEPERATOR = "د";
    private static String ROW_SEPERATOR = "\n";
    private static String[] TABLE_DATA_CONTENT = new String[]{""};
    private static String[] TABLE_COLUMN_TITLE = new String[]{""};
    private static String TABLE_CONTENT_STRINGS = "";
    private static String TABLE_TITLE_STRINGS = "";
    private static String TABLE_FOOTER = "";
    public static int INITIAL_SIZE = 100;
    public String TABLE_BOX_SHADOW = "#888888";
    private static String TABLE_BORDER_SOLID = "#07214f";
    private static String TABLE_BACKGROUND_ODD = "#ffffff";
    private static String TABLE_BACKGROUND_EVEN = "#a6d3ed";
    private static String TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#629edb";
    private static String TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#003f7f";
    private static String TABLE_CONTENT_TEXT_COLOR = "#020101";
    private static String PLAIN_WHITE_COLOR = "#ffffff";
    private static String TRANSPARENT_COLOR = "#00000000";
    private static String TABLE_FOOTER_TEXT_COLOR = "#020101";

    private static String TABLE_TITLE_FONT = "bold";
    private static String TABLE_CONTENT_FONT = "normal";
    private static String TABLE_TITLE_FONT_FAMILY = "Arial";
    private static String TABLE_CONTENT_FONT_FAMILY = "Arial";
    private static String TABLE_TITLE_TEXT_ALIGNMENT = "left";
    private static String TABLE_CONTENT_TEXT_ALIGNMENT = "left";
    private static String TABLE_FOOTER_ALIGNEMT = "center";
    private static String TABLE_TITLE_TEXT_COLOR = "#ffffff";
    private static String TABLE_FOOTER_FONT_FAMILY = "Arial";
    private static int TABLE_FOOTER_TEXT_SIZE = 5;
    private static String TABLE_FOOTER_FONT = "Arial";
    private static int TABLE_PADDING = 30;
    private static int TABLE_TITLE_TEXT_SIZE = 20;
    private static int TABLE_CONTENT_TEXT_SIZE = 16;


    private static boolean SHOW_BOX_SHADOW = false;
    private static int TABLE_THEME = 0;
    private static int TABLE_HighlightAlternate = 3;


    //public static class Theme{
    public static int OCEAN = 0;
    public static int LAVICI = 1;
    public static int GOLDALINE = 2;
    public static int ECOKENYA = 3;
    public static int DESKTOP = 4;
    public static int MAASAI = 5;
    public static int LEVICI = 6;
    public static int ORIO = 7;
    public static int SKELETON = 8;
    public static int MESH = 9;
    public static int CUSTOM = 10;
    //}

    public LegacyTableView(Context context) {
        super(context);
        initView(context);
    }

    public LegacyTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context){
        resetVariables();
        this.getSettings().setJavaScriptEnabled(true) ;
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.setInitialScale(INITIAL_SIZE);
    }



    public void setZoomEnabled(boolean zoomEnabled){
        this.getSettings().setSupportZoom(true);
    }

    public void setShowZoomControls(boolean zoomEnabled) {
        this.getSettings().setBuiltInZoomControls(true);
    }


    public static int getInitialTableSize() {
        return INITIAL_SIZE;
    }

    public void setTheme(int theme){
        this.TABLE_THEME = theme;
    }


    //public static class HighlightAlternate{
    public static int ODD = 0;
    public static int EVEN = 1;
    public static int DEFAULT = 2;
    //}

    //public static class Font{
    public static int NORMAL = 0;
    public static int BOLD = 1;
    //}

    //public static class Alignment{
    public static int LEFT = 0;
    public static int RIGHT = 1;
    public static int CENTER = 2;
    //}

 /*   public static class FontFamily{
        public static int ARIAL = 0;
        public static int HELEVITICA = 1;
        public static int TIMES_NEW_ROMAN = 2;
        public static int IMPACT = 3;
        public static int COURIER_NEW = 4;
        public static int GEORGIA = 5;
        public static int BOOKMAN = 6;
        public static int COMIC_SANS_NEW = 7;
    }*/



    public void build(){
       /* deprecated code
       initializeTheme();
        contrasts();
        configure();
        BuildTable();
        String completeHtmlData = new LegacyDataHelper().generateLegacyData();
        this.loadData(completeHtmlData, "text/html", "UTF-8");
        //clear data
        this.TABLE_CONTENT_STRINGS = "";
        this.TABLE_TITLE_STRINGS = "";
        this.tableContent.clear();*/

        initializeTheme();
        contrasts();
        configure();
        BuildTable();
        String completeHtmlData = new LegacyDataHelper().generateLegacyData();
        //reloads with loadDataWithBaseUrl (don't use this line on build as it may not load some css data) :- ONLY FOR REBUILDS
        this.loadDataWithBaseURL(null,completeHtmlData,"text/html", "UTF-8", null);
        //clear data
        this.TABLE_CONTENT_STRINGS = "";
        this.TABLE_TITLE_STRINGS = "";
        this.tableContent.clear();
    }
    @Deprecated
    public void rebuild(){
        initializeTheme();
        contrasts();
        configure();
        BuildTable();
        String completeHtmlData = new LegacyDataHelper().generateLegacyData();
        //reloads with loadDataWithBaseUrl (don't use this line on build as it may not load some css data) :- ONLY FOR REBUILDS
        this.loadDataWithBaseURL(null,completeHtmlData,"text/html", "UTF-8", null);
        //clear data
        this.TABLE_CONTENT_STRINGS = "";
        this.TABLE_TITLE_STRINGS = "";
        this.tableContent.clear();
    }


    public void setHighlight(int tableHighlightAlternate){
        this.TABLE_HighlightAlternate = tableHighlightAlternate;
    }



    private void contrasts(){
        switch (TABLE_HighlightAlternate){
            case 0:
                TABLE_BACKGROUND_EVEN = PLAIN_WHITE_COLOR;
                return;
            case 1:
                TABLE_BACKGROUND_ODD = PLAIN_WHITE_COLOR;
                return;
            case 2:
                TABLE_BACKGROUND_EVEN = PLAIN_WHITE_COLOR;
                TABLE_BACKGROUND_ODD = PLAIN_WHITE_COLOR;
                return;
            default:
                TABLE_BACKGROUND_EVEN = PLAIN_WHITE_COLOR;
                TABLE_BACKGROUND_ODD = PLAIN_WHITE_COLOR;
                return;

        }

    }

    private void configure(){
        if(!SHOW_BOX_SHADOW){
            TABLE_BOX_SHADOW = TRANSPARENT_COLOR;
        }
    }


    public void setBottomShadowVisible(boolean shadow){

        this.SHOW_BOX_SHADOW = shadow;
    }


    private void initializeTheme(){
        switch (TABLE_THEME) {
            case 0://OCEAN
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#0288D1";
                TABLE_BACKGROUND_ODD = "#BBDEFB";
                TABLE_BACKGROUND_EVEN = "#BBDEFB";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#0288D1";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#03A9F4";
                return;
            case 1://LAVICI
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#E91E63";
                TABLE_BACKGROUND_ODD = "#F8BBD0";
                TABLE_BACKGROUND_EVEN = "#F8BBD0";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#C2185B";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#E91E63";
                return;
            case 2://GOLD
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#FFA000";
                TABLE_BACKGROUND_ODD = "#FFECB3";
                TABLE_BACKGROUND_EVEN = "#FFECB3";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#FFA000";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#FFC107";
                return;
            case 3://ECOKENYA
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#388E3C";
                TABLE_BACKGROUND_ODD = "#C8E6C9";
                TABLE_BACKGROUND_EVEN = "#C8E6C9";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#388E3C";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#4CAF50";
                return;
            case 4://DESKTOP
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#455A64";
                TABLE_BACKGROUND_ODD = "#CFD8DC";
                TABLE_BACKGROUND_EVEN = "#CFD8DC";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#455A64";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#607D8B";
                return;
            case 5://MAASAI
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#D32F2F";
                TABLE_BACKGROUND_ODD = "#FFCDD2";
                TABLE_BACKGROUND_EVEN = "#FFCDD2";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#D32F2F";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#F44336";
                return;
            case 6://LEVICI
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#212121";
                TABLE_BACKGROUND_ODD = "#ffffff";
                TABLE_BACKGROUND_EVEN = "#ffffff";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#212121";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#212121";
                TABLE_TITLE_TEXT_COLOR = "#ffffff";
                return;
            case 7://ORIO
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#5D4037";
                TABLE_BACKGROUND_ODD = "#D7CCC8";
                TABLE_BACKGROUND_EVEN = "#D7CCC8";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#5D4037";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#795548";
                return;
            case 8://SKELETON
                TABLE_BOX_SHADOW = TRANSPARENT_COLOR;
                TABLE_BORDER_SOLID = "#ffffff";
                TABLE_BACKGROUND_ODD = "#ffffff";
                TABLE_BACKGROUND_EVEN = "#ffffff";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#ffffff";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#ffffff";
                TABLE_TITLE_TEXT_COLOR = "#0000";
                return;
            case 9://MESH
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#212121";
                TABLE_BACKGROUND_ODD = "#ffffff";
                TABLE_BACKGROUND_EVEN = "#ffffff";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#ffffff";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#ffffff";
                TABLE_TITLE_TEXT_COLOR = "#212121";
                return;
            case 10:
                //YOUR CUSTOM ATTRIBUTES INSTEAD
                return;
            default:
                //TABLE_BOX_SHADOW = "#888888";
                TABLE_BORDER_SOLID = "#07214f";
                TABLE_BACKGROUND_ODD = "#ffffff";
                TABLE_BACKGROUND_EVEN = "#a6d3ed";
                TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#629edb";
                TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#003f7f";
                return;

        }
    }


    private void BuildTable() {
        //if(TABLE_COLUMN_TITLE!=null)
        tableContent.add(resolveTableTitle(TABLE_COLUMN_TITLE));

        StringBuffer buffer=new StringBuffer();
        String[] array = resolveTableData(TABLE_DATA_CONTENT).split(ROW_SEPERATOR);
        //while(c.moveToNext())
        for(int i=0; i<array.length; i++){
            // buffer.append("data: "+c.getString(0)+"\n");
            tableContent.add(array[i]);
        }

    }


    private String resolveTableData(String[] array){
        String tableData = "";
        //if(TABLE_DATA_CONTENT!=null)
        double colCount = 0;

        for(int i=0; i<array.length; i++) {
            colCount++;
            tableData += TABLE_DATA_CONTENT[i] + COLUMN_SEPERATOR;
            if(colCount == TABLE_COLUMN_TITLE.length){
                tableData += ROW_SEPERATOR;
                colCount = 0;
            }

        }

        return tableData;
    }


    private String resolveTableTitle(String[] array){
        String tableData = "";
        for(int i=0; i<array.length; i++){
            tableData += TABLE_COLUMN_TITLE[i] + COLUMN_SEPERATOR;
        }
        return tableData;
    }

    /*public static String[] legacyColumnsToArray(String array){
        return array.replaceFirst(LEGACY_COLUMN_SEPERATOR, "").split(LEGACY_COLUMN_SEPERATOR);
    }*/

    public static void insertLegacyContent(String... array){
        for(int i=0; i<array.length; i++) {
            TABLE_CONTENT_STRINGS += LEGACY_COLUMN_SEPERATOR+array[i];
        }
        //TABLE_CONTENT_STRINGS = TABLE_CONTENT_STRINGS.replaceFirst(LEGACY_COLUMN_SEPERATOR, "");
    }

    public static String[] readLegacyTitle(){
        return TABLE_TITLE_STRINGS.replaceFirst(LEGACY_COLUMN_SEPERATOR, "").split(LEGACY_COLUMN_SEPERATOR);
    }

    public static void insertLegacyTitle(String... array){
        for(int i=0; i<array.length; i++) {
            TABLE_TITLE_STRINGS += LEGACY_COLUMN_SEPERATOR+array[i];
        }
        //TABLE_CONTENT_STRINGS = TABLE_CONTENT_STRINGS.replaceFirst(LEGACY_COLUMN_SEPERATOR, "");
    }

    public static String[] readLegacyContent(){
        return TABLE_CONTENT_STRINGS.replaceFirst(LEGACY_COLUMN_SEPERATOR, "").split(LEGACY_COLUMN_SEPERATOR);
    }

    public static void setLegacyColumnSeperator(String columnSeperator){
        LEGACY_COLUMN_SEPERATOR = columnSeperator;
    }

    public static String getLegacyColumnSeperator(){
        return LEGACY_COLUMN_SEPERATOR;
    }

    public static String getRowSeperator(){
        return ROW_SEPERATOR;
    }

    public static String getColumnSeperator(){
        return COLUMN_SEPERATOR;
    }


    public void setTitle(String[] tableColumnTitle){
        for(int i=0; i<tableColumnTitle.length; i++){
            tableColumnTitle[i] = tableColumnTitle[i].replaceAll(ROW_SEPERATOR, "").replaceAll(COLUMN_SEPERATOR, "");
        }
        this.TABLE_COLUMN_TITLE = tableColumnTitle;
    }

    public void setContent(String[] contentData){
        for(int i=0; i<contentData.length; i++){
            contentData[i] = contentData[i].replaceAll(ROW_SEPERATOR, "").replaceAll(COLUMN_SEPERATOR, "");
        }
        this.TABLE_DATA_CONTENT = contentData;
    }


    public void setFooterText(String footer){
        this.TABLE_FOOTER = footer;
    }

    public void setRowSeperator(String rowSEPERATOR){
        this.ROW_SEPERATOR  = rowSEPERATOR;
    }

    public void setColumnSeperator(String columnSEPERATOR){
        this.COLUMN_SEPERATOR = columnSEPERATOR;
    }


    public void setTitleFont(int tableTitleFont){
        switch (tableTitleFont){
            case 0:
                this.TABLE_TITLE_FONT = "normal";
                return;
            case 1:
                this.TABLE_TITLE_FONT = "bold";
                return;
            case 2:
                this.TABLE_TITLE_FONT = "italic";
                return;
            case 3:
                this.TABLE_TITLE_FONT = "bold-italic";
                return;
            default:
                this.TABLE_TITLE_FONT = "normal";
                return;
        }
    }


    public void setTableContentTextAlignment(int contentFont){
        switch (contentFont){
            case 0:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "left";
                return;
            case 1:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "right";
                return;
            case 2:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "center";
                return;
            default:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "left";
                return;
        }
    }

    public void setContentFont(int contentFont){
        switch (contentFont){
            case 0:
                this.TABLE_CONTENT_FONT = "normal";
                return;
            case 1:
                this.TABLE_CONTENT_FONT = "bold";
                return;
            case 2:
                this.TABLE_CONTENT_FONT = "italic";
                return;
            case 3:
                this.TABLE_CONTENT_FONT = "bold-italic";
                return;
            default:
                this.TABLE_CONTENT_FONT = "normal";
                return;
        }
    }

    public void setFooterFont(int contentFont){
        switch (contentFont){
            case 0:
                this.TABLE_FOOTER_FONT = "normal";
                return;
            case 1:
                this.TABLE_FOOTER_FONT = "bold";
                return;
            case 2:
                this.TABLE_FOOTER_FONT = "italic";
                return;
            case 3:
                this.TABLE_FOOTER_FONT = "bold-italic";
                return;
            default:
                this.TABLE_FOOTER_FONT = "normal";
                return;
        }
    }

    public void resetVariables(){
        tableContent = new LinkedList<>();
        COLUMN_SEPERATOR = "د";
        LEGACY_COLUMN_SEPERATOR = "د";
        ROW_SEPERATOR = "\n";
        TABLE_DATA_CONTENT = new String[]{""};
        TABLE_COLUMN_TITLE = new String[]{""};
        TABLE_FOOTER = "";
        INITIAL_SIZE = 100;
        TABLE_BOX_SHADOW = "#888888";
        TABLE_BORDER_SOLID = "#07214f";
        TABLE_BACKGROUND_ODD = "#ffffff";
        TABLE_BACKGROUND_EVEN = "#a6d3ed";
        TABLE_BACKGROUND_LINEAR_GRADIENT_TOP= "#629edb";
        TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = "#003f7f";
        TABLE_CONTENT_TEXT_COLOR = "#020101";
        PLAIN_WHITE_COLOR = "#ffffff";
        TRANSPARENT_COLOR = "#00000000";
        TABLE_FOOTER_TEXT_COLOR = "#020101";

        TABLE_TITLE_FONT = "bold";
        TABLE_CONTENT_FONT = "normal";
        TABLE_TITLE_FONT_FAMILY = "Arial";
        TABLE_CONTENT_FONT_FAMILY = "Arial";
        TABLE_TITLE_TEXT_ALIGNMENT = "left";
        TABLE_CONTENT_TEXT_ALIGNMENT = "left";
        TABLE_FOOTER_ALIGNEMT = "center";
        TABLE_TITLE_TEXT_COLOR = "#ffffff";
        TABLE_FOOTER_FONT_FAMILY = "Arial";
        TABLE_FOOTER_TEXT_SIZE = 5;
        TABLE_FOOTER_FONT = "Arial";
        TABLE_PADDING = 30;
        TABLE_TITLE_TEXT_SIZE = 20;
        TABLE_CONTENT_TEXT_SIZE = 16;

        boolean SHOW_BOX_SHADOW = false;
        TABLE_THEME = 0;
        TABLE_HighlightAlternate = 3;

        //public static class Theme{
        OCEAN = 0;
        LAVICI = 1;
        GOLDALINE = 2;
        ECOKENYA = 3;
        DESKTOP = 4;
        MAASAI = 5;
        LEVICI = 6;
        ORIO = 7;
        SKELETON = 8;
        MESH = 9;
    }

    /*public void setContentFontFamily(int contentFont){
        switch (contentFont){
            case 0:
                this.TABLE_CONTENT_FONT_FAMILY  = "Arial";
                return;
            case 1:
                this.TABLE_CONTENT_FONT_FAMILY  = "Helevitica";
                return;
            case 2:
                this.TABLE_CONTENT_FONT_FAMILY  = "Times New Roman";
                return;
            case 3:
                this.TABLE_CONTENT_FONT_FAMILY  = "Impact";
                return;
            case 4:
                this.TABLE_CONTENT_FONT_FAMILY  = "Courier";
                return;
            case 5:
                this.TABLE_CONTENT_FONT_FAMILY  = "Georgia";
                return;
            case 6:
                this.TABLE_CONTENT_FONT_FAMILY  = "Bookman";
                return;
            case 7:
                this.TABLE_CONTENT_FONT_FAMILY  = "Comic Sans MS New";
                return;
            default:
                this.TABLE_CONTENT_FONT_FAMILY  = "Arial";
                return;
        }
    }*/

    /*public void setTitleFontFamily(int conteFont){
        switch (conteFont){
            case 0:
                this.TABLE_TITLE_FONT_FAMILY  = "Arial Header";
                return;
            case 1:
                this.TABLE_TITLE_FONT_FAMILY  = "Helevitica";
                return;
            case 2:
                this.TABLE_TITLE_FONT_FAMILY = "Times New Roman";
                return;
            case 3:
                this.TABLE_TITLE_FONT_FAMILY  = "Impact";
                return;
            case 4:
                this.TABLE_TITLE_FONT_FAMILY  = "Courier";
                return;
            case 5:
                this.TABLE_TITLE_FONT_FAMILY  = "Georgia";
                return;
            case 6:
                this.TABLE_TITLE_FONT_FAMILY  = "Bookman";
                return;
            case 7:
                this.TABLE_TITLE_FONT_FAMILY  = "Comic Sans MS New";
                return;
            default:
                this.TABLE_TITLE_FONT_FAMILY  = "Arial";
                return;
        }
    }*/

    /*public void setFooterFontFamily(int conteFont){
        switch (conteFont){
            case 0:
                this.TABLE_FOOTER_FONT_FAMILY = "Arial";
                return;
            case 1:
                this.TABLE_FOOTER_FONT_FAMILY  = "Helevitica";
                return;
            case 2:
                this.TABLE_FOOTER_FONT_FAMILY = "Times New Roman";
                return;
            case 3:
                this.TABLE_FOOTER_FONT_FAMILY  = "Impact";
                return;
            case 4:
                this.TABLE_FOOTER_FONT_FAMILY  = "Courier";
                return;
            case 5:
                this.TABLE_FOOTER_FONT_FAMILY  = "Georgia";
                return;
            case 6:
                this.TABLE_FOOTER_FONT_FAMILY  = "Bookman";
                return;
            case 7:
                this.TABLE_FOOTER_FONT_FAMILY  = "Comic Sans MS New";
                return;
            default:
                this.TABLE_FOOTER_FONT_FAMILY  = "Arial";
                return;
        }
    }*/


    public void setTitleTextAlignment(int textAlignment){
        switch (textAlignment){
            case 0:
                this.TABLE_TITLE_TEXT_ALIGNMENT = "left";
                return;
            case 1:
                this.TABLE_TITLE_TEXT_ALIGNMENT = "right";
                return;
            case 2:
                this.TABLE_TITLE_TEXT_ALIGNMENT = "center";
                return;
            default:
                this.TABLE_TITLE_TEXT_ALIGNMENT = "left";
                return;
        }
    }

    public void setContentTextAlignment(int textAlignment){
        switch (textAlignment){
            case 0:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "left";
                return;
            case 1:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "right";
                return;
            case 2:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "center";
                return;
            default:
                this.TABLE_CONTENT_TEXT_ALIGNMENT = "left";
                return;
        }
    }


    public void setFooterTextAlignment(int textAlignment){
        switch (textAlignment){
            case 0:
                this.TABLE_FOOTER_ALIGNEMT = "left";
                return;
            case 1:
                this.TABLE_FOOTER_ALIGNEMT = "right";
                return;
            case 2:
                this.TABLE_FOOTER_ALIGNEMT  = "center";
                return;
            default:
                this.TABLE_FOOTER_ALIGNEMT = "center";
                return;
        }
    }


    /*public void setFooterTextSize(int footer){
        this.TABLE_FOOTER_TEXT_SIZE = footer;
    }*/

    public void setTitleTextSize(int titleTextSize){
        this.TABLE_TITLE_TEXT_SIZE = titleTextSize;
    }

    public void setTitleTextColor(String titleTextColor){
        this.TABLE_TITLE_TEXT_COLOR = titleTextColor;
    }


    public void setContentTextSize(int contentTextSize){
        this.TABLE_CONTENT_TEXT_SIZE = contentTextSize;
    }

    public void setTablePadding(int padding){
        this.TABLE_PADDING = padding;
    }

    public void setTableFooterTextColor(String color){
        this.TABLE_FOOTER_TEXT_COLOR = color;
    }


    public void setFooterTextColor(String color){
        this.TABLE_FOOTER_TEXT_COLOR  = color;
    }

    public void setTableFooterTextSize(int size){
        this.TABLE_FOOTER_TEXT_SIZE = size;
    }




    public void setBottomShadowColorTint(String tableBoxShadow){
        this.TABLE_BOX_SHADOW = tableBoxShadow;
    }

    public void setBorderSolidColor(String borderSolidColor){
        this.TABLE_BORDER_SOLID       = borderSolidColor;
    }

    public void setBackgroundOddColor(String backgroundOddColor){
        this.TABLE_BACKGROUND_ODD  = backgroundOddColor;
    }

    public void setBackgroundEvenColor(String backgroundEvenColor){
        this.TABLE_BACKGROUND_EVEN  = backgroundEvenColor;
    }

    public void setHeaderBackgroundLinearGradientTOP(String backgroundLinearGradient){
        this.TABLE_BACKGROUND_LINEAR_GRADIENT_TOP = backgroundLinearGradient;
    }

    public void setHeaderBackgroundLinearGradientBOTTOM(String backgroundLinearGradient){
        this.TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM = backgroundLinearGradient;
    }

    public void setContentTextColor(String tableTextColor){
        this.TABLE_CONTENT_TEXT_COLOR  = tableTextColor;
    }


 /*   private static String TABLE_TITLE_FONT = "bold";
    private static String TABLE_CONTENT_FONT = "normal";
    private static String TABLE_TITLE_FONT_FAMILY = "Arial";
    private static String TABLE_CONTENT_FONT_FAMILY = "Arial";
    private static String TABLE_TITLE_TEXT_ALIGNMENT = "left";
    private static String TABLE_TABLE_CONTENT_TEXT_ALIGNEMT = "left";
    private static String TABLE_TITLE_TEXT_COLOR = "#ffffff";
    private static int TABLE_PADDING = 7;
    private static int TABLE_TITLE_TEXT_SIZE = 15;
    private static int TABLE_CONTENT_TEXT_SIZE = 12;*/


   /* public void setTableColumnCount(int tableColumnCount){
        this.COLUMN_COUNT = tableColumnCount;
    }
*/

    public class  LegacyDataHelper{
        StringBuffer html;

        public String generateLegacyData(){

            String[] tableArray = null;
            html = new StringBuffer("<html><head>"+getLegacyStyle()+"</head>" + "<table class=\"TableStyle\">");

            for(String data : tableContent)
            {
                tableArray = data.split(COLUMN_SEPERATOR);
                html.append("<tr>");
                for (int i = 0; i < tableArray.length; i++) {
                    html.append("<td>" + tableArray[i] + "</td>");

                }
                html.append("</tr>");
            }
            html.append("</tr>" + "</table>" + "<br/><br/><div align="+TABLE_FOOTER_ALIGNEMT+
                    "></div><br/><div align="+TABLE_FOOTER_ALIGNEMT+">" +
                    "<font size="+TABLE_FOOTER_TEXT_SIZE+" "+
                    "color="+TABLE_FOOTER_TEXT_COLOR+" "+
                   /* "face="+TABLE_FOOTER_FONT_FAMILY+" "+
                    ""+TABLE_FOOTER_FONT+" "+*/
                    ">"+TABLE_FOOTER+"</font></></div></html>");

            return html.toString();
        }

        private String getLegacyStyle(){
            String cssString;
            cssString = "<style>"+
                    ".TableStyle {"+
                    "margin:0px;padding:0px;"+
                    "width:100%;"+
                    "box-shadow: 10px 10px 5px"+TABLE_BOX_SHADOW+";"+
                    "border:1px solid"+TABLE_BORDER_SOLID+";"+

                    "-moz-border-radius-bottomleft:0px;"+
                    "-webkit-border-bottom-left-radius:0px;"+
                    "border-bottom-left-radius:0px;"+

                    "-moz-border-radius-bottomright:0px;"+
                    "-webkit-border-bottom-right-radius:0px;"+
                    "border-bottom-right-radius:0px;"+

                    "-moz-border-radius-topright:0px;"+
                    "-webkit-border-top-right-radius:0px;"+
                    "border-top-right-radius:0px;"+

                    "-moz-border-radius-topleft:0px;"+
                    "-webkit-border-top-left-radius:0px;"+
                    "border-top-left-radius:0px;"+
                    "}.TableStyle table{"+
                    "border-collapse: collapse;"+
                    "border-spacing: 0;"+
                    "width:100%;"+
                    "height:100%;"+
                    "margin:0px;padding:0px;"+
                    "}.TableStyle tr:last-child td:last-child {"+
                    "-moz-border-radius-bottomright:0px;"+
                    "-webkit-border-bottom-right-radius:0px;"+
                    "border-bottom-right-radius:0px;"+
                    "}"+
                    ".TableStyle table tr:first-child td:first-child {"+
                    "-moz-border-radius-topleft:0px;"+
                    "-webkit-border-top-left-radius:0px;"+
                    "border-top-left-radius:0px;"+
                    "}"+
                    ".TableStyle table tr:first-child td:last-child {"+
                    "-moz-border-radius-topright:0px;"+
                    "-webkit-border-top-right-radius:0px;"+
                    "border-top-right-radius:0px;"+
                    "}.TableStyle tr:last-child td:first-child{"+
                    "-moz-border-radius-bottomleft:0px;"+
                    "-webkit-border-bottom-left-radius:0px;"+
                    "border-bottom-left-radius:0px;"+
                    "}.TableStyle tr:hover td{"+

                    "}"+
                    ".TableStyle tr:nth-child(odd){ background-color:"+TABLE_BACKGROUND_ODD+";}"+
                    ".TableStyle tr:nth-child(even)    { background-color:" +TABLE_BACKGROUND_EVEN +"; }.TableStyle td{"+
                    "vertical-align:middle;"+

                    //TABLE CONTENT STYLES
                    "border:1px solid"+ TABLE_BORDER_SOLID +";"+
                    "border-width:0px 1px 1px 0px;"+
                    "text-align:"+TABLE_CONTENT_TEXT_ALIGNMENT+";"+
                    "padding:"+TABLE_PADDING+"px;"+
                    "font-size:"+TABLE_CONTENT_TEXT_SIZE+"px;"+
                    "font-family:"+TABLE_CONTENT_FONT_FAMILY+";"+
                    "font-weight:"+TABLE_CONTENT_FONT+";"+
                    "color:"+TABLE_CONTENT_TEXT_COLOR+";"+
                    "}.TableStyle tr:last-child td{"+
                    "border-width:0px 1px 0px 0px;"+
                    "}.TableStyle tr td:last-child{"+
                    "border-width:0px 0px 1px 0px;"+
                    "}.TableStyle tr:last-child td:last-child{"+
                    "border-width:0px 0px 0px 0px;"+
                    "}"+
                    ".TableStyle tr:first-child td{"+
                    "background:-o-linear-gradient(bottom,"+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+" 5%, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+" 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, "+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+"), color-stop(1, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+") );"+
                    "background:-moz-linear-gradient( center top, "+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+" 5%, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+" 100% );"+
                    "filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+", endColorstr="+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+");	background: -o-linear-gradient(top,"+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+",003f7f);"+
                    //TITLE STYLES
                    "background-color:"+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+";"+
                    "border:0px solid"+TABLE_BORDER_SOLID+";"+
                    "text-align:"+TABLE_TITLE_TEXT_ALIGNMENT+";"+
                    "border-width:0px 0px 1px 1px;"+
                    "font-size:"+TABLE_TITLE_TEXT_SIZE+"px;"+
                    "font-family:"+TABLE_TITLE_FONT_FAMILY+";"+
                    "font-weight:"+TABLE_TITLE_FONT+";"+
                    "color:"+TABLE_TITLE_TEXT_COLOR+ ";"+
                    "}"+
                    ".TableStyle tr:first-child:hover td{"+
                    "background:-o-linear-gradient(bottom, "+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+" 5%, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+" 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, "+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+"), color-stop(1, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+") );"+
                    "background:-moz-linear-gradient( center top, "+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+" 5%, "+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+" 100% );"+
                    "filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+", endColorstr="+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+");	background: -o-linear-gradient(top,"+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+","+TABLE_BACKGROUND_LINEAR_GRADIENT_BOTTOM+");"+

                    "background-color:"+TABLE_BACKGROUND_LINEAR_GRADIENT_TOP+";"+
                    "}"+
                    ".TableStyle tr:first-child td:first-child{"+
                    "border-width:0px 0px 1px 0px;"+
                    "}"+
                    ".TableStyle tr:first-child td:last-child{"+
                    "border-width:0px 0px 1px 1px;"+
                    "}"+
                    "</style>";
            return cssString;
        }
    }
}