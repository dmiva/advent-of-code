package year2025

import org.scalatest.funsuite.AnyFunSuite
import year2025.Day02

class Day02Spec extends AnyFunSuite:

  private val sample: String = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

  test("Day02 part1") {
    assert(Day02.part1(sample) == 1227775554L)
  }

  test("Day02 part2") {
    assert(Day02.part2(sample) == 4174379265L)
  }
