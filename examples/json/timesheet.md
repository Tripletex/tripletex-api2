#`/timesheet/entry` payload examples

###POST
entry with project
````json
{
    "project": { "id": 123 },
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "01-01-1970",
    "hours": 7.5
}
````
with out project
````json
{
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "01-01-1970",
    "hours": 7.5
}
````

Chargeable Hours
````json
{
    "project": { "id": 123 },
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "01-01-1970",
    "hours": 8,
    "chargeableHours": 7.5,
    "chargeable": true
}
````

#`timesheet/salaryTypeSpecification` payload examples
###POST/PUT
minimum
```json
{
    "employee": { "id":  123 },
    "salaryType": { "id":  123 },
    "date": "01-01-1970",
    "count": 2
}
```

"normal"
```json
{
    "employee": { "id":  123 },
    "salaryType": { "id":  123 },
    "description": "some text",
    "date": "01-01-1970",
    "count": 2
}
```
