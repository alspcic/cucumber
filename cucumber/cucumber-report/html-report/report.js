$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Sample1.feature");
formatter.feature({
  "line": 1,
  "name": "Introduction to cucumber part 1",
  "description": "As a test engineer\r\nI want to be able to write and execute a simple scenario",
  "id": "introduction-to-cucumber-part-1",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4857387637,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Simple scenario",
  "description": "",
  "id": "introduction-to-cucumber-part-1;simple-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I am on the home page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see home page header",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I should see home page description",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I should see menu",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 933328249,
  "status": "passed"
});
});