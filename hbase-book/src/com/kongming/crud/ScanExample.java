package com.kongming.crud;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 说明:
 * User: kongming
 * Date: 2015/4/23
 * Time: 20:49
 */
public class ScanExample {


    public static void main(String[] args) throws IOException {

        HBaseHelper helper = HBaseHelper.getDefaultHelper();

        HTable table = new HTable(HBaseHelper.configuration, "hbasetest");

        Scan  scan = new Scan();
        ResultScanner resultScanner = table.getScanner(scan);

        System.out.println("scanning table #1");

        for(Result res: resultScanner){
            System.out.println(res);
        }

        System.out.println(" #1  end");


        /**
         * 置顶列蔟  减少网络io 面向列的好处
         */
        Scan scan2 = new Scan();
        scan2.addFamily(Bytes.toBytes("colfam1"));
        ResultScanner resultScanner1 = table.getScanner(scan2);
        for(Result result : resultScanner1){
            System.out.println(result);
        }
        System.out.println(" #2  end");


        Scan scan1= new Scan();
        scan1.addColumn(Bytes.toBytes("colfam1"),Bytes.toBytes("qual1")).setStartRow(Bytes.toBytes("row2")).setStopRow(Bytes.toBytes("row2"));
        ResultScanner resultScanner2 = table.getScanner(scan1);
        for (Result result : resultScanner2) {
            System.out.println(result);
        }
        System.out.println(" #3  end");

    }

}
