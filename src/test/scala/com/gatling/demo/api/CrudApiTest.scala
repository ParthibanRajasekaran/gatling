package com.gatling.demo.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CrudApiTest extends Simulation{

  val httpProtocol = http
    .baseUrl("https://reqres.in")

  val createUser = http("Create User")
    .post("/api/users")
    .asJson
    .body(RawFileBody("data/user.json")).asJson
//    .body(StringBody(
//      """
//        |{
//        |    "name": "Parthiban",
//        |    "job": "leader"
//        |}
//        |""".stripMargin)).asJson
    .check(status.is(201), jsonPath("$.name").is("Parthiban"));

  val updateUser = http("Update User")
    .put("/api/users/1")
    .asJson
    .body(StringBody(
      """
        |{
        |    "name": "Parthiban",
        |    "job": "Lion Tamer"
        |}
        |""".stripMargin))
    .check(status.is(200), jsonPath("$.job").is("Lion Tamer"))

  val getUser = http("Get User")
    .get(("/api/users/1"))
    .check(status.is(200))

  val deleteUser = http("Delete User")
    .delete(("/api/users/1"))
    .check(status.is(204))

  val scenario1 = scenario("POST User API")
    .exec(createUser).pause(1)

  val scenario2 = scenario("GET User API")
    .exec(getUser).pause(1)

  val scenario3 = scenario("UPDATE User API")
    .exec(updateUser).pause(1)

  val scenario4 = scenario("DELETE User API")
    .exec(deleteUser).pause(1)


  setUp(
    scenario1.inject(rampUsers(10).during(12)),
    scenario2.inject(atOnceUsers(8)),
    scenario3.inject(constantUsersPerSec(5).during(5)),
    scenario4.inject(rampUsers(5).during(5))
  ).protocols(httpProtocol)

  }
