# Citizen Interview Flatten Nested Integer Array
This service takes an arbitrary array of arrays with numbers
and flattens it into a single array.

This aws service can be tested like this: 
**`curl --location -g --request GET 'https://gc098wrsnc.execute-api.eu-central-1.amazonaws.com/default/flattenArray?input=[1,2,31212,[[[-1000]]]]'`**


The expected output of above command will be like this: 
**`{
    "output": [
        1,
        2,
        31212,
        -1000
    ]
}`**
