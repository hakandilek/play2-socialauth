import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play2-socialauth-sample"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "com.minimalabs" % "play2-socialauth_2.9.1" % "0.1-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        resolvers += Resolver.url("GitHub play2-socialauth Repository", url("http://hakandilek.github.com/play2-socialauth/releases/"))(Resolver.ivyStylePatterns)
    )

}
