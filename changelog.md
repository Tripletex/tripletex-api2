# API changelog

## 2.10.1 (2018-04-25)
* Added endpoint `PUT /travelExpense/:copy`
* Changed validation for `TravelExpense`: Validation now only occurs when `isCompleted` is set to `true`. Allows for creation of empty travel reports.

## 2.10.0 (2018-04-19)
Nye endepunkter på prosjekt: put, post og delete samt litt feilretting.

## 2.8.0 (2018-04-19)
Nye endepunkter: put for ledger/voucher, put for ledger/voucher{id}, delete for ledger/account.

## 2.5.5 (2018-02-08)
Bedre støtte av revisjoner/versjoner. Man vil nå få feilkode 8000 "Revision Exception" når man forsøker å oppdatere et objekt, men har spesifisert feil versjon av objektet. Dette skjer typisk hvis noen har redigert objekter du forsøker å oppdatere.

## 2.5.0 (2017-11-23)
Ny API-versjon med lønn er lansert. Følgende nye grupperinger med endepunkter er tilgjengelig: salary/payslip, salary/specification, salary/transaction og salary/type. Klikk på Swagger-lenken nederst på siden for å se alle de nye endepunktene.

## 2.4.0 (2017-11-15)
Ny API-versjon med ansatte er lansert. Nye endepunkter er lagt til grupperingen employee, og følgende nye grupperinger av endepunkter er nå lansert: employee/employment, employee/employment/details, employee/employment/employmentType, employee/employment/leaveOfAbsence,
employee/employment/leaveOfAbsenceType, employee/employment/occupationCode,
employee/employment/remunerationType, employee/employment/workingHoursScheme og employee/standardTime. Klikk på Swagger-lenken nederst for å se alle de nye endepunktene.

## 2.3.3 (2017-11-07)
Endepunktet for avdeling (department) har fått et nytt parameter: departmentManagerId.

## 2.3.2 (2017-10-30)
Endepunktet for produkt har fått et nytt parameter: productNumber.

## 2.3.1 (2017-10-20)
Hovedbok (ledger) har fått to nye endepunkter: get for ledger/openPosts og get for leder/posting/openPosts for å hente ut åpne poster fra hovedbok.

## 2.3.0 (2017-10-10)
Den nye versjonen inneholder nye endepunkter for crm/prospect: get for prospect og get for prospect {id}.

## 2.2.0 (2017-09-27)
Ny versjon inneholder følgende nye endepunkter: post for product, put for product, get for productUnit, get for productUnit{id}. I tillegg har vi utvidet produkt-API-et så man også kan hente ut følgende data: utsalgspris inkl./eks. mva, innkjøpspris, status, mva-koder, valuta, produktenhet, lagervare og lagerbeholdning.
