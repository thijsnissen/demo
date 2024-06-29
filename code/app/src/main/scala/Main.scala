import scala.io.BufferedSource
import scala.io.Source
import zio.*

object Main extends ZIOAppDefault:
  lazy val acquire: String => UIO[BufferedSource] =
    s => ZIO.attemptBlockingIO(Source.fromResource(s)).orDie

  lazy val release: BufferedSource => UIO[Unit] =
    b => ZIO.attemptBlockingIO(b.close).orDie

  lazy val program: UIO[Unit] =
    ZIO
      .acquireReleaseWith(acquire("myResource.txt"))(release):
        (b: BufferedSource) =>
          ZIO
            .succeed(b.mkString.trim)
            .flatMap(Console.printLine(_))
      .orDie

  lazy val run: UIO[ExitCode] =
    program
      .onError(ZIO.logErrorCause(_))
      .exitCode
