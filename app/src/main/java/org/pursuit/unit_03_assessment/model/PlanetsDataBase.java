package org.pursuit.unit_03_assessment.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PlanetsDataBase extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Planets";
    private static final String DATABASE_NAME = "Planets.db";
    private static final int SCHEMA_VERSION =1;
    private static PlanetsDataBase planetsDataBaseInstance;

    public static synchronized PlanetsDataBase getInstance(Context context) {
        if (planetsDataBaseInstance == null) {

        }
        return planetsDataBaseInstance;
    }
    public PlanetsDataBase(@NonNull Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, number TEXT, image TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    PlanetImage planetImage = null;

    public PlanetImage getPlanetImage(String name, String number) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME , null);

        if (cursor != null){
            if (cursor.moveToFirst()) planetImage = new PlanetImage(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("number")));

            return planetImage;
            }
        return null;
    }
        public void addPlanetImage(String name, String number){
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.getCount() == 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, number VALUES('" +
                    name + "','" +
                    number + "',''");
        }
        cursor.close();
    }
    public List <PlanetImage> getPlanetImage(){
        List<PlanetImage> planetImageList = new ArrayList<>();
        PlanetImage planetImage = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    planetImage = new PlanetImage(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("number")));
                    planetImageList.add(planetImage);
                } while (cursor.moveToNext());
            }
        }
        return planetImageList;
    }
}