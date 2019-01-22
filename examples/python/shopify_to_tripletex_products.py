import json

import requests

from helper_functions import read_config
from shopify_store import ShopifyStore
from tripletex_api_helper_funtions import get_session_token


def set_products_inactive():
    querystring = {"fields": "*"}  # * = get all fields
    payload = ""
    url = "https://tripletex.no/v2/product"
    response = requests.request("GET", url, data=payload, headers=headers, params=querystring)
    tt_products = json.loads(response.text)['values']

    url = "https://tripletex.no/v2/product/{}"
    for p in tt_products:
        if p['number'].startswith("5"):  # condition, which products you want to set inactive
            p['isInactive'] = True
            payload = json.dumps(p)
            response = requests.request("PUT", url.format(p['id']), data=payload, headers=headers)
            print(response.text)


def transfer_shopify_to_tripletex_products():
    store = ShopifyStore(config['shopify']['store_url'], config['shopify']['api_key'], config['shopify']['password'])
    products_json = store.get_products()
    shopify_products = json.loads(products_json)['products']
    for shopify_product in shopify_products:
        for variant in shopify_product['variants']:
            product_title = shopify_product['title']
            if "gift" in product_title or "soap" in product_title or "detergent" in product_title:
                continue
            print("transferring product: {}".format(product_title))
            url = "https://tripletex.no/v2/product"
            payload = {
                "name": product_title,
                "number": variant['sku'],
                "costExcludingVatCurrency": 0,
                "priceExcludingVatCurrency": 0,
                "priceIncludingVatCurrency": 0,
                "isInactive": False,
                "isStockItem": True,
                "stockOfGoods": variant['inventory_quantity'],
                "vatType": {
                    "id": 5,
                },
            }
            response = requests.request("POST", url, data=json.dumps(payload), headers=headers)
            print(response.text)


if __name__ == '__main__':
    config = read_config("auth_info.ini")  # auth_info.ini must contain credentials for both
    headers = {'Content-Type': 'application/json; charset=utf-8',
               'Authorization': 'Basic {}'.format(get_session_token(config['consumer_token'],
                                                                    config['employee_token']))}

    # make some products inactive
    set_products_inactive()

    # transfer products from Shopify to Tripletex
    transfer_shopify_to_tripletex_products()
