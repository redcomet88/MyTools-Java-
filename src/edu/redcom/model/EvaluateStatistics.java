package edu.redcom.model;

/**
 * @Description: 中层评测结果的统计
 * @Author: redcomet
 * @Date: 2019-01-03-20:53
 */

public class EvaluateStatistics {

    public String evaDah;
    public String zw;

    public int zzsx[];  //政治思想和道德品质
    public int ywzs[];  //业务知识和管理技术水平
    public int gztd[];  //工作态度和勤奋敬业
    public int wcgz[];  //完成工作量等
    public int zjsf[];  //遵纪守法、廉洁自律
    public int zhpj[];  //综合评价
    public int rzjy[];  //任职建议

    public  EvaluateStatistics(){
        //zzsx1 = new int[]{0,0,0,0};
        zzsx = new int[4];
        ywzs = new int[4];
        gztd = new int[4];
        wcgz = new int[4];
        zjsf = new int[4];
        zhpj = new int[4];
        rzjy = new int[4];
    }

}
