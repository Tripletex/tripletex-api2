import csv
import json
from tripletex import Tripletex
from config import Config


config = Config()

client = Tripletex(config.base_url, config.consumer_token, config.employee_token, config.expiration_date)
'''
Alternatively, you can create a client from config, like so:
client = Tripletex.from_config(config)
'''

def create_emps():
    with open('employees.cvs', mode='r') as csv_file:
        csv_reader = csv.DictReader(csv_file)
        for row in csv_reader:        
            print(f'\tcreating {row["firstname"]} {row["lastname"]} ...')
            payload = {
                'firstName': row["firstname"],
                'lastName': row["lastname"],
                'email': row["email"],
                'dateOfBirth': row["dateOfBirth"],
                'userType': row["userType"],
                'employments': [
                    {
                        'startDate': row["startDate"], 
                        'employmentDetails': [
                            {
                                'percentageOfFullTimeEquivalent': row["percentageOfFullTimeEquivalent"]
                            }
                        ]
                    }
                ]
            }
            
            client.create_employee(payload=payload)

def create_product(name):
    payload = {
        'name': name
    }
    return client.create_product(payload=payload)

def create_customer(name):
    payload = {
        'name': name
    }
    return client.create_customer(payload=payload)

def create_order(customer_id, customer_name, product_id, order_date, delivery_date):
    payload = {
        'customer' : 
        {
            'id': customer_id,
            'name': customer_name
        },
        'orderLines': [
            {
                'product': 
                {
                    'id': product_id
                }  
            }
        ],
        'orderDate': order_date,
        'deliveryDate': delivery_date
    }
    return client.create_order(payload=payload)

def create_invoice(invoice_date, invoice_due_date, order_id):
    
    payload = {
        'invoiceDate': invoice_date,
        'invoiceDueDate': invoice_due_date,
        'orders': [{'id': order_id}]
    }
    return client.create_invoice(payload=payload)

def read_emps():
    return client.get_employees()


if (__name__ == '__main__'):
    '''Example usage'''
    create_emps()
    
    print(">> creating product")
    product = create_product('RPi13').value

    print(">> creating customer")
    customer =  create_customer('TPG13').value

    print(">> fetching product")
    print(client.get_product_by_id(product.id, 'id,name,weight').value)

    print(">> fetching customer")
    print(client.get_customer_by_id(customer.id, 'id,name,isSupplier').value)

    print(">> creating order")
    order = create_order(customer.id, customer.name, product.id, '2021-11-17', '2021-11-18').value
    print(">> creating invoice")
    invoice = create_invoice('2021-11-18', '2021-12-18', order.id).value

    print(invoice.id)