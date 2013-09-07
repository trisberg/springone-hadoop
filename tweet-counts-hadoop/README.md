springone-hadoop
================

# Tweet Counts in plain Hadoop Map Reduce

Build and run using

````
cd ~/springone-hadoop/tweet-counts-hadoop
export HADOOP_INSTALL=~/test/hadoop-1.2.1 
export PATH=$PATH:$HADOOP_INSTALL/bin:$HADOOP_INSTALL/sbin
export JAVA_HOME=/usr/lib/jvm/java-6-openjdk-amd64
mvn clean install
export HADOOP_CLASSPATH=~/springone-hadoop/tweet-counts-hadoop/target/tweet- counts-hadoop-0.1.0.jar
hadoop com.springdeveloper.hadoop.TweetHashTagCounter ~/springone- hadoop/data/nbatweets-small.txt ~/springone-hadoop/output
````

_Adjust JAVA_HOME and your path to the project as needed._
