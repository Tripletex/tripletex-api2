#!/usr/bin/env bash

id="123"

curl -X DELETE "http://www.tripletex.no/v2/timesheet/salaryTypeSpecification/$id"
-H "accept: application/json"
-H "authorization: Basic $TOKEN"
