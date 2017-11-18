# portfolio
simple restapi app done with Spring Boot and used as an example of how to remove Spring Boot

Well it’s actually quite easy. We can start replacing Spring to-be-injected fields with references to a new BigGlobals class.
To illustrate the method, I created an example of a mini restapi app with SpringBoot, you can find all the sources on my porfolio project on Github.
Now the application is very simple but, I hope, still shows the good and bad things about SpringBoot. 
It is a web server exposing some Rest apis, using json as data format:
  update the price of a collection of stock.
  retrieve the latest price for a stock.
  buy/sell a number of stocks
  get the current value of stocks you still own (portfolio)

There is no persistence and everything is stored in memory.
