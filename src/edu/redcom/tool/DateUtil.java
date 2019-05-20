package edu.redcom.tool;

import edu.redcom.constant.EvaConstant;
import edu.redcom.dao.JscxDao;
import edu.redcom.util.MD5;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 */
public class DateUtil {



    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = sdf.parse("2019-04-01");
        Date end = sdf.parse("2019-05-20");
        Date temp = begin;

        for(;temp.compareTo(end)==-1||temp.compareTo(end)==0;){

            Calendar c = Calendar.getInstance();
            c.setTime(temp);
            c.add(Calendar.DAY_OF_MONTH, 1);
            temp = c.getTime();
            Format f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("生成日期：    " +f.format(temp));
        }

    }



    public static String getGandomSix(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }
}
