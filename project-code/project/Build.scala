import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play2-socialauth"
    val appVersion      = "0.1-SNAPSHOT"

    val appDependencies = Seq(
        //socialauth library
        "org.brickred" % "socialauth" % "2.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        organization := "com.minimalabs",
        // The Sonatype repository for socialauth
        resolvers += "sonatype-oss-public" at "http://oss.sonatype.org/content/groups/public/"
    )

}
