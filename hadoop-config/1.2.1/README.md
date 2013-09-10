Hadoop Configuration
====================

Single-node pseudo-distributed cluster
--------------------------------------

Modify $HADOOP_INSTALL/etc/hadoop/hadoop-env.sh

modify line 9: `# export JAVA_HOME=/usr/lib/j2sdk1.5-sun`

to be:

    export JAVA_HOME=<path to your Java install home>

On Ubuntu 13.04 with Java 1.6 it would be:

    export JAVA_HOME="/usr/lib/jvm/java-6-openjdk-amd64"

Copy the following files from the `hadoop-config/1.2.1/conf` 
directory of this repo:
```
  core-site.xml
  hdfs-site.xml
  mapred-site.xml
```
  to:
```
  $HADOOP_INSTALL/conf
```

This is a barebones configuration that stores any data files in your
temp directory but it allows you to quickly get up and running executing
mapreduce jobs. 

You can uncomment the config properties that specifies specific location 
for hadoops local directories. Just edit the file system locations.
