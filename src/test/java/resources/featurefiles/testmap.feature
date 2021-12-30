Feature: Stores On Map Screenshot Test

  As a user I should be able to drag map to targeted location and take screenshot

  @regression
  Scenario: verify user is able to drag map to targeted location and take screenshot having location in centre
    When I click on information link "Our stores"
    Then I am able to drag map to Palm Beach Location and take screenshot