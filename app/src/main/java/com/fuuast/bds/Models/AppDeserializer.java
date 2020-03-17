package com.fuuast.bds.Models;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class AppDeserializer <T> implements JsonDeserializer<T>
{
    @Override
    public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        Log.i("myAppDeserializer",je.getAsString());
        // Get the "content" element from the parsed JSON
        JsonElement content = je.getAsJsonObject().get("Data");
        //JsonArray content = je.getAsJsonArray();

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(content, type);

    }
}