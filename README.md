# Website not currently up, took it down due to cost

# ecommerce-app
An ecommerce website using spring boot + postgreSQL + react and docker, deployed through AWS ECS + RDS.

Made to improve and display my spring boot backend skills, as well as learn some docker and AWS.


Nothing costs any money lol, check your accounts payment details after signing up/in to see a wonderful little treat.


Also, please be aware that while i require info from a user to show most of my functionality, you don't need to
provide any real info about yourself like your real emails and addresses etc. Just make something up for testing purposes.
I considered adding an email confirmation but i do not wish to gatekeep my display of skills by forcing people to reveal
sensitive information into my database. Just make up fake credentials and have fun trying out the website :)


Yes, i made all the item entities manually.
Yes, it made me depressed.
No, i wouldn't do it again.

## Trying it locally

## with docker compose:

simply place a .env file in the root directory with these values filled out

```
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/[some_name]
SPRING_DATASOURCE_USERNAME=[some_name]
SPRING_DATASOURCE_PASSWORD=[some_password]
REACT_APP_BASE_URL=http://localhost:3000
BACKEND_API_BASE_URL=http://localhost:8080
POSTGRES_DB=[same as some_name from SPRING_DATASOURCE_URL]
POSTGRES_USER=[same as SPRING_DATASOURCE_USERNAME]
POSTGRES_PASSWORD=[same as SPRING_DATASOURCE_PASSWORD]
GOOGLE_DISCOVERY_URL=[your_google_discovery_url]
GOOGLE_CLIENT_ID=[your_google_client_id]
```

then go into the file root/frontend/client/runtime-env.js and enter:

```
(function() {
  window.__ENV__ = {
    BACKEND_API_BASE_URL: "[same value as BACKEND_API_BASE_URL from root .env]"
  };
})();
```

then go into a docker enabled terminal and enter:
```bash
docker-compose up -d --build
```

Remember terminate the containers, enter:
```bash
docker-compose down
```

## without docker compose:

Requires postgreSQL to be setup on your computer.

same .env file from the version with docker compose as well as same root/frontend/client/runtime-env.js.

ensure your backend gets these environmental variables:

```
REACT_APP_BASE_URL=http://localhost:3000
GOOGLE_DISCOVERY_URL=[your_google_discovery_url]
GOOGLE_CLIENT_ID=[your_google_client_id]
SPRING_DATASOURCE_URL=[your_postgres_datasource_url]
SPRING_DATASOURCE_USERNAME=[your_postgres_datasource_username]
SPRING_DATASOURCE_PASSWORD=[your_postgres_datasource_password]
```

If you don't have google discovery stuff, you can alternatively just remove the LoginWithOpenidButton in frontend/client/pages/LoginPage.jsx
and frontend/client/pages/RegisterPage.jsx.

then, start your backend isolated through intellij or something, and once that succeds go into frontend directory and enter:

```bash
npm install
```

then:

```bash
npm run dev
```

