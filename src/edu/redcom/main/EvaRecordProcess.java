package edu.redcom.main;

import edu.redcom.constant.EvaConstant;
import edu.redcom.dao.JscxDao;
import edu.redcom.model.EvaluateRecord;
import edu.redcom.model.EvaluateStatistics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 2018中层干部评测数据的处理
 * @Author: redcomet
 * @Date: 2019-01-03-20:37
 */

public class EvaRecordProcess {

    public static void main (String args[]){


        System.out.println("Data Process Begin...");

        for (String[] t : EvaConstant.zhongceng) {
            //JscxDao.addEvaRecord(name,t[0],t[1]);
            //对每一个中层，干部，我们需要去查询到他的评测数据进行统计

        }

        process("00997","job_test");


        System.out.println("Data Process End...");
    }



private static void process(String dah, String job)
{
    List<EvaluateRecord> records = new ArrayList();
    EvaluateStatistics es;

    es = new EvaluateStatistics();
    records = JscxDao.findRecordByEvaDah(dah);

    es.evaDah = dah ;
    es.zw = job;

    for(EvaluateRecord record : records){

        switch(record.getZzsx().intValue()){
            case 1:
                es.zzsx[0] ++ ;
                break;
            case 2:
                es.zzsx[1] ++ ;
                break;
            case 3:
                es.zzsx[2] ++ ;
                break;
            case 4:
                es.zzsx[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getYwzs().intValue()){
            case 1:
                es.ywzs[0] ++ ;
                break;
            case 2:
                es.ywzs[1] ++ ;
                break;
            case 3:
                es.ywzs[2] ++ ;
                break;
            case 4:
                es.ywzs[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getGztd().intValue()){
            case 1:
                es.gztd[0] ++ ;
                break;
            case 2:
                es.gztd[1] ++ ;
                break;
            case 3:
                es.gztd[2] ++ ;
                break;
            case 4:
                es.gztd[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getWcgz().intValue()){
            case 1:
                es.wcgz[0] ++ ;
                break;
            case 2:
                es.wcgz[1] ++ ;
                break;
            case 3:
                es.wcgz[2] ++ ;
                break;
            case 4:
                es.wcgz[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getZjsf().intValue()){
            case 1:
                es.zjsf[0] ++ ;
                break;
            case 2:
                es.zjsf[1] ++ ;
                break;
            case 3:
                es.zjsf[2] ++ ;
                break;
            case 4:
                es.zjsf[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getZhpj().intValue()){
            case 1:
                es.zhpj[0] ++ ;
                break;
            case 2:
                es.zhpj[1] ++ ;
                break;
            case 3:
                es.zhpj[2] ++ ;
                break;
            case 4:
                es.zhpj[3] ++ ;
                break;
            case 0:
                break;
        }

        switch(record.getRzjy().intValue()){
            case 1:
                es.rzjy[0] ++ ;
                break;
            case 2:
                es.rzjy[1] ++ ;
                break;
            case 3:
                es.rzjy[2] ++ ;
                break;
            case 4:
                es.rzjy[3] ++ ;
                break;
            case 0:
                break;
        }


    }
    System.out.println("Data Process Count: " + records.size());
    JscxDao.addEvaRecordStatistics(es, records.size(), "2018");
}
}