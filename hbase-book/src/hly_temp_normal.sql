create table hly_temp_normal (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
stnid CHAR(11),
month TINYINT,
day TINYINT,
value1 VARCHAR(5),
value2 VARCHAR(5),
value3 VARCHAR(5),
value4 VARCHAR(5),
value5 VARCHAR(5),
value6 VARCHAR(5),
value7 VARCHAR(5),
value8 VARCHAR(5),
value9 VARCHAR(5),
value10 VARCHAR(5),
value11 VARCHAR(5),
value12 VARCHAR(5),
value13 VARCHAR(5),
value14 VARCHAR(5),
value15 VARCHAR(5),
value16 VARCHAR(5),
value17 VARCHAR(5),
value18 VARCHAR(5),
value19 VARCHAR(5),
value20 VARCHAR(5),
value21 VARCHAR(5),
value22 VARCHAR(5),
value23 VARCHAR(5),
value24 VARCHAR(5)
);



######Hbase table ddl


hadoop$ $HBASE_HOME/bin/hbase shell

 create ‘hly_temp’, {NAME => ‘n’, VERSIONS => 1}

 create 'music_user_bhvr_attr',{NAME => 'bhbr',VERSIONS => 2147483647,BLOOMFILTER=>'ROW'},{NAME => 'attr',VERSIONS => 2147483647,BLOOMFILTER=>'ROW'}

create 'music_user_bhvr_attr_index',{NAME => 'cf1',VERSIONS => 2147483647,BLOOMFILTER=>'ROW'},{NAME => 'cf2',VERSIONS => 2147483647,BLOOMFILTER=>'ROW'}










