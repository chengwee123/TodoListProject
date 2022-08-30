# TodoListProject

Instructions
Clone the repo:

Git:
$ git clone git@github.com:chengwee123/TodoListProject.git

Use Maven
Open a command window and run:
mvn test


Run a subset of Features or Scenarios:
-Dcucumber.options="src/test/resources/Features/TodoList.feature --plugin pretty"

Specify a different formatter:
-Dcucumber.options="--plugin json:target/JSONReports/report.json"
