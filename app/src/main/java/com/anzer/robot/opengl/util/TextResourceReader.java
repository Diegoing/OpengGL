package com.anzer.robot.opengl.util;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName: TextResourceReader
 * @Description: java类作用描述
 * @Author: zhouqiande
 * @Date: 2020/6/17 17:49
 */
public class TextResourceReader {

    public static String readTextFileFromResource(Context context,int resourceId)  {
        StringBuilder body = new StringBuilder();
        try{
            InputStream inputStream = context.getResources().openRawResource(resourceId);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String nextLine;
            while((nextLine = bufferedReader.readLine())!= null){
                body.append(nextLine);
                body.append("\n");
            }
        }catch (IOException o){
            throw new RuntimeException("Could not open resoure :" + resourceId,o);
        }catch (Resources.NotFoundException nfe){
            throw new RuntimeException("Resource not found :" + resourceId,nfe);
        }


        return body.toString();
    }
}
