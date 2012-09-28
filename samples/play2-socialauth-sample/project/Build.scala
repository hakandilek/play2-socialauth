import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play2-socialauth-sample"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "play2-socialauth" % "play2-socialauth_2.9.1" % "0.1-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        resolvers += "Local Play Repository" at "file://path/to/play-2.0/repository/local"
    )

}
