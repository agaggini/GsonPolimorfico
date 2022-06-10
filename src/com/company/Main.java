package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Telefono telefono1 = new TelefonoFijo("4588754", "223", "549");
        Telefono telefono2 = new TelefonoCelular("155478598", "2234", "548", true);
        List<Telefono> telefonos = new ArrayList<Telefono>();
        telefonos.add(telefono1);
        telefonos.add(telefono2);
        Domicilio domicilio1 = new Domicilio("Calle Falsa", 123);
        Cliente cliente1 = new Cliente("Pepe", "Luis", 55, domicilio1, telefonos);
        cliente1.setFechaNacimiento(LocalDate.now());

        Telefono telefono3 = new TelefonoFijo("4588754", "223", "549");
        Telefono telefono4 = new TelefonoFijo("155478598", "2234", "548");
        List<Telefono> telefonos2 = new ArrayList<Telefono>();
        telefonos2.add(telefono3);
        telefonos2.add(telefono4);
        Domicilio domicilio2 = new Domicilio("Calle Falsa", 123);
        Cliente cliente2 = new Cliente("Pepe Dos", "Luis", 55, domicilio2, telefonos2);

        clientes.add(cliente1);
        clientes.add(cliente2);

        String path = "C:\\Users\\DELL\\Desarrollo\\UTN\\Prog3\\Gson_Polimorfico\\files\\";

        Serializador ser = new Serializador<ArrayList<Cliente>>();

        try {
            ser.Serializar(clientes, path);

            List<Cliente> clientes2 = (ArrayList<Cliente>) ser.Deserializar(path);
            System.out.println(clientes2.get(0).toString());

        } catch (IOException e) {
            System.out.println("No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
        finally {

        }
    }
}
