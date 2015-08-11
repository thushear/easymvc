package com.kongming.crud;

import com.kongming.util.HBaseHelper;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 * User: kongming
 * Date: 15-1-29
 * Time: 下午2:42
 */
public class DeleteExample {


    public static void main(String[] args) throws IOException {

        HBaseHelper helper = HBaseHelper.getDefaultHelper();

        helper.dropTable("testtable");
        helper.createTable("testtable", "colfam1", "colfam2");
        HTable table = new HTable(HBaseHelper.configuration, "testtable");
        /*helper.put("testtable",
                new String[] { "row1" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        System.out.println("Before delete call...");
        helper.dump("testtable", new String[]{ "row1" }, null, null);
        // vv DeleteExample
        Delete delete = new Delete(Bytes.toBytes("row1")); // co DeleteExample-1-NewDel Create delete with specific row.

        //delete.setTimestamp(1); // co DeleteExample-2-SetTS Set timestamp for row deletes.

        //delete.deleteColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1")); // co DeleteExample-3-DelColNoTS Delete the latest version only in one column.
       //delete.deleteColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual3"), 5); // co DeleteExample-4-DelColTS Delete specific version in one column.

        // delete.deleteColumns(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1")); // co DeleteExample-5-DelColsNoTS Delete all versions in one column.

       *//* delete.deleteColumns(Bytes.toBytes("colfam1"), Bytes.toBytes("qual3"), 6); // co DeleteExample-6-DelColsTS Delete the given and all older versions in one column.
       *//*
        //delete.deleteFamily(Bytes.toBytes("colfam1")); // co DeleteExample-7-AddCol Delete entire family, all columns and versions.
        delete.deleteFamily(Bytes.toBytes("colfam1"), 3); // co DeleteExample-8-AddCol Delete the given and all older versions in the entire column family, i.e., from all columns therein.

        table.delete(delete); // co DeleteExample-9-DoDel Delete the data from the HBase table.

        table.close();
        // ^^ DeleteExample
        System.out.println("After delete call...");
        helper.dump("testtable", new String[] { "row1" }, null, null);
*/
       /* helper.put("testtable",
                new String[] { "row1" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        helper.put("testtable",
                new String[] { "row2" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        helper.put("testtable",
                new String[] { "row3" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        System.out.println("Before delete call...");
        helper.dump("testtable", new String[]{ "row1", "row2", "row3" }, null, null);
        // vv DeleteListExample
        List<Delete> deletes = new ArrayList<Delete>(); // co DeleteListExample-1-CreateList Create a list that holds the Delete instances.

        Delete delete1 = new Delete(Bytes.toBytes("row1"));
        delete1.setTimestamp(4); // co DeleteListExample-2-SetTS Set timestamp for row deletes.
        deletes.add(delete1);

        Delete delete2 = new Delete(Bytes.toBytes("row2"));
        delete2.deleteColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1")); // co DeleteListExample-3-DelColNoTS Delete the latest version only in one column.
        delete2.deleteColumns(Bytes.toBytes("colfam2"), Bytes.toBytes("qual3"), 5); // co DeleteListExample-4-DelColsTS Delete the given and all older versions in another column.
        deletes.add(delete2);

        Delete delete3 = new Delete(Bytes.toBytes("row3"));
        delete3.deleteFamily(Bytes.toBytes("colfam1")); // co DeleteListExample-5-AddCol Delete entire family, all columns and versions.
        delete3.deleteFamily(Bytes.toBytes("colfam2"), 3); // co DeleteListExample-6-AddCol Delete the given and all older versions in the entire column family, i.e., from all columns therein.
        deletes.add(delete3);

        table.delete(deletes); // co DeleteListExample-7-DoDel Delete the data from multiple rows the HBase table.

        table.close();
        // ^^ DeleteListExample
        System.out.println("After delete call...");
        helper.dump("testtable", new String[]{ "row1", "row2", "row3" }, null, null);
*/

        helper.put("testtable",
                new String[] { "row1" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        helper.put("testtable",
                new String[] { "row2" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        helper.put("testtable",
                new String[] { "row3" },
                new String[] { "colfam1", "colfam2" },
                new String[] { "qual1", "qual1", "qual2", "qual2", "qual3", "qual3" },
                new long[]   { 1, 2, 3, 4, 5, 6 },
                new String[] { "val1", "val2", "val3", "val4", "val5", "val6" });
        System.out.println("Before delete call...");
        helper.dump("testtable", new String[]{ "row1", "row2", "row3" }, null, null);

        List<Delete> deletes = new ArrayList<Delete>();

        Delete delete1 = new Delete(Bytes.toBytes("row1"));
        delete1.setTimestamp(4);
        deletes.add(delete1);

        Delete delete2 = new Delete(Bytes.toBytes("row2"));
        delete2.deleteColumn(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"));
        delete2.deleteColumns(Bytes.toBytes("colfam2"), Bytes.toBytes("qual3"), 5);
        deletes.add(delete2);

        Delete delete3 = new Delete(Bytes.toBytes("row3"));
        delete3.deleteFamily(Bytes.toBytes("colfam1"));
        delete3.deleteFamily(Bytes.toBytes("colfam2"), 3);
        deletes.add(delete3);

        // vv DeleteListErrorExample
        Delete delete4 = new Delete(Bytes.toBytes("row2"));
    /*[*/delete4.deleteColumn(Bytes.toBytes("BOGUS"),/*]*/ Bytes.toBytes("qual1")); // co DeleteListErrorExample-1-DelColNoTS Add bogus column family to trigger an error.
        deletes.add(delete4);

        try {
            table.delete(deletes); // co DeleteListErrorExample-2-DoDel Delete the data from multiple rows the HBase table.
        } catch (Exception e) {
            System.err.println("Error: " + e); // co DeleteListErrorExample-3-Catch Guard against remote exceptions.
        }
        table.close();

        System.out.println("Deletes length: " + deletes.size()); // co DeleteListErrorExample-4-CheckSize Check the length of the list after the call.
        for (Delete delete : deletes) {
            System.out.println(delete); // co DeleteListErrorExample-5-Dump Print out failed delete for debugging purposes.
        }
        // ^^ DeleteListErrorExample
        System.out.println("After delete call...");
        helper.dump("testtable", new String[]{ "row1", "row2", "row3" }, null, null);

    }
}
