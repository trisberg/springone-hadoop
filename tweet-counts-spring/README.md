springone-hadoop
================

# Tweet Counts using Spring configuration

Requires that the tweet-counts-hadoop project has been built and is available in your local Maven repository.

If that's not the case do the following:
````
cd ~/springone-hadoop/tweet-counts-hadoop
mvn clean install
cd ~/springone-hadoop/tweet-counts-spring
````

Build and run using

````
cd ~/springone-hadoop/tweet-counts-spring
mvn clean package
sh ./target/appassembler/bin/tweetcount
````

Adjust JAVA_HOME and your path to the project as needed.
