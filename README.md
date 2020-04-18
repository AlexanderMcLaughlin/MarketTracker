# MarketTracker
A real-time stock market tracking dashboard that consists of a framework for creating different algorithms that can be used to predict the fluctuation of different indexes and stocks

## RealTime Tracking
This application is built to track the current status of the market. It will update once a minute with whichever index or stock the user specifies (currently only handles Dow Jones, NASDAQ, and S&P 500, however, it is scalable to include all stocks and indexes)

## Custom Algorithms
This application is built around the idea that you can select an algorithm from a dropdown menu on either of the three trackers that are the main focus of the dashboard and it will predict the market's fluctuation in realtime alongside realtime numbers. It will also provide you with the difference between the prediction and actual prices. The algorithms simply need to be put into a function in the Algorithm class that returns the value predicted, added to the dropdown menus, and given handling and it will function just like realtime. This option will be made more convenient in future updates.

## Getting Started Tracking
Custom algorithms can be implemented by the user by adding a method to the Algorithm class, adding the name of the algorithm to the "algorithmList" variable in the MarketTracker class, and then giving it handling in the main method under the comment that says "// This is where all the translation to which algorithm happens". Many examples are provided. For the top algorithm it should be called by using the 'a' variable, for the middle you use 'b', and for the bottom you use 'c'.

Simply make your changes, compile the project, and run the associated jar file.
