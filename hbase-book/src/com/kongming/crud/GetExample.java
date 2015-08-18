package com.kongming.crud;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 说明:
 * User: kongming
 * Date: 15-1-29
 * Time: 上午11:39
 */
public class GetExample {

    public static void main(String[] args) throws IOException {

        HBaseHelper helper = HBaseHelper.getDefaultHelper();

        HTable table = new HTable(HBaseHelper.configuration, "hbasetest");

        /*Get get = new Get(Bytes.toBytes("row1"));
        get.addColumn(Bytes.toBytes("colfam1"),Bytes.toBytes("qual1"));

        Result result = table.get(get);

        byte[] val = result.getValue(Bytes.toBytes("colfam1"),Bytes.toBytes("qual1"));

        System.out.println("value:" + Bytes.toString(val));*/

        // vv GetListExample
     /*   byte[] cf1 = Bytes.toBytes("colfam1");
        byte[] qf1 = Bytes.toBytes("qual1");
        byte[] qf2 = Bytes.toBytes("qual2"); // co GetListExample-1-Prepare Prepare commonly used byte arrays.
        byte[] row1 = Bytes.toBytes("row1");
        byte[] row2 = Bytes.toBytes("row2");

        List<Get> gets = new ArrayList<Get>();  // co GetListExample-2-CreateList Create a list that holds the Get instances.

        Get get1 = new Get(row1);
        get1.addColumn(cf1, qf1);
        gets.add(get1);

        Get get2 = new Get(row2);
        get2.addColumn(cf1, qf1); // co GetListExample-3-AddGets Add the Get instances to the list.
        gets.add(get2);

        Get get3 = new Get(row2);
        get3.addColumn(cf1, qf2);
        gets.add(get3);

        Result[] results = table.get(gets); // co GetListExample-4-DoGet Retrieve rows with selected columns from HBase.

        System.out.println("First iteration...");
        for (Result result : results) {
            String row = Bytes.toString(result.getRow());
            System.out.print("Row: " + row + " ");
            byte[] val = null;
            if (result.containsColumn(cf1, qf1)) { // co GetListExample-5-GetValue1 Iterate over results and check what values are available.
                val = result.getValue(cf1, qf1);
                System.out.println("Value: " + Bytes.toString(val));
            }
            if (result.containsColumn(cf1, qf2)) {
                val = result.getValue(cf1, qf2);
                System.out.println("Value: " + Bytes.toString(val));
            }
        }

        System.out.println("Second iteration...");
        for (Result result : results) {
            for (KeyValue kv : result.raw()) {
                System.out.println("Row: " + Bytes.toString(kv.getRow()) + // co GetListExample-6-GetValue2 Iterate over results again, printing out all values.
                        " Value: " + Bytes.toString(kv.getValue()));
            }
        }*/
        // ^^ GetListExample


        /**
         * get 列表和put 不一样
         *
         */
       /* byte[] cf1 = Bytes.toBytes("colfam1");
        byte[] qf1 = Bytes.toBytes("qual1");
        byte[] qf2 = Bytes.toBytes("qual2");
        byte[] row1 = Bytes.toBytes("row1");
        byte[] row2 = Bytes.toBytes("row2");

        // vv GetListErrorExample
        List<Get> gets = new ArrayList<Get>();

        Get get1 = new Get(row1);
        get1.addColumn(cf1, qf1);
        gets.add(get1);

        Get get2 = new Get(row2);
        get2.addColumn(cf1, qf1); // co GetListErrorExample-1-AddGets Add the Get instances to the list.
        gets.add(get2);

        Get get3 = new Get(row2);
        get3.addColumn(cf1, qf2);
        gets.add(get3);

        Get get4 = new Get(row2);
    *//*[*//*get4.addColumn(Bytes.toBytes("BOGUS"),*//*]*//* qf2);
        gets.add(get4); // co GetListErrorExample-2-AddBogus Add the bogus column family get.

        Result[] results = table.get(gets); // co GetListErrorExample-3-Error An exception is thrown and the process is aborted.

        System.out.println("Result count: " + results.length); // co GetListErrorExample-4-SOUT This line will never reached!
        // ^^ GetListErrorExample
*/

        /**
         * get row or before
         */
        // vv GetRowOrBeforeExample
        Result result1 = table.getRowOrBefore(Bytes.toBytes("row1"), // co GetRowOrBeforeExample-1-GetRow1 Attempt to find an existing row.
                Bytes.toBytes("colfam1"));
        System.out.println("Found: " + Bytes.toString(result1.getRow())); // co GetRowOrBeforeExample-2-SOUT1 Print what was found.

        Result result2 = table.getRowOrBefore(Bytes.toBytes("row99"), // co GetRowOrBeforeExample-3-GetRow2 Attempt to find a non-existent row.
                Bytes.toBytes("colfam1"));
        System.out.println("Found: " + Bytes.toString(result2.getRow())); // co GetRowOrBeforeExample-4-SOUT2 Returns the row that was sorted at the end of the table.

        for (KeyValue kv : result2.raw()) {
            System.out.println("  Col: " + Bytes.toString(kv.getFamily()) + // co GetRowOrBeforeExample-5-Dump Print the returned values.
                    "/" + Bytes.toString(kv.getQualifier()) +
                    ", Value: " + Bytes.toString(kv.getValue()));
        }

        Result result3 = table.getRowOrBefore(Bytes.toBytes("abc"), // co GetRowOrBeforeExample-6-GetRow3 Attempt to find a row before the test rows.
                Bytes.toBytes("colfam1"));
        System.out.println("Found: " + result3); // co GetRowOrBeforeExample-7-SOUT3 Should return "null" since there is no match.
        // ^^ GetRowOrBeforeExample


    }

}
