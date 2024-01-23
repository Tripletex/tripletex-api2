# API changelog

## 2.70.53 (2024-01-23)
- Changes to AltinnApi, now get returns "***********" when the company has AltinnLogin

## 2.70.52 (2024-01-17)
  - Add new fields in `TravelExpenseZoneDTO`
    - `fromDate` (inclusive)
    - `toDate` (inclusive)
    - `currencyId`
- Add new query params to `GET /travelExpense/zone`
    - `date`, getting the valid zones based on `fromDate` and `toDate`
    - `query`, searching by `countryCode` or `zoneName`
- New ordering of `GET /travelExpense/zone` based on `zoneName`
- New API for all available Pension Providers `/pension` that can be connected to `/salary/settings/pensionScheme`

## 2.70.51 (2023-12-11)
- Add API endpoint /vatTermSizeSettings for specifying VAT term sizes.

## 2.70.50 (2023-12-06)
- Add new field `department` to `AccountDTO`

## 2.70.48 (2023-10-23)
- Added `POST /contact/list` endpoint for batch creating new contacts

## 2.70.47 (2023-10-20)
- Added ordering to `department/query` (orders by number, then by name)

## 2.70.46 (2023-09-15)
-  Add new field `isRemoveAccessAtEmploymentEnded` to `EmploymentDTO`

## 2.70.45 (2023-08-24)
- Add new field `discountPercentage` to `OrderDTO`
- Add new field `markUpOrderLines` to `OrderDTO`

## 2.70.44 (2023-07-20)
- Add new field `status` to `OrderDTO`
- Add new field `website` to `CustomerDTO`
- Add new field `website` to `SupplierDTO`

## 2.70.43 (2023-07-04)
- Add new field `OrderGroups` to `OrderDTO`
- Add new query param `updateLinesAndGroups` to `PUT /Order/{id}`

## 2.70.42 (2023-05-04)
- Add new field `discountPercentage` to `CustomerDTO`

## 2.70.41 (2023-04-28)
- Add API endpoint for searching for result budgets for multiple projects, departments, employees or products.
  - GET `/resultbudget`

## 2.70.40 (2023-04-24)
- Added endpoints to upload and delete attachments on salary
  - PUT `/salary/transaction/{id}/attachment`
  - POST `/salary/transaction/3746350/attachment/list`
  - POST `/salary/transaction/3746350/attachment`

## 2.70.30 (2023-04-12)
- Change "Send PO by email" API to send data as `body` istead of `Query Params`
- 
## 2.70.21 (2023-04-12)
- Added DELETE endpoint to `Order`

## 2.70.20 (2023-03-27)
- Added /asset/upload API endpoint for importing assets in Excel format.

## 2.70.19 (2023-03-14)
- Added to depreciationAccountId, lifetimeInMonths, incomingBalance, accumulatedDepreciation to Asset.

## 2.70.18 (2023-03-07)
- `stockOfGoods` from `Product` resource will only be available on demand 

## 2.70.17 (2023-03-01)
- Added new endpoint `GET municipality/query`

## 2.70.15 (2023-02-15)
- Updated InvoiceDTO by adding a new InvoiceRemarkDTO and deprecating the old invoiceRemarks field.

## 2.70.14 (2023-02-10)
Added sendToCustomer param to the invoice endpoint :createCreditNote

## 2.70.12 (2023-02-07)
- Added PUT endpoint for EmployeePreferences
- New field in EmployeePreferencesDTO
    - `language`

## 2.70.11 (2023-01-10)
- New field in SupplierInvoiceDTO 
    - `outstandingAmount`

## 2.70.10 (2023-01-05)
- New field in PurchaseOrderlineDTO 
    - `supplierProduct`

## 2.70.9 (2022-12-16)
- Add "query" param for `GET /inventory` to be able searching by name

## 2.70.8 (2022-12-14)
- Added new endpoint: `GET /employee/employment/occupationCode/{id}`
- New field for search `GET /employee/employment/occupationCode`
- `id` filter based on OccupationCode ids

## 2.70.7 (2022-12-14)
- New field invoicingDepartment in AccountDTO

## 2.70.5 (2022-11-21)
- Added endpoint for downloading reminder pdf: `/reminder/{reminderId}/pdf`

## 2.70.4 (2022-10-25)
- Deprecating `typeOfStocktaking` field in `/inventory/stocktaking`

## 2.70.3 (2022-10-25)
- `POST order/:invoiceMultipleOrders` supports field `sendToCustomer`

## 2.70.2 (2022-10-24)
- `POST order/:id/invoice` supports fields `sendType` and `overrideEmailAddress`

## 2.70.1 (2022-10-24)
- Deprecating `isDeletable` field in `product` endpoint. Field will always return false for other consumers then Tripletex Web or App.

## 2.70.0 (2022-10-24)
- Added new endpoint fore reading, creating and deleting opening balances: 'ledger/voucher/openingBalance' with GET, POST and DELETE. The opening balance is a starting point for accounting in Tripletex, where existing balance and sub-ledger values can be defined.

## 2.69.27 (2022-10-13)
- Added new internal fields for `ProductLineDTO`: `counted`, `counter`, `dateCounted` and `expectedStock` 
- Added new read-only field for `ProductLineDTO`: `location`

## 2.69.26 (2022-10-10)
- Added new query params `query` and `productGroupIds` for search method in `ProductLineAPI`

## 2.69.25 (2022-09-27)
- Added endpoints for CompanyStandardTime: `salary/settings/standardTime`
- Added new endpoint `GET employee/standardTime/byDate`

## 2.69.24 (2022-09-05)
- Added endpoint DrivingStop (post, get, delete)

## 2.69.23 (2022-09-02)
- Added fields requiresDepartment and requiresProject to AccountDTO

## 2.69.22 (2022-07-08)
- Added new endpoint: `DELETE /contact/list`. It takes a comma separated list of contacts ids

## 2.69.21 (2022-07-06)
- New field in ProductDTO 
    - `mainSupplierProduct`
- New field in SupplierProductDTO
    - `isMainSupplierProduct`
   
## 2.69.20 (2022-06-10)
- Deprecated `discountPrice` from `Product` resource  

## 2.69.19 (2022-05-04)
- New field for search GET `/employee` filter based on `email`

## 2.69.18 (2022-04-26)
- Added webhooks for account.create, account.update and account.delete

## 2.69.17 (2022-04-08)
- Added field saftCode to ledger/account POST , GET and PUT

## 2.69.16 (2022-04-07)
- Added field externalVoucherNumber to ledger/voucher POST and PUT

