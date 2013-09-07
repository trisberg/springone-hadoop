springone-hadoop
================

Demo code for SpringOne2GX 2013 [Getting started with Spring Data and Apache Hadoop](http://springone2gx.com/conference/santa_clara/2013/09/session?id=29423)

The first plain Hadoop MapReduce example uses a local Hadoop 1.2.1 install in standalone mode.

````
mkdir ~/test
cd ~/test
tar xvzf ~/Downloads/hadoop-1.2.1-bin.tar.gz
export HADOOP_INSTALL=~/test/hadoop-1.2.1
export PATH=$PATH:$HADOOP_INSTALL/bin:$HADOOP_INSTALL/sbin
export JAVA_HOME=/usr/lib/jvm/java-6-openjdk-amd64
hadoop version
````
_Adjust JAVA_HOME and your path to the project as needed._

You should see something like the following:

    Hadoop 1.2.1
    Subversion https://svn.apache.org/repos/asf/hadoop/common/branches/branch-1.2 -r 1503152
    Compiled by mattf on Mon Jul 22 15:23:09 PDT 2013
    From source with checksum 6923c86528809c4e7e6f493b6b413a9a
    This command was run using /home/trisberg/test/hadoop-1.2.1/hadoop-core-1.2.1.jar

Now go to this page for further instructions:

[tweet-counts-hadoop](tweet-counts-hadoop)

The other examples are built using the [Spring for Apache Hadoop](https://github.com/SpringSource/spring-hadoop) support and rely on having a Hadoop 
cluster available on the following addresses:

HDFS:		hdfs://sandbox:8020
JobTracker:	sandbox:50300

You can use the [Hortonworks Sandbox](http://hortonworks.com/sandbox/) for this. I added the following entry to my /etc/hosts file:

````
172.16.87.148   sandbox
````

Adjust as needed for your installation specifics.

See the following Spring for Apache Hadoop examples for more instructions:

[tweet-counts-spring](tweet-counts-spring)
[tweet-top10-pig](tweet-top10-pig)
[tweet-influencers-hive](tweet-counts-hadoop)
[tweet-batch](tweet-batch)

