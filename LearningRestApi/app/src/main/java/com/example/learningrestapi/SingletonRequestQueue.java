package com.example.learningrestapi;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequestQueue {

    private static SingletonRequestQueue INSTANCE;
    private RequestQueue requestQueue;
    private static Context context;

    private SingletonRequestQueue(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized SingletonRequestQueue getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new SingletonRequestQueue(context);
        }
        return INSTANCE;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }
}
