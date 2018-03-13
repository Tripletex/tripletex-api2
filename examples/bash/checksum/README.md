# Checksum

Example code and documentation for the experimental "checksum" feature.

**Important note**: The checksum feature is currently **experimental**, and should not be relied on without safeguards.

---

## What problems are solved with checksum?

* Checksum can be used to quickly determine whether a previously known data set has been changed
* Requests to unchanged data sets are returned in a fraction of the original time
* Allows for higher frequency of polling

## What problems _are not_ solved with checksum?

* Checksum does not speed up API calls when changes occur at a generally faster rate than the freqency of polling (in fact, most are actually slowed down a tiny bit)

## How do I take advantage of checksum?

See [example.sh](./example.sh) for a simple use case, or follow the following steps:

1. For any list endpoint (e.g. `/project` or `/ledger/voucher`), include the HTTP header `If-None-Match` set to any non-empty string.
2. The response will contain a field `versionDigest`. This is your checksum (**Note**: this is _only_ a checksum when specifying the `If-None-Match` header!)
3. Perform the same request as in step 1, but now with the `If-None-Match` header set to the checksum from step 2
4. If the data set has changed, you will receive the response as usual, but with a new `versionDigest` value.
5. If there have not been any changes, you will (very quickly) receive a [HTTP 304 Not Modified](https://http.cat/304), indicating a checksum match.

## Limitations

The current checksum implementation has a few limitations:

* False negatives: The checksum may change even when the data set is unchanged, as it may be based on a larger data set than what was requested from the API.
* False positives: The checksum should always change when the data set is changed, but there are a few legitimate exceptions:
  * Changes to user privileges between requests. Roles are not taken into account when calculating the checksum, even though the data set returned could have been different.
  * Changes to objects not directly related to the API endpoint, fetched through `fields`. For example, changes to the `projectManager` of a `project` (fetched with `fields=projectManager(*)`) will not update the checksum for the `/project` endpoint. Changes to directly related fields will, however, also provide an updated checksum. E.g. changing `orderline` will additionally update the checksum for `order`.

## Technical details

Checksum is based on the HTTP standard for [ETag caching](https://en.wikipedia.org/wiki/HTTP_ETag). This is why the header `If-None-Match` is used for requesting a data set with a given checksum.

Instead of using the `ETag` header to return the calculated checksum, the already existing property `versionDigest` is overwritten. This is a temporary solution to lower risk for existing integrations, and will be replaced with the `ETag` header in a later version.

The checksum system is not enabled by default for all list requests as it will slow down all API requests not taking advantage of the feature. The current implementation will perform the checksum calculation as an extra overhead to the request. This is also done temporarily to prevent breaking existing integrations.
