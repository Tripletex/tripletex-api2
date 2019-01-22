import requests
import json
import base64


def get_session_token(consumer_token, employee_token):
    querystring = {"consumerToken": consumer_token,
                   "employeeToken": employee_token,
                   "expirationDate": "2025-01-01"}
    url = "https://tripletex.no/v2/token/session/:create"
    response = requests.request("PUT", url, params=querystring)

    session_token = json.loads(response.text)['value']['token']
    username_and_pass = str.encode("0:{}".format(session_token))  # make byte like
    return base64.b64encode(username_and_pass).decode('utf-8')
