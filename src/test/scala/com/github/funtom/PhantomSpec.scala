package com.github.funtom

import com.github.funtom.runtime.PhantomCallError

class PhantomSpec extends SpecHelper {
  describe("Phantom call should throw Exception") {
    it("'?ceil(2.5)' must be Exception") {
      assertThrows[PhantomCallError] {
        E("?ceil(2.5)")
      }
    }
    it("'?hoge(1, 2)' must be Exception") {
      assertThrows[PhantomCallError] {
        E("?hoge(1, 2)")
      }
    }
  }
  describe("Phantom call depends on execution paths") {
    it("'if(false) ?neverCalled(1, 2) else 1' should be fine") {
      val result = E(
        """
           if(false) ?neverCalled(3, 4) else 1
      """)
      assert(BoxedInt(1) == result)
    }
    it("'if(true) ?neverCalled(1, 2) else 1' should throw Exception") {
      assertThrows[PhantomCallError] {
        E(
          """
           if(true) ?neverCalled(3, 4) else 1
      """)
      }
    }
    it("val v = random(0, 2); if(v == 1) ?v(1) else ?v(2) should throw correct Exception") {
      val error = intercept[PhantomCallError] {
        E(
          """
            |val v = random(0, 2)
            |if(v == 1) ?v(1) else ?v(2)
          """.stripMargin)
      }
      val param = error.params.head.asInstanceOf[BoxedInt]
      assert(1 == param.value || 2 == param.value)
    }
  }
}
