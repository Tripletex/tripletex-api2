#!/bin/Bash

# Example use of experimental "checksum" feature in Tripletex API
# See README.md for important notes on the checksum feature.

# IMPORTANT: Everything regarding checksum is subject to change.
# Integrations trying out the checksum feature will _not_ break if
# we decide to change the implementation. However, the advantages
# of using checksum may be lost and the integration has to be updated.


# CONFIGURATION:
sessionToken="*** CHANGE ME ***"
proxyEmployeeId=0

# Set up auth header
basicAuthToken=$(echo -n "$proxyEmployeeId:$sessionToken" | base64)

# Enable new checksum feature by sending in a non-empty checksum
dummyChecksum="someNonEmptyValue"

# Call the API with a dummy checksum to get the initial data set as well as the initial checksum
result=$(
  curl https://tripletex.no/v2/project \
    --header "Authorization: Basic $basicAuthToken" \
    --header "If-None-Match: $dummyChecksum" \
    --silent
);

# Checksum is currently stored
versionDigest=$(echo "$result" | jq --raw-output .versionDigest)
count=$(echo "$result" | jq --raw-output .count)

echo "Got $count results with checksum $versionDigest"

# Call the same API endpoint with the previously received checksum (versionDigest).
# This should result in HTTP 304 (Not Modified) indicating no changes – unless the dataset has changes, of course.
curl https://tripletex.no/v2/project \
    --header "Authorization: Basic $basicAuthToken" \
    --header "If-None-Match: $versionDigest" \
    --verbose \
    --silent
