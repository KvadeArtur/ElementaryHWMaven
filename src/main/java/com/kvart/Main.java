package com.kvart;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        1) Создать проект Maven. В корень проекта положить текстовый файл.
        Распарсить этот JSON и вывести обьекты через println().
         */

        Gson gson = new Gson();

        StringBuilder sb = new StringBuilder();
        readFromFile(sb);
        String json = sb.toString();
        Group restoredGroup = gson.fromJson(json, Group.class);
        System.out.println(restoredGroup);

        /*
        2*) Используя библиотеку Jackson сериализовать полученные обьекты
        в формате XML и записать в другой файл.
         */

        XmlMapper mapper = new XmlMapper();

        javaSerializedToXmlFile(restoredGroup);
    }

    private static void readFromFile(StringBuilder sb) {
        try (BufferedReader br = new BufferedReader(new FileReader("TextJson.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void javaSerializedToXmlFile(Group group) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("Group_java.xml");
        xmlMapper.writeValue(file, group);
    }
}
