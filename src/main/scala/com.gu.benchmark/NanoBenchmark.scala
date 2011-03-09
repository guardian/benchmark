package com.gu.benchmark

import scala.compat.Platform

trait NanoBenchmark {

  def before() {}
  def after() {}

  def run()

  def runBenchmark(noTimes: Int): List[Double] =
    for (i <- List.range(1, noTimes + 1)) yield {
      Platform.collectGarbage
      before()

      val startTime = System.nanoTime
      run()
      val stopTime = System.nanoTime

      after()
      Platform.collectGarbage

      (stopTime - startTime) / 1000.0
    }

  def prefix: String = getClass().getName()
}
