package nl.thijsnissen
package demo

import zio.*

object Program:
  lazy val program: ZIO[Any, Throwable, Unit] =
    for
      _ <- ZIO.logInfo("Starting app...")
      _ <- Console.printLine("Hello world!")
    yield ()

  lazy val bootstrap: ZIO[Any, Throwable, Unit] =
    program // (Logging.Logging *> Flyway.migrate *> program).provide(...)
