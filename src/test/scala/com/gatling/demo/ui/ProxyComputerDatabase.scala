package com.gatling.demo.ui

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ProxyComputerDatabase extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://opensource-demo.orangehrmlive.com")
    .inferHtmlResources(WhiteList(), BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("application/json")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:108.0) Gecko/20100101 Firefox/108.0")
  


  private val scn = scenario("ProxyComputerDatabase")
    .exec(
      http("login page")
        .get("/web/index.php/auth/login")
        .resources(
          http("request_1")
            .get("/web/index.php/core/i18n/messages")
        )
    )
    .pause(7)
    .exec(
      http("login with valid credentials")
        .post("/web/index.php/auth/validate")
        .formParam("_token", "4f81edace6faeef296f00b.9aQuYxh9hdRMSsnuxQbgFMRrO32pLDCKDPLYsppkKxA.mtdWJmocx55-LbCYiTSpeYgTDkrCSF6_b73g4-IuWyGclkYzeSjunDwbqg")
        .formParam("username", "Admin")
        .formParam("password", "admin123")
        .resources(
          http("request_3")
            .get("/web/index.php/core/i18n/messages"),
          http("request_4")
            .get("/web/images/orange.png?1672659722816"),
          http("request_5")
            .get("/web/images/orangehrm-logo.png?1672659722816"),
          http("request_6")
            .get("/web/index.php/api/v2/dashboard/employees/action-summary"),
          http("request_7")
            .get("/web/index.php/api/v2/dashboard/shortcuts"),
          http("request_8")
            .get("/web/index.php/api/v2/dashboard/employees/time-at-work?timezoneOffset=1&currentDate=2023-04-14&currentTime=18:07"),
          http("request_9")
            .get("/web/index.php/pim/viewPhoto/empNumber/7"),
          http("request_10")
            .get("/web/index.php/api/v2/dashboard/employees/leaves?date=2023-04-14"),
          http("request_11")
            .get("/web/index.php/api/v2/dashboard/employees/locations"),
          http("request_12")
            .get("/web/index.php/api/v2/buzz/feed?limit=5&offset=0&sortOrder=DESC&sortField=share.createdAtUtc"),
          http("request_13")
            .get("/web/index.php/api/v2/dashboard/employees/subunit"),
          http("request_14")
            .post("/web/index.php/events/push"),
          http("request_15")
            .get("/web/index.php/pim/viewPhoto/empNumber/15"),
          http("request_16")
            .get("/web/index.php/buzz/photo/12"),
          http("request_17")
            .get("/web/index.php/buzz/photo/11"),
          http("request_18")
            .get("/web/index.php/pim/viewPhoto/empNumber/22"),
          http("request_19")
            .get("/web/index.php/pim/viewPhoto/empNumber/2")
        )
    )
    .pause(7)
    .exec(
      http("logout")
        .get("/web/index.php/auth/logout")
        .resources(
          http("request_21")
            .get("/web/index.php/core/i18n/messages")
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