## 2.69.15 (2022-04-04)
- Added new field in VoucherDTO:
  - `supplierVoucherType`
 
## 2.69.14 (2022-04-01)
- Deprecated `GET product/external` endpoint please use `GET product/external/query` or `GET product/external/{id}`.

## 2.69.13 (2022-03-22)
- Added new field in SupplierDTO:
  - `isEfoNelfoMerchant`

## 2.69.12 (2022-03-21)
- Added endpoint for ResourcePlanBudget
  - `GET /project/resourcePlanBudget`
## 2.69.11 (2022-03-03)
- New field in CurrencyDTO 
    - `isDisabled`
- New field in ProductPriceDTO
    - `purchasePriceCurrency`
- Added parameter `showOnlyLastPrice` to `GET product\price` method

## 2.69.10 (2022-02-28)
- Added new PurchaseOrderline endpoints:
  - `POST /purchaseOrder/orderline/list`
  - `PUT /purchaseOrder/orderline/list`
  - `DELETE /purchaseOrder/orderline/list`
- Added new fields to PurchaseOrder:
  - `internalComment`
  - `receivedDate`
  - `lastSentTimestamp`
  - `lastSentEmployeeName`
- Added new field to PurchaseOrderline:
  - `unitListPriceCurrency`
 
## 2.69.9 (2022-02-18)
- Added field `isFactoring` to `Customer`.

## 2.69.8 (2022-03-02)
- Added fields `accountNumberFrom` and `accountNumberTo` in `Ledger/posting`

## 2.69.7 (2022-02-10)
- Added field `sequence` to `TravelCostCategoryDTO`.

## 2.69.6 (2022-01-26)
- Removed field `employee` from `Address`.

## 2.69.5 (2021-11-24)
- Added parameter `AVTALEGIRO` to the URL parameter `sendType` for the endpoint `PUT /invoice/{id}/:send`.
- This allows integrations to send invoices as AvtaleGiro.

## 2.69.4 (2021-11-16)
- Added field `invoiceOnAccountVatHigh` to `Order`
- Added field `totalInvoicedOnAccountAmountAbsoluteCurrency` to `Order`

## 2.69.3 (2021-11-15)
- Added field `currency` to `Company`

## 2.69.2 (2021-11-05)
- Added new query parameters `paidAmountAccountCurrency`, `paymentTypeIdRestAmount` and `paidAmountAccountCurrencyRest` to `POST /order/{id}/:invoice`. 
This is to support prepaid amount where invoice currency is different to payment account currency and to support prepaid amount with two different payment types.

## 2.69.1 (2021-11-03)
- Added field `useProductNetPrice` to `Project`
- Added field `ignoreCompanyProductDiscountAgreement` to `Project`

## 2.69.0 (2021-10-27)
- API endpoint for creating historical vouchers. These are vouchers created outside Tripletex, and should be from closed accounting years. The intended usage is to get access to historical transcations in Tripletex. Also creates postings. All amount fields in postings will be used. VAT postings must be included, these are not generated automatically like they are for normal vouchers in Tripletex.
  - `POST /ledger/voucher/historical/historical`
  - `POST /ledger/voucher/historical/employee`
  - `POST /ledger/voucher/historical/{voucherId}/attachment`
  - `PUT /ledger/voucher/historical/:closePostings`
  - `PUT /ledger/voucher/historical/:reverseHistoricalVouchers`
  - `PUT /ledger/vatType/createRelativeVatType`

## 2.68.18 (2021-10-25)
- Added field `ledgerAccount` to `Customer` and `Supplier`
  - This is used on `Multiple Ledgers` to specify ledger account on customers and suppliers. 

## 2.68.17 (2021-09-30)
- Added field `canCreateBackorder` to `Order`

## 2.68.16 (2021-09-20)
- Added field `sendMethodDescription` to `Order`

## 2.68.15 (2021-09-03)
- Added field `externalRef` to `Posting`. The field contains an external reference for identifying payment basis of the posting, e.g., KID, customer identification or credit note number.

## 2.68.14 (2021-08-23)
- Fixed a bug in `POST /invoice/list` introduced in `2.68.10` where the operation would fail because of duplicate order creations.

## 2.68.13 (2021-08-12)
- Added field "changedSince" to `GET /customer`

## 2.68.12 (2021-08-05)
- Added field "createBackOrder" to '/order/{id}/:invoice'

## 2.68.11 (2021-07-21)
- Added inventory id to response for `GET /inventory/inventories`

## 2.68.10 (2021-07-14)
- Fixed bug that did not create orderLines if included in `POST /order`

## 2.68.9 (2021-07-01)
- Added validation on `/employee/employment` for `startDate` so it can no longer be changed to after the `date` of the second `employmentDetails`

## 2.68.7 (2021-07-01)
- Added query parameters `createOnAccount`, `amountOnAccount`, and `onAccountComment` to PUT `/order/{id}/:invoice`

## 2.68.6 (2021-06-28)
- Added fields `amortizationAccount`, `amortizationStartDate`, and `amortizationEndDate` to `PostingDTO`

## 2.68.5 (2021-06-28)
- Added new query parameter `voucherDate` to `PUT /supplierInvoice/voucher/{id}/postings`. Allows changing the date of the voucher connected to this supplier invoice: "If set, the date of the voucher and the supplier invoice will be changed to this date. If empty, date will not be changed" 

## 2.68.4 (2021-06-21)
- Added `PUT /supplierInvoice/{invoiceId}/:changeDimension` for changing of project, department, employee, and product on debit postings for a supplier invoice. 

## 2.68.3 (2021-06-10)
- Added field `isInactive` to `Department`

## 2.68.1 (2021-05-19)
- Added `GET /ledger/voucher/>externalVoucherNumber` to find vouchers based on the external voucher number. 

## 2.68.0 (2021-05-07)
- Added `POST /purchaseOrder/{id}/attachment/list`
- Added `DELETE /purchaseOrder/{id}/attachment`

## 2.67.0 (2021-05-06)

- Added `GET /saft/exportSAFT` for exporting a SAF-T file of the Tripletex account.

## 2.66.0 (2021-05-04)
- Added `GET /product/discountGroup`
- Added `GET /product/discountGroup/{id}`- 
- Added `POST /product/{id}/image`
- Added `DELETE /product/{id}/image`
- Added field `discountGroup` to `Product`
- Added field `weight` to `Product`
- Added field `weightUnit` to `Product`
- Added field `volume` to `Product`
- Added field `volumeUnit` to `Product`
- Added field `image` to `Product`

