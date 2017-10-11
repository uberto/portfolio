#greetings
curl localhost:8080

write price of a stock
curl http://localhost:8080/ticker -d @ibm.json --header "Content-Type: application/json"

#read price of a stock
curl localhost:8080/ticker?stock=IBM.N

#buy a stock
curl http://localhost:8080/portfolio -d @buy_ibm.json --header "Content-Type: application/json"

#read portfolio value
curl localhost:8080/portfolio
