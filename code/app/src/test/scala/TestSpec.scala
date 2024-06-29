import zio.*
import zio.test.*

object TestSpec extends ZIOSpecDefault:
  lazy val spec: Spec[TestEnvironment & Scope, Any] =
    suite("Main"):
      test("prints to the Console"):
        for
          _ <- Main.run
          o <- TestConsole.output
        yield assertTrue(o.headOption contains "Hello, world!\n")
