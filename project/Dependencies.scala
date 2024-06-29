import sbt.*

object Dependencies {
  lazy val common = Seq(
    "com.lihaoyi" %% "pprint" % Version.pprint
  )

  lazy val app = Seq(
    "dev.zio" %% "zio"                 % Version.zio,
    "dev.zio" %% "zio-json"            % Version.zioJson,
    "dev.zio" %% "zio-config"          % Version.zioConfig,
    "dev.zio" %% "zio-config-magnolia" % Version.zioConfig,
    "dev.zio" %% "zio-http"            % Version.zioHttp,
    "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % Version.tapir
  )

  lazy val test = Seq(
    "dev.zio" %% "zio-test"          % Version.zioTest % Test,
    "dev.zio" %% "zio-test-sbt"      % Version.zioTest % Test,
    "dev.zio" %% "zio-test-magnolia" % Version.zioTest % Test
  )
}
