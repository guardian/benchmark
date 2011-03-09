import sbt._

class BenchmarkProject(info: ProjectInfo) extends DefaultProject(info) {

  override def compileOptions = super.compileOptions ++ Seq(Unchecked)

  val math = "org.apache.commons" % "commons-math" % "2.1" withSources
  val scalaTest = "org.scalatest" % "scalatest" % "1.3" % "test" withSources
}
