Feature:Mail Testning

  Background:
    Given i am on the email regrestration page in "chrome" https://login.mailchimp.com/signup/

  @mytag
  Scenario Outline:User sign up
    Given I have input <email>
    And I have also input <username>
    And I have also input pasword <password>
    When I press signup
    Then the result should be <message> on the screen
    Examples:
      | email        | username      | password   | message                                                                              |
      | "emailValid" | "validUser"   | "Ludde?2x" | "Check your email"                                                                   |
      | "emailValid" | "100longUser" | "Ludde?2x" | "Enter a value less than 100 characters long"                                        |
      | "emailValid" | "alredyUser"  | "Ludde?2x" | "Another user with this username already exists. Maybe it's your evil twin. Spooky." |
      | "noEmail"    | "validUser"   | "Ludde?2x" | "Please enter a value"                                                               |