#!/usr/bin/env bash

#see timesheet.md in the json folder for more examples of bodies
body="{ \"employee\": { \"id\":  123 }, \"salaryType\": { \"id\":  123 }, \"date\": \"1970-01-01\", \"count\": 2 }"

curl -X POST "http://www.tripletex.no/v2/timesheet/salaryTypeSpecification" \
-H "accept: application/json" \
-H "authorization: Basic $TOKEN" \
-H "Content-Type: application/json" \
-d "$body"
