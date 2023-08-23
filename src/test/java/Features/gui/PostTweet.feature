Feature: Post Tweet

  @PostTweet
  Scenario Outline: Post Tweet on twitter
    When When user enter a post <posts>

    Examples:
      | posts                                                                                                                                                                                       |
      | Super happy to participate in #TESTAUTOTHON2023 organised by @stepin_forum in partnership with @verity_software. This event is running in parallel with #STEPINSUMMIT2023.  Team Vodafone 3 |
      | The participation is amazing and about 35 teams are sure to win event. Team Vodafone-3. @stepin_forum @veriity_software                                                                     |
      | My Team Vodafone - 3 is doing great and we are sure to win event. Finger crossed for winning @stepin_forum @veriity_software                                                                |
      | Today is Day 1, preliminiary rounf=d for #TESTAUTOTHON2023. Results tomorrow during #STEPINSUMMIT2023 Results declaration @stepin_forum @veriity_software                                   |
      | #TESTAUTOTHON2023 #STEPINSUMMIT2023. Thanks for opening a platform to explore and demonstrate our knowledge. @stepin_forum @veriity_software                                                |