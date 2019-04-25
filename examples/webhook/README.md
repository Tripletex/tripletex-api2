# WebHooks in Tripletex

**Tripletex WebHook's supports a growing number of internal events for your integrations to subscribe to.**

You can see the API2 endpoints for managing your WebHook subscriptions under **/event** and **/event/subscription** in the [swagger doc](https://tripletex.no/v2-docs/new).

## List currently available events

**The list of subscribable events is currently limited to a select few, but we are very happy to expand based on use-cases. The current list of events includes:**
* Invoice charged: `invoice.charged`
* Order created: `order.create`
* Order updated: `order.update`
* Order deleted: `order.delete`
* Product created: `product.create`
* Product updated: `product.update`
* Product deleted: `product.delete`
* Voucher created: `voucher.create`
* Voucher updated: `voucher.update` (also triggered when changing the voucher's postings!)
* Voucher deleted: `voucher.delete`
* Project created: `project.create`
* Project updated: `project.update`
* Project deleted: `project.delete`
* Customer created: `customer.create`
* Customer updated: `customer.update`
* Customer deleted: `customer.delete`
* Supplier created: `supplier.create`
* Supplier updated: `supplier.update`
* Supplier deleted: `supplier.delete`
* Let us know if you have any suggestions!


It is also possible to see supported events from the API:

	curl -X GET --header 'Accept: application/json' --header 'Authorization: Basic <token>' 'https://tripletex.no/v2/event'

> Events are created in the format **"object.verb"**, and may include additional verbs other than *create, update, delete*. Webhook events will include an optional `payloadModel`, referencing the swagger model being sent. Events of type *delete* only include the object ID, and not the object itself.

        {
	    "value": {
		    "product.create": {
		        "description": "Product created",
			"payloadModel": "Product"
			
		    },
		    "order.delete": {
		        "description": "Order deleted"
		    }
		}
	}

## Subscribing to an event
	POST https://tripletex.no/v2/event/subscription
>
	{
		"event": "product.create",
		"targetUrl": "https://your.receiver",
		"fields": "optional; fields from the triggering object to send"
	}
> "*fields*" is an optional parameter, and follows the same format as in API2.
If you made a call to **GET /v2/product/{ID}** with a *fields* parameter, you can use the **same fields** to get the same response from a subscription to **product.\***.

## Authentication for callback

It is recommended to set up some form of authentication against the `targetUrl` callback, to prevent misuse.
At the moment, two authentication mechanisms are supported:

1. Basic authentication as a part of the URL. Username and password specified as a part of the URL will be sent as an `Authorization` header when performing callbacks. Example: `https://username:password@myintegration.example/tripletex`. Username and password will here be sent following the (basic authentication protocol)[https://en.wikipedia.org/wiki/Basic_access_authentication].

2. Include secret token as query/path parameters. Example: `https://myintegration.example/tripletex?token=secret123`. This is less recommended than basic authentication, but also supported.

These are the supported mechanisms supported **right now**. If you have need for more complicated authentication, please let us know and we will consider adding additional mechanisms.


### Syncing
If you set up a subscription, give it a few seconds to propagate to all servers, and then sync up all data from e.g. GET /v2/product. 

> Remember to **check the version** number of objects loaded through bulk sync and webhooks.
> For now we recommend having a **nightly sync** to make sure everything is loaded.
> Note that if an object is modified several times in rapid succession, the webhook system might skip over a version number or two, but sends over the latest version.

## WebHook format

	POST <url specified in the subscription>
> 
	{  
		"subscriptionId": ###,
		"event": "object.verb",
		"id": ###, // Event triggering object's id (Because if *.delete, then "value" below will be null)
		"value": {... single object, optionally filtered by fields ...}
	}  


## Subscription status
	GET /v2/event/subscription
> 
	{ 
		..........
		"values": [
			{
				"id": 1,
				"version": 0, // Simply shows how many times this record has been modified (using PUT)
				"url": "https://tripletex.no/v2/event/subscription/1",
				"event": "product.create",
				"targetUrl": "http://webhook.target.io/foo",
				"fields": "*,currency(*)",
				"status": "ACTIVE"
			}
		]
	}
> In the future, the **status** can be set to **ACTIVE**, **DISABLED**'. But the system might also set a subscription's status to a more descriptive value, e.g. **DISABLED_TOO_MANY_ERRORS**.
