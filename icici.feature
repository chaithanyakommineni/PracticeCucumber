#Author: kommineni chaithanya

@tag
Feature: Login Functionality of ICICI
#Background:
#Given open browser as "browser" And enter url as "url"

@tag1
Scenario: Valid login of icici
Given open browser as "firefox" And enter url as "https://infinity.icicibank.com/corp/Login.jsp"
When Enter username "username" And password "password" And click on sign in
|549630689|9989593467@m|
Then successfully login
@tag2
Scenario: Valid login of icici
Given open browser as "firefox" And enter url as "https://infinity.icicibank.com/corp/Login.jsp"
When Enter username "username" And password "password" And click on sign in
|549630689|9989593467@m|
Then successfully login
@tag3
Scenario Outline: Valid credentials of icici
Given open browser as "<browser>" And enter url as "<url>"

When enter username "<username>" And password as "<password>" And click on sign in
Then success "<status>"

Examples:
  |browser| url | username  |password | status |
   | firefox| https://infinity.icicibank.com/corp/Login.jsp|549630689|  9989593467@m | success|
   | chrome| https://infinity.icicibank.com/corp/Login.jsp|549630689|  9989593467@m | success|
   | firefox| https://infinity.icicibank.com/corp/Login.jsp|549630689|  9989593467@m | success|
