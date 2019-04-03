package com.example.apachespark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApacheSparkApplication {

	public static void main(String[] args) {

//		SpringApplication.run(ApacheSparkApplication.class, args);


//		List<Double> inputData = new ArrayList<>();
//		inputData.add(45.58);
//		inputData.add(89.23);
//		inputData.add(98.79);
//		inputData.add(78.39);
//		inputData.add(12.56);
//
//
//
//		SparkConf sparkConf = new SparkConf().setAppName("startingSpark").setMaster("local[2]");
//		JavaSparkContext sc = new JavaSparkContext(sparkConf);
//
//		JavaRDD<Double> myrdd = sc.parallelize(inputData);
//		sc.close();

		SparkConf sparkConf = new SparkConf().setAppName("startingSpark").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);

		JavaRDD<String> textFile = sc.textFile("/home/pasindu/Desktop/Projects/apache-spark/src/main/resources/wordcount.text");
		JavaPairRDD<String, Integer> counts = textFile
				.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
				.mapToPair(word -> new Tuple2<>(word, 1))
				.reduceByKey((a, b) -> a + b);
		counts.saveAsTextFile("/home/pasindu/Desktop/Projects/apache-spark/src/main/resources/wordcount1");

		System.out.println("--------------count-----------");
		System.out.println("\n\n"+counts.count()+"\n\n--------------------");


	}

	public String wordCount(){

		SparkConf sparkConf = new SparkConf().setAppName("startingSpark").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);

		JavaRDD<String> textFile = sc.textFile("resources/wordcount.text");
		JavaPairRDD<String, Integer> counts = textFile
				.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
				.mapToPair(word -> new Tuple2<>(word, 1))
				.reduceByKey((a, b) -> a + b);
//		counts.saveAsTextFile("hdfs://...");

		System.out.println("--------------count-----------");
		System.out.println(counts);
		return "";
	}

}
