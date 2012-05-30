Scenario: Addition using ExampleTable

Given a variable x with value 2
Given a variable y with value <expected>
When I add <value> to x
Then x should equal to y

Examples:
|value|expected|
|    1|       3|
|   17|      19|
|   40|      42|


Scenario: Addition using ExampleTable all parameters

Given a variable x with value 2
When I add <value> to <var>
Then <var> should equal to <expected>

Examples:
|var|value|expected|
|  x|    1|       3|
|  x|   17|      19|
|  x|   40|      42|
