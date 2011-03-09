package com.gu.benchmark

import scala.testing.Benchmark

object Preamble {

  private def underline(s: String) = {
    (1 to s.length) map { _ => "-" } mkString
  }

  implicit def numericList2Statistics[T](numerics: List[T])(implicit numeric: Numeric[T]) = {
    def statistics = new Statistics(numerics)
  }

  implicit def nanoBenchmark2RunAndPrintStatistics(benchmark: NanoBenchmark) = new {
    def runAndPrintStatistics(runs: Int) {
      println()
      println(benchmark.prefix)
      println(underline(benchmark.prefix))

      val results = new Statistics(benchmark runBenchmark runs)

      println(results.summary)
      println()
    }
  }

  implicit def benchmark2RunAndPrintStatistics(benchmark: Benchmark) = new {
    def runAndPrintStatistics(runs: Int) {
      println()
      println(benchmark.prefix)
      println(underline(benchmark.prefix))

      val results = new Statistics(benchmark runBenchmark runs)

      println(results.summary)
      println()
    }
  }
}

