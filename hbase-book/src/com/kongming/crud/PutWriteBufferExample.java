package com.kongming.crud;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 说明:
 * User: kongming
 * Date: 15-1-28
 * Time: 下午4:31
 */
public class PutWriteBufferExample {


    /**
     * hbase 客户端设置为autoflush=false则会先把要提交到hbase的数据放在本地缓存
     * 等到flush的时候才提交
     * 导致了下边的输出
     *
     * auto flush :true
       Result :keyvalues=NONE
       result: keyvalues={row1/basic:qua1/1422463590582/Put/vlen=4/mvcc=0, row1/basic:qua2/1422463590582/Put/vlen=4/mvcc=0}
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HBaseHelper helper = HBaseHelper.getDefaultHelper();
        helper.dropTable("hbasetest");
        helper.createTable("hbasetest","basic");
        HTable table = new HTable(HBaseHelper.configuration,"hbasetest");
        System.out.println("auto flush :" + table.isAutoFlush());
        table.setAutoFlush(false);
        Put put1 = new Put(Bytes.toBytes("row1"));
        put1.add(Bytes.toBytes("basic"), Bytes.toBytes("qua1"), Bytes.toBytes("val1"));
        table.put(put1);
        Put put2 = new Put(Bytes.toBytes("row2"));
        put1.add(Bytes.toBytes("basic"),Bytes.toBytes("qua2"),Bytes.toBytes("val1"));
        table.put(put2);

        Get get = new Get(Bytes.toBytes("row1"));
        Result res  =  table.get(get);
        System.out.println("Result :" + res);

        table.flushCommits();
        res  =  table.get(get);
        System.out.println("result: " + res);


    }



}
