# Citizen Interview Flatten Nested Integer Array
This service takes an arbitrary array of arrays with numbers
and flattens it into a single array.

> * This aws service can be tested like this: <br />
**`curl --location -g --request GET 'https://gc098wrsnc.execute-api.eu-central-1.amazonaws.com/default/flattenArray?input=[1,2,31212,[[[-1000]]]]'`**


> * The expected output of above command will be like this: <br />
**`{
    "output": [
        1,
        2,
        31212,
        -1000
    ]
}`**

> * When the request doesn't have a parameter which is named as input: <br />
**`curl --location -g --request GET 'https://gc098wrsnc.execute-api.eu-central-1.amazonaws.com/default/flattenArray?inp=[1,2,31212,[[[-1000]]]]'`**

> * The service will return BadRequest(400) and the output will be like this:  <br />
**` "message": "Missing required request parameters: [input]"`**
