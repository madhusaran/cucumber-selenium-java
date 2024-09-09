@demo
Feature: Fetch Transactions


Scenario: Fetch all transaction details with a value of less than 50,000 from web table

Given User navigate to transaction page
Then Fecth the transactions with value "<" than 50000


Scenario: Fetch all transaction details with a value of greater than 50,000 from web table

Given User navigate to transaction page
Then Fecth the transactions with value ">" than 50000


Scenario: Fetch all transaction details with a value of equal to 15,000 from web table

Given User navigate to transaction page
Then Fecth the transactions with value "=" than 15000