Benchmark
=========

What is it?
-----------

Benchmark is a small Scala library to support benchmark testing, particularly in combination with `sbt-benchmark-plugin`. Included are:

 * `NanoBenchmark.scala`: A version of `scala.testing.Benchmark` is included which measures times in nanoseconds.
 * `Statistics.scala`: Wrapper around `commons-math` statistics utilities to compute means, variances, etc for benchmarking results.
 * `Preamble.scala`: Convenience preamble with `runAndPrintStatistics` methods for benchmark classes.

Include in your project by adding the following to your SBT project definition. (With most recent version number.)

   val guardian = "Guardian GitHub" at "http://guardian.github.com/maven/repo-releases"
   val benchmarks = "com.gu" % "benchmark" % "0.1" withSources
