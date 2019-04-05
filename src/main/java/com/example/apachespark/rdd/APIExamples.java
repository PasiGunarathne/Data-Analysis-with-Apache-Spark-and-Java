package com.example.apachespark.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pasindu on 4/5/19.
 */
public class APIExamples {

    public String wordCount(){
        SparkConf sparkConf = new SparkConf().setAppName("startingSpark").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<String> textFile = sc.textFile("/home/pasindu/Desktop/Projects/apache-spark/src/main/resources/wordcount.text");
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        counts.saveAsTextFile("/home/pasindu/Desktop/Projects/apache-spark/dest/wordcount");

        System.out.println("\n\nWord count-"+counts.count()+"\n\n--------------------");
        String c = Long.toString(counts.count());


        return c;
    }

    public String piEstimation(){

        SparkConf sparkConf = new SparkConf().setAppName("startingSpark").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        int NUM_SAMPLES=99999;
        List<Integer> l = new ArrayList<>(NUM_SAMPLES);
        for (int i = 0; i < NUM_SAMPLES; i++) {
            l.add(i);
        }

        long count = sc.parallelize(l).filter(i -> {
            double x = Math.random();
            double y = Math.random();
            return x*x + y*y < 1;
        }).count();
        System.out.println("\n\n\n\nPi is roughly " + 4.0 * count / NUM_SAMPLES+"\n\n\n");
        return "";
    }


}
