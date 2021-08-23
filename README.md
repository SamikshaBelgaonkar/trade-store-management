# trade-store-management-duestcheBankAssessment

There is a scenario where thousands of trades are flowing into one store,  We have created one trade store, which stores the trade.

There are couples of validation, we have taken care of: 
1.	During transmission if the lower version is being received by the store it will reject the trade and throw an exception. If the version is same it will override the existing record.
2.	Store should not allow the trade which has less maturity date then today date.
3.	Store should automatically update expire flag if in a store the trade crosses the maturity date.

How to run this app: 
1. clone it to local machine.
2. Run the app as springBoot app.
3. Once the app is started. go to http://localhost:8080/h2-console and add the records. Alternatively, you can also use swagger-ui.
4. To check if records are been added, you can call the GET endpoint.
