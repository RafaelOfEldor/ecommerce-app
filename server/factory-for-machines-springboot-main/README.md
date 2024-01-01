                                        -----IMPORTANT-----

To start program and enable API, simply run the FactoryApplication.
Make sure this README is in editor mode when reading these instructions, otherwise
example json's can be difficult to read.

A lot of the tests are based on our Bean commandLineRunner setup, so if you
change it or remove it, a lot of our integration tests will fail as id's
and sizes are based on that setup. Integration tests also
fail if they are all run in the same context/runtime, as changes to
order, address or customer affect each other, and thus messes up id's
and sizes that are asserted. 

So TLDR: Test the test files individually instead of
all the tests in the same runtime/context, otherwise the integration tests 
mingle and assertions come out wrong despite functionality working as 
intended.

Many-to-Many relation between order and machine as we wanted one order to 
be able to contain multiple machines, and same machines to be able
to exist on multiple orders. So in our model, a machine
simply represents that machine rather than a specific instance of
that machine. We felt that this model more accurately resembles a 
factory where it has x amount of stock of a machine and so multiple orders
use the database for reference to a type of machine
rather than a specific instance. This way we don't have to create a new 
identical machine everytime a new order is issued, but rather use
a reference to the already made type of that machine. The task never states 
anything against this as it simply says an order can have one or 
more machines, but nothing about whether the same machine, or in our case
reference to a machine, can exist on many orders. And in our model
a new machine can still be made for any new or existing order if needed.

Parts and subassemblies are in many-to-one relationships, so when adding a part to a
subassembly or a subassembly to a machine, they need to be 
new/unassigned, otherwise it causes primary key violation. Server won't crash
but nothing will happen or be returned.

We also chose to ignore some JsonProperties to keep it a bit more tidy,
so that you don't have to get long lists of customer orders when fetching addresses,
or a long list of subassemblies and parts when fetching orders.
In a real use-case one would simply fetch the id's provided in one table
and use them in another to link any necessary entities.

                                ------All api crud operations ------

GET REQUESTS:

for all elements of an entity:
GET http://localhost:8080/api/{entity}

for page of 10 instances of an entity:
GET http://localhost:8080/api/{entity}/page/{pagenumber}

for instance of an entity by id:
GET http://localhost:8080/api/{entity}/{id}

POST REQUESTS:

---NOTE:
All extra functionality post requests have an example of what the json body 
should look like above the method in the corresponding controller file.
for general post requests, do a get request to the entity by id and use that for
reference.

