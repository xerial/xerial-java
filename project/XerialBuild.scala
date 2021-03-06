/*
 * Copyright 2012 Taro L. Saito
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File
import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin._
import scala._
import scala.Some
import xerial.sbt.Pack._

object XerialBuild extends Build {

  val SCALA_VERSION = "2.10.0"

  def releaseResolver(v: String): Resolver = {
    val profile = System.getProperty("xerial.profile", "default")
    profile match {
      case "default" => {
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT"))
          "snapshots" at nexus + "content/repositories/snapshots"
        else
          "releases" at nexus + "service/local/staging/deploy/maven2"
      }
      case p => {
        sys.error("unknown xerial.profile:%s".format(p))
      }
    }
  }
  lazy val defaultJavacOptions = Seq("-encoding", "UTF-8", "-source", "1.6")

  lazy val buildSettings = Defaults.defaultSettings ++ releaseSettings ++ Seq[Setting[_]](
    organization := "org.xerial.java",
    organizationName := "Xerial Project",
    organizationHomepage := Some(new URL("http://xerial.org/")),
    description := "Xerial: Data Management Utiilities",
    scalaVersion := SCALA_VERSION,
    autoScalaLibrary := false,
    publishMavenStyle := true,
    publishArtifact in Test := false,
    publishTo <<= version { (v) => Some(releaseResolver(v)) },
    pomIncludeRepository := {
      _ => false
    },
    parallelExecution := true,
    parallelExecution in Test := false,
    crossPaths := false,
    javacOptions in Compile := defaultJavacOptions ++ Seq("-target", "1.6"),
    javacOptions in Compile in doc := defaultJavacOptions ++  Seq("-windowtitle", "Xerial API", "-linkoffline", "http://docs.oracle.com/javase/6/docs/api/", "http://docs.oracle.com/javase/6/docs/api/"),
    pomExtra := {
      <url>http://xerial.org/</url>
      <licenses>
        <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        </license>
      </licenses>
        <scm>
          <connection>scm:git:github.com/xerial/xerial-java.git</connection>
          <developerConnection>scm:git:git@github.com:xerial/xerial-java.git</developerConnection>
          <url>github.com/xerial/xerial-java.git</url>
        </scm>
        <properties>
          <scala.version>{SCALA_VERSION}</scala.version>
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        </properties>
        <developers>
          <developer>
            <id>leo</id>
            <name>Taro L. Saito</name>
            <url>http://xerial.org/leo</url>
          </developer>
        </developers>
    }
  )


  import Dependencies._

  private val dependentScope = "test->test;compile->compile"

  // Project modules
  lazy val root = Project(
    id = "xerial",
    base = file("."),
    settings = buildSettings ++ packSettings ++ Seq(
      packExclude := Seq("root"),
//      packMain := Map("xerial" -> "xerial.lens.cui.Main"),
      publish := {},
      publishLocal := {}
    )
  ) aggregate(core, lens, silk, storage, xml)

  lazy val core = Project(
    id = "xerial-core",
    base = file("xerial-core"),
    settings = buildSettings ++ Seq(
      description := "Xerial core utiltiles",
      libraryDependencies ++= testLib
    )
  )

  lazy val lens = Project(
    id = "xerial-lens",
    base = file("xerial-lens"),
    settings = buildSettings ++ Seq(
      description := "Lens for mapping between objects and structured data (XML, JSON, Silk, etc.)",
      libraryDependencies ++= Seq(
        "org.xerial" % "sqlite-jdbc" % "3.7.2" % "test"
      )
    )
  ) dependsOn (core % dependentScope, silk, xml)

  lazy val silk = Project(
    id = "xerial-silk",
    base = file("xerial-silk"),
    settings = buildSettings ++ Seq(
      description := "Silk text-format",
      libraryDependencies ++= Seq(
        "org.antlr" % "antlr" % "3.2"
      )
    )
  ) dependsOn (core % dependentScope)

  lazy val storage = Project(
    id = "xerial-storage",
    base = file("xerial-storage"),
    settings = buildSettings ++ Seq(
      description := "Storage management libraries",
      libraryDependencies ++= Seq(
        "org.xerial" % "sqlite-jdbc" % "3.7.2",
        "postgresql" % "postgresql" % "8.3-603.jdbc3",
        "com.h2database" % "h2" % "1.1.101"
      )
    )
  ) dependsOn (core % dependentScope, lens)

  lazy val xml = Project(
    id = "xerial-xml",
    base = file("xerial-xml"),
    settings = buildSettings ++ Seq(
      description := "XML parser and indexing library",
      libraryDependencies ++= Seq(
        "xpp3" % "xpp3" % "1.1.4c"
      )
    )
  ) dependsOn (core % dependentScope)

  object Dependencies {
    val testLib = Seq(
     "junit" % "junit" % "4.10" % "test",
//      "org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
      "com.novocode" % "junit-interface" % "0.10-M2" % "test"
    )
  }

}








