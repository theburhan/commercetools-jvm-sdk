import sbt._
import sbt.Keys._

object Libs extends json with http with other with test {

}

trait json {
  private val jacksonVersion = "2.5.3"

  val `jackson-annotations` = "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion
  val `jackson-core` = "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion
  val `jackson-databind` =  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion
  val `jackson-module-parameter-names` = "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % jacksonVersion
  val `jackson-datatype-jsr310` =  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % jacksonVersion
  val `jackson-databind-java-optional` =  "org.zapodot" % "jackson-databind-java-optional" % "2.5.1"

  val `jackson` =
    `jackson-annotations` ::
      `jackson-core` ::
      `jackson-databind` ::
      `jackson-module-parameter-names` ::
      `jackson-datatype-jsr310` ::
      `jackson-databind-java-optional` ::
      Nil

  val `gson` = "com.google.code.gson" % "gson" % "2.3.1"
}

trait http {
  val `async-http-client-1.8` = "com.ning" % "async-http-client" % "1.8.7"
  val `async-http-client-1.9` = "com.ning" % "async-http-client" % "1.9.18"
  val `apache-httpasyncclient` = "org.apache.httpcomponents" % "httpasyncclient" % "4.0.2"
}

trait other {
  val `nv-i18n` = "com.neovisionaries" % "nv-i18n" % "1.15"
  val `commons-lang3` = "org.apache.commons" % "commons-lang3" % "3.4"
  val `commons-io` = "org.apache.commons" % "commons-io" % "1.3.2"
  val `moneta` = "org.javamoney" % "moneta" % "1.0"
  val `slf4j-api` = "org.slf4j" % "slf4j-api" % "1.7.12"
  val `logback-classic` = "ch.qos.logback" % "logback-classic" % "1.1.3"
  val `jul-to-slf4j` = "org.slf4j" % "jul-to-slf4j" % "1.7.12"
}

trait test {
  val `junit-dep` = "junit" % "junit-dep" % "4.11"
  val assertj =  "org.assertj" % "assertj-core" % "3.0.0"
  val `junit-interface` = "com.novocode" % "junit-interface" % "0.11"

  val allTestLibs =
    `junit-dep` ::
      `junit-interface` ::
      assertj ::
      Nil
}