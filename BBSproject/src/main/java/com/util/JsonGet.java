package com.util;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JsonGet {
    public static String getString(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String jsonString = null;
        InputStreamReader isr= new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8 );
        BufferedReader bufferedReader = new BufferedReader(isr);
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            stringBuilder.append(str);
        }
        jsonString = stringBuilder.toString();
        return jsonString;}

    public static void backString(Map map, HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        Gson gs=new Gson();
        String jsonStr=gs.toJson(map);
        out.println(jsonStr);
        out.flush();
    }
}