## 2.65.0 (2021-05-03)

- Added `POST /saft/importSAFT` for importing SAF-T files into Tripletex.


## 2.64.0 (2021-04-21)

- Added `GET /project/controlFormType`
- Added `GET /project/controlFormType/{id}`
- Added `GET /project/settings`
- Added `PUT /project/settings`

## 2.63.4 (2021-04-20)

- Added field `costPercentage` to `ActivityDTO`

## 2.63.3 (2021-03-30)

- Added `department` to `Contact`
- New field for search GET `/contact` filter based on `department`

## 2.63.2 (2021-03-25)

- New GET `/project/template/{id}` endpoint

## 2.63.1 (2021-03-23)

- New field for search GET `/inventory/inventoryLocation` filter based on `name`

## 2.63.0 (2021-03-17)

- Bulk endpoints for `Subscription`
  - `PUT /event/subscription/list`
  - `POST /event/subscription/list`
  - `DELETE /event/subscription/list`

## 2.62.2 (2021-03-15)

- New fields for search `GET /product/inventoryLocation`
  - `inventoryId` filter based on Inventory ids
  - `isMainLocation` filter based on InventoryLocation that are marked as main locations.

## 2.62.1 (2021-02-19)

- Added `basisPercentage` and `relativeVatType` to `VatTypeDTO`!

## 2.62.0 (2021-02-18)

- Added read-only field `document` to `PurchaseOrder`
- Added read-only field `attachment` to `PurchaseOrder`
- Added read-only field `ediDocument` to `PurchaseOrder`
- Added `POST /purchaseOrder/{id}/attachment`

## 2.61.0 (2021-02-17)

- Added model `PickupPoint`
- Added `GET /pickupPoint`
- Added `GET /pickupPoint/{id}`
- Added field `pickupPoint` to `PurchaseOrder`

## 2.60.5 (2021-02-16)

- New field in `GET /inventory/location` field `isInactive`. Makes it possible to search for InventoryLocations based active / inactive.

## 2.60.4 (2021-02-15)

- New field in `GET /voucherStatus` field `status`. Make it possible to search for voucherStatuses filtered by status.
- New field in `GET /voucherStatus` field `type`. Make it possible to search for voucherStatuses filtered by type.
- Change `GET /invoice` field `voucherId` to take a comma separated list of voucherIds

## 2.60.3 (2021-02-09)

- New field in `POST /supplierInvoice/{invoiceId}/:addPayment` `partialPayment`. Adding multiple payments are now only possible when setting `partialPayment`to true.

## 2.60.2 (2021-02-09)

- Deprecated field `bankAccounts` on `CustomerDTO` and `SupplierDTO`.
- Introduced new field `bankAccountPresentation` on `CustomerDTO` and `SupplierDTO`. This can now be used to create/update and
read bankAccount information connected to a customer or supplier.

## 2.60.1 (2021-02-04)

- Added endpoint `ledger/voucher/>voucherReception`

## 2.60.0 (2021-02-01)

New resultbudget endpoints:

- GET: `/resultbudget/company`
- GET: `/resultbudget/department/{id}`
- GET: `/resultbudget/project/{id}`
- GET: `/resultbudget/product/{id}`
- GET: `/resultbudget/employee/{id}`

## 2.59.1 (2021-01-27)
- Added new query params `typeOfVat` and `vatDate` on `GET /ledger/vatType`. If you for example specify `OUTGOING`
as the type of VAT, you will only get VAT types that the company has access to (from the vat-settings of the company) and is of the provided type. 
`vatDate` will default to today's date if not specified.
- Added new field `legalVatTypes` on `AccountDTO`. This is a list of legal VAT types that you can use on the actual account. 

## 2.59.0 (2021-01-26)
- The checksum feature is now only used if the client specifies the `If-None-Match` header

## 2.58.0 (2021-01-18)
- Added new endpoint: product/inventoryLocation (GET, POST, PUT, DELETE)
- Added field `inventoryLocation` to `GoodsReceiptLineDTO`, `OrderLineDTO` and `ProjectOrderLineDTO`
Only available for users that have activated the Logistics Pluss Beta-program

## 2.57.7 (2021-01-07)
- Added field `invoiceComment` to `ProjectDTO`

## 2.57.6 (2021-01-05)
- Added query param `assignableProjectManagers` to `/employee` (GET) endpoint

## 2.57.5 (2020-12-22)
- Removed deprecated field `deductions` from `SalaryCompilationDTO`, which affects `salary/compilation` endpoint

## 2.57.4 (2020-12-17)
- Added new readonly postingType `OUTGOING_INVOICE_CUSTOMER_POSTING` to `PostingDTO`

## 2.57.3 (2020-12-14)
- Can now set `deliveryAddress` field in `ProjectDTO` (no longer readonly)

## 2.57.2 (2020-12-11)
- Added fields `orderLines` and `travelReports` to `InvoiceDTO`

## 2.57.1 (2020-12-08)
- Added field `attention` to `ProjectDTO`
- Added field `reference` to `ProjectDTO`
- Can now set `contact` field in `ProjectDTO` (no longer readonly)

## 2.57.0 (2020-12-07)
- Added new endpoint: product/logisticsSettings (GET, PUT)

Only available for users that have activated the Logistics Pluss Beta-program

## 2.56.6 (2020-12-02)
- Added Attachment of earnings (tax) to `salary/compilation` endpoint

## 2.56.5 (2020-11-30)
- Added new endpoint to `order/orderLine` (PUT)

## 2.56.4 (2020-11-26)
- Added new endpoint: `addPayment` to `SupplierInvoiceAPI`
- Removed authorization on call to GET `/event`

## 2.56.3 (2020-11-24)
- Added new readonly postingType `INVOICE_EXPENSE` to `PostingDTO`

## 2.56.2 (2020-11-23)
- Add EmployeeDTO as readonly property `sender` in `/voucherMessage` endpoint.

## 2.56.1 (2020-11-19)
- Add `comment`, `message`, `externaObjectUrl` and `referenceNumber` to `VoucherStatusDTO` 
- Add `attachments` to `OrderDTO`
- Added `employeeCategory` to `EmployeeDTO`
- Added new endpoint: `employee/category` (GET, POST, PUT, DELETE)
- Added new endpoint: `employee/category/list` (POST, PUT, DELETE)

## 2.56.0 (2020-11-18)
- Added new endpoint: `product/productPrice` (GET)

