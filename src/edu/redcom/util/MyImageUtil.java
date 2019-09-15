package edu.redcom.util;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author Administrator
 * @title: MyImageUtil
 * @projectName njfu
 * @description: TODO
 * @date 2019/9/15 00159:50
 */
public class MyImageUtil {

    //参考来源 https://blog.csdn.net/xiao__jia__jia/article/details/79307767
    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,String filePath)
    {  //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        //imgStr.replace("","");
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
