## Overview

# Requirement

1.  Your application should accept and validate a 7 or 10 digit phone number. - no formatting is mentioned
2.  Assuming a standard alpha-numeric telephone keypad please generate a list of all possible combinations of alpha-numeric phone numbers from the input phone number. Display the total count at the beginning. -- assuming `0` and `1` will remain same as they doesn't have any corresponding letter
3.  Implement paging for the output with each page getting it's data from the server. - most tricky part as the application doesn't involve any database operation but in the frontend we needed to have pagination.
4.  Provide unit tests for your backend implementation. - will do

# Output

For example:  If the input number is 240 386 6106 then the output is

Total number of combinations: <count goes here>

240 386 610M

240 386 610N

240 386 610O

….

Page links: 1, 2, 3…

## Direction
1. Spring Boot REST API used for backend
2. logback used for logging
3. Swagger documentation
4. All possible combinations generated but couldn't make it work on the pagination part
5. Used spring cache to reduce re-processing but got stuck on the total number of combinations
6. Frontend using Angular and Angular Material
7. Tried to use oboe for async fetching of data - couldn't able to do it in the way I wanted
8. Tried using prime table to cache the data locally once received - not good design as it takes time to fetch

## Alternate 
I could've used a database to store all the combinations once generated to create the pagination and total count but doesn't seem like a good design to me.

## Reference
Slightly modified - https://leetcode.com/problems/letter-combinations-of-a-phone-number/