## 2.55.2 (2020-11-17)
- Add field `preliminaryInvoice` to `OrderDTO`
- Open `/Invoice` for preliminary invoices

## 2.55.1 (2020-11-13)
Updated existing and created new endpoints for changes in a-melding from January 2021:
- Added field employmentEndReason  to /employment endpoint
- Added field employmentForm to /employment/details endpoint
- Added new endpoints /salary/settings/pensionScheme  (GET, PUT, POST, DELETE)

## 2.55.0 (2020-11-11)
- Added new endpoint: `voucherMessage` (POST, GET)

## 2.54.9 (2020-11-09)
- Added the fields `creditedInvoice` and `isCredited` to the `/invoice` endpoints

## 2.54.8 (2020-11-05)
- Removed unused field `extraPercentOrderLines` in `/project

## 2.54.7 (2020-11-01)
- Made comment optional when approving voucher in `/supplierInvoice`
- Corrected sorting order of elements in `voucherApprovalListElementDTO`

## 2.54.6 (2020-10-20)
- Added `language` field to `/customer` endpoints

## 2.54.5 (2020-10-19)

Made following changes to `/supplierInvoice`
- Re-named field `number` to `invoiceNumber`
- Added `commentFromOriginator` and `project` to VoucherApprovalListElementDTO
- Made sure the order of the VoucherApprovalListElements are the same in the api as in the web application

## 2.54.4 (2020-10-14)

- Added new endpoints `DELETE /customer` and `DELETE /supplier`.

## 2.54.3 (2020-10-08)

- Added tempNumber to VoucherDTO.

## 2.54.2 (2020-09-21)

- Add new API endpoint: `POST /order/list` which allows posting a list of Orders, with OrderLines embedded inside.

## 2.54.1 (2020-09-04)

- Added `phoneNumberWork` to `ContactDTO`

## 2.54.0 (2020-09-04)

- Add new API endpoint: `POST /invoice/list` which allows posting a list of Invoices, with new Order and OrderLines embedded inside.
- Allow embedding new Orders and OrderLines inside an Invoice, when posting a new Invoice using the `POST /invoice` API endpoint.
- API change: `paymentTypeId` and `paidAmount` added to InvoiceDTO. These are optional, and used to specify payment type and paid amount when posting a list of invoices.
- API change: In OrderLineDTO, the `order` field is now optional. This is because now, a list of Invoices can be posted, where each Invoice contains a list of Orders, where each Order contains a list of OrderLines, embedded inside.

Example of `POST /invoice/list`:
```json  
  [
    {
      "invoiceDate": "2020-09-02",
      "invoiceDueDate" : "2020-09-12",
      "orders" : [
      {
       "deliveryDate" : "2020-09-03",
       "orderDate" : "2020-09-01",
       "customer" : {"id" : 3001 },
       "orderLines" : [{
         "count" : 2,
         "description" : "Example description"
         }]
       }
     ]
    }
  ]
