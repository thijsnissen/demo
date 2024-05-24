import sbt.*

object Dependencies {
  lazy val common = Seq(
    "com.lihaoyi" %% "pprint" % Version.pprint
  )

  lazy val app = Seq(
    "dev.zio" %% "zio" % Version.zio,
    "dev.zio" %% "zio-json" % Version.zioJson,
    "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % Version.tapir
  )

  lazy val test = Seq(
    "org.scalatest" %% "scalatest" % Version.scalatest % "test"
  )
}
