package edu.redcom.main;

import edu.redcom.constant.EvaConstant;
import edu.redcom.dao.JscxDao;
import edu.redcom.util.MD5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 为中层干部评测生成账号的评测数据
 */
public class EvaInitial {

    public static final int ACCT_COUNT = 10;      //生成的账号数量
    public static final String NAMS_SUFFIC = "FXY"; //账号名称前缀

    public static void main(String[] args){
        //System.out.println(EvaConstant.zhongceng.length);

        List<String> evaAccounts = new ArrayList<>();
        //1.生成评测账号
        for(int i = 1;i<ACCT_COUNT + 1; i++){
            String accName = "";
            if(i<10){
                accName = NAMS_SUFFIC + "00" + i;
            }
            else if (i>=10 && i<100){
                accName = NAMS_SUFFIC + "0" + i;
            }else{
                accName = NAMS_SUFFIC + i;
            }
            //System.out.println(accName);
            evaAccounts.add(accName);
        }

        //2.根据待评测中层的数据向数据库生成评测数据
        int j = 0;
        for(String name : evaAccounts) {
            //生成t_user 和 t_user_role的数据
            String password = getGandomSix();
            JscxDao.addEvaUser(name,"评测账号",MD5.crypt(password));

            //生成t_evaluate_record表的数据
            for (String[] t : EvaConstant.zhongceng) {
                //System.out.println(t[0] + t[1]);
                JscxDao.addEvaRecord(name,t[0],t[1]);
            }
            j++ ;
            /*if(j%10 == 0)
                System.out.println("生成中，生成账号:" + j + "个账号结束");*/
            System.out.println( name + "  " + password );

        }
        System.out.println("生成账号结束，共生成账号:" + j + "个。");
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
