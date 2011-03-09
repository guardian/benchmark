package com.gu.benchmark

import com.gu.benchmark.Preamble._
import org.scalatest.{Tag, FunSuite}

trait BenchmarkSuite extends FunSuite {

  protected def bench(benchmarkName: String, benchmarkTags: Tag*)(f: => Unit) {
    test(benchmarkName, benchmarkTags:_*) { f }
  }

  protected def bench(benchmark: NanoBenchmark, runs: Int) {
    bench(benchmark.prefix) { benchmark runAndPrintStatistics runs }
  }

}