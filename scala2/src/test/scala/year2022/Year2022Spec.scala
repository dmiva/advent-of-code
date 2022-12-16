package year2022

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Year2022Spec extends AnyWordSpec with Matchers {

  "Day 1" when {
    "Part 1" in { Day01.part1 shouldBe 70369 }
    "Part 2" in { Day01.part2 shouldBe 203002 }
  }

  "Day 2" when {
    "Part 1" in { Day02.part1 shouldBe 12855 }
    "Part 2" in { Day02.part2 shouldBe 13726 }
  }

  "Day 3" when {
    "Part 1" in { Day03.part1 shouldBe 7848 }
    "Part 2" in { Day03.part2 shouldBe 2616 }
  }

  "Day 4" when {
    "Part 1" in { Day04.part1 shouldBe 498 }
    "Part 2" in { Day04.part2 shouldBe 859 }
  }

  "Day 5" when {
    "Part 1" in { Day05.part1 shouldBe "RFFFWBPNS" }
    "Part 2" in { Day05.part2 shouldBe "CQQBBJFCS" }
  }
}
