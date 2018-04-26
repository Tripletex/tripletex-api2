# API changelog

## 2.10.1 (2018-04-25)

* Added endpoint `PUT /travelExpense/:copy`
* Changed validation for `TravelExpense`:
	* Validation now only occurs when `isCompleted` is set to `true`. Allows for creation of empty travel reports.

## 2.10.0 (2018-04-19)

* Added endpoints for `POST`, `PUT` and `DELETE` on `/project`
* Fixed some bugs

## 2.8.0 (2018-04-19)

* Added endpoint `PUT /ledger/voucher`
* Added endpoint `PUT /ledger/voucher/{id}`
* Added endpoint `DELETE /ledger/account`

## 2.5.5 (2018-02-08)

* Improved revision/version handling. The API now returns error code `8000` ("Revision Exception") when attempting to `PUT` an object with the wrong `version` specified. This typically happens when someone else has modified the specified object.

## 2.5.0 (2017-11-23)

* Added endpoints for salary:
	* `/salary/payslip`
	* `/salary/specification`
	* `/salary/transaction`
	* `/salary/type`

## 2.4.0 (2017-11-15)

* Added endpoints for employees and employment:
	* `/employee/employment`
	* `/employee/employment/details`
	* `/employee/employment/employmentType`
	* `/employee/employment/leaveOfAbsence`
	* `/employee/employment/leaveOfAbsenceType`
	* `/employee/employment/occupationCode`
	* `/employee/employment/remunerationType`
	* `/employee/employment/workingHoursScheme`
	* `/employee/standardTime`

## 2.3.3 (2017-11-07)

* Changed endpoint `/department`
	* Introduced filter parameter `departmentManagerId`

## 2.3.2 (2017-10-30)

* Changed endpoint `/product`:
	* Introduced filter parameter `productNumber`

## 2.3.1 (2017-10-20)

* Added endpoints for ledger (hovedbok):
 	* `/ledger/openPosts`
 	* `/leder/posting/openPosts`

## 2.3.0 (2017-10-10)

* Added endpoints for prospects (CRM):
	* `GET /crm/prospect`
	* `GET /crm/prospect/{id}`

## 2.2.0 (2017-09-27)

* Added endpoints for product:
	* `POST /product`
	* `PUT /product`
	* `PUT /product/unit`
	* `GET /product/unit/`
* Added fields to Product:
	* `priceIncludingVatCurrency` (utsalgspris inkl. mva)
	* `priceExcludingVatCurrency` (utsalgspris eks. mva)
	* `costExcludingVatCurrency` (innkjøpspris)
	* `isInactive`
	* `vatType` (mva-kode)
	* `currency`
	* `productUnit`
	* `isStockItem` (lagervare)
	* `stockOfGoods` (lagerbeholdning)

