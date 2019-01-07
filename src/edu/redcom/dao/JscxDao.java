package edu.redcom.dao;

import edu.redcom.model.EvaluateRecord;
import edu.redcom.model.EvaluateStatistics;
import edu.redcom.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JscxDao {
    /**
     * 生成中层干部评测账号
     * @param dah
     * @param passowrd
     */
    public static void addEvaUser(String dah,String ygxm,String passowrd) {
        String sql = "insert into t_user(dah,ygxm,mjkkh,sex,mobile,email,sfzh,password,gwdj,flag,bz,pysx,pyqp,px) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sql2 = "insert into t_user_role(dah,role_id)" + "values(?,?)";
        String sql3 = "insert into t_dept_user(dah,jgh) values(?,?) ";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            pstmt = connection.prepareStatement(sql2);
            pstmt.setString(1, dah);
            pstmt.setInt(2, 2);
            pstmt.execute();

            pstmt = connection.prepareStatement(sql3);
            pstmt.setString(1, dah);
            pstmt.setString(2, "001");
            pstmt.execute();

            pstmt = connection.prepareStatement(sql);
            // 自定义数据
            pstmt.setString(1, dah);
            pstmt.setString(2, ygxm);
            pstmt.setString(3, "0");
            pstmt.setString(4, "M");
            pstmt.setString(5, "111");
            pstmt.setString(6, "111");
            pstmt.setString(7, "111");
            pstmt.setString(8, passowrd);   //密码
            pstmt.setString(9, "eva");   //岗位等级
            pstmt.setString(10, "0");    //flag
            pstmt.setString(11, "0");    //bz
            pstmt.setString(12, "1");
            pstmt.setString(13, "1");
            pstmt.setString(14, "1");
            // 自定义数据 END
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
            JDBCUtil.close(pstmt);
            JDBCUtil.close(rs);
        }
    }

    /**
     * 生成中层干部评测数据
     * @param dah
     * @param eva_dah
     * @param eva_zw
     */
    public static void addEvaRecord(String dah,String eva_dah,String eva_zw) {
        String sql = "insert into t_evaluate_record(dah,eva_dah,eva_zw,zzsx,ywzs,gztd,wcgz,zjsf,zhpj,rzjy,finished,eva_year) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            pstmt = connection.prepareStatement(sql);
            // 自定义数据
            pstmt.setString(1, dah);
            pstmt.setString(2, eva_dah);
            pstmt.setString(3, eva_zw);
            pstmt.setDouble(4, 0.0);
            pstmt.setDouble(5, 0.0);
            pstmt.setDouble(6, 0.0);
            pstmt.setDouble(7, 0.0);
            pstmt.setDouble(8, 0.0);
            pstmt.setDouble(9, 0.0);
            pstmt.setDouble(10, 0.0);
            pstmt.setInt(11, 0);
            pstmt.setString(12, "2018");
            // 自定义数据 END
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
            JDBCUtil.close(pstmt);
            JDBCUtil.close(rs);
        }
    }


    public static void addEvaRecordStatistics(EvaluateStatistics es, int count, String year) {
        String sql = "insert into t_evaluate_record_statistics(eva_dah,eva_zw,zzsx1,zzsx2,zzsx3,zzsx4,ywzs1,ywzs2,ywzs3,ywzs4,gztd1,gztd2,gztd3," +
                "gztd4,wcgz1,wcgz2,wcgz3,wcgz4,zjsf1,zjsf2,zjsf3,zjsf4,zhpj1,zhpj2,zhpj3,zhpj4," +
                "rzjy1,rzjy2,rzjy3,rzjy4,zongji,eva_year) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtil.getConnection();
            pstmt = connection.prepareStatement(sql);
            // 自定义数据
            pstmt.setString(1, es.evaDah);
            pstmt.setString(2, es.zw);
            pstmt.setInt(3,es.zzsx[0]) ;
            pstmt.setInt(4,es.zzsx[1]);
            pstmt.setInt(5,es.zzsx[2]);
            pstmt.setInt(6,es.zzsx[3]);
            pstmt.setInt(7,es.ywzs[0]) ;
            pstmt.setInt(8,es.ywzs[1]);
            pstmt.setInt(9,es.ywzs[2]);
            pstmt.setInt(10,es.ywzs[3]);
            pstmt.setInt(11,es.gztd[0]) ;
            pstmt.setInt(12,es.gztd[1]);
            pstmt.setInt(13,es.gztd[2]);
            pstmt.setInt(14,es.gztd[3]);
            pstmt.setInt(15,es.wcgz[0]) ;
            pstmt.setInt(16,es.wcgz[1]);
            pstmt.setInt(17,es.wcgz[2]);
            pstmt.setInt(18,es.wcgz[3]);
            pstmt.setInt(19,es.zjsf[0]) ;
            pstmt.setInt(20,es.zjsf[1]);
            pstmt.setInt(21,es.zjsf[2]);
            pstmt.setInt(22,es.zjsf[3]);
            pstmt.setInt(23,es.zhpj[0]) ;
            pstmt.setInt(24,es.zhpj[1]);
            pstmt.setInt(25,es.zhpj[2]);
            pstmt.setInt(26,es.zhpj[3]);
            pstmt.setInt(27,es.rzjy[0]) ;
            pstmt.setInt(28,es.rzjy[1]);
            pstmt.setInt(29,es.rzjy[2]);
            pstmt.setInt(30,es.rzjy[3]);
            pstmt.setInt(31,count);
            pstmt.setString(32,year);
            // 自定义数据 END
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
            JDBCUtil.close(pstmt);
            JDBCUtil.close(rs);
        }
    }

    public static List<EvaluateRecord> findRecordByEvaDah(String dah) {
        List<EvaluateRecord> records = new ArrayList();
        EvaluateRecord record = null;
        Connection connection = null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql = "select * from t_evaluate_record where eva_dah = ?";
        try {
            connection = JDBCUtil.getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,dah);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                record = new EvaluateRecord();
                record.setEvaDah(rs.getString(3));
                record.setZzsx(rs.getDouble(5));
                record.setYwzs(rs.getDouble(6));
                record.setGztd(rs.getDouble(7));
                record.setWcgz(rs.getDouble(8));
                record.setZjsf(rs.getDouble(9));
                record.setZhpj(rs.getDouble(10));
                record.setRzjy(rs.getDouble(11));
                //record.setWcgz(rs.getDouble(5));
                records.add(record);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(connection);
            JDBCUtil.close(pstmt);
            JDBCUtil.close(rs);
        }
        return records;
    }
}
