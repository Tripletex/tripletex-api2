# `/timesheet/entry` payload examples

### POST
Entry with project
````json
{
    "project": { "id": 123 },
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "1970-01-01",
    "hours": 7.5
}
````
With out project
````json
{
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "1970-01-01",
    "hours": 7.5
}
````

Chargeable Hours
````json
{
    "project": { "id": 123 },
    "activity":  { "id": 123},
    "employee": {"id": 123},
    "date": "1970-01-01",
    "hours": 8,
    "chargeableHours": 7.5,
    "chargeable": true
}
````

# `timesheet/salaryTypeSpecification` payload examples
### POST/PUT
Minimum
```json
{
    "employee": { "id":  123 },
    "salaryType": { "id":  123 },
    "date": "1970-01-01",
    "count": 2
}
```

With description
```json
{
    "employee": { "id":  123 },
    "salaryType": { "id":  123 },
    "description": "some text",
    "date": "1970-01-01",
    "count": 2
}
```
