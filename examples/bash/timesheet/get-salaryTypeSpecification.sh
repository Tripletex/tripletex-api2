#!/usr/bin/env bash

#In this example we get every salary Type Specification registered on the 1st of February 2020 that you token has access to
# You could also use employeeId to sort on employees.
# both are optional
curl -X GET "http://www.tripletex.no/v2/timesheet/salaryTypeSpecification?dateFrom=2020-01-01&dateTo=2020-01-02" \
-H "accept: application/json" \
-H "authorization: Basic $TOKEN"
