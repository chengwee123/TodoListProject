Feature: feature to test add/delete/edit new todos item functionality

  Scenario: Add new todos item successfully
    Given user is on todos page
    When user enters todo item
    And clicks on enter button
    Then new item displayed on the todos list page

  Scenario: edit todos item successfully
    When user double click on todo item
    And enter new item name
    Then update item name from todos list page

  Scenario: filter todos item list by Active
    When user enters todo item1
    And clicks on enter button1
    Then new item displayed on the todos list page1
    When user filter todo item by Active
    And clicks on Active button
    Then Active todo items should be displayed excluded (Completed)

  Scenario: filter todos item list by Completed
    When user completed a todo item
    And clicks on the item checkbox
    Then strikethrough the todo item
    When user filter todo item by Completed
    And clicks on Completed button
    Then Completed items should be displayed excluded (Active)

  Scenario: filter todos item list by ALL
    When user filter todo item by ALL
    And clicks on ALL button
    Then ALL todo items should be displayed included (Active/Completed)

  Scenario: Clear completed item from the list
    When user clear completed item
    And clicks on Clear Completed button
    Then Completed items should be removed from the list

  Scenario: delete todos item successfully
    When user mouseover on todo item
    And clicks on x button
    Then item removed from todos list page
