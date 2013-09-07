springone-hadoop
================

# Pig Top 10 example using Spring configuration

Requires that the tweet-counts-hadoop project has been built and is available in your local Maven repository and 
that the tweet-counts-spring application has been run.

If that's not the case do the following:
````
cd ~/springone-hadoop/tweet-counts-hadoop
mvn clean install
cd ~/springone-hadoop/tweet-counts-spring
mvn clean package
sh ./target/appassembler/bin/tweetcount
cd ~/springone-hadoop/tweet-top10-pig
````

Build and run using

````
cd ~/springone-hadoop/tweet-top10-pig
mvn clean package
sh ./target/appassembler/bin/pigApp
````

_Adjust JAVA_HOME and your path to the project as needed.__
