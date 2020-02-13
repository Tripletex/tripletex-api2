#!/usr/bin/env bash

#see timesheet.md in the json folder for more examples of bodies
body="{ \"count\": 10 }"
id="123"

curl -X PUT "http://www.tripletex.no/v2/timesheet/salaryTypeSpecification/$id" \
-H "accept: application/json" \
-H "authorization: Basic $TOKEN" \
-H "Content-Type: application/json" \
-d "$body"
