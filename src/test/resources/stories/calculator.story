Scenario: 2+2

Given a variable x with value 2
When I add 2 to x
Then x should equal to 4
And the calculator should not be in error

Scenario: 2+2 avec une variable y

Given a variable y with value 2
When I add 2 to y
Then y should equal to 4
And the calculator should not be in error

Scenario: 37+5 avec une variable UnBienJoli_Nom

Given a variable UnBienJoli_Nom with value 37
When I add 5 to UnBienJoli_Nom
Then UnBienJoli_Nom should equal to 42
And the calculator should not be in error

Scenario: 7+2 et 9+4 avec une variable y et une variable x

Given a variable y with value 7
Given a variable x with value 9
When I add 2 to y
When I add 4 to x
Then x should equal to 13
Then y should equal to 9
And the calculator should not be in error

Scenario: 37+5+6+17 

Given a variable x with value 37
When I add 5 to x
And I add 6 to x
And I add 17 to x
Then x should equal to 65
And the calculator should not be in error

Scenario: Undefined variable displays error message

When I add 5 to y
Then the calculator should display the message 'Variable <y> is not defined'


Scenario: Variable can be added to an other variable

Given a variable x with value 37
Given a variable y with value 5
When I add y to x
Then x should equal to 42
And the calculator should not be in error

