package com.gatling.demo.ui

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class HarComputerDatabase extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://app.launchdarkly.com")
    .inferHtmlResources( BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,de;q=0.6")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")

  private val uri2 = "https://computer-database.gatling.io/computers"
  
  private val uri3 = "https://events.launchdarkly.com/events/bulk/62913038bb88120c8d0102a7"
  
  private val uri4 = "https://clientstream.launchdarkly.com/eval/62913038bb88120c8d0102a7/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"

  private val scn = scenario("ComputerDatabase")
    .exec(
      http("ComputerDatabasePage")
        .get(uri2 + "?f=ARRA")
    )
    .pause(1)
    .exec(
      http("NewComputerPage")
        .get("/sdk/goals/62913038bb88120c8d0102a7")
        .resources(
          http("CreateNewComputer")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("FilterComputer")
            .get("/sdk/goals/62913038bb88120c8d0102a7"),
          http("request_4")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("request_5")
            .post(uri3)
            .body(RawFileBody("com/gatling/demo/computerdatabase/0005_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_6")
        .get(uri2 + "/355")
        .resources(
          http("request_7")
            .get(uri4)
        )
    )
    .pause(1)
    .exec(
      http("request_8")
        .get("/sdk/goals/62913038bb88120c8d0102a7")
        .resources(
          http("request_9")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("request_10")
            .get("/sdk/goals/62913038bb88120c8d0102a7"),
          http("request_11")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("request_12")
            .get(uri4),
          http("request_13")
            .post(uri3)
            .body(RawFileBody("com/gatling/demo/computerdatabase/0013_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_14")
        .post(uri3)
        .body(RawFileBody("com/gatling/demo/computerdatabase/0014_request.json"))
    )
    .pause(28)
    .exec(
      http("request_15")
        .post(uri2 + "/355")
        .formParam("name", "ARRA")
        .formParam("introduced", "2022-12-20")
        .formParam("discontinued", "2023-04-10")
        .formParam("company", "1")
        .resources(
          http("request_16")
            .get(uri4)
        )
    )
    .pause(1)
    .exec(
      http("request_17")
        .get("/sdk/goals/62913038bb88120c8d0102a7")
        .resources(
          http("request_18")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("request_19")
            .get("/sdk/goals/62913038bb88120c8d0102a7"),
          http("request_20")
            .get("/sdk/evalx/62913038bb88120c8d0102a7/users/eyJrZXkiOiJlYjgwMTRiNS1hYjllLTQxZmYtOGQ3Ni0yOTRkMWMxYzI1MzMiLCJjdXN0b20iOnsiZGlhbHVwSGFzaCI6MzkwLCJlbWFpbHMiOlsiUGFydGhpYmFuIFJhamFzZWthcmFuIiwiYW5vbnltb3VzIl0sImluaXRpYWxJbnN0YWxsRGF0ZSI6MTY3MzgxMDA0NDY5N319"),
          http("request_21")
            .post(uri3)
            .body(RawFileBody("com/gatling/demo/computerdatabase/0021_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_22")
        .post(uri3)
        .body(RawFileBody("com/gatling/demo/computerdatabase/0022_request.json"))
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
