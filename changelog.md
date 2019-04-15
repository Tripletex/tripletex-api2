# API changelog

## 2.33.8 (2019-04-15)
* Added field `invoicesDueIn` to `/customer` endpoint
* Added field `invoicesDueInType` to `/supplier` endpoint

## 2.33.7 (2019-04-15)
* Added field `overdueNoticeEmail` to `/customer` endpoint
* Added field `overdueNoticeEmail` to `/supplier` endpoint

## 2.33.6 (2019-04-12)
* Added new search parameter `isApplicableForSupplierInvoice` to `GET /ledger/account`

## 2.33.5 (2019-04-10)
* Customer's isSupplier can be managed (created and updated) via `/customer`

## 2.33.4 (2019-04-04)
* Added readOnly field `hourlyCostPercentage` to `timesheet\entry`

## 2.33.3 (2019-04-02)
* Added endpoint GET, POST, PUT, DELETE `project\hourlyRates`
* Added endpoint GET, POST, PUT, DELETE `project\hourlyRates\projectSpecificRates`

## 2.33.2 (2019-03-14)
* Enhanced endpoint  `/department` with DELETE method

## 2.33.1 (2019-03-12)
* Added field to /employee: holidayAllowanceEarned: year, amount, basis, amountExtraHolidayWeek

## 2.33.0 (2019-03-08)
* Added endpoint GET, POST, PUT `/employee/hourlyCostAndRate`

## 2.32.5 (2019-03-06)
* Added field `factor` to `Currency` for GET `/currency`.

## 2.32.4 (2019-03-04)
* Extended `invoiceSendMethod` to support EFAKTURA. VIPPS and PAPER for PUT /customer/{id}/ and POST /customer API endpoints. The PUT /invoice/{id}/:send also supports these send methods.

## 2.32.3 (2019-02-28)
* Added fields `isMainEmployer` and `taxDeductionCode` to endpoint `/employee/employment` 

## 2.32.3 (2019-02-26)
* Added the possibility to create and update customers with emailAttahcmentType. The field `emailAttahcmentType` has been added to the PUT /customer/{id}/ and POST /customer API endpoints. This parameter is optional.

## 2.32.2 (2019-02-22)
* Employee's address can be managed (created and updated) via `/employee` endpoint
* Customer's postal and physical address can be managed (created and updated) via `/customer` endpoint
* Supplier's postal and physical address can be managed (created and updated) via `/supplier` endpoint

## 2.32.2 (2019-02-20)
* Added the possibility to create and update customers with invoiceSendMethod. The parameters `invoiceSendMethod` which is enum values and `singleCustomerInvoice` which is a boolean have been added to the PUT /customer/{id}/ and POST /customer API endpoints. These parameters are optional, but for setting `invoiceSendMethod` to EHF the `singleCustomerInvoice` must be set to false.

## 2.32.1 (2019-02-15)
* Added endpoint DELETE `/ledger/voucher/{id}/attachment`

## 2.32.0 (2019-02-11)
* Added endpoint GET, POST `/{travelExpenseId}/attachment`

## 2.31.0 (2019-01-20)
* Added endpoint GET `/timestheet/settings`

## 2.30.5 (2019-01-20)
* Added readOnly fields to /product: `elNumber`, `nrfNumber`

## 2.30.4 (2019-01-17)
* Added ENUM values to `employmentType`, `remunerationType` and `workingHoursScheme` in /employee/employment/details

## 2.30.2 (2019-01-08)
* Added fields to /supplier: `isWholesaler`, `showProducts`
* Added field to /product/external: `organizationNumber`

## 2.30.1 (2018-12-19)
* Added field to /employee: `comments`

## 2.30.0 (2018-12-18)
* Added endpoint POST, PUT, GET employee/nextOfKin
* Added fields to /employee: `phoneNumberHome`, `InternationalIdDTO `

## 2.29.0 (2018-12-14)
* Added endpoint POST employee/employment/leaveOfAbsence/list

## 2.28.1 (2018-12-13)
* Added endpoint GET, PUT `/company/settings/altinn`

## 2.28.0 (2018-12-03)
* Added endpoint GET, POST, PUT /division
* Deprecated endpoint GET /company/divisions

## 2.27.4 (2018-11-30)
* Added field `number`to Payslip

