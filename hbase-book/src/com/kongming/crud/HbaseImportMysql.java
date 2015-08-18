package com.kongming.crud;

import com.kongming.util.DBUtils;
import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 说明: 从mysql导出数据到hbase
 * User: kongming
 * Date: 2015/5/6
 * Time: 14:46
 */
public class HbaseImportMysql {


    public static void main(String[] args) throws IOException {

        HTable table = HBaseHelper.obtainHTable("hly_temp");
        Connection connection;
        Statement stmt = null;
        String query = "select * from hly_temp_normal";

        connection = DBUtils.connectToDefaultDB();

        byte[] family  = Bytes.toBytes("n");
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // hbase cell  version
            long ts = System.currentTimeMillis();
            while (rs.next()){
                String stnid = rs.getString("stnid");
                int month = rs.getInt("month");
                int day = rs.getInt("day");
                String rowKey = stnid + String.valueOf(month) + String.valueOf(day);
                Put p = new Put(Bytes.toBytes(rowKey));

                for (int i = 5;i<29;i++){
                    String column = "v" + String.valueOf(i - 4);
                    String value = rs.getString(i);
                    p.add(family,Bytes.toBytes(column),ts,Bytes.toBytes(value));
                }
                table.put(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (table != null){
                table.close();
            }

        }


    }


}
