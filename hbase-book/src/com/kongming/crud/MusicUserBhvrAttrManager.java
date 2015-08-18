package com.kongming.crud;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 * User: kongming
 * Date: 2015/5/8
 * Time: 9:51
 */
public class MusicUserBhvrAttrManager {




    public static void main(String[] args) {
        HTable table = HBaseHelper.obtainHTable("music_user_bhvr_attr");
        //fillAttrFamily(table);
        //fillBhvrFamily(table);
        String[] rows = {"userid1"};
        String[] fams = {"bhvr"};
        String[] quals = {""};

        //scanTs(table);

        //scanPage(table);


        scanVersions(table);


    }


    /**
     * 查询某一行某个时间跨度 例如 最近三个月内的 所有数据版本
     * 如何分页
     * @param table
     */
    private static void scanVersions(HTable table) {
        Get get = new Get(Bytes.toBytes("userid2"));
        get.addFamily(Bytes.toBytes("bhbr"));
        long ts = System.currentTimeMillis();
        long startTime = ts - 1000 * 60 * 60 * 24 * 10;
        long endTime =  ts - 1000 * 60 * 60 * 24 * 5;
        System.out.println("startTime = " + new Date(startTime));
        System.out.println("endTime = " + new Date(endTime));
        ResultScanner resultScanner = null;
        try {

            get.setTimeRange(startTime,endTime);
            Scan scan = new Scan(get);

            scan.setMaxVersions();
            resultScanner =  table.getScanner(scan);
            for (Result result : resultScanner) {
                final List<KeyValue> list = result.list();
                for (KeyValue keyValue : list) {
                    System.out.println("key:" + keyValue + ", value :" + Bytes.toString(keyValue.getValue()) + " , ts :" + new Date(keyValue.getTimestamp()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *  按行分页查询  需要传入 startrow
     * @param table
     */
    private static void scanPage(HTable table) {
        Filter pageFilter = new PageFilter(10);
        Scan scan = new Scan();
        scan.setFilter(pageFilter);
        scan.setStartRow(Bytes.toBytes("userid2"));
        ResultScanner resultScanner = null;
        try {
            resultScanner =  table.getScanner(scan);
            for (Result result : resultScanner) {
                final List<KeyValue> list = result.list();
                for (KeyValue keyValue : list) {
                    System.out.println("key:" + keyValue + ", value :" + Bytes.toString(keyValue.getValue()) + " , ts :" + new Date(keyValue.getTimestamp()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (resultScanner != null) {
                resultScanner.close();
            }
        }
    }

    //




    /**
     *
     * 按时间范围查询
     * 返回的版本是 endtime 之前的最新版本
     * @param table
     */
    private static void scanTs(HTable table) {
        long ts = System.currentTimeMillis();
        long startTime = ts - 1000 * 60 * 60 * 24 * 10;
        long endTime =  ts - 1000 * 60 * 60 * 24 * 5;
        System.out.println("startTime = " + new Date(startTime));
        System.out.println("endTime = " + new Date(endTime));
        //simpleGet(table);
        Scan scan = new Scan();
        ResultScanner resultScanner = null;
        try {
            scan.setTimeRange(startTime,endTime);
            scan.addFamily(Bytes.toBytes("bhbr"));
            scan.addFamily(Bytes.toBytes("attr"));
            scan.setBatch(0);
            scan.setCaching(10000);
            resultScanner =  table.getScanner(scan);
            for (Result result : resultScanner) {
                final List<KeyValue> list = result.list();
                for (KeyValue keyValue : list) {
                    System.out.println("key:" + keyValue + ", value :" + Bytes.toString(keyValue.getValue()) + " , ts :" + new Date(keyValue.getTimestamp()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resultScanner!=null){
                resultScanner.close();
            }

        }
    }

    //=======简单检索






    /**
     * 按照rowkey查询
     * @param table
     */
    private static void simpleGet(HTable table) {
        Get get = new Get(Bytes.toBytes("userid1"));
        get.addColumn(Bytes.toBytes("bhbr"),Bytes.toBytes("uid"));
        get.addColumn(Bytes.toBytes("attr"),Bytes.toBytes("username"));
        try {
            Result result = table.get(get);
            for (KeyValue keyValue : result.raw()) {
                System.out.println("kv :" + keyValue + ", value :" + Bytes.toString(keyValue.getValue()) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void get(HTable table, String[] rows, String[] fams, String[] quals)
            throws IOException {

        List<Get> gets = new ArrayList<Get>();
        for (String row : rows) {
            Get get = new Get(Bytes.toBytes(row));
            get.setMaxVersions();
            if (fams != null) {
                for (String fam : fams) {
                    for (String qual : quals) {
                        get.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual));
                    }
                }
            }
            gets.add(get);
        }
        Result[] results = table.get(gets);
        for (Result result : results) {
            for (KeyValue kv : result.raw()) {
                System.out.println("KV: " + kv +
                        ", Value: " + Bytes.toString(kv.getValue()));
            }
        }
    }








    //--------------数据填充阶段 填充数据


    private static void fillBhvrFamily(HTable table) {
        List<Put> putList = new ArrayList<Put>();
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String rowKey = "userid" + i;
            Put put = new Put(Bytes.toBytes(rowKey));
            for (int j = 0; j < 100; j++) {
                long ts1 = ts - 1000 * 60 * 60 * 24 * j;
                put.add(Bytes.toBytes("bhbr"),Bytes.toBytes("uid"), ts1,Bytes.toBytes("userid" + i));
                put.add(Bytes.toBytes("bhbr"),Bytes.toBytes("vid"),ts1,Bytes.toBytes("musicid" + j));
                put.add(Bytes.toBytes("bhbr"),Bytes.toBytes("downid"),ts1,Bytes.toBytes("down" + j));
                putList.add(put);
            }

        }

        try {
            table.put(putList);
        } catch (InterruptedIOException e) {
            e.printStackTrace();
        } catch (RetriesExhaustedWithDetailsException e) {
            e.printStackTrace();
        }
    }

    private static void fillAttrFamily(HTable table) {
        List<Put> putList = new ArrayList<Put>();

        long ts = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
             String rowKey = "userid" + i;
             Put put = new Put(Bytes.toBytes(rowKey));
             put.add(Bytes.toBytes("attr"),Bytes.toBytes("username"),ts,Bytes.toBytes("thushear" + i));
             put.add(Bytes.toBytes("attr"),Bytes.toBytes("age"),ts,Bytes.toBytes(10 + i));
            putList.add(put);
        }

        try {
            table.put(putList);
        } catch (InterruptedIOException e) {
            e.printStackTrace();
        } catch (RetriesExhaustedWithDetailsException e) {
            e.printStackTrace();
        }
    }


}
