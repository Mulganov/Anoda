package com.mulganov.test_task.anoda;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Element {

    public User user;
    public ArrayList<String> likes;
    public ArrayList<String> tags;
    public long date;
    public String photo;                // адрес где находится картинка

    public static class User{
        public String photo;            // адрес где находится картинка
        public String name;
        public String location;
    }
}
