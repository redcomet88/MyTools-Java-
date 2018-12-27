package edu.redcom.tool;

import edu.redcom.constant.EvaConstant;
import edu.redcom.dao.JscxDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 为中层干部评测生成账号的评测数据
 */
public class EvaInitial {

    public static final int ACCT_COUNT = 25;      //生成的账号数量


    public static void main(String[] args){
        //System.out.println(EvaConstant.zhongceng.length);

        List<String> evaAccounts = new ArrayList<>();
        //1.生成评测账号
        for(int i = 1;i<ACCT_COUNT + 1; i++){
            String accName = "";
            if(i<=10){
                accName = "PC" + "00" + i;
            }
            else if (i>10 && i<100){
                accName = "PC" + "0" + i;
            }else{
                accName = "PC" + i;
            }
            //System.out.println(accName);
            evaAccounts.add(accName);
        }

        //2.根据待评测中层的数据向数据库生成评测数据
        int j = 0;
        for(String name : evaAccounts) {
            //生成t_user 和 t_user_role的数据
            JscxDao.addEvaUser(name,"评测账号","e10adc3949ba59abbe56e057f20f883e");

            //生成t_evaluate_record表的数据
            for (String[] t : EvaConstant.zhongceng) {
                //System.out.println(t[0] + t[1]);
                JscxDao.addEvaRecord(name,t[0],t[1]);
            }
            j++ ;
            if(j%10 == 0)
                System.out.println("生成中，生成账号:" + j + "个账号结束");
        }
        System.out.println("生成账号结束，共生成账号:" + j + "个。");
    }
}
