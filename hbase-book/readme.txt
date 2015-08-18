该项目依赖环境
完全分布式hbase集群
Attribute Name	Value	Description
HBase Version	0.96.2-hadoop2, r1581096	HBase version and revision
HBase Compiled	Mon Mar 24 16:03:18 PDT 2014, stack	When HBase version was compiled and by whom
Hadoop Version	2.6.0, re3496499ecb8d220fba99dc5ed4c99c8f9e33bb1	Hadoop version and revision
Hadoop Compiled	2014-11-13T21:10Z, jenkins	When Hadoop version was compiled and by whom
Zookeeper Quorum	master:2181	Addresses of all registered ZK servers. For more, see zk dump.
HBase Root Directory	hdfs://192.168.159.129:9000/hbase	Location of HBase home directory
HMaster Start Time	Wed Jan 21 22:45:49 CST 2015	Date stamp of when this HMaster was started
HMaster Active Time	Wed Jan 21 22:45:50 CST 2015	Date stamp of when this HMaster became active
HBase Cluster ID	d6e260e7-e8a0-41ab-afa0-4b081186be21	Unique identifier generated for each HBase cluster
Load average	6.00	Average number of regions per regionserver. Naive computation.
Coprocessors	[]	Coprocessors currently loaded by the master




http://www1.ncdc.noaa.gov/pub/data/normals/1981-2010/


//-------------------------------------------------------------------
公共数据集合是个练习HBase数据合并的很好数据源。互联网上有很多公共数据集合。我们在本文中奖使用 “美国国家海洋和大气管理局 1981-2010气候平均值”的公共数据集合。访问http://www1.ncdc.noaa.gov/pub/data/normals/1981-2010/下载。

这些气候报表数据是由美国国家海洋和大气管理局（NOAA）生成的。在本文中，我们使用在目录 products | hourly 下的小时温度数据（可以在上述链接页面中找到）。下载hly-temp-normal.txt文件。


