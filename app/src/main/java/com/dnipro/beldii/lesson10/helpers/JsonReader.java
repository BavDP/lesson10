package com.dnipro.beldii.lesson10.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonReader {
    InputStream jsonStream;
    StringBuilder jsonContent;

    public JsonReader(InputStream jsonResource) {
        this.jsonStream = jsonResource;
        jsonContent = new StringBuilder();
        Reader reader = new InputStreamReader(jsonStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.lines().forEach(line -> jsonContent.append(line));
    }

    public JSONObject getAsObject() {
        try {
            return new JSONObject(this.jsonContent.toString());
        } catch (JSONException e) {
            e.getStackTrace();
        }
        return null;
    }

    public JSONArray getAsArray() {
        try {
            return new JSONArray(this.jsonContent.toString());
        } catch (JSONException e) {
            e.getStackTrace();
        }
        return null;
    }

    public String getAsString() {
        return this.jsonContent.toString();
    }

    /*public <T> ArrayList<T> getAsArray(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        try {
            final ArrayList<T> res = new ArrayList<>();
            final JSONArray array =  new JSONArray(this.jsonContent.toString());
            HashSet<String> jsonFields = new HashSet<>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field: fields) {
                MyJson myJson = field.getAnnotation(MyJson.class);
                if (myJson != null) {
                    jsonFields.add(field.getName());
                }
            }
            if (jsonFields.isEmpty()) {
                return res;
            }
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                T tObj = clazz.newInstance();
                jsonFields.forEach(f -> {
                    try {
                        Field tObjFld = tObj.getClass().getDeclaredField(f);
                        if (tObjFld != null) {
                            tObjFld.setAccessible(true);
                            String tObjFldType = tObjFld.getType().getName();
                            System.out.printf(tObjFldType);
                        }
                    } catch (NoSuchFieldException e) {
                        e.getStackTrace();
                    }
                });
            }
        } catch (JSONException e) {
            e.getStackTrace();
        }
        return null;
    }*/
}