package com.gu.benchmark

import scala.collection.JavaConversions._

import scala.math._

import org.apache.commons.math.stat.StatUtils
import org.apache.commons.math.stat.descriptive.moment.{ Kurtosis, Skewness }

class Statistics[T](private val numerics: List[T])(implicit numeric: scala.math.Numeric[T]) {
  private lazy val xs = (numerics map { numeric.toDouble }).toArray

  lazy val count: Int = numerics.length

  lazy val sum: T = numerics.sum
  lazy val product: T = numerics.product
  lazy val max: T = numerics.max
  lazy val min: T = numerics.min

  lazy val mean: Double = StatUtils mean xs
  lazy val geometricMean: Double = StatUtils geometricMean xs
  lazy val skewness: Double = (new Skewness) evaluate xs
  lazy val kurtosis: Double = (new Kurtosis) evaluate xs
  lazy val variance: Double = StatUtils variance xs

  def percentile(p: Double): Double = StatUtils.percentile(xs, p)

  lazy val standardDeviation: Double = sqrt(variance)
  lazy val sampleStandardDeviation: Double = sqrt(xs.length / (xs.length - 1) * variance)

  lazy val summary: String = List(
    "Mean           : %.3f" format mean,
    "StdDev         : %.3f" format standardDeviation,
    "95%% percentile : %.3f" format percentile(95),
    "99%% percentile : %.3f" format percentile(99),
    "Total          : %.3f" format sum
  ) mkString "\n"
}

