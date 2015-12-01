import sbt.Keys._
import sbt._
import sbtassembly.AssemblyKeys._
import sbtassembly.{ PathList, MergeStrategy }

object NpaBuild extends Build {
  val SPARK_VERSION = "1.5.2"
  val SCALA_VERSION = "2.10.5"
  
  lazy val commonSettings = Seq(
    organization := "com.ibm.data.mining.bigdata.hotel",
    version := "0.1",
    scalaVersion := SCALA_VERSION)

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = coreSettings ++ commonSettings)

  val excludeNetty = ExclusionRule(organization = "org.jboss.netty")
  val excludeAsm = ExclusionRule(organization = "asm")
  val excludeServletApi = ExclusionRule(organization = "javax.servlet", artifact = "servlet-api")
  val excludeJackson = ExclusionRule(organization = "org.codehaus.jackson")
  val excludeJersey = ExclusionRule(organization = "com.sun.jersey")

  def coreSettings = Defaults.defaultSettings ++ Seq(

    name := "hotel-spark-job-example",
    scalacOptions := Seq("-deprecation", "-unchecked", "-optimize", "-feature"),

    test in assembly := {},

    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", "mailcap", xs @ _*) => MergeStrategy.last
      case PathList("META-INF", "mimetypes.default", xs @ _*) => MergeStrategy.last
      case PathList("META-INF", "maven", xs @ _*) => MergeStrategy.last
      case PathList("META-INF", "native", xs @ _*) => MergeStrategy.first
      case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.first
      case PathList("com", "google", xs @ _*) => MergeStrategy.first
      case PathList("com", "fasterxml", xs @ _*) => MergeStrategy.last
      case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
      case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
      case PathList("javax", "transaction", xs @ _*) => MergeStrategy.first
      case PathList("parquet.thrift", xs @ _*) => MergeStrategy.first
      case PathList("javax", "xml", xs @ _*) => MergeStrategy.last
      case PathList("parquet", xs @ _*) => MergeStrategy.first
      case PathList(xs @ _*) if xs.last endsWith ".properties" => MergeStrategy.filterDistinctLines
      case PathList(xs @ _*) if xs.last endsWith ".xml" => MergeStrategy.filterDistinctLines
      case PathList(xs @ _*) if xs.last endsWith ".html" => MergeStrategy.filterDistinctLines
      case PathList("org", xs @ _*) => MergeStrategy.first
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },

    assemblyJarName := "hotel-spark-job-demo.jar",
    mainClass := Some("com.ibm.data.mining.bigdata.hotel.SparkJobDriver"),

    resolvers ++= Seq(
      "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository",
      "Local Ivy Repository" at Path.userHome.asFile.toURI.toURL + ".ivy2/local",
      "maven2-repository.dev.java.net" at "http://download.java.net/maven/2",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
      "Spray Repository" at "http://repo.spray.io/",
      "Cloudera Repository" at "http://repository.cloudera.com/artifactory/cloudera-repos/",
      "Java.net Maven 2 Repository" at "http://download.java.net/maven/2",
      "mapr-maven" at "http://repository.mapr.com/nexus/content/groups/mapr-public/",
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")),

    fork := true,
    javaOptions += "-XX:MaxPermSize=1024m",
    javaOptions += "-Xmx3g",

    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.2.1",
	  "org.scalaz" % "scalaz-core_2.10" % "7.2.0-RC1",
      "org.xerial.snappy" % "snappy-java" % "1.1.2",
	  // spark
      "org.apache.spark" % "spark-core_2.10" % SPARK_VERSION % "provided",
      "org.apache.spark" % "spark-mllib_2.10" % SPARK_VERSION % "provided",
      "org.apache.spark" % "spark-streaming_2.10" % SPARK_VERSION % "provided" ,
      "org.apache.spark" % "spark-catalyst_2.10" % SPARK_VERSION % "provided",
      "org.apache.spark" % "spark-sql_2.10" % SPARK_VERSION % "provided",
      "org.apache.spark" % "spark-hive_2.10" % SPARK_VERSION % "provided",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "junit" % "junit" % "4.11" % "test"
      ),
    libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _))
}