## 2.27.3 (2018-11-27)
* Deprecated response field `VoucherSearchResponse.totalNumberOfPostings`

## 2.27.2 (2018-11-22)
* Added fields to /country: `isoAlpha2Code`, `isoAlpha3Code`, `isoNumericCode`

## 2.27.1 (2018-11-21)
* Added PUT, POST and GET order line by ID to `project/orderline` 

## 2.27.0 (2018-11-12)
* Added field `discountPrice` to Product 

## 2.26.3 (2018-11-07)
* `/invoice/{id}/:payment` added optinal paidAmountCurrency parameter, to specify the amount paid in the invoice currency.

## 2.26.2 (2018-10-31)
* `PUT /ledger/voucher/{id}/:reverse` added method for reversing vouchers.

## 2.26.1 (2018-10-31)
* `GET /project` added the field `displayName`

## 2.26.0 (2018-10-29)
* Added endpoint `GET /invoice/details/{id}` which returns additional details about project invoices, such as project fee amounts, markup, travel expenses, invoice text, the amount on account balance and vat type. 
* Added `projectInvoiceDetails` to the Invoice API model, which contains a list of project invoice details for the given invoice.
* Added `discountPercentage` to the Project API model, containing the discount percentage specified for the project.

## 2.25.0 (2018-10-26)
* Added endpoint `PUT /contact`

## 2.24.0 (2018-10-24)
* The general field `changes` now contains all changes. Before this version only the creation and the last change was listed.

## 2.23.3 (2018-10-15)
* Added field `invoice` to TravelExpense 

## 2.23.2 (2018-10-12)
* `GET,PUT /project` added isReadyForInvoicing.

## 2.23.1 (2018-10-10)
* New endpoint: `/project/participant` (`POST`, `GET`, `PUT`, `DELETE`)
* `GET /project` Now has field for participants.

## 2.23.0 (2018-10-10)
* New endpoint: `/document`
* Three new fields in `GET /ledger/voucher`: attachment, document and ediDocument

## 2.22.2 (2018-10-09)
* `GET /project` Now has field for deliveryAddress.

## 2.22.1 (2018-09-19)
* `PUT /project` Now allow changing project description.

## 2.22.0 (2018-09-17)
* `POST /salary/transaction` new boolean parameter for generating tax deduction.
* `GET/POST/PUT/DELETE /project/orderline` new BETA endpoints for selected participants only.

## 2.21.4 (2018-09-12)
* `PUT /project` allow PUT on non-internal projects.

## 2.21.3 (2018-09-6)
* `GET /contact` added phoneNumberMobile.

## 2.21.2 (2018-09-05)
* Changed Swagger documentation to correctly specify return code `201` rather than `200` for `POST` requests.

## 2.21.1 (2018-08-31)
* `PUT /invoice/{id}/:createCreditNote` added for creating credit notes.
* AmountRoundoff og amountRoundoffCurrency added to Invoice.

## 2.20.1 (2018-08-24)
* `DELETE /ledger/voucher` added.
* `GET /inventory` with query parameter isMainInventory now works as intended.

## 2.20.0 (2018-08-23)
* `POST /ledger/voucher/importDocument` now supports an optional description that will be used on the new voucher(s).

## 2.19.0 (2018-08-22)

* New endpoint: `PUT /ledger/voucher/list` - Update multiple vouchers.
* `Voucher.year` is now correctly defined as read-only.

## 2.18.0 (2018-08-21)

* Added information about outstanding payment and payment reminders to invoices: `postings`, `reminders`, `sumRemits`, `amountOutstanding` og `amountOutstandingTotal`.
* Added a `/reminder` API endpoint and `:createReminder` to the invoice API endpoint.

## 2.17.1 (2018-08-17)

* Added support for `organizationNumber` query parameter in `/customer` (GET) and `/supplier` (GET).

## 2.17.0 (2018-08-16)

* `/customer` (PUT and POST): `accountManager` is no longer read-only.

## 2.16.2 (2018-08-13)

* Added the possibility to create prepaid invoices. The parameters `paymentTypeId` og `paidAmount` have been added to the PUT /order/{id}/:invoice and POST /invoice API endpoints. These parameters are optional, but both must be provided if a prepaid invoice should be created.

## 2.16.1 (2018-08-02)

