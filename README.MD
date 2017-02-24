[![Build Status](https://travis-ci.org/pencale/message-chat.svg?branch=master)](https://travis-ci.org/pencale/message-chat)
##Chat


## How To Get Started

- Copy docker-compose.yml to you server.
- Run:
```bash
sudo docker-compose up
```
Chat will be available by this link:

* `http://localhost:8181`


## How to chatting

- Login with your google account.
- In Dialogs you will see active users only.
- Click on user to start chatting.

## How to expose port
By default chat is working on 8181 port.
You can expose it to another port changing the config file
* 'docker-compose.yml'
```bash
    ports:
      - "your_port:8181"
```
