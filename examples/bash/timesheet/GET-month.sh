


#!/usr/bin/env bash

id="123"
employeeId="321"
monthYear="2020-01"


#get based on ID
curl "http://www.tripletex.no/v2/timesheet/month/$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#get based on month/employee
curl "http://www.tripletex.no/v2//timesheet/month/byMonthNumber?employeeIds=$employeeId&monthYear=$monthYear"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"