general post request for all entities:
POST http://localhost:8080/api/{entity}
-- body: json of the entity without id('s), and any properties that are
   lists are optional to include and can be added to later.


for adding existing address to a customer from address mapping:
POST http://localhost:8080/api/address/{idOfCustomer}/existingaddress
-- body: json with a Long field "addressId" for id of
   existing address.
   example:
   {
   "addressId": 4 <-(number corresponding to address id)
   }


for adding existing address to a customer from customer mapping:
POST http://localhost:8080/api/customer/{idOfCustomer}/existingaddress
-- body: json with a Long field "addressId" for id of
   existing address.
   example:
   {
      "addressId": 4 <-(number corresponding to address id)
   }


for adding new address to a customer from customer mapping:
POST http://localhost:8080/api/customer/{idOfCustomer}/newaddress
-- body: json with String field of "addressStreetName" and
   String field for "addressStreetNameNumber"example:
   {
      "addressStreetName": "street name",
      "addressStreetNameNumber": "number on house"
   }

for adding new address to a customer from address mapping:
POST http://localhost:8080/api/address/{idOfCustomer}/newaddress
-- body: json with String field of "addressStreetName" and
   String field for "addressStreetNameNumber"example:
   {
      "addressStreetName": "street name",
      "addressStreetNameNumber": "number on house"
   }


for creating a new customer and adding existing address to it:
POST http://localhost:8080/api/customer/newcustomer/existingaddress
-- body: Takes in a json with string field for "customerName", string field for 
   "customerEmail" and Long field for "addressId".
   Example:
   {
   "customerName": "name of customer",
   "customerEmail": "email of customer"
   "addressId": 5 <- (id of existing address)
   }


for creating a new customer and address, and adding the address to the customer:
POST http://localhost:8080/api/customer/newcustomer/newaddress
-- body: json with String field of "orderName" and a list "machineId" of Long's 
   corresponding to machineId's
   example:
   {
   "customerName": "name of customer",
   "customerEmail": "email of customer"
   "addressStreetName": "name of street"
   "addressStreetNameNumber": "number on house"
   }


for creating a new order and adding it to a customer from customer mapping:
POST http://localhost:8080/api/customer/{idOfCustomer}/order
-- body: json with String field for "orderName" and a list "machineId" of Long's 
   corresponding to machineId's
   example:
   {
      "orderName": "order for (name here) ", <-(just a name or description of the order.)
      "machineId": [
                      5, <-(the id of machine 5)
                      22 <-(the id of machine 22)
                   ]
   }


for adding existing machines to an order:
POST http://localhost:8080/api/machine/order/{orderid}/addexistingmachines
-- body: json with a "machineId" property that is a list "machineId" of Long's 
   corresponding to machineId's
   example:
   {
      "machineId": [
         10,
         19,
         22
      ]
   }


for adding existing unassigned subassemblies to an existing machine:
POST http://localhost:8080/api/machine/{idOfMachine}/addto/existing
-- body: json with a list "subassemblyId" of
   Longs. Example:

!!! IMPORTANT THAT EXISTING SUBASSEMBLIES YOU TRY TO ADD
    DO NOT YET BELONG TO ANOTHER MACHINE
   {
       "subassemblyId": [
         51, <-(the id of subassembly 51)
         52, <-(the id of subassembly 52)
         53 <-(the id of subassembly 53)
       ]
  }


for adding existing unassigned subassemblies to a new machine:
POST http://localhost:8080/api/machine/addto/new
-- body: json with a string property "machineName", integer property for
   itemQuantity and a list "subassemblyId" of Longs. Example:

!!! IMPORTANT THAT EXISTING SUBASSEMBLIES YOU TRY TO ADD
    DO NOT YET BELONG TO ANOTHER MACHINE
   {
      "machineName": "(name of machine here) ",
      "itemQuantity" 1 <-(amount of items)
      "subassemblyId": [
         51, <-(the id of subassembly 51)
         52, <-(the id of subassembly 52)
         53 <-(the id of subassembly 53)
      ]
   }

for adding existing unassigned parts to a new subassembly:
POST http://localhost:8080/api/subassembly/addto/new
-- body: json with a string property "subassemblyName" and a list "partId" of
   Longs. Example:
!!! IMPORTANT THAT EXISTING PARTS DO NOT YET BELONG TO ANOTHER SUBASSEMBLY !!!
{
   "subassemblyName": "(name of subassembly here) ",
   "partId": [
      14, <-(the id of part 14)
      5, <-(the id of part 5)
      22 <-(the id of part 22)
   ]
}

for adding existing unassigned parts to an existing subassembly
POST http://localhost:8080/api/subassembly/{idOfSubassembly}/addto/existing
-- body: json with a list "partId" of
   Longs. Example:

!!! IMPORTANT THAT EXISTING PARTS DO NOT YET BELONG TO ANOTHER SUBASSEMBLY !!!
{
   "partId": [
      14, <-(the id of part 14)
      5, <-(the id of part 5)
      22 <-(the id of part 22)
   ]
}


PUT REQUESTS

 ---note:
We thought about adding functionality for changing one entity through another,
but we decided that it doesn't make a lot of sense to change for instance an order
or an address through a customer. As such, any entity routing to change entity is mainly 
for that specific entity, not any attached entities. Use the order or address routes
to change order or addresses, not the customer route. You can keep other entities in, but
any changes made to customer, address or order through another entity than its own
will not stay.

To change instance of entity:
PUT http://localhost:8080/api/{entity}/{idOfEntity}
-- body: json of the entity with non-id, entity exclusive
   fields changed to whatever user wants. 
   (Do a fetch request by id to entity for reference)  

DELETE REQUESTS

To delete instance of entity:
DELETE http://localhost:8080/api/{entity}/{idOfEntity}

