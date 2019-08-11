# ecommerce
How to run it locally:
1. Open the project use IDE (eclipse, intellij, etc)
2. Run MySQL in local computer and create database with name `ecommercedb`
3. Run scripts: 
    - src/main/resources/schema.sql
    - src/main/resuorces/data.sql
4. Update username and password in `src/main/resources/application.yml`

API:
GET: localhost:8810/ecommerce/user/v1/find-module-by-id/1
GET: localhost:8810/ecommerce/user/v1/find-module-by-id/2
GET: localhost:8810/ecommerce/user/v1/find-module-by-id/3

f user id not found:

{
    "error": "User ID not exist!",
    "exception": null
}
