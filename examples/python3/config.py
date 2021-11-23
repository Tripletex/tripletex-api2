base_url = '<BASE_URL>'
consumer_token = '<CONSUMER_TOKEN>'
employee_token = 'EMPLOYEE_TOKEN'

expiration_date = 'EXPIRATION_DATE'

class Config():
    def __init__(self):
        self.base_url = base_url
        self.consumer_token = consumer_token
        self.employee_token = employee_token
        self.expiration_date = expiration_date