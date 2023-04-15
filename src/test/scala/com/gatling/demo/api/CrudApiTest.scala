package com.gatling.demo.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ApiTest extends Simulation{

  val httpProtocol = http
    .baseUrl("https://reqres.in/api/users")

  val getUser = http("Get Single User")
    .get("/2")
    .check(status.is(200))
    .check(jsonPath("$.data.first_name"));

  val scenario1 = scenario("GET users API")
    .exec(getUser)
    .pause(1)

  setUp(scenario1.inject(atOnceUsers(10))).protocols(httpProtocol)

  }
