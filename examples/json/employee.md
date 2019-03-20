## Employee payload examples

### Create a new employee resource along with its address:
`POST /employee`
```json
{
  "firstName": "John",
  "lastName": "Doe",
  ...

  "address": {
    "addressLine1": "Address line1",
    "addressLine2": "Address line2",
    "postalCode": "Postal code",
    "city": "Oslo"
  }
}
```


### Update an employee resource along with its address:
`PUT /employee/{id}`
```json
{
  "id": EMPLOYEE_ID,
  "firstName": "John",
  "lastName": "Doe",
  ...

  "address": {
    "id": ADDRESS_ID,
    "addressLine1": "Updated address line1",
    "addressLine2": "Updated address line2",
    "postalCode": "Updated code",
    "city": "Oslo"
  }
}
```
