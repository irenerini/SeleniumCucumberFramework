$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/WalletHubReview.feature");
formatter.feature({
  "name": "Write a review for Wallet Hub Insurance Company",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@WalletHubReview"
    }
  ]
});
formatter.scenario({
  "name": "Write Review",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@WalletHubReview"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Login to the WalletHub website",
  "keyword": "Given "
});
formatter.match({
  "location": "WalletHub_Steps.login_to_the_WalletHub_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Rate stars as part of review",
  "keyword": "When "
});
formatter.match({
  "location": "WalletHub_Steps.rate_stars_as_part_of_review()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a review by selecting company",
  "keyword": "Then "
});
formatter.match({
  "location": "WalletHub_Steps.write_a_review_by_selecting_company()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check for the updation of review feed",
  "keyword": "Then "
});
formatter.match({
  "location": "WalletHub_Steps.check_for_the_updation_of_review_feed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});