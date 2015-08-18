package com.kongming.count;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Increment;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 说明:
 * User: kongming
 * Date: 2015/4/23
 * Time: 21:26
 */
public class BasicIncr {


    public static void main(String[] args) throws IOException {
        HBaseHelper helper = HBaseHelper.getDefaultHelper();
       /* helper.dropTable("hits");
        helper.createTable("hits", "daily", "colfam1");*/
        HTable table = new HTable(HBaseHelper.configuration, "hits");
        /**
         *  单计数器
         */
        long cnt1 =  table.incrementColumnValue(Bytes.toBytes("1"),Bytes.toBytes("daily"),Bytes.toBytes("20150423"),1);
        System.out.println("cnt1 = " + cnt1);
        long cnt2 =  table.incrementColumnValue(Bytes.toBytes("1"),Bytes.toBytes("daily"),Bytes.toBytes("20150423"),1);
        System.out.println("cnt2 = " + cnt2);
        long cnt3 =  table.incrementColumnValue(Bytes.toBytes("1"),Bytes.toBytes("daily"),Bytes.toBytes("20150423"),1);
        System.out.println("cnt3 = " + cnt3);
        long cnt4 =  table.incrementColumnValue(Bytes.toBytes("1"),Bytes.toBytes("daily"),Bytes.toBytes("20150423"),-121);
        System.out.println("cnt4 = " + cnt4);


        /**
         * 多坐标计数器
         */

        Increment increment = new Increment(Bytes.toBytes("1"));
        increment.addColumn(Bytes.toBytes("daily"),Bytes.toBytes("20150423"),1000)
                .addColumn(Bytes.toBytes("colfam1"),Bytes.toBytes("20150423"),1000);

        Result result =  table.increment(increment);
        for (KeyValue keyValue : result.raw()) {
            System.out.println("keyValue = " + keyValue + "  value :" + Bytes.toLong(keyValue.getValue()));
        }


    }

}
