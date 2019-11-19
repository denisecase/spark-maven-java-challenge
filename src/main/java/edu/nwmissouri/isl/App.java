package edu.nwmissouri.isl;

// imports
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.util.Arrays;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;
import java.util.Comparator;

/**
 * Hello world!
 */
public final class App {
  private App() {
  }

  private static void process(String fileName) {

    // define a spark configuration
    SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Challenge");

    // define a spark context
    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

    // use textFile() to read data into RDD
    JavaRDD<String> inputFile = sparkContext.textFile(fileName);

    // use Java API to flatMap text into an RDD of strings (words)
    // In 2.0, FlatMapFunction.call() returns an Iterator rather than Iterable.
    JavaRDD<String> wordsFromFile = inputFile.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

    // use Java API to map each word to an output pair
    JavaPairRDD<String, Integer> countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1))
        .reduceByKey((x, y) -> (int) x + (int) y);

    // countData has records in the form (word, 5)

    JavaPairRDD<Integer, String> output = countData.mapToPair(p -> new Tuple2(p._2, p._1))
        .sortByKey(Comparator.reverseOrder());

    // save results to a folder (RDDs are complex)

    String outputFolder = "results";
    Path path = FileSystems.getDefault().getPath(outputFolder);
    FileUtils.deleteQuietly(path.toFile());
    output.saveAsTextFile(outputFolder);

    // close spark context
    sparkContext.close();
  }

  /**
   * Says hello to the world.
   * 
   * @param args The arguments of the program.
   */
  public static void main(String[] args) {
    // System.out.println("Hello World!");

    if (args.length != 1) {
      System.out.println("Please provide a single argument (text file name).");
      System.exit(0);
    }
    // call wordCount with the first argument
    process(args[0]);

  }
}
