## travelExpense POST payload examples

### Expense without cost
```json
{
	"employee":{"id":EMPLOYEE_ID},
		"isChargeable":false,
		"isFixedInvoicedAmount":false,
		"isIncludeAttachedReceiptsWhenReinvoicing":false
}
```


### travelExepense without compensations
```json
{
	"employee":{"id":EMPLOYEE_ID},
	"travelDetails":
	{
		"isForeignTravel":false,
		"isDayTrip":false,
		"departureDate":"2018-10-03",
		"returnDate":"2018-10-03",
		"departureFrom":"Haslum",
		"destination":"Oslo",
		"departureTime":"08:00",
		"returnTime":"17:00",
		"purpose":"work"
	},
	"isChargeable":false,
	"isFixedInvoicedAmount":false,
	"isIncludeAttachedReceiptsWhenReinvoicing":false
}
```


### travelExpense with mileage allowances (passenger rate for 2018)
```json
{
	"employee":{"id":EMPLOYEE_ID},
	"travelDetails":
	{
		"isForeignTravel":false,
		"isDayTrip":false,
		"departureDate":"2018-10-03",
		"returnDate":"2018-10-03",
		"departureFrom":"Haslum",
		"destination":"Oslo",
		"departureTime":"08:00",
		"returnTime":"17:00",
		"purpose":"work"
	},
	"isChargeable":false,
	"isFixedInvoicedAmount":false,
	"isIncludeAttachedReceiptsWhenReinvoicing":false,
	"mileageAllowances":[
		{
			"rateType":{"id":13603},
			"date":"2018-10-03",
			"departureLocation":"Haslum",
			"destination":"Oslo",
			"rate":1,
			"km":1,
			"passengers":[
				{
					"name":"Per"
				}
			]
		}
	]
}
```


### travelExpense with all compensation types
```json
{
	"employee":{"id":EMPLOYEE_ID},
	"travelDetails":{
	"isForeignTravel":false,
		"isDayTrip":false,
		"departureDate":"2018-10-03",
		"returnDate":"2018-10-03",
		"departureFrom":"Haslum",
		"destination":"Oslo",
		"departureTime":"08:00",
		"returnTime":"17:00",
		"purpose":"work"
	},
	"isChargeable":false,
	"isFixedInvoicedAmount":false,
	"isIncludeAttachedReceiptsWhenReinvoicing":false,
	"perDiemCompensations":[
		{
			"rateType":{"id":13593},
			"count":1,
			"location":"Haslum"
		}
	],
	"mileageAllowances":[
		{
			"rateType":{"id":13598},
			"date":"2018-10-03",
			"departureLocation":"Haslum",
			"destination":"Oslo",
			"rate":1,
			"km":1
		}
	],
	"accommodationAllowances":[
		{
			"rateType":{"id":13609},
			"count":1,
			"rate":1,
			"location":"Haslum"
		}
	],
	"costs":[
		{
			"paymentType":{"id":PAYMENT_TYPE_ID},
			"date":"2018-10-03",
			"costCategory":{"id":COST_CATEGORY_ID},
			"amountCurrencyIncVat":1
		}
	]
}
```
