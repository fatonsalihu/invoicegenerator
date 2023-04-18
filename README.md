
**Description**

Endpoint: ( port:8080 )
POST - /api/invoices - Generates invoices with given json data like example below:

     [{
        "name": "Product 1",
        "quantity": 100,
        "price": 0.25,
        "discount": 0,
        "VAT": 8
      },
      {
        "name": "Product 2",
        "quantity": 38,
        "price": 2.4,
        "discount": 0,
        "VAT": 8
      }]

All Product data from the challenge is provide in root directory in file: `body-data.json`




**Installation**

    mvn clean install
