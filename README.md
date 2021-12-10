# Load Balance With Open Feign
Demo Project for executing Load Balance With Open Feign

![test (1)](https://user-images.githubusercontent.com/10045954/145556232-1b93a340-0e42-45e9-92d1-f5c3e65d4206.jpg)

-> Product Master Micro Service rum in two ports : 8087 & 8088
 -> Service for inserting product code and rate
     
        localhost:8087/product/v1/saveproduct
        localhost:8088/product/v1/saveproduct
        // post request
        {
	          "productCode" : "PRD01",
	          "productRate" : "25"
        }
 -> Product Calculation MS run in port 8089
        //GET Request
        http://localhost:8089/productcalculator/PRD01/2
        
       // Output (FIrst Click)
        
        {
          "productID": 1,
          "productCode": "PRD01",
          "productRate": 25.00,
          "productQuantity": 2,
          "totalPrice": 50.00,
            "port": "8087"
        }
        
        
         // Output (Second Click)
        
        {
          "productID": 1,
          "productCode": "PRD01",
          "productRate": 25.00,
          "productQuantity": 2,
          "totalPrice": 50.00,
            "port": "8088"
        }
        
        //Port number changed 
