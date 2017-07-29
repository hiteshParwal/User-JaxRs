# User-JaxRs

A user entry has following attributes – 
•	Guid (should be generated in UUID format - https://en.wikipedia.org/wiki/Universally_unique_identifier)
•	Name
•	City
•	Phone no
•	Gender
•	Creation time (yyyy-MM-ddTHH:mm:ssZ)
•	Last Updation time (yyyy-MM-ddTHH:mm:ssZ)

a.	Create user using POST
•	URL - http://localhost:8081/user/webapi/users
•	HTTP Method – POST
•	Sample input payload
{
       "city": "Hyderabad",
        "gender": "male",
        "name": "Hitesh Parwal",
        "phoneNo": "4456576765"
 }
•	Expected Response – 200 OK
{
    "city": "Hyderabad",
    "creationTime": "2017-07-29T19:35:51.215",
    "gender": "male",
    "guid": "212eb235-a5de-423c-8972-83dac8705b07",
    "lastUpdationTime": "2017-07-29T19:35:51.215",
    "name": "Hitesh Parwal",
    "phoneNo": "4456576765"
}

b.	Overriding update using PUT

•	URL - http://localhost:8081/user/webapi/users/{guid}
•	Example - http://localhost:8081/user/webapi/users/212eb235-a5de-423c-8972-83dac8705b07
•	HTTP Method – PUT
	Sample Input Payload – 
{
        "city": "Hyderabad",
        "gender": "male",
        "name": "Hitesh Kumar Parwal"  
}
Sample response (note phone no should be overridden to null) 200 OK – 
	{
        "city": "Hyderabad",
        "creationTime": "2017-07-29T19:35:51.215",
        "gender": "male",
        "guid": "212eb235-a5de-423c-8972-83dac8705b07",
        "lastUpdationTime": "2017-07-29T19:58:30.674",
        "name": "Hitesh Kumar Parwal"
    }

c. Incremental update using PATCH (This ethod is not implemented currently in project )
•	URL - http://xxx/usersvc/v1/users/{guid}
•	Example - http://xxx/usersvc/v1/users/ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17
•	HTTP Method – PATCH
•	Sample Input Payload – 
•	{
  "name": "Mr. Hitesh"
}

•	Sample Response – 200 OK    
This should change only name and update lastUpdationTime. Rest values should remain same.  

d. Searching user using GET
• Use-case 1 -> Search a specific user -  
• URL -http://localhost:8081/user/webapi/users/{guid}
• Example - http://localhost:8081/user/webapi/users/212eb235-a5de-423c-8972-83dac8705b07
• Http Method - GET

Use-case 2 -> Apply a search filter using query parameters search all the user by gender
•	URL -http://localhost:8081/user/webapi/users?gender=male
•	Http Method – GET
•	Sample Response – 200 OK
    {
      "guid": "ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17",
      "name": "Hitesh Kumar Parwal",
      "city": "Hyderabad",
      "phoneno": "420420420420",
      "gender": "male",  
      "creationTime": "2017-06-01T01:12:30Z",
      "lastUpdationTime": "2017-06-01T01:12:30Z"
  }
  
  Use-case 3- Get specific return attributes using query parameter
•	URL - http://localhost:8081/user/webapi/users?returnAttrs=guid,name
•	Http Method – GET
• Sample Response – 200 OK
[
    {
        "guid": "ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17",
        "name": "Hitesh"
    },
    {
        "guid": "7117719b-051a-444d-90bf-da0b1988bd1c",
        "name": "Hitesh Kumar Parwal"
    }
]
    
Use-case 4- Provide sorting control using query parameter
Note:OrderBy has to implement
• URL - http://localhost:8081/user/webapi/users?gender=male&returnAttrs=guid,name,city
•	Http Method – GET
• Sample Response – 200 OK
  [
    {
        "city": "Hyderabad",
        "guid": "44989191-4a3e-4b23-8af2-0e901abd868f",
        "name": "Hitesh Kumar Parwal"
    },
    {
        "city": "indore",
        "guid": "ce1e2dea-7e06-4d2a-9e2d-ea7e068d2a17",
        "name": "Hitesh"
    }
]
 
e. Removing user using DELETE
• URL - http://localhost:8081/user/webapi/users/{guid}
• Http Method – DELETE
• Expected response – 200 OK

