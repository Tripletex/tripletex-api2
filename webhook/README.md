# WebHooks in Tripletex

**Tripletex WebHook's supports a growing number of internal events for your integrations to subscribe to.**

You can see the API2 endpoints for managing your WebHook subscriptions under **/event** and **/event/subscription** in the [swagger doc](https://tripletex.no/v2-docs/).

## List currently available events

	curl -X GET --header 'Accept: application/json' --header 'Authorization: Basic <your authenticatin>' 'https://tripletex.no/v2/event'

> Events are created in the format **"object.verb"**, and may include additional verbs then *create, update, delete*.

    {
	    "value": {
		    "customer.create": "Description",
		    "invoice.delete": "Description"
		}
	}

## Subscribing to an event
	POST https://tripletex.no/v2/event/subscription
>
	{
		"event": "customer.create",
		"target": "https://your.receiver",
		"fields": "optional; fields from the triggering object to send"
	}
> "*fields*" is an optional parameter, and follows the same format as in API2.
If you made a call to **GET /v2/customer/{ID}** with a *fields* parameter, you can use the **same fields** to get the same response from a subscription to **customer.\***.

### Syncing
If you set up a subscription, give it a few seconds to propagate to all servers, and then sync up all data from ex: GET /v2/customer. 

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
				"event": "project.create",
				"targetUrl": "http://webhook.target.io/foo",
				"fields": "",
				"status": "ACTIVE"
			}
		]
	}
> In the future, the **status** can be set to **ACTIVE**, **DISABLED**'.  But the system might also set a subscription's status to ex: **DISABLED_TOO_MANY_ERRORS**.
