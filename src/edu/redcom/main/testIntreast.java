package edu.redcom.main;

/**
 * 计算信用卡的刷卡利息  【闪付+正常组合】
 */
public class testIntreast {

    public static void main(String[] args){
        int[] xe = {3000,3000,3000,3000,3000,3000};
        double[] ll = {2.774,2.83,2.89,2.95,3.01,3.08};
        int de = 20000;
        double dell = 4.09;
        double sum1 = 0;
        double sum2 = 0;
        for(int i=0;i<xe.length;i++){
           sum1 += xe[i] * ll[i];
           sum2 += xe[i];
        }
        //加上大额的输入
        sum1 += de * dell;
        sum2 += de;
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum1/sum2);
    }




}
