package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class Serializador<T> {

    public void Serializar(T x, String path) throws IOException {
        File file = new File(path + "mi_archivo.json");

        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(Telefono.class, new AbstractTelefonoAdapter());
        Gson gson = gsonBilder.create();

        //Serializo
        Type listType = new TypeToken<T>(){}.getType();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        gson.toJson(x, listType, bufferedWriter);
        bufferedWriter.close();
    }

    public T Deserializar(String path, Class<T> elementClass) throws FileNotFoundException {
        File file = new File(path + "mi_archivo.json");

        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(Telefono.class, new AbstractTelefonoAdapter());
        Gson gson = gsonBilder.create();

        //Deserializo
        Type listType = new TypeToken<List<T>>(){}
                .where(new TypeParameter<T>(){}, elementClass).getType();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        return gson.fromJson(bufferedReader, listType);
    }
}
