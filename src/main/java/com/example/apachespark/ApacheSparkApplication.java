package com.example.apachespark;

import com.example.apachespark.rdd.APIExamples;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheSparkApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApacheSparkApplication.class, args);

		APIExamples apiExamples = new APIExamples();
		apiExamples.wordCount();
//		apiExamples.piEstimation();

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



	}

}
