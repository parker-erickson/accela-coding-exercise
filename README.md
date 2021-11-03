# accela-coding-exercise

Steps to run the program:

1. Clone the repo
2. In the terminal navigate to the target file
3. run $java -jar demo-0.0.1-SNAPSHOT.jar
4. navigate to localhost:8081/api/v1/person/
5. open an API tool such as Postman
6. Submit your requests there.

Requests:

#POST: 

## Add a person

localhost:8081/api/v1/person/
## {
##    "firstname" : "Gordon",
##    "lastname" : "Ramsey",
##    "id":1
## }

## Add an address to a person
// Append the id you would like to add an address to at the end of the url.
localhost:8081/api/v1/person/1 
{
    "street" : "123 api ave.",
    "city" : "San Francisco",
    "state" : "CA",
    "postalcode" : 12345

}

# PUT:
## Edit an Address
// Append the id you would like to add an address to at the end of the url.
localhost:8081/api/v1/person/1 
{
    "street" : "123 Data dr.",
    "city" : "Denver",
    "state" : "C0",
    "postalcode" : 54321
}

# GET:
## List all People
// Run a get command with the first url

## Get a person by name
// append the first and last name of the person to the end of the url separated by a '_'
Example: http://localhost:8081/api/v1/person/Gordon_Ramsey

## Get a person by id
// Similar to get by name, just append the id you want to look up
Example: http://localhost:8081/api/v1/person/1

## Get the count of all people
Navigate to: http://localhost:8081/api/v1/person/count

#DELETE:
## Delete person by id
// Run a Delete command in the API tool and append the id you want to delete at the end of the url
Example: http://localhost:8081/api/v1/person/1

## Delete a persons address
// Run a delete command in the API tool and append 'delete-address_{id}' at the end of the url
Example: http://localhost:8081/api/v1/person/delete-address_1
