# Multiclient-Chat
A GUI chat application based on client-server architecture. This app was created to learn socket programming, multithreading and swing. Learn by doing is the best way.

To run the application, just download the client and server JARs, first start the server with a port number and then start client(s) with the IP address and port at which the server is listening to.

# How the program works?
Server:-
* Start the Server GUI Screen.
* Listen for new connections from new Clients.
* Start a new Thread for each newly connected Client.
* Keep listening for new connections or messages sent, and update the conversations view accordingly.
 
Client:-
* Start the Client GUI Screen.
* Spawn a new thread which keeps listening to incoming messages from server, and update the conversations view accordingly.
* Send to the server any new messages, and update the conversations view accordingly. 
 
 