```

## 2.53.0 (2020-08-24)

- Added new endpoints for approving supplierInvoices:
  - `PUT /supplierinvoice/:approve`
  - `PUT /supplierinvoice/{id}/:approve`
  - `PUT /supplierinvoice/{id}/:reject`
  - `PUT /supplierinvoice/{id}/:addRecipient`

## 2.52.0 (2020-08-19)

- Added new endpoints`/order/orderGroup` (get, put, post, delete)

## 2.51.0 (2020-08-17)

- Added new endpoint`/product/unit/master` with a list of Product Units (Get)

## 2.50.0 (2020-07-08)

- Added new endpoint`/supplierInvoice/voucher/{id}/postings` (Put)

## 2.49.0 (2020-07-06)

- Added new endpoints `/voucherStatus` (get, post)

## 2.48.0 (2020-06-30)

- Added `GET` for new endpoint `/balanceSheet` (get the balance sheet / saldobalanse for the specified parameters)

## 2.47.0 (2020-06-25)

Added new `transportType` endpoint.

## 2.46.3 (2020-06-04)

- Added `invoiceComment` and `invoiceRemarks` to InvoiceDTO.

## 2.46.2 (2020-05-18)

Set the correct values of taxDeductionCode and isMainEmployer upon creating of employments if those fields are not sent to Tripletex.

## 2.46.1 (2020-05-15)

Added fields `tollCost` and `passengerSupplement` to `MileageAllowanceDTO`

## 2.46.0 (2020-05-15)

New endpoints for deviation on purchaseorder. Only available for users that have activated the Logistics Pluss Beta-program:

- purchaseOrder/deviation (GET, POST, PUT DELETE)
- purchaseOrder/deviation/{id}/:approve
- purchaseOrder/deviation/{id}/:deliver
- purchaseOrder/deviation/{id}/:undeliver

## 2.45.2 (2020-05-11)

- Added readonly field isInactive to Activity endpoint.

## 2.45.1 (2020-05-05)

- Improved PUT `/travelExpense/`to allow managing lists of perdiemCompensations ( creating / updating / deleting multiple perdiemCompensations in one request)

## 2.45.0 (2020-04-27)

- Added GET `/timesheet/month`, this gets the month status/overview for a specified month/employee combination or ID
- Added PUT `/timesheet/month` actions for complete, re-open, approve and un-approve based on a month/employee combination or ID

## 2.44.2 (2020-04-27)

Added `DELETE` method to `product` endpoint.

## 2.44.1 (2020-04-22)

Added `receiverEmail`, `discount`, `packingNoteMessage`, `transporterMessage`, `comments`, `attention` and `currency` fields to PurchaseOrder object

## 2.44.0 (2020-04-21)

Added `GET` for new endpoint `/travelExpense/zone` (find zone by id and search)
Added new field `travelExpenseZoneId` to `/travelExpense/perDiemCompensation` endpoint in `PerDiemCompensationDTO`

## 2.43.1 (2020-04-16)

Added `DEFAULT` send type parameter for `/purchaseOrder/{id}/:send` method

## 2.43.0 (2020-04-08)

New endpoints added for product group:

- `product/group` (GET, POST, PUT, DELETE)
- `product/groupRelation` (GET, POST, DELETE)

## 2.42.1 (2020-04-07)

Small patch for `purchaseOrder` endpoint

- Change name of the field `contact` to `ourContact` to be consistent with the GUI
- Added field `supplierContact`

## 2.42.0 (2020-04-03)

New methods added for `purchaseOrder` endpoint:

- `/purchaseOrder/{id}/:send`
- `/purchaseOrder/{id}/:sendByEmail`

## 2.41.2 (2020-03-18)

`/travelExpense/perDiemCompensation/autoSuggest` new internal endpoint that generates on the fly per diem compensations with auto-suggested data based on input and travel details without storing them in the database. ( POST )

## 2.41.1 (2020-03-18)

`/address` endpoints are now deprecated and hidden. Prefer using `/deliveryAddress` for delivery addresses, or addresses through their parent objects, e.g. `/employee` or `/customer`. Existing integrations are not affected.

## 2.41.0 (2020-03-17)

New endpoint added:

- `purchaseOrder/orderline` (GET, POST, PUT, DELETE)

## 2020-03-17

- Session, consumer, and employee tokens generated on the test environment (api.tripletex.io) are now prefixed with `test-`, to easily distinguish them from production tokens.

## 2.40.2 (2020-03-12)

- `VoucherDTO` Added validation on voucher type

## 2.40.1 (2020-03-11)

- Added field `description` to `Product`.

## 2.40.0 (2020-03-10)

New endpoints for goods receipt. Only available for users that have activated the Logistics/Logistics Pluss Beta-program:

- `purchaseOrder/goodsReceipt` (GET, POST, PUT DELETE)
- `purchaseOrder/goodsReceiptLine` (GET, POST, PUT DELETE)

## 2.39.3 (2020-02-25)

- New endpoint:
  `PUT /order/:invoiceMultipleOrders` Charges a single customer invoice from multiple orders. The orders must be to the same customer, currency, due date, receiver email and attn.

## 2.39.2 (2020-02-21)

- Changes to `GET /timesheet/salaryTypeSpecification`. We have have removed query `date` in favour of `dateFrom`
  (From and including) and `dateTo` (To and excluding). This change is done to make the endpoint be more in line with
  other timesheet endpoints like `/entry` for instance. This is not something we usually do but as this endpoint is in beta
  and only been released on week ago, it's a bit of now or never.

- `CustomerDTO` change
  Allow multiple email addresses on invoice email, separated by ;

## 2.39.1 (2020-02-19)

Added new methods to `/purchaseOrder` endpoint:

- POST
- PUT
- DELETE

## 2.39.0 (2020-02-13)

End point changed:

- added `showInTimesheet` to `/salary/type` this boolean value describes if if a salary type is applicable for timesheet or not

New endpoint:

- `timesheet/salaryTypeSpecification` (GET, POST, PUT DELETE):  
  Adding this endpoint has given us the possibility to log for instance overtime.

## 2.38.6 (2020-02-13)

New endpoints in product:

- POST /product/list
- PUT /product/list

## 2.38.5 (2020-02-03)

Webhooks for `create` (and similar) events are now triggered even when an update happens at the same time.
Previously, only the `update` webhook was sent, skipping the `create` webhook.
This means it should no longer be necessary to subscribe to `update`-events when you're only interested in `create`.

## 2.38.4 (2020-01-30)

- Allow creation of external projects (isInternal = false) from POST `/project/` and PUT `/project/` for pilots only.
- New endpoint `/project/projectActivity`
- POST: `/activity`

## 2.38.3 (2020-01-30)

- Added field `status` to GET `/purchaseOrder` and GET `/purchaseOrder/{id}` endpoint

## 2.38.2 (2020-01-20)

Updated following field in ProjectDTO:

- mainProject should now update the main project via PUT `/project/{id}`

## 2.38.1 (2020-01-16)

Added following field to ContactDTO:

- phoneNumberMobileCountryId (If not set, it will be derived from phoneNumberMobile if possible, or default to Norway)

## 2.38.0 (2020-01-15)

Added endpoint:

- GET `/purchaseOrder` and GET `/purchaseOrder/{id}`

## 2.37.8 (2020-01-09)

Removed `required` validation for fields marked as `readOnly`. Resolves [issue #12](https://github.com/Tripletex/tripletex-api2/issues/12)

## 2.37.7 (2020-01-08)

Added following field to EmployeeDTO:

- phoneNumberMobileCountryId (If not set, it will be derived from phoneNumberMobile if possible, or default to Norway)

## 2.37.6 (2019-12-16)

Added two new endpoints for salary compilation:

- `/salary/compilation`
- `/salary/compilation/pdf`

## 2.37.5 (2019-12-16)

Abroad remittance for salary transactions is now supported - only in pilot. Added following fields to EmployeeDTO:

- iban
- bic (swift)
- creditorBankCountryId

## 2.37.3 (2019-11-25)

- Added query param includePayrollTaxZones to endpoint municipality/get. Default is true. True will return payroll tax zone info with the municipality DTO. Notice that since there now are municipalities with more than one zone, those are represented by more than one DTO with the same municipality number.

## 2.37.2 (2019-11-15)

- Added 'mimetype' field to DocumentDTO
- Updated `Bankstatement`
  _ Added `accountId` field to Bankstatement and restrictions have been added to not allow bankstatements for the same
  account and time period.  
   _ POST: `/bank/statement/import` now requires that `bankId`, `accountId`, `fromDate` and `toDate` is spesified.

## 2.37.1 (2019-11-07)

Added 'isSalaryAdmin' and 'showPayslip' to TravelExpenseDTO

## 2.37.0 (2019-10-24)

Added support for subscription invoices in the API. First create an order with subscription settings, then approve the order for subscription invoicing. The subscription invoice can also be charged using order :invoice method. New API methods:

- PUT: `/order/{id}/approveSubscriptionInvoice`
- PUT: `/order/{id}/unApproveSubscriptionInvoice`

## 2.36.3 (2019-10-17)

- Feature: all responses now has a header field named `x-tlx-request-id` containing the request identifier.

## 2.36.02 (2019-10-07)

New WebHooks events added:

- `employee.create`, `employee.update` and `employee.delete`
- `contact.create`, `contact.update` and `contact.delete`

## 2.36.01 (2019-10-02)

- Added query parameters for the fields `inActive` and `showOnEmployeeExpenses` for `travelExpense/costCategory`.

## 2.36.0 (2019-10-01)

New project/period endpoints:

- GET: `/project/{id}/period/hourlistReport`
- GET: `/project/{id}/period/invoiced`
- GET: `/project/{id}/period/invoicingReserve`
- GET: `/project/{id}/period/monthlyStatus`
- GET: `/project/{id}/period/overallStatus`

New project/task endpoint:

- GET: `/project/task`

New fields:

- Added fields `signatureRequired` and `signed` to `/project/controlForm` endpoint
- Added field `isapproved` to `/invoice endpoint
- Added fields `signatureRequired` and `signed` to `/project/controlForm` endpoint
- Added fields `isFixedPrice`, `fixedprice`, `contributionMarginPercent`, `numberOfSubProjects`, `numberOfProjectParticipants`, `contact`, `invoicingPlan` and `preliminaryInvoice` to `/project/controlForm` endpoint
- Added field `isBudget` and `invoice` to `/project/orderline` endpoint

