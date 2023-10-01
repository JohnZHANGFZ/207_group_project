# 207_week3_project

### Problem Domain:
Recipe selection

### Proposed Solution:
We are thinking of developing an application that can keep inventory of what the user has in their fridge and pantry, 
and is able to suggest recipes based on the available ingredients.

### Link of API
One API we can make use of is: https://api-ninjas.com/api/recipe

### Screen shot of trying out the API

![](/images/screenshot.png)

### Example output of running Java code
The example is attached in the file Exampleoutput.txt

### technical problems
1. throttling of api requests

    API ninja allows for 50k total api calls per month, this will limit the usability of the API, 
    and cause some trouble when we test the code too.
    Also, the maximum calls in one second is 100 times. This problem will cause a problem if someone enters a list 
    with more than 100 ingredients.
2. The readability of the results directly returned by the API.

    As you can see from Exampleoutput.txt, the result is all in one line and is extremely long. We need to do some 
    additional editing and modifications to this result to make it more readable.