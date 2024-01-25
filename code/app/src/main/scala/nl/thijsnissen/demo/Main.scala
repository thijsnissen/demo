package nl.thijsnissen
package demo

import zio.*

object Main extends ZIOAppDefault:
  override lazy val run: ZIO[Any, Throwable, Unit] =
    Program.bootstrap
