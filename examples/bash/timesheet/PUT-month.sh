#!/usr/bin/env bash

id="123"
employeeId="321,654,987"
monthYear="2020-01" #January 2020

#complete based on ID
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:complete?id=$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#complete based on month/employee
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:complete?employeeIds=$employeeId&monthYear=$monthYear"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#re-open based on ID
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:reopen?id=/$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#re-open based on month/employee
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:reopen?employeeIds=$employeeId&monthYear=$monthYear"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#approve based on ID
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:approve?id=/$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#approve based on month/employee
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:approve?employeeIds=$employeeId&monthYear=$monthYear"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#un-approve based on ID
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:unapprove?id=$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"

#un-approve based on month/employee
curl -X PUT "http://www.tripletex.no/v2/timesheet/month/:unapprove?employeeIds=$employeeId&monthYear=$monthYear"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"
