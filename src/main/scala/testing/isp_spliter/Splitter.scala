package testing.isp_spliter

import java.nio.file.{Files, Path, Paths}

import akka.Done
import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.stream.alpakka.csv.scaladsl.CsvParsing
import akka.stream.alpakka.file.scaladsl.LogRotatorSink
import akka.stream.scaladsl.{FileIO, Flow, GraphDSL, Partition, Sink}
import akka.stream.{ActorMaterializer, SinkShape}
import akka.util.ByteString

import scala.concurrent.{ExecutionContextExecutor, Future}

object Splitter extends App {

  implicit val system: ActorSystem = ActorSystem("Splitter")
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  implicit val log: LoggingAdapter = Logging(system, classOf[App])
  implicit val mat: ActorMaterializer = ActorMaterializer()

  val basePath = "D://"
  val sourceFileName = "total_24-03-2019"

  def fileSizeTriggerCreator(isp: Isp): () => ByteString => Option[Path] = () => {
    var size: Int = 0
    var fileCount: Int = 1
    _: ByteString =>
      if (size % 100000 == 0) {
        val path = Files.createFile(Paths.get(s"$basePath${sourceFileName}_${isp.toString}_US_$fileCount.csv"))
        println("path", path)
        size += 1
        fileCount += 1
        Some(path)
      } else {
        size += 1
        None
      }
  }

  def sizeRotatorSink(isp: Isp): Sink[ByteString, Future[Done]] = LogRotatorSink(fileSizeTriggerCreator(isp))

  val ispFileWriterSink = Sink.fromGraph(GraphDSL.create() { implicit b =>
    import GraphDSL.Implicits._
    import Isp.isps

    val partition = b.add(Partition[InputData](isps.size, in => isps.indexOf(in.isp)))
    isps.foreach(isp => partition
      .via(Flow[InputData].map(in => ByteString(in.toOutputData.toCsv.mkString("", ";", "\n"))).async)
      .to(sizeRotatorSink(isp)))

    SinkShape(partition.in)
  })

  FileIO
    .fromPath(Paths.get(basePath + sourceFileName + ".csv"))
    .via(CsvParsing.lineScanner(escapeChar = '|'))
    .drop(1)
    .map(bsList => InputData.fromStrList(bsList.map(_.utf8String)))
    .collect { case Some(inputData) => inputData }
    .to(ispFileWriterSink)
    .run()
    .foreach(println)

}
