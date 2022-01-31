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

def create_emps(department_id):
    """
    Create employees from cvs file
    """
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
                'department': {
                    'id': department_id
                },
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

def create_department(name):
    payload = {
        'name': name
    }
    return client.create_department(payload=payload)

def read_emps():
    return client.get_employees()


if (__name__ == '__main__'):
    '''Example usage'''

    print(">> creating department")
    department = create_department('The Fun Dept').value
    print(f">> department '{department.name}' has been created with department id '{department.id}'")

    print('>> creating employees from cvs file')
    create_emps(department_id=department.id)
 
    print(">> creating product")
    product = create_product('Cool Product').value
    print(f">> product '{product.name}' has been created with product id '{product.id}'")

    print(">> creating customer")
    customer = create_customer('Valued Customer').value
    print(f">> customer '{customer.name}' has been created with customer id '{customer.id}'")

    print(">> fetching product")
    print(client.get_product_by_id(product.id, 'id,name,weight').value)

    print(">> fetching customer")
    print(client.get_customer_by_id(customer.id, 'id,name,isSupplier').value)

    print(">> creating order")
    order_date = '2022-11-17' # addjust as per your usecase
    delivery_date = '2022-11-18' # addjust as per your usecase
    order = create_order(customer.id, customer.name, product.id, order_date=order_date, delivery_date=delivery_date).value
    print(f">> order has been created with order id '{order.id}'")

    print(">> creating invoice")
    invoice_date = '2022-11-18' # addjust as per your usecase
    invoice_due_date = '2022-12-18' # addjust as per your usecase
    invoice = create_invoice(invoice_date=invoice_date, invoice_due_date=invoice_due_date, order_id=order.id).value
    print(f">> invoice has been created with invoice id '{invoice.id}'")
    