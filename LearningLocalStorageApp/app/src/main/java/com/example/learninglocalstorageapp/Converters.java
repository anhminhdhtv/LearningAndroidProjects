package com.example.learninglocalstorageapp;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value){
        return value == null ? null: new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date){
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Boolean fromInt(int value){
        return value == 1 ? true : false;
    }

    @TypeConverter
    public static int booleanToInt(boolean bool){
        return bool == true ? 1: 0;
    }
}
