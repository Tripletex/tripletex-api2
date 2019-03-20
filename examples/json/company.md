## Company payload examples

### Update company information along with its address:
`PUT /company`
```json
{
  "id": COMPANY_ID,
  "name": "Updated company name",
  ...

  "address": {
    "id": ADDRESS_ID,
    "addressLine1": "Updated address line 1",
    "addressLine2": "Updated address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  }
}
```
