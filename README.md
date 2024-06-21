# Native Nursery Network
Finding plant nurseries that have what you're looking for can be a pain. Now nurseries can provide potential customers with an easy way to see their offerings and place orders, and customers can find which nurseries have exactly what they're looking for.

## Program features
1. Authenticated users can view and search nurseries
    * Nurseries can be selected by id
    * Nurseries have optional search parameters of whether they have a storefront, whether they offer shipping, and by name
2. Authenticated users can view and search plants
    * Plants can be searched by id, max height, and/or scientific name
    * A list of all plants can attained
    * Plant models include scientific and common names, max height, typical planting month, bloom color (if applicable), if they are pollinaotr friendly, what nurseries have them, a, categories (e.g. bushes, te\rees, grasses, riparian species, edible), as well as a list of appropriate soils and light conditions
3. Admin and sellers can add and update plants
4. Authorized customers can create, view, and edit their own orders
    * Line items in order include the plant, quantity to be ordered
    * Adding a plant or changing its quantity updates inventory levels
    * orders display subtotals and tax
    * Items can be added to remove from order
5. Authorized customers can update their customer profile
6. Admin and authorized sellers can create, update and delete the nursery info
7. Authorized sellers can add plants to database
8. Admin and authorized sellers can view orders

### New Features
1. Nursery creator can add employees to their nursery, who will have seller access to features like updating inventory and nursery details
2. Users can register and login
3. Admin can add permissions to other users
4. Users can can create and add to carts that are specific to a selected nursery
    * Carts can be emptied, deleting all items (inventory will be added back to database)
    * Carts are checked out to create orders
5. Sellers can increase the inventory level of a plant they carry (or add create an entry that they have inventory for)
6. Users can submit a request to be added as seller
    * Admin can approve these requests
7. Sellers can view all orders for their nursery, filtering by whether they have been recieved by the customer, and wether they are for pickup or delivery, and pickup location (if applicable)
### Flex goals
14. Users can get a list of which nurseries carry a specified plant and how much they have in stock
15. Users can pull up lists of plants that are in a specified category, light requirement, soil condition
15. Additional query parameters added for searching plants
    - Pollinator friendly, bloom color, planting month, common name
16. Add in geolocation service

## API Endpoints
### Current
|   Endpoint   |   Method  |   Description     |Success|Error | Authentication|
|:---------:|:---------:|:-----------------:|:-----:|:----:|:-------------:|
|/api/customers/{id} | GET|Get details for a specific customer|200|404|User associated with account, Admin|
|/api/customers|POST|Create a new customer profile|201|422|User|
|api/customers/{id}|PUT|Update customer profile|200|422,404|User(created by), Admin|
|/api/nurseries|GET|List of nurseries|200|400|All authenticated|
|/api/nurseries/{id}|GET|View single nursery|200|404|All authenticated|
|/api/nurseries|POST|Add a new nursery profile|201|422|Seller, Admin|
|/api/nurseries/{id}|PUT|Update existing nursery|200|422, 404| Seller (createdBy or staff), Admin|
|/api/nurseries/{id}|DELETE|Delete an existing nursery|204|404|Seller(CreatedBy), Admin|
|/api/plants/|GET|List of plants|200|400|All authenticated|
|/api/plants/{id}|GET|Get plant by id|200|400, 404|All auth.|
|/api/plants|POST|Add a new plant to inventory|201|422|Admin, Seller|
|/api/update/{id}|PUT|Update existing plant|200|422,404|Admin, Seller|
|/api/orders/{id}|GET|Get order details|200|404, 405|Customer(createdBy), Admin, Seller|
|/api/orders/nurseries/{id}|GET|List of all orders associated with a nursery|200|404, 405|Seller, Admin|
|/api/orders/customers/{id}|GET|List of all orders associated with a customer|200|404, 405|Customer, Admin|
|/api/orders|POST|Create a new (empty) order|201|422|Customer|
|/api/orders/{id}|PUT|Update order details|200|422,404,405|Customer(createdBy), Admin|
|api/orders/{id}|DELETE|Remove an existing order|Customer, Admin
|/api/orders/{id}/add|POST|Add an item to a order|201|422,404,405|Customer(createdBy)|
|/api/orders/{id}/remove|DELETE|Remove an item from a order|204|404,405|Customer(createdBy), Admin|
|/api/orders/{id}/change-quant|PUT|Update quanity of existing item in order|200|404, 405|Customer, Admin|
|/api/plants/{id}|GET|Get details for 1 plant|200|404|All auth.|
|/api/plants|GET|Get list of plants|200|400|All auth.|
|/api/plants|POST|Add a new plant|201|422,405|Admin, Seller|
|/api/plants/{id}|PUT|Update an existing plant|200|404,405,422|Admin, Seller|
### Upcoming
|   Endpoint   |   Method  |   Description     |Success|Error | Authentication|
|:---------:|:---------:|:-----------------:|:-----:|:----:|:-------------:|
|/api/orders/customers/{id}|GET|Get list of orders for a customer|200|404, 405|Customer(createdBy), Admin|
|/api/orders/nurseries/{id}|GET|Get list of orders for a specific nursery|200|404, 405|Seller, Admin|