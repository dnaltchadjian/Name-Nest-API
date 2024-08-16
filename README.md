# NameNest API
 NameNest is a simple but powerful tool for finding the perfect name.
 
 The API is a Spring Boot powered application which connects to MongoDB Atlas. It provides name data in a
 clear and concise format and offers enhanced querying capabilities across over 45,000 first names.
## API Usage

### Endpoints
 All API calls are rooted in the "/api/v1/" endpoint. The main endpoints are the "namesQuery" and "namesCount"
 calls, which take almost identical parameters. 
 - **namesQuery**: provides full name data; the name itself, the gender, and the associated country frequency information
 - **namesCount**: provides a simple count of the names matching the parameter criteria.

### URI Parameters

The API can be called with any number of supplied parameters, case-insensitive.

#### Criteria parameters
 - Text matching (each of the following can be combined to make criteria more specific, it will always use an AND operation)
   - **startsWith**: prefix for a name, i.e. "st" will return results like "**St**acy", or "**St**uart"
   - **endsWith**: suffix for a name, i.e. "us" will return results like "Ang**us**", or "Marc**us**"
   - **contains**: matching text for a name in any part of it, i.e. "ord" will return results like "G**ord**on", "**Ord**ančo", and "Wilf**ord**"
 - **gender**: "M", or "F" depending on whether male or female names are desired respectively; leave blank for both
 - **isUnisex**: "true" or "false" (true by default), depending on whether unisex names are to be included; only relevant if a gender is supplied
 - **albania**, **theNetherlands**, and other country parameters: a "true" or "false" (false by default) value indicating whether a name occurs in the specified country
   - See [Accepted country parameters](#accepted-country-parameters) below
   - If no country or countries are specified, names from all countries are returned in queries
 
#### Functional parameters
These parameters are only used in the **namesQuery** endpoint.
 - **pageNumber**: the page number for paginated results (not required)
 - **pageSize**: the page size for paginated results; defaults to 10 if not provided and only relevant if pageNumber is specified

### JSON Return Data

####namesQuery endpoint
 - **name**: the actual name string
 - **gender**: the gender, represented in single letter format; see [firstname-database](#sources-and-other-information) below for link to database with gender coding rules
 - **countryMap**: a map containing each of the country frequency scores; see [firstname-database](#sources-and-other-information) below for link to database with frequency scoring rules

Sample output from hitting endpoint: "/api/v1/names**Query**?startsWith=ott&endsWith=o&contains=v"
```json
[
  {
    "id": {
      "timestamp": 1720238307,
      "date": "2024-07-06T03:58:27.000+00:00"
    },
    "name": "Ottaviano",
    "gender": "M",
    "countryMap": {
      "Italy": -8
    }
  },
  {
    "id": {
      "timestamp": 1720238307,
      "date": "2024-07-06T03:58:27.000+00:00"
    },
    "name": "Ottavino",
    "gender": "M",
    "countryMap": {
      "Italy": -8
    }
  },
  {
    "id": {
      "timestamp": 1720238307,
      "date": "2024-07-06T03:58:27.000+00:00"
    },
    "name": "Ottavio",
    "gender": "M",
    "countryMap": {
      "Italy": -5,
      "Swiss": -8
    }
  }
]
```

####namesCount endpoint

 Sample output from hitting "/api/v1/names**Count**?startsWith=ott&endsWith=o&contains=v"
```json
3
```

## Sources and other Information

 The database data is supplied by the firstname-database by Matthias Winkelmann found here:
 https://github.com/MatthiasWinkelmann/firstname-database/tree/master
 
## Accepted country parameters
 Any number of these countries can be provided to the API with a "true" value to indicate that results should have a frequency value from that country.
 If combined, the query will act as an "OR" operator, meaning if "armenia", "greece", and "italy" are all set to "true",
 results will be shown for names that occur in any of the countries individually, not necessarily all of them.

Accepted countries:
- albania
- arabiaPersia
- armenia
- austria
- azerbaijan
- belarus
- bosniaAndHerzegovina
- bulgaria
- china
- croatia
- czech
- denmark
- eastFrisia
- estonia
- finland
- france
- georgia
- germany
- greatBritain
- greece
- hungary
- iceland
- indiaSriLanka
- ireland
- israel
- italy
- japan
- kazakhstanUzbekistan
- korea
- kosovo
- latvia
- lithuania
- luxembourg
- macedonia
- malta
- moldova
- montenegro
- norway
- poland
- portugal
- romania
- russia
- serbia
- slovakia
- slovenia
- spain
- sweden
- swiss
- theNetherlands
- turkey
- ukraine
- usa
- vietnam
- otherCountries