'''
Purpose:    Provides a python client with selected endpoints
Author:     Ahmed Al-Faris
Version:    2111
Status:     Beta
'''
import json
from types import SimpleNamespace
import requests
from requests.auth import HTTPBasicAuth


class Tripletex:
    def __init__(self, base_url, consumer_token, employee_token, expiration_date):
        self.base_url = base_url
        self.consumer_token = consumer_token
        self.employee_token = employee_token
        self.expiration_date = expiration_date
        self.session_token = self.create_session_token().value.token
        self.auth = self.authenticate(self.session_token)
        self.headers = {'Content-Type': 'application/json' }

    @classmethod
    def from_config(cls, config):
        return cls(config.base_url, config.consumer_token, config.employee_token, config.expiration_date)

    def create_session_token(self):
        params = {'consumerToken' : self.consumer_token, 'employeeToken' : self.employee_token, 'expirationDate' : self.expiration_date}
        r = requests.put(f'{self.base_url}/token/session/:create', params=params)
        if (r.status_code == 200):
            return self.map(r)

        raise Exception(r.status_code, r.text, r.reason)

    def authenticate(self, session_token):
        return HTTPBasicAuth('0', session_token)

    def who_am_i(self, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/token/session/>whoAmI', params=params, auth=self.auth)
        return self.map(r)

# Company
    def get_company_by_id(self, company_id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/company/{company_id}', params=params, auth=self.auth)
        return self.map(r)

# Employee
    def get_employee_by_id(self, employee_id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/employee/{employee_id}', params=params, auth=self.auth)
        return self.map(r)

    def get_employees(self, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/employee', params=params, auth=self.auth)
        return self.map(r)

    def create_employee(self, payload):
        r = requests.post(f'{self.base_url}/employee', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

# Country
    def get_countries(self, ids='', sorting='', fields=''):
        params= {'id':ids, 'sorting':sorting, 'fields':fields}
        r = requests.get(f'{self.base_url}/country', params=params, auth=self.auth)
        return self.map(r)

    def get_country_by_id(self, country_id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/country/{country_id}', params=params, auth=self.auth)
        return self.map(r)

# project
    def get_projects(self, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/project', params=params, auth=self.auth)
        return self.map(r)

    def update_project(self, id, payload):
        r = requests.put(f'{self.base_url}/project/{id}', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

# order
    def get_orders(self, orderDateFrom, orderDateTo, fields=''):
        params = {'orderDateFrom': orderDateFrom,'orderDateTo': orderDateTo, 'fields': fields}
        r = requests.get(f'{self.base_url}/order', params=params, auth=self.auth)
        return self.map(r)

    def create_order(self, payload):
        r = requests.post(f'{self.base_url}/order', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

    def get_order_line_by_id(self, id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/order/orderline/{id}',  params=params, auth=self.auth)
        return self.map(r)

# product
    def get_product_by_id(self, id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/product/{id}', params=params, auth=self.auth)
        return self.map(r)

    def create_product(self, payload):
        r = requests.post(f'{self.base_url}/product', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

 # customer
    def create_customer(self, payload):
        r = requests.post(f'{self.base_url}/customer', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

    def get_customer_by_id(self, id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/customer/{id}', params=params, auth=self.auth)
        return self.map(r)

# invoice
    def create_invoice(self, payload):
        r = requests.post(f'{self.base_url}/invoice', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

# department
    def get_departments(self, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/department', params=params, auth=self.auth)
        return self.map(r)

    def create_department(self, payload):
        r = requests.post(f'{self.base_url}/department', data=json.dumps(payload), auth=self.auth, headers=self.headers)
        return self.map(r)

    def get_department_by_id(self, id, fields=''):
        params = {'fields': fields}
        r = requests.get(f'{self.base_url}/department/{id}', params=params, auth=self.auth)
        return self.map(r)

# helpers
    @staticmethod
    def map(response):
        data = json.dumps(response.json())
        return json.loads(data, object_hook=lambda d: SimpleNamespace(**d))
