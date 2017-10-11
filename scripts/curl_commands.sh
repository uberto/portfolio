#greetings
curl localhost:8080

write price of a stock
curl -vX POST http://localhost:8080/ticker -d @ibm.json --header "Content-Type: application/json"

#read price of a stock
curl localhost:8080/ticker?stock=IBM.N

