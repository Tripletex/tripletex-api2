#!/bin/bash

# Example authentication process for Tripletex API

# CONFIGURATION:

# Integration secret
consumerToken="*** CHANGE ME ***"

# End-user secret generated for our integration
employeeToken="*** CHANGE ME ***"

# API host
apiHost="https://tripletex.no"

# Uncomment the line below if you are using the integration environment
# apiHost="https://api.tripletex.io"

# Used to perform API requests in a different company context (e.g. accountant access)
# Default value "0" is used to act as your primary company
proxyCompanyId=0

# Session token expiration date
sessionExpirationDate="2022-01-01"

# Make sure "jq" is installed
if ! hash jq 2>/dev/null; then
  echo "error: required tool 'jq' is not installed. Install with your favourite package manager, e.g. brew, apt-get, yum, dnf, pacman";
  exit 1;
fi

# Generate new session token based on consumerToken and employeeToken
authResponse=$(
  curl "$apiHost/v2/token/session/:create?consumerToken=$consumerToken&employeeToken=$employeeToken&expirationDate=$sessionExpirationDate" \
    --request PUT \
    --silent
)

# Extract the JSON property "value" and then "token" form the response
sessionToken=$(echo "$authResponse" | jq --raw-output .value.token)

# Check whether we got a valid-looking session token in the response
if [[ "$sessionToken" != *"-"* ]]; then
  echo "Error generating session token";
  echo "$authResponse";
  exit 1;
fi

echo "Session token generated: $sessionToken"

# Set up basic authentication value
# Basic auth is done by base64-encoding the username and password, separated by ":", i.e. "username:password"
# In our case, the username is our proxyCompanyId (or 0), and the password is our sessionToken
authUsername="$proxyCompanyId"
authPassword="$sessionToken"
basicAuthToken=$(echo -n "$authUsername:$authPassword" | base64)

# Perform a basic "whoAmI" call to the API with the authorization header
curl "$apiHost/v2/token/session/%3EwhoAmI" \
  --header "Authorization: Basic $basicAuthToken" \
  --silent

