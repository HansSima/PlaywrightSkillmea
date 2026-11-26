Feature: Formular

  Scenario: Test zaskrtnuti - 1
    Given Uzivatel je na strance formulare
    When Uzivatel zaskrtne radiobutton male
    And Uzivatel zaskrtne radiobutton female
    Then Uzivatel vidi zaskrtnuto female
    And Uzivatel vidi zaskrtnuto male