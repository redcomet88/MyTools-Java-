package edu.redcom.dao;

import edu.redcom.util.JDBCUtil;

import java.sql.*;

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
}
