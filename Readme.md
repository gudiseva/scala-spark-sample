# Apache Spark - Word Count Example in Scala Spark.


# Hadoop Commands

    C:\> sbt clean compile package
    C:\> hadoop fs -mkdir /spark
    C:\> hadoop fs -mkdir /spark/input
    C:\> hadoop fs -mkdir /spark/output
    
    C:\> hadoop fs -copyFromLocal C:\Users\css110738\Documents\TEMP_NPP.txt /spark/input/
    C:\> hadoop fs -ls /spark/input
         Found 1 items
    
    C:\> hadoop fs -ls /spark/output/spark_result
         Found 1 items
         
    C:\> hadoop fs -text -ignoreCrc /spark/output/spark_result/part-*
         OR
    C:\> hadoop fs -cat /spark/output/spark_result/part-*
    
    C:\> hadoop fs -rm -r /spark/output/spark_result


# Build

    C:\> sbt clean compile package


# To Run the Spark Job from Main:

    // Pass the program arguments as below:
    C:\Users\css110738\Documents\TEMP_NPP.txt C:\TEMP\spark_result
    
    
# To Run the Spark Job using SBT:

    C:\> sbt clean compile package
    C:\> sbt "project scalasparksample" "run C:\Users\css110738\Documents\TEMP_NPP.txt C:\TEMP\spark_result"


# To Run the Spark Job using spark-submit [LOCAL]:

    C:\> rmdir C:\TEMP\spark_result /s /q  // -- To delete the Output directory
    
    C:\> spark-submit --class com.csscorp.app.MainApp --master local[2] C:\GUDISEVA\Workspace\idea_projects\ScalaSparkSample\target\scala-2.10\scalasparksample_2.10-1.0.jar C:\Users\css110738\Documents\TEMP_NPP.txt C:\TEMP\spark_result\

    OR

    C:\> spark-submit --class com.csscorp.app.MainApp --master local[2] .\target\scala-2.10\scalasparksample_2.10-1.0.jar C:\Users\css110738\Documents\TEMP_NPP.txt C:\TEMP\spark_result\


# To Run the Spark Job using spark-submit [HDFS]:

    C:\> hadoop fs -rm -r /spark/output/spark_result  // -- To delete the Output directory
    
    OR
    
    C:\> hadoop fs -rm -r hdfs://LAP-04-2312:8020/spark/output/spark_result
    
    
    C:\> spark-submit --class com.csscorp.app.MainApp --master local[2] .\target\scala-2.10\scalasparksample_2.10-1.0.jar /spark/input/TEMP_NPP.txt /spark/output/spark_result/

    OR

    C:\> spark-submit --class com.csscorp.app.MainApp --master local[2] .\target\scala-2.10\scalasparksample_2.10-1.0.jar hdfs://LAP-04-2312:8020/spark/input/TEMP_NPP.txt hdfs://LAP-04-2312:8020/spark/output/spark_result/


#### Errors
[error] java.lang.OutOfMemoryError: Java heap space

    C:\> set JAVA_OPTS=-Xmx2G


## Nag Arvind Gudiseva
Technical Specialist - Analytics || CSS Corp