* Fixed incorrect URL references to costCategory and paymentType from `travelExpense/cost`.

## 2.16.0 (2018-08-02)
* `POST /ledger/voucher/importDocument` [BETA] Upload a document to create one or more vouchers. Valid document formats are PDF, PNG, JPEG, TIFF and EHF.

## 2.15.2 (2018-07-27)

* Distinguished payment type in travelExpense API between costCategory and paymentType. new GET endpoints for `travelExpense/costCategory` and `travelExpense/paymentType`. It is now possible to actually obtain these for use with `travelExpense/cost`. (This is a "breaking" change for `travelExpense/cost`, but also makes it usable.)

## 2.15.1 (2018-07-04)

* Added field `reverseVoucher` to Voucher - a reference to the voucher that is produced when the current voucher is reversed.
* Added fields `vacationAllowanceAmount` (readonly), `grossAmount` (readonly), `amount` (readonly) to Salary.Payslip.
* Added field `amount` to Salary.Specification.

## 2.15.0 (2018-06-29)

* Added support of bank reconciliation.
* Added endpoint `bank/statement` for importing bank statements.
* Added endpoint `bank/reconciliation/`for reconciliation. Reconciliation can be done either with a bank statement, or without.
* Added endpoint `bank/reconciliation/match` for mapping postings to transactions on the bank statement.
* Added endpoint `bank/` for getting banks that are supported, their register numbers and the bank statement file formats that can be imported.

## 2.14.2 (2018-06-27)

* Added fields `externalAccountsNumber`, `description` (readonly) and `mainProject` (readonly) to Project.

## 2.14.1 (2018-06-21)

* Added webhook support for Customer, Supplier and Project:
	* `customer.create`
	* `customer.update`
	* `customer.delete`
	* `supplier.create`
	* `supplier.update`
	* `supplier.delete`
	* `project.create`
	* `project.update`
	* `project.delete`

## 2.14.0 (2018-06-19)

* Added endpoint `ledger/voucher/{id}/:sendToInbox`

## 2.13.3 (2018-06-18)
* `GET /employee`
	* Added **allowInformationRegistration** as a query parameter and as a read-only field. This parameter determines if salary information can be registered on the user including hours, travel expenses and employee expenses. The user may also be selected as a project member on projects.

## 2.13.2 (2018-06-15)

* Updated handling of JSON parse errors
	* Errors deserializing input JSON now results in [HTTP error 422](https://http.cat/422) instead of [500](https://http.cat/500)
	* Mapping errors are now specified instead of the generic message `Invalid json`

## 2.13.1 (2018-06-12)

* Added webhook support for Voucher events:
	* `voucher.create`
	* `voucher.update`
	* `voucher.delete`
* Changed endpoint `/timesheet/entry`
	* Added read-only field to TimesheetEntry: `chargeableHours`

## 2.12.2 (2018-05-28)

* Added endpoint `ledger/voucher/>nonPosted`

## 2.12.1 (2018-05-28)

* Changed endpoint `/supplier`
	* Introduced filter parameter `changedSince`, to only list suppliers changed after a given timestamp

## 2.12.0 (2018-05-28)

* Added endpoints for payment types for outgoing payments:
  * `GET /ledger/paymentTypeOut`
  * `POST /ledger/paymentTypeOut`
  * `POST /ledger/paymentTypeOut/list`
  * `PUT /ledger/paymentTypeOut/list`
  * `DELETE /ledger/paymentTypeOut/{id}`
  * `GET /ledger/paymentTypeOut/{id}`
  * `PUT /ledger/paymentTypeOut/{id}`

## 2.11.2 (2018-05-24)
  * Changed `GET /travelExpense`
	* added queryparameter **state** with the posilble values *ALL*, *OPEN*, *DELIVERED*, *APPROVED*, *SALARY_PAID* (default value *ALL*)

## 2.11.1 (2018-05-09)

* Added validation of addresses to `PUT /address/`
	* Empty addresses are not allowed.
	* Either Address.name or Address.customerVendorId is now required.

## 2.11.0 (2018-05-09)

* Added beta version of [webhooks](examples/webhook) for pilot users
	* Exposes new endpoints for `GET /event` and `GET/POST/PUT/DELETE /event/subscription`
	* Contact us to join the pilot program!

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