## 2.35.12 (2019-09-10)

- Changed type of employment/division from int to divisionDTO; employment/details/occupationcode from int to occupationcodeDTO; employment/details/municipalityid from int to municipalityDTO.

## 2.35.11 (2019-08-30)

- Changed type of query parameter `employeeId` in `/employee/employment/details` endpoint from Integer to String

## 2.35.10 (2019-08-27)

- Added field `ean` to `/product` endpoint

## 2.35.9 (2019-08-05)

New API Endpoint for Order, that lets you attach a document to a specified Order ID:

- PUT: `/order/{id}/:attach`

## 2.35.8 (2019-07-19)

- Updated `swagger.json`:
  - Added `schemas` property to clearly specify that only HTTPS is supported (required for Postman swagger import)
  - Added `contact` property with a link to the GitHub repository

## 2.35.7 (2019-07-10)

- Added new field `phoneNumberWork` (read/write) to `Employee` for `/employee` endpoint

## 2.35.6 (2019-07-08)

- Added fields `authHeaderName` (read/write) and `authHeaderValue` (write only) to `Subscription` to allow for custom authentication headers. If set, the specified header will be included in webhook POST callbacks.

## 2.35.5 (2019-06-24)

- validate that costs exists on expense for `PUT /travelExpense/:deliver` and `PUT /travelExpense/:approve`

## 2.35.4 (2019-06-20)

New endpoint travelexpense/settings for a company.

- GET: "/travelExpense/settings"

## 2.35.3 (2019-06-14)

