package com.gatling.demo.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FeederTest extends Simulation{

  val httpProtocol = http.baseUrl("https://computer-database.gatling.io")

  val feeder = csv("data/user.csv").random

  val feederScenario = scenario("Feeder Demo")
    .repeat(2) {
    feed(feeder)
    .exec { session =>
      println( "Name: "+session("name").as[String])
      println( "Job: "+session("job").as[String])
      println( "Page: "+session("page").as[String])
    session }.pause(1)
    .exec(http("Go to ${page}")
    .get("/#{page}")
    ) }

  setUp(feederScenario.inject(atOnceUsers(3))).protocols(httpProtocol)
}
