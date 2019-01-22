import requests
import json


class ShopifyStore:

    def __init__(self, store_url, api_key, password):
        self.store_url = store_url
        self.api_key = api_key
        self.password = password

    def get_products(self):
        url = "{}/admin/products.json".format(self.store_url)
        querystring = {"limit": "250"}  # max products per page
        response = requests.request("GET", url, params=querystring, auth=(self.api_key, self.password)).text

        return json.loads(response)['products']

    def create_product(self, product):
        url = "{}/admin/products.json".format(self.store_url)
        return requests.request("POST", url, data=json.dumps(product), headers={'Content-Type': "application/json"},
                                auth=(self.api_key, self.password)).text

    def update_prodcut(self, product_change):
        url = "{}/admin/products/{}.json".format(self.store_url, product_change["product"]['id'])
        return requests.request("PUT", url,
                                headers={'Content-Type': "application/json"},
                                data=json.dumps(product_change),
                                auth=(self.api_key, self.password))
