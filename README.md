# Citizen Interview Flatten Nested Integer Array
This service takes an arbitrary array of arrays with numbers
and flattens it into a single array.

This aws service can be tested like this: 

**`curl --location -g --request GET 'https://pykj6wpy7c.execute-api.eu-central-1.amazonaws.com/test/flattenArray?input=[1001,-2,[3,[4]]]' \
--header 'Content-Type: application/json'`**


The expected output of above command will be like this: 
**`{"output":[1001, -2, 3, 4]}`**