package edu.redcom.tool;

import java.util.Random;

public class RandomS {
    public static void main(String[] args){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        System.out.println(result);
    }


}