- Removed `maxLength` validation for enum-fields. This resolves an issue with the [C# swagger code generator](https://github.com/swagger-api/swagger-codegen/issues/9148).

## 2.35.2 (2019-06-04)

New Document Archive endpoints that handles document archive associated with diferent object types.
Returns list with all documents archive associated with an object type specified in path variable {id}

- GET: `/documentArchive/project/{id}`
- GET: `/documentArchive/employee/{id}`
- GET: `/documentArchive/customer/{id}`
- GET: `/documentArchive/supplier/{id}`
- GET: `/documentArchive/product/{id}`
- GET: `/documentArchive/account/{id}`
- GET: `/documentArchive/prospect/{id}`  
  Create a document/upload to archive and associate it with an object type specified by {id}
- POST: `/documentArchive/project/{id}`
- POST: `/documentArchive/employee/{id}`
- POST: `/documentArchive/supplier/{id}`
- POST: `/documentArchive/customer/{id}`
- POST: `/documentArchive/product/{id}`
- POST: `/documentArchive/account/{id}`
- POST: `/documentArchive/prospect/{id}`  
  Updates document archive meta data for a specific document {id}
- PUT: `/documentArchive/{id}`  
  Delete document archive specified by {id}
- DELETE: `/documentArchive/{id}`

## 2.35.1 (2019-05-27)

- GET `/ledger/vatType` and GET `/ledger/vatType/{id}` now supports vat number 0.
- Most objects that had `VatType` as a field will now be able to return data instead of `null` when the vat number is 0.

## 2.35.0 (2019-05-22)

- Added endpoint GET `/project/controlForm`

## 2.34.2 (2019-05-20)

- Changed field `amount` to `/travelExpense` endpoint to readonly
- Added field `chargeableAmount` to `/travelExpense` endpoint
- Changed field `costs` to `/travelExpense` to be writable
- Added field `document` to `/travelExpense` endpoint
- For `travelExpense/cost`, changed field `amountNOKInclVAT` to `/travelExpens/cost` to be writable

## 2.34.0 (2019-05-16)

- Added endpoint `/event/{eventType}` to give examples for each event model
- Added event type `notification.sent`, which is triggered once the employee is sent a new notifications

## 2.33.9 (2019-04-23)

- Added endpoint for getting currency exchange rates at `/currency/{id}/rate`

## 2.33.8 (2019-04-15)

- Added field `invoicesDueIn` to `/customer` endpoint
- Added field `invoicesDueInType` to `/supplier` endpoint

## 2.33.7 (2019-04-15)

- Added field `overdueNoticeEmail` to `/customer` endpoint
- Added field `overdueNoticeEmail` to `/supplier` endpoint

## 2.33.6 (2019-04-12)

- Added new search parameter `isApplicableForSupplierInvoice` to `GET /ledger/account`

## 2.33.5 (2019-04-10)

- Customer's isSupplier can be managed (created and updated) via `/customer`
- Supplier's isCustomer can be managed (created and updated) via `/supplier`

## 2.33.4 (2019-04-04)

- Added readOnly field `hourlyCostPercentage` to `timesheet\entry`

## 2.33.3 (2019-04-02)

- Added endpoint GET, POST, PUT, DELETE `project\hourlyRates`
- Added endpoint GET, POST, PUT, DELETE `project\hourlyRates\projectSpecificRates`

## 2.33.2 (2019-03-14)

- Enhanced endpoint `/department` with DELETE method

## 2.33.1 (2019-03-12)

- Added field to /employee: holidayAllowanceEarned: year, amount, basis, amountExtraHolidayWeek

## 2.33.0 (2019-03-08)

- Added endpoint GET, POST, PUT `/employee/hourlyCostAndRate`

## 2.32.5 (2019-03-06)

- Added field `factor` to `Currency` for GET `/currency`.

## 2.32.4 (2019-03-04)

- Extended `invoiceSendMethod` to support EFAKTURA. VIPPS and PAPER for PUT /customer/{id}/ and POST /customer API endpoints. The PUT /invoice/{id}/:send also supports these send methods.

## 2.32.3 (2019-02-28)

- Added fields `isMainEmployer` and `taxDeductionCode` to endpoint `/employee/employment`

## 2.32.3 (2019-02-26)

- Added the possibility to create and update customers with emailAttahcmentType. The field `emailAttahcmentType` has been added to the PUT /customer/{id}/ and POST /customer API endpoints. This parameter is optional.

## 2.32.2 (2019-02-22)

- Employee's address can be managed (created and updated) via `/employee` endpoint
- Customer's postal and physical address can be managed (created and updated) via `/customer` endpoint
- Supplier's postal and physical address can be managed (created and updated) via `/supplier` endpoint

## 2.32.2 (2019-02-20)

- Added the possibility to create and update customers with invoiceSendMethod. The parameters `invoiceSendMethod` which is enum values and `singleCustomerInvoice` which is a boolean have been added to the PUT /customer/{id}/ and POST /customer API endpoints. These parameters are optional, but for setting `invoiceSendMethod` to EHF the `singleCustomerInvoice` must be set to false.

## 2.32.1 (2019-02-15)

- Added endpoint DELETE `/ledger/voucher/{id}/attachment`

## 2.32.0 (2019-02-11)

- Added endpoint GET, POST `/{travelExpenseId}/attachment`

## 2.31.0 (2019-01-20)

- Added endpoint GET `/timestheet/settings`

## 2.30.5 (2019-01-20)

- Added readOnly fields to /product: `elNumber`, `nrfNumber`

## 2.30.4 (2019-01-17)

- Added ENUM values to `employmentType`, `remunerationType` and `workingHoursScheme` in /employee/employment/details

## 2.30.2 (2019-01-08)

- Added fields to /supplier: `isWholesaler`, `showProducts`
- Added field to /product/external: `organizationNumber`

## 2.30.1 (2018-12-19)

- Added field to /employee: `comments`

## 2.30.0 (2018-12-18)

- Added endpoint POST, PUT, GET employee/nextOfKin
- Added fields to /employee: `phoneNumberHome`, `InternationalIdDTO`

## 2.29.0 (2018-12-14)

- Added endpoint POST employee/employment/leaveOfAbsence/list

## 2.28.1 (2018-12-13)

- Added endpoint GET, PUT `/company/settings/altinn`

## 2.28.0 (2018-12-03)

- Added endpoint GET, POST, PUT /division
- Deprecated endpoint GET /company/divisions

## 2.27.4 (2018-11-30)

- Added field `number`to Payslip

## 2.27.3 (2018-11-27)

- Deprecated response field `VoucherSearchResponse.totalNumberOfPostings`

## 2.27.2 (2018-11-22)

- Added fields to /country: `isoAlpha2Code`, `isoAlpha3Code`, `isoNumericCode`

## 2.27.1 (2018-11-21)

- Added PUT, POST and GET order line by ID to `project/orderline`

## 2.27.0 (2018-11-12)

- Added field `discountPrice` to Product

## 2.26.3 (2018-11-07)

- `/invoice/{id}/:payment` added optinal paidAmountCurrency parameter, to specify the amount paid in the invoice currency.

## 2.26.2 (2018-10-31)

- `PUT /ledger/voucher/{id}/:reverse` added method for reversing vouchers.

## 2.26.1 (2018-10-31)

- `GET /project` added the field `displayName`

## 2.26.0 (2018-10-29)

- Added endpoint `GET /invoice/details/{id}` which returns additional details about project invoices, such as project fee amounts, markup, travel expenses, invoice text, the amount on account balance and vat type.
- Added `projectInvoiceDetails` to the Invoice API model, which contains a list of project invoice details for the given invoice.
- Added `discountPercentage` to the Project API model, containing the discount percentage specified for the project.

## 2.25.0 (2018-10-26)

- Added endpoint `PUT /contact`

## 2.24.0 (2018-10-24)

- The general field `changes` now contains all changes. Before this version only the creation and the last change was listed.

## 2.23.3 (2018-10-15)

- Added field `invoice` to TravelExpense

## 2.23.2 (2018-10-12)

- `GET,PUT /project` added isReadyForInvoicing.

## 2.23.1 (2018-10-10)

- New endpoint: `/project/participant` (`POST`, `GET`, `PUT`, `DELETE`)
- `GET /project` Now has field for participants.

## 2.23.0 (2018-10-10)

- New endpoint: `/document`
- Three new fields in `GET /ledger/voucher`: attachment, document and ediDocument

## 2.22.2 (2018-10-09)

- `GET /project` Now has field for deliveryAddress.

## 2.22.1 (2018-09-19)

- `PUT /project` Now allow changing project description.

## 2.22.0 (2018-09-17)

- `POST /salary/transaction` new boolean parameter for generating tax deduction.
- `GET/POST/PUT/DELETE /project/orderline` new BETA endpoints for selected participants only.

## 2.21.4 (2018-09-12)

- `PUT /project` allow PUT on non-internal projects.

## 2.21.3 (2018-09-6)

- `GET /contact` added phoneNumberMobile.

## 2.21.2 (2018-09-05)

- Changed Swagger documentation to correctly specify return code `201` rather than `200` for `POST` requests.

## 2.21.1 (2018-08-31)

- `PUT /invoice/{id}/:createCreditNote` added for creating credit notes.
- AmountRoundoff og amountRoundoffCurrency added to Invoice.

## 2.20.1 (2018-08-24)

- `DELETE /ledger/voucher` added.
- `GET /inventory` with query parameter isMainInventory now works as intended.

## 2.20.0 (2018-08-23)

- `POST /ledger/voucher/importDocument` now supports an optional description that will be used on the new voucher(s).

## 2.19.0 (2018-08-22)

- New endpoint: `PUT /ledger/voucher/list` - Update multiple vouchers.
- `Voucher.year` is now correctly defined as read-only.

## 2.18.0 (2018-08-21)

- Added information about outstanding payment and payment reminders to invoices: `postings`, `reminders`, `sumRemits`, `amountOutstanding` og `amountOutstandingTotal`.
- Added a `/reminder` API endpoint and `:createReminder` to the invoice API endpoint.

## 2.17.1 (2018-08-17)

- Added support for `organizationNumber` query parameter in `/customer` (GET) and `/supplier` (GET).

## 2.17.0 (2018-08-16)

- `/customer` (PUT and POST): `accountManager` is no longer read-only.

## 2.16.2 (2018-08-13)

- Added the possibility to create prepaid invoices. The parameters `paymentTypeId` og `paidAmount` have been added to the PUT /order/{id}/:invoice and POST /invoice API endpoints. These parameters are optional, but both must be provided if a prepaid invoice should be created.

## 2.16.1 (2018-08-02)

- Fixed incorrect URL references to costCategory and paymentType from `travelExpense/cost`.

## 2.16.0 (2018-08-02)

- `POST /ledger/voucher/importDocument` [BETA] Upload a document to create one or more vouchers. Valid document formats are PDF, PNG, JPEG, TIFF and EHF.

## 2.15.2 (2018-07-27)

- Distinguished payment type in travelExpense API between costCategory and paymentType. new GET endpoints for `travelExpense/costCategory` and `travelExpense/paymentType`. It is now possible to actually obtain these for use with `travelExpense/cost`. (This is a "breaking" change for `travelExpense/cost`, but also makes it usable.)

## 2.15.1 (2018-07-04)

- Added field `reverseVoucher` to Voucher - a reference to the voucher that is produced when the current voucher is reversed.
- Added fields `vacationAllowanceAmount` (readonly), `grossAmount` (readonly), `amount` (readonly) to Salary.Payslip.
- Added field `amount` to Salary.Specification.

## 2.15.0 (2018-06-29)

- Added support of bank reconciliation.
- Added endpoint `bank/statement` for importing bank statements.
- Added endpoint `bank/reconciliation/`for reconciliation. Reconciliation can be done either with a bank statement, or without.
- Added endpoint `bank/reconciliation/match` for mapping postings to transactions on the bank statement.
- Added endpoint `bank/` for getting banks that are supported, their register numbers and the bank statement file formats that can be imported.

## 2.14.2 (2018-06-27)

- Added fields `externalAccountsNumber`, `description` (readonly) and `mainProject` (readonly) to Project.

## 2.14.1 (2018-06-21)

- Added webhook support for Customer, Supplier and Project:
  _ `customer.create`
  _ `customer.update`
  _ `customer.delete`
  _ `supplier.create`
  _ `supplier.update`
  _ `supplier.delete`
  _ `project.create`
  _ `project.update` \* `project.delete`

## 2.14.0 (2018-06-19)

- Added endpoint `ledger/voucher/{id}/:sendToInbox`

## 2.13.3 (2018-06-18)

- `GET /employee` \* Added **allowInformationRegistration** as a query parameter and as a read-only field. This parameter determines if salary information can be registered on the user including hours, travel expenses and employee expenses. The user may also be selected as a project member on projects.

## 2.13.2 (2018-06-15)

- Updated handling of JSON parse errors
  _ Errors deserializing input JSON now results in [HTTP error 422](https://http.cat/422) instead of [500](https://http.cat/500)
  _ Mapping errors are now specified instead of the generic message `Invalid json`

## 2.13.1 (2018-06-12)

- Added webhook support for Voucher events:
  _ `voucher.create`
  _ `voucher.update` \* `voucher.delete`
- Changed endpoint `/timesheet/entry` \* Added read-only field to TimesheetEntry: `chargeableHours`

## 2.12.2 (2018-05-28)

- Added endpoint `ledger/voucher/>nonPosted`

## 2.12.1 (2018-05-28)

- Changed endpoint `/supplier` \* Introduced filter parameter `changedSince`, to only list suppliers changed after a given timestamp

## 2.12.0 (2018-05-28)

- Added endpoints for payment types for outgoing payments:
  - `GET /ledger/paymentTypeOut`
  - `POST /ledger/paymentTypeOut`
  - `POST /ledger/paymentTypeOut/list`
  - `PUT /ledger/paymentTypeOut/list`
  - `DELETE /ledger/paymentTypeOut/{id}`
  - `GET /ledger/paymentTypeOut/{id}`
  - `PUT /ledger/paymentTypeOut/{id}`

## 2.11.2 (2018-05-24)

- Changed `GET /travelExpense`
  - added queryparameter **state** with the posilble values _ALL_, _OPEN_, _DELIVERED_, _APPROVED_, _SALARY_PAID_ (default value _ALL_)

## 2.11.1 (2018-05-09)

- Added validation of addresses to `PUT /address/`
  _ Empty addresses are not allowed.
  _ Either Address.name or Address.customerVendorId is now required.

## 2.11.0 (2018-05-09)

- Added beta version of [webhooks](examples/webhook) for pilot users
  _ Exposes new endpoints for `GET /event` and `GET/POST/PUT/DELETE /event/subscription`
  _ Contact us to join the pilot program!

## 2.10.1 (2018-04-25)

- Added endpoint `PUT /travelExpense/:copy`
- Changed validation for `TravelExpense`: \* Validation now only occurs when `isCompleted` is set to `true`. Allows for creation of empty travel reports.

## 2.10.0 (2018-04-19)

- Added endpoints for `POST`, `PUT` and `DELETE` on `/project`
- Fixed some bugs

## 2.8.0 (2018-04-19)

- Added endpoint `PUT /ledger/voucher`
- Added endpoint `PUT /ledger/voucher/{id}`
- Added endpoint `DELETE /ledger/account`

## 2.5.5 (2018-02-08)

- Improved revision/version handling. The API now returns error code `8000` ("Revision Exception") when attempting to `PUT` an object with the wrong `version` specified. This typically happens when someone else has modified the specified object.

## 2.5.0 (2017-11-23)

- Added endpoints for salary:
  _ `/salary/payslip`
  _ `/salary/specification`
  _ `/salary/transaction`
  _ `/salary/type`

## 2.4.0 (2017-11-15)

- Added endpoints for employees and employment:
  _ `/employee/employment`
  _ `/employee/employment/details`
  _ `/employee/employment/employmentType`
  _ `/employee/employment/leaveOfAbsence`
  _ `/employee/employment/leaveOfAbsenceType`
  _ `/employee/employment/occupationCode`
  _ `/employee/employment/remunerationType`
  _ `/employee/employment/workingHoursScheme` \* `/employee/standardTime`

## 2.3.3 (2017-11-07)

- Changed endpoint `/department` \* Introduced filter parameter `departmentManagerId`

## 2.3.2 (2017-10-30)

- Changed endpoint `/product`: \* Introduced filter parameter `productNumber`

## 2.3.1 (2017-10-20)

- Added endpoints for ledger (hovedbok):
  _ `/ledger/openPosts`
  _ `/leder/posting/openPosts`

## 2.3.0 (2017-10-10)

- Added endpoints for prospects (CRM):
  _ `GET /crm/prospect`
  _ `GET /crm/prospect/{id}`

## 2.2.0 (2017-09-27)

- Added endpoints for product:
  _ `POST /product`
  _ `PUT /product`
  _ `PUT /product/unit`
  _ `GET /product/unit/`
- Added fields to Product:
  _ `priceIncludingVatCurrency` (utsalgspris inkl. mva)
  _ `priceExcludingVatCurrency` (utsalgspris eks. mva)
  _ `costExcludingVatCurrency` (innkjøpspris)
  _ `isInactive`
  _ `vatType` (mva-kode)
  _ `currency`
  _ `productUnit`
  _ `isStockItem` (lagervare) \* `stockOfGoods` (lagerbeholdning)
