import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.File;
import java.io.IOException;

/**
 * 
 */

/**
 * @author kongming
 *
 */
public class PutExample {
	
	public static Configuration configuration;

    static {  
    	
    	if (System.getProperty("os.name").contains("Windows")) {  
            File workaround = new File(".");  
            System.getProperties().put("hadoop.home.dir",workaround.getAbsolutePath());  
            File dir = new File("./bin");  
            if (!dir.exists()) {  
                dir.mkdirs();  
            }  
            File exe = new File("./bin/winutils.exe");  
            if (!exe.exists()) {  
                try {
					exe.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }  
        }  
        configuration = HBaseConfiguration.create();  
        configuration.set("hbase.zookeeper.property.clientPort", "2181");  
        configuration.set("hbase.zookeeper.quorum", "master");  
        configuration.set("hbase.master", "master:600000");  
        
        configuration.set("hbase.rootdir", "hdfs://master:9000/hbase");
    }  
    
    
    /** 
     * 查询所有数据 
     * @param tableName 
     */  
    public static void QueryAll(String tableName) {  
        HTablePool pool = new HTablePool(configuration, 1000);  
        HTableInterface table = pool.getTable(tableName);  
        try {  
            ResultScanner rs = table.getScanner(new Scan());  
            for (Result r : rs) {  
                System.out.println("获得到rowkey:" + new String(r.getRow()));  
                for (KeyValue keyValue : r.raw()) {  
                    System.out.println("列：" + new String(keyValue.getFamily())  
                            + "====值:" + new String(keyValue.getValue()));  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }


    /** 
     * 插入数据 
     * @param tableName 
     */  
    public static void insertData(String tableName) {  
        System.out.println("start insert data ......");  
        HTablePool pool = new HTablePool(configuration, 1000);  
        HTableInterface table = pool.getTable(tableName);  
        Put put = new Put("112233bbbcccc".getBytes());// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值  
        put.add("column1".getBytes(), null, "aaa".getBytes());// 本行数据的第一列  
        put.add("column2".getBytes(), null, "bbb".getBytes());// 本行数据的第三列  
        put.add("column3".getBytes(), null, "ccc".getBytes());// 本行数据的第三列  
        try {  
            table.put(put);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("end insert data ......");  
    }


    /** 
     * 创建表 
     * @param tableName 
     */  
    public static void createTable(String tableName) {  
        System.out.println("start create table ......");  
        try {  
            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);  
            if (hBaseAdmin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建  
                hBaseAdmin.disableTable(tableName);  
                hBaseAdmin.deleteTable(tableName);  
                System.out.println(tableName + " is exist,detele....");  
            }  
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);  
            tableDescriptor.addFamily(new HColumnDescriptor("column1"));  
            tableDescriptor.addFamily(new HColumnDescriptor("column2"));  
            tableDescriptor.addFamily(new HColumnDescriptor("column3"));  
            hBaseAdmin.createTable(tableDescriptor);  
        } catch (MasterNotRunningException e) {  
            e.printStackTrace();  
        } catch (ZooKeeperConnectionException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("end create table ......");  
    }  


	 public static void main(String[] args) throws IOException {
//		 createTable("kongming1");
//		 insertData("kongming");
		 QueryAll("kongming");
		 /*   Configuration conf = HBaseConfiguration.create(); // co PutExample-1-CreateConf Create the required configuration.

		      conf.set("hbase.zookeeper.property.clientPort", "2181");
		      conf.set("hbase.zookeeper.quorum", "192.168.159.129");
		      conf.set("hbase.master", "192.168.159.129:60000");
		      conf.set("hbase.rootdir", "hdfs://192.168.159.129:9000/hbase");
                                                                                                                                                                w
		      // ^^ PutExample
		    HBaseHelper helper = HBaseHelper.getHelper(conf);
		    helper.dropTable("testtable");
		    helper.createTable("testtable", "colfam1");
		    // vv PutExample
		    HTable table = new HTable(conf, "testtable"); // co PutExample-2-NewTable Instantiate a new client.

		    Put put = new Put(Bytes.toBytes("row1")); // co PutExample-3-NewPut Create put with specific row.

		    put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"),
		      Bytes.toBytes("val1")); // co PutExample-4-AddCol1 Add a column, whose name is "colfam1:qual1", to the put.
		    put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"),
		      Bytes.toBytes("val2")); // co PutExample-4-AddCol2 Add another column, whose name is "colfam1:qual2", to the put.

		    table.put(put); // co PutExample-5-DoPut Store row with column into the HBase table.
*/		  }


}
