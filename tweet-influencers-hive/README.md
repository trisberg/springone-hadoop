springone-hadoop
================

# Hive examples using Spring configuration

There are two example apps - HiveApp which uses a HiveTemplate and HiveJdbcApp which uses Hive2's new JDBC driver.

Build and run using

````
cd ~/springone-hadoop/tweet-influencers-hive
mvn clean package
sh ./target/appassembler/bin/hiveApp
sh ./target/appassembler/bin/hiveJdbcApp
````

Adjust JAVA_HOME and your path to the project as needed.
