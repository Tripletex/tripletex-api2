# API changelog
25.04.2018 (versjon 2.10.1): Nytt endepunkt på travelExpense: copy. Validering skjer nå kun når reiseregning leveres (kan opprettes tom).

19.04.2018 (versjon 2.10.0): Nye endepunkter på prosjekt: put, post og delete samt litt feilretting.

14.03.2018 (versjon 2.8.0): Nye endepunkter: put for ledger/voucher, put for ledger/voucher{id}, delete for ledger/account.

08.02.2018 (versjon 2.5.5): Bedre støtte av revisjoner/versjoner. Man vil nå få feilkode 8000 "Revision Exception" når man forsøker å oppdatere et objekt, men har spesifisert feil versjon av objektet. Dette skjer typisk hvis noen har redigert objekter du forsøker å oppdatere.

23.11.2017 (versjon 2.5.0): Ny API-versjon med lønn er lansert. Følgende nye grupperinger med endepunkter er tilgjengelig: salary/payslip, salary/specification, salary/transaction og salary/type. Klikk på Swagger-lenken nederst på siden for å se alle de nye endepunktene.

15.11.2017 (versjon 2.4.0): Ny API-versjon med ansatte er lansert. Nye endepunkter er lagt til grupperingen employee, og følgende nye grupperinger av endepunkter er nå lansert: employee/employment, employee/employment/details, employee/employment/employmentType, employee/employment/leaveOfAbsence,
employee/employment/leaveOfAbsenceType, employee/employment/occupationCode,
employee/employment/remunerationType, employee/employment/workingHoursScheme og employee/standardTime. Klikk på Swagger-lenken nederst for å se alle de nye endepunktene.

07.11.2017 (versjon 2.3.3): Endepunktet for avdeling (department) har fått et nytt parameter: departmentManagerId.

30.10.2017 (versjon 2.3.2): Endepunktet for produkt har fått et nytt parameter: productNumber.

20.10.2017 (versjon 2.3.1): Hovedbok (ledger) har fått to nye endepunkter: get for ledger/openPosts og get for leder/posting/openPosts for å hente ut åpne poster fra hovedbok.

10.10.2017 (versjon 2.3.0): Den nye versjonen inneholder nye endepunkter for crm/prospect: get for prospect og get for prospect {id}.

27.09.2017 (versjon 2.2.0): Ny versjon inneholder følgende nye endepunkter: post for product, put for product, get for productUnit, get for productUnit{id}. I tillegg har vi utvidet produkt-API-et så man også kan hente ut følgende data: utsalgspris inkl./eks. mva, innkjøpspris, status, mva-koder, valuta, produktenhet, lagervare og lagerbeholdning.
