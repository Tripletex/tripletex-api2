## Customer payload examples

### Create a new customer along with its postal, physical, and delivery addresses:
`POST /customer`
```json
{
  "name": "New customer name",
  ...

  "postalAddress": {
    "addressLine1": "New postal address line 1",
    "addressLine2": "New postal address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  },
  "physicalAddress": {
    "addressLine1": "New physical address line 1",
    "addressLine2": "New physical address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  },
  "deliveryAddress": {
    "addressLine1": "New delivery address line 1",
    "addressLine2": "New delivery address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  }
}
```

### Update an existing customer along with its postal and physical addresses. Delivery address can be updated via **/address/{id}** endpoint:
`PUT /customer/{id}`
```json
{
  "id": CUSTOMER_ID,
  "name": "Updated customer name",
  ...

  "postalAddress": {
    "id": ADDRESS_ID,
    "addressLine1": "Updated postal address line 1",
    "addressLine2": "Updated Postal address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  },
  "physicalAddress": {
    "id": ADDRESS_ID,
    "addressLine1": "Updated physical address line 1",
    "addressLine2": "Updated physical address line 2",
    "postalCode": "0000",
    "city": "Oslo"
  }
}
```
