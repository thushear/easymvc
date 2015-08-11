package com.kongming.crud;

import com.kongming.util.HBaseHelper;

import java.io.IOException;

/**
 * 说明:
 * User: kongming
 * Date: 15-1-28
 * Time: 下午4:58
 */
public class PutListExample {


    /**
     * hbase client  put(List)
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HBaseHelper helper = HBaseHelper.getDefaultHelper();
        helper.dropTable("rebate_order_finish_mq");
        helper.createTable("rebate_order_finish_mq", "b");
       /* HTable table = new HTable(HBaseHelper.configuration, "hbasetest");
        table.setAutoFlush(false);
        // vv PutListExample
        List<Put> puts = new ArrayList<Put>()*/; // co PutListExample-1-CreateList Create a list that holds the Put instances.


        /**
         * 正确
         */
        /*Put put1 = new Put(Bytes.toBytes("row1"));
        put1.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val1"));
        puts.add(put1); // co PutListExample-2-AddPut1 Add put to list.

        Put put2 = new Put(Bytes.toBytes("row2"));
        put2.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val2"));
        puts.add(put2); // co PutListExample-3-AddPut2 Add another put to list.

        Put put3 = new Put(Bytes.toBytes("row2"));
        put3.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"),
                Bytes.toBytes("val3"));
        puts.add(put3); // co PutListExample-4-AddPut3 Add third put to list.

        table.put(puts); // co PutListExample-5-DoPut Store multiple rows with columns into HBase.
*/


        /**
         * 列族不存在错误
         * Exception in thread "main" org.apache.hadoop.hbase.client.RetriesExhaustedWithDetailsException: Failed 1 action: org.apache.hadoop.hbase.regionserver.NoSuchColumnFamilyException: Column family BOGUS does not exist in region hbasetest,,1422464606112.cfff90c3f7d2f5712a0b89c16b474824. in table 'hbasetest', {NAME => 'basic', DATA_BLOCK_ENCODING => 'NONE', BLOOMFILTER => 'ROW', REPLICATION_SCOPE => '0', COMPRESSION => 'NONE', VERSIONS => '1', TTL => '2147483647', MIN_VERSIONS => '0', KEEP_DELETED_CELLS => 'false', BLOCKSIZE => '65536', IN_MEMORY => 'false', BLOCKCACHE => 'true'}, {NAME => 'colfam1', DATA_BLOCK_ENCODING => 'NONE', BLOOMFILTER => 'ROW', REPLICATION_SCOPE => '0', COMPRESSION => 'NONE', VERSIONS => '1', TTL => '2147483647', MIN_VERSIONS => '0', KEEP_DELETED_CELLS => 'false', BLOCKSIZE => '65536', IN_MEMORY => 'false', BLOCKCACHE => 'true'}
         */
        // vv PutListErrorExample1
        /*Put put1 = new Put(Bytes.toBytes("row1"));
        put1.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val1"));
        puts.add(put1);
        Put put2 = new Put(Bytes.toBytes("row2"));
    *//*[*//*put2.add(Bytes.toBytes("BOGUS"),*//*]*//* Bytes.toBytes("qual1"),
                Bytes.toBytes("val2")); // co PutListErrorExample1-1-AddErrorPut Add put with non existent family to list.
        puts.add(put2);
        Put put3 = new Put(Bytes.toBytes("row2"));
        put3.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"),
                Bytes.toBytes("val3"));
        puts.add(put3);

        table.put(puts); // co PutListErrorExample1-2-DoPut Store multiple rows with columns into HBase.*/
        // ^^ PutListErrorExample1


        /**
         * 提交的時候部分錯誤   正确行提交成功
         */
        // vv PutListErrorExample2
      /*  Put put1 = new Put(Bytes.toBytes("row1"));
        put1.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val1"));
        puts.add(put1);
        Put put2 = new Put(Bytes.toBytes("row2"));
        put2.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
                Bytes.toBytes("val2"));
        puts.add(put2);
        Put put3 = new Put(Bytes.toBytes("row2"));
        put3.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"),
                Bytes.toBytes("val3"));
        puts.add(put3);
    *//*[*//*
        Put put4 = new Put(Bytes.toBytes("row2"));
        puts.add(put4);*//*]*//* // co PutListErrorExample2-1-AddErrorPut Add put with no content at all to list.

    *//*[*//*
        try {*//*]*//*
            table.put(puts);
    *//*[*//*
        } catch (Exception e) {
            System.err.println("Error: " + e);
            try {
                table.flushCommits();*//*]*//* // co PutListErrorExample2-2-Catch Catch local exception and commit queued updates.
            } catch (InterruptedIOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (RetriesExhaustedWithDetailsException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
    *//*[*//*
        }*//*]*//*
        // ^^ PutListErrorExample2

        String[] rows = new String[]{"row1", "row2"};
        String[] fams = new String[]{"colfam1"};
        String[] quas = new String[]{"qual1", "qual2"};

        helper.dump("hbasetest", rows, fams, quas);
*/
    }